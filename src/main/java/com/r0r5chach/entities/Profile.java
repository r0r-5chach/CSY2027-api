package com.r0r5chach.entities;

public class Profile {
    protected int id;
    protected Name name;
    protected Status recordStatus;
    protected String phoneNumber, email;
    protected User profile;



    public Profile(Name name, Status recordStatus, String phoneNumber, String email, User profile) {
        this.name = name;
        this.recordStatus = recordStatus;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.profile = profile;
    }


    public Profile(int id, Name name, Status recordStatus, String phoneNumber, String email, User profile) {
        this(name, recordStatus, phoneNumber, email, profile);
        this.id = id;
    }    
    

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getRecordStatus() {
        return this.recordStatus;
    }

    public void setRecordStatus(Status recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Name getName() {
        return this.name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getProfile() {
        return this.profile;
    }

    public void setProfile(User profile) {
        this.profile = profile;
    }
    
}
