package com.example.model;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class Greeting {

    private String message;
    private String hostname;

    public Greeting() {
    }

    public Greeting(String message) {
        this.message = message;
        try {
            this.hostname=InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public String getMessage() {
        return message;

    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setMessage(String message) {
        this.message = message;
        try {
            this.hostname=InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
