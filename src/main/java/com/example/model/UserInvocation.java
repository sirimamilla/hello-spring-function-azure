package com.example.model;

public class UserInvocation {
    String method;
    User user;

    public UserInvocation() {
    }

    public UserInvocation(String method, User user) {
        this.method = method;
        this.user = user;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
