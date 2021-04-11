package com.example.securitycamera;

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

//    public static ArrayList<Visitor> getVisitors(){
//        ArrayList<Visitor> visitors = new ArrayList<Visitor>();
//        visitors.add(new Visitor("Obama","Fri, Apr 9  12:00am"));
//        visitors.add(new Visitor("Sahil","Sat, Apr 10  12:00am"));
//        visitors.add(new Visitor("Noah","Sun, Apr 11  12:00am"));
//        return visitors;
//    }
}