package com.example.securitycamera;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import java.io.InputStream;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;

import android.net.Uri;


public class MainActivity extends AppCompatActivity {
    private Button button;
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //populateUsersList();

        /*button = (Button) findViewById(R.id.tvImg);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                browser1();
            }
        });
        */
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
    public void browser1(View view){
        //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/imgres?imgurl=https%3A%2F%2Fstatic.toiimg.com%2Fphoto%2F72975551.cms&imgrefurl=https%3A%2F%2Ftimesofindia.indiatimes.com%2Flife-style%2Fevents%2Fsurya-grahan-today-annular-solar-eclipse-2019-december-images-photos-pics-video-check-out-these-breathing-pictures-of-the-seasons-last-surya-grahan-of-26-december-2019-india%2Fphotostory%2F72975550.cms&tbnid=pTd2OIa33-6LVM&vet=12ahUKEwikm8vW4_TvAhVEOH0KHRvnDl8QMygAegUIARDWAQ..i&docid=78aIM0GrmvG9rM&w=1200&h=900&q=images&ved=2ahUKEwikm8vW4_TvAhVEOH0KHRvnDl8QMygAegUIARDWAQ"));
        //startActivity(browserIntent);
        //Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(imageView);
        openURL("https://www.google.com/imgres?imgurl=https%3A%2F%2Fstatic.toiimg.com%2Fphoto%2F72975551.cms&imgrefurl=https%3A%2F%2Ftimesofindia.indiatimes.com%2Flife-style%2Fevents%2Fsurya-grahan-today-annular-solar-eclipse-2019-december-images-photos-pics-video-check-out-these-breathing-pictures-of-the-seasons-last-surya-grahan-of-26-december-2019-india%2Fphotostory%2F72975550.cms&tbnid=pTd2OIa33-6LVM&vet=12ahUKEwikm8vW4_TvAhVEOH0KHRvnDl8QMygAegUIARDWAQ..i&docid=78aIM0GrmvG9rM&w=1200&h=900&q=images&ved=2ahUKEwikm8vW4_TvAhVEOH0KHRvnDl8QMygAegUIARDWAQ");
    }

    public void openURL(String url){
        Uri uri = Uri.parse(url);
        Intent launchWeb = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(launchWeb);

    }




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