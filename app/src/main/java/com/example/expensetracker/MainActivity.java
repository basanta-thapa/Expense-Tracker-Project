package com.example.expensetracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private static  int MENU_HOME = R.id.homebtn;
    private static  int MENU_TRANSACTION = R.id.Transaction ;
    private static  int MENU_REPORT = R.id.Report;
    private static  int MENU_SETTING = R.id.Setting;
    private static  int MENU_ADD = R.id.add;
    BottomAppBar bottomAppbar;
    FrameLayout fragmentContainer;
    FloatingActionButton fad;
    BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentContainer = (FrameLayout) findViewById(R.id.fragmentContainer);
        fad = (FloatingActionButton) findViewById(R.id.fad);
        fad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyBottomSheetDialog bottomSheetDialog = new MyBottomSheetDialog();
                bottomSheetDialog.show(getSupportFragmentManager(), "bottomSheet");
            }
        });

//        bottomAppbar = (BottomAppBar) findViewById(R.id.bottomAppbar);
        bottomNav = (BottomNavigationView) findViewById(R.id.bottomNav);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            //        bottomNav.setOnNavigationItemSelectedListener(item -> {
            Fragment fragment;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
             int itemId = item.getItemId();

                if (itemId == MENU_HOME) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new Home_fragment()).commit();
                } else if (itemId == MENU_TRANSACTION) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new Transaction_fragment()).commit();

//                } else if (itemId == MENU_ADD) {
////                    getSupportFragmentManager().beginTransaction().replace(R.id.fad, new MyBottomSheetDialog()).commit();
//                    MyBottomSheetDialog bottomSheetDialog = new MyBottomSheetDialog();
//                    bottomSheetDialog.show(getSupportFragmentManager(), "bottomSheet");
                } else if (itemId == MENU_REPORT) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new Report_fragment()).commit();
                } else if (itemId == MENU_SETTING) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new Setting_Fragment()).commit();
                }

                return true;
            }
        });
    }}
