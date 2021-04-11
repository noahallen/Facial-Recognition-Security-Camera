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

}