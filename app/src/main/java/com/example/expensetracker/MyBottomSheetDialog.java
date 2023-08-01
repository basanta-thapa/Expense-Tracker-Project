package com.example.expensetracker;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MyBottomSheetDialog extends BottomSheetDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new BottomSheetDialog(requireContext(), getTheme());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottomsheet_layout, container, false);

        TextView addExpenseText = view.findViewById(R.id.addExpenseText);
        TextView addIncomeText = view.findViewById(R.id.addIncomeText);

        addExpenseText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle "Add Expense" click
                ExpenseFragment expenseFragment = new ExpenseFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentContainer, expenseFragment);
                transaction.addToBackStack(null);  // Optional: Add the fragment to the back stack
                transaction.commit();
                dismiss();  // Close the bottom sheet dialog
            }
        });

        addIncomeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle "Add Income" click
                IncomeFragment incomeFragment = new IncomeFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentContainer, incomeFragment);
                transaction.addToBackStack(null);  // Optional: Add the fragment to the back stack
                transaction.commit();
                dismiss();  // Close the bottom sheet dialog
            }
        });


        return view;
    }
}


