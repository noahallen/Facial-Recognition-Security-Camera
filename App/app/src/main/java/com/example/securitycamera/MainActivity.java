package com.example.securitycamera;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
import androidx.core.app.NotificationCompat;
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


    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_visitor);
        new FirebaseDatabaseHelper().readVisitor(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Visitor> visitors, List<String> keys) {
                new RecyclerView_Config().setConfig(mRecyclerView, MainActivity.this, visitors, keys);
                addNotification();
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
    public void addNotification(){
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >= 26)
        {
            //When sdk version is larger than26
            String id = "channel_1";
            String description = "143";
            int importance = NotificationManager.IMPORTANCE_LOW;
            NotificationChannel channel = new NotificationChannel(id, description, importance);
                        //channel.enableLights(true);
                        //channel.enableVibration(true);
            manager.createNotificationChannel(channel);
            Notification notification = new Notification.Builder(MainActivity.this, id)
                    .setCategory(Notification.CATEGORY_MESSAGE)
                    .setSmallIcon(R.mipmap.logocam1_circ_round)
                    .setContentTitle("You've got a visitor!")
                    .setContentText(" is at your door!")
                    //.setContentIntent(pendingIntent)
                   // .setAutoCancel(true)
                    .build();
            manager.notify(1, notification);
        }

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

