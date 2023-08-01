package com.example.expensetracker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.BreakIterator;
import java.util.ArrayList;


public class ExpenseFragment extends Fragment {
 private EditText expense_name,amount_expense,note_expense;
private Button  submit;
    private DatabaseHelper databaseHelper;
//    private ArrayList<DataModel> dataList;
//    private DataAdapter dataAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_expense, container, false);
        databaseHelper = new DatabaseHelper(getActivity());
        expense_name = view.findViewById(R.id.addExpenseText);
        amount_expense = view.findViewById(R.id.addAmount);
        note_expense = view.findViewById(R.id.addNote);
        submit = view.findViewById(R.id.submit_expense);


//        dataList = new ArrayList<>();
//        dataAdapter = new DataAdapter(getActivity(), R.layout.list_item, dataList);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int id = Integer.parseInt(idEditText.getText().toString());
                String name = expense_name.getText().toString();
//                String amount_exp= Integer.parseInt(String.valueOf(amount_expense));
                String amount_exp= amount_expense.getText().toString();
                String note_exp = note_expense.getText().toString();
                databaseHelper.insertData( getActivity(),name, amount_exp,note_exp);



            }

        });
        return view;
       }}
//        updateButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int id = Integer.parseInt(idEditText.getText().toString());
//                String name = nameEditText.getText().toString();
//                String address = addressEditText.getText().toString();
//                databaseHelper.updateData(id, name, address);
//                Toast.makeText(MainActivity.this, "Data updated successfully",
//                        Toast.LENGTH_SHORT).show();
//                displayData();
//
//                clearInputFields();
//            }
//        });
//        deleteButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int id = Integer.parseInt(idEditText.getText().toString());
//                databaseHelper.deleteData(id);
//                Toast.makeText(MainActivity.this, "Data deleted successfully",
//                        Toast.LENGTH_SHORT).show();
//                displayData();
//                clearInputFields();
//            }
//        });
//    }
//    private void displayData() {
//        dataList.clear();
//        dataList.addAll(databaseHelper.getAllData());
//        dataAdapter.notifyDataSetChanged();
//    }
//    private void clearInputFields() {
//        idEditText.setText("");
//        nameEditText.setText("");
//        addressEditText.setText("");
//    }
//}

