package com.example.securitycamera;

import java.util.ArrayList;

public class Visitor {
    private String name;
    private String time;
    //private String img;

    public Visitor(){

    }

    public Visitor(String name, String time){
        this.name = name;
        this.time = time;
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

    public static ArrayList<Visitor> getVisitors(){
        ArrayList<Visitor> visitors = new ArrayList<Visitor>();
        visitors.add(new Visitor("Obama","Fri, Apr 9  12:00am"));
        visitors.add(new Visitor("Sahil","Sat, Apr 10  12:00am"));
        visitors.add(new Visitor("Noah","Sun, Apr 11  12:00am"));
        return visitors;
    }
}