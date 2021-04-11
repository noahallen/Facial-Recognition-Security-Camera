package com.example.securitycamera;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //populateUsersList();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_visitor);
        new FirebaseDatabaseHelper().readVisitor(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Visitor> visitors, List<String> keys) {
                new RecyclerView_Config().setConfig(mRecyclerView, MainActivity.this, visitors, keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }

    /*private void populateUsersList() {
        // Construct the data source
        ArrayList<Visitor> arrayOfVisitors = Visitor.getVisitors();
        // Create the adapter to convert the array to views
        VisitorAdapter adapter = new VisitorAdapter(this, arrayOfVisitors);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.ActivityLog); //change
        listView.setAdapter(adapter); //change
    }*/

}
/*
// Read from the database
    myRef.addValueEventListener(new ValueEventListener()) {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
                }

        @Override
        public void onCancelled(DatabaseError error) {
        // Failed to read value
        Log.w(TAG, "Failed to read value.", error.toException());
        }
        });

 */