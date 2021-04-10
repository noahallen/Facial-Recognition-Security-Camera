package com.example.securitycamera;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.text.DateFormatSymbols;
import java.util.ArrayList;

/*
public class MainActivity extends AppCompatActivity {

    ListView ActivityLog;
    String[] LogObjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        //NavigationUI.setupWithNavController(navView, navController);
        ActivityLog = findViewById(R.id.ActivityLog);
        LogObjects = new DateFormatSymbols().getMonths();
        ArrayAdapter<String> ALogAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, LogObjects);
        ListView ActivityLog = (ListView) findViewById(R.id.ActivityLog);
        ActivityLog.setAdapter(ALogAdapter);

    }

}*/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateUsersList();
    }

    private void populateUsersList() {
        // Construct the data source
        ArrayList<Visitor> arrayOfVisitors = Visitor.getVisitors();
        // Create the adapter to convert the array to views
        VisitorAdapter adapter = new VisitorAdapter(this, arrayOfVisitors);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.ActivityLog);
        listView.setAdapter(adapter);
    }

}