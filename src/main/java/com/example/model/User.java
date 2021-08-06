package com.example.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class User {

    @Id
    private String name;
    private String place;
    private Date date=new Date();
    private String hostName="test";

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public User(String name, String place) {
        this.name = name;
        this.place = place;

    }

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public void setName(String name) {
        this.name = name;
    }
}
