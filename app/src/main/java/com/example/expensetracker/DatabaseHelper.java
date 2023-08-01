package com.example.expensetracker;

import static java.security.AccessController.getContext;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.List;
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "my_database.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "my_table_expense";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_expense = "Expense";

    public static final String COLUMN_amount = "Amount";
    public static final String COLUMN_note = "Note";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_expense + " TEXT, " +
                COLUMN_amount + " TEXT, " +
                COLUMN_note + " TEXT)";
        db.execSQL(createTableQuery);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Handle database upgrades if needed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public void insertData( Context context,String expense, String amount , String note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_expense, expense);
        values.put(COLUMN_amount, amount);
        values.put(COLUMN_note, note);
//        db.insert(TABLE_NAME, null, values);
//
//        db.close();
        try {
            long result = db.insert(TABLE_NAME, null, values);
            if (result == -1) {
                // Failed to insert data
                Toast.makeText(context, "Failed to insert data.", Toast.LENGTH_SHORT).show();
            } else {
                // Data inserted successfully
                Toast.makeText(context, "Data inserted successfully.", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            // Exception occurred while inserting data
            Toast.makeText(context, "Error inserting data: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } finally {
            db.close();
        }
    }


    public List<DataModel> getAllExpenses() {
        List<DataModel> expensesList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursor = db.rawQuery("SELECT * from my_table_expense ", null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range") String expense = cursor.getString(cursor.getColumnIndex(COLUMN_expense));
                @SuppressLint("Range") String amount = cursor.getString(cursor.getColumnIndex(COLUMN_amount));
                @SuppressLint("Range") String note = cursor.getString(cursor.getColumnIndex(COLUMN_note));

                DataModel dataModel = new DataModel(id, expense, amount, note);
                expensesList.add(dataModel);
            } while (cursor.moveToNext());
            cursor.close();
        }

        db.close();
        return expensesList;
    }
}
//public Cursor getinfo(){
//        SQLiteDatabase db= this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * from my_table_expense ",null);
//        return cursor;
//
//}}


//    public void updateData(int id,String expense, int amount , String note) {
//        SQLiteDatabase db = getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_ID, id);
//        values.put(COLUMN_expense, expense);
//        values.put(COLUMN_amount, amount);
//        values.put(COLUMN_note, note);
//        db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new
//                String[]{String.valueOf(id)});
//        db.close();
//    }
//    public void deleteData(int id) {
//
//        SQLiteDatabase db = getWritableDatabase();
//        db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
//        db.close();
//    }
//    public List<DataModel> getAllData() {
//        List<DataModel> dataList = new ArrayList<>();
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
//        if (cursor.moveToFirst()) {
//            do {
//                @SuppressLint("Range") int id =
//                        cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
//                @SuppressLint("Range") String name =
//                        cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
//                @SuppressLint("Range") String address =
//                        cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS));
//                DataModel data = new DataModel(id, name, address);
//                dataList.add(data);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//        return dataList;
//    }

