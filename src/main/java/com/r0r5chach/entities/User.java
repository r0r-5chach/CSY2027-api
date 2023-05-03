package com.r0r5chach.entities;

import com.r0r5chach.services.generic.Access;

public class User {
    private int id;
    private String username, password, token;
    private Access type;
    private Profile profile;

    public User(String username, String password, Access type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public User(String username, String password, Access type, Profile profile) {
        this(username, password, type);
        this.profile = profile;
    }

    public User(String username, String password, String token, Access type) {
        this(username, password, type);
        this.token = token;
    }

    public User(String username, String password, String token, Access type, Profile profile) {
        this(username, password, type);
        this.token = token;
        this.profile = profile;
    }

    public User(int id, String username, String password, Access type) {
        this(username, password, type);
        this.id = id;
    }

    public User(int id, String username, String password, Access type, Profile profile) {
        this(username, password, type, profile);
        this.id = id;
    }

    public User(int id, String username, String password, String token, Access type) {
        this(username, password, token, type);
        this.id = id;
    }

    public User(int id, String username, String password, String token, Access type, Profile profile) {
        this(username, password, token, type, profile);
        this.id = id;
    }
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public Access getType() {
        return type;
    }

    public void setType(Access type) {
        this.type = type;
    }
    public Profile getProfile() {
        return profile;
    }    

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}