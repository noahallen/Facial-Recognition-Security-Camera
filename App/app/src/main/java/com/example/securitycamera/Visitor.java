package com.example.securitycamera;

import java.util.ArrayList;

public class Visitor {
    private String name;
    private String time;

    public Visitor(String name, String time){
        this.name = name;
        this.time = time;
    }

    public String getName(){
        return name;
    }

    public String getTime(){
        return time;
    }

    public static ArrayList<Visitor> getVisitors(){
        ArrayList<Visitor> visitors = new ArrayList<Visitor>();
        visitors.add(new Visitor("Obama","Fri, Apr 9  12:00am"));
        visitors.add(new Visitor("Sahil","Sat, Apr 10  12:00am"));
        visitors.add(new Visitor("Noah","Sun, Apr 11  12:00am"));
        return visitors;
    }
}