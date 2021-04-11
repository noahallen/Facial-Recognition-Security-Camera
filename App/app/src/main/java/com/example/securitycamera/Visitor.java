package com.example.securitycamera;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.ArrayList;

public class Visitor {
    private String name;
    private String time;
    //private String img;
    //private String img;

    public Visitor(){

    }

    public Visitor(String name, String time){  //, String img
        this.name = name;
        this.time = time;
        //this.img = img;
    }

    public String getName(){
       // addNotification();
        return name;
    }

    public void setName(String name){
        this.name =name;
    }

    public String getTime(){
        return time;
    }

    public void setTime(String time){
        this.time = time;
    }

//    public String getImg(){
//        return img;
//    }
//
//    public void setImg(){
//        this.img = img;
//    }



//    private void addNotification(){
//        NotificationCompat.Builder builder =new NotificationCompat.Builder(this, "VIBRATION" )
//                .setSmallIcon(R.mipmap.logocam1_circ_round)
//                .setContentTitle("hey boiii")
//                .setContentText("this is a test notification");
//
////        Intent notificationIntent =new Intent(this, FirebaseDatabaseHelper.class);
////        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
////        builder.setContentIntent(contentIntent);
//
//        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        manager.notify(0, builder.build());
//    }



//    public static ArrayList<Visitor> getVisitors(){
//        ArrayList<Visitor> visitors = new ArrayList<Visitor>();
//        visitors.add(new Visitor("Obama","Fri, Apr 9  12:00am"));
//        visitors.add(new Visitor("Sahil","Sat, Apr 10  12:00am"));
//        visitors.add(new Visitor("Noah","Sun, Apr 11  12:00am"));
//        return visitors;
//    }
}