package com.example.expensetracker;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Transaction_fragment extends Fragment {


    private TableLayout expensesListView;
//    private ArrayList<String> expensesList;
//    private ArrayAdapter<String> adapter;

    private TableLayout expensesTable;
    private DatabaseHelper databaseHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaction_fragment, container, false);

        expensesTable = view.findViewById(R.id.TableExpense);
        databaseHelper = new DatabaseHelper(getActivity());

        // Load data from the database and update the table
        loadExpenses();


        return view;
    }



    private void loadExpenses() {
        List<DataModel> expensesList = databaseHelper.getAllExpenses();

        if (expensesList.isEmpty()) {
            Log.d("Transaction_fragment", "No data found in the database.");
            return;
        }


        for (DataModel  expense : expensesList) {
            TableRow tableRow = new TableRow(getActivity());

            TextView textViewId = new TextView(getActivity());
            textViewId.setText(String.valueOf(expense.getId()));
            textViewId.setPadding(60, 0, 20, 0);
            tableRow.addView(textViewId);

            TextView textViewExpense = new TextView(getActivity());
            textViewExpense.setText(expense.getExpense());
            textViewExpense.setPadding(60, 0, 20, 0);
            tableRow.addView(textViewExpense);

            TextView textViewAmount = new TextView(getActivity());
            textViewAmount.setText(String.valueOf(expense.getAmount()));
            textViewAmount.setPadding(60, 0, 20, 0);
            tableRow.addView(textViewAmount);

            TextView textViewNote = new TextView(getActivity());
            textViewNote.setText(expense.getNote());
            textViewNote.setPadding(60, 0, 20, 0);
            tableRow.addView(textViewNote);

            expensesTable.addView(tableRow);
        }
    }
}