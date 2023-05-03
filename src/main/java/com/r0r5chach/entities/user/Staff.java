package com.r0r5chach.entities.user;

import java.util.List;

public class Staff extends Profile {
    private Address address;
    private List<String> roles, specialisms;
    private Reason.Staff dormantReason;
    

    public Staff(Name name, Status recordStatus, String phoneNumber, String email, User profile, Address address) {
        super(name, recordStatus, phoneNumber, email, profile);
        this.address = address;
    }
    public Staff(int id, Name name, Status recordStatus, String phoneNumber, String email, User profile, Address address) {
        super(id, name, recordStatus, phoneNumber, email, profile);
        this.address = address;
    }

    public Staff(Name name, Status recordStatus,  String phoneNumber, String email, User profile, Address address, List<String> roles) {
        this(name, recordStatus, phoneNumber, email, profile, address);
        this.roles = roles;
    }
    public Staff(int id, Name name, Status recordStatus,  String phoneNumber, String email, User profile, Address address, List<String> roles) {
        this(id, name, recordStatus, phoneNumber, email, profile, address);
        this.roles = roles;
    }

    public Staff(Name name, Status recordStatus,  String phoneNumber, String email, User profile, Address address, List<String> roles, List<String> specialisms) {
        this(name, recordStatus, phoneNumber, email, profile, address, roles);
        this.specialisms = specialisms;
    }
    public Staff(int id, Name name, Status recordStatus,  String phoneNumber, String email, User profile, Address address, List<String> roles, List<String> specialisms) {
        this(id, name, recordStatus, phoneNumber, email, profile, address, roles);
        this.specialisms = specialisms;
    }

    public Staff(Name name, Status recordStatus,  String phoneNumber, String email, User profile, Address address, List<String> roles, List<String> specialisms, Reason.Staff dormantReason) {
        this(name, recordStatus, phoneNumber, email, profile, address, roles, specialisms);
        this.dormantReason = dormantReason;
    }
    public Staff(int id, Name name, Status recordStatus,  String phoneNumber, String email, User profile, Address address, List<String> roles, List<String> specialisms, Reason.Staff dormantReason) {
        this(id, name, recordStatus, phoneNumber, email, profile, address, roles, specialisms);
        this.dormantReason = dormantReason;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public List<String> getRoles() {
        return roles;
    }
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
    public List<String> getSpecialisms() {
        return specialisms;
    }
    public void setSpecialisms(List<String> specialisms) {
        this.specialisms = specialisms;
    }
    public Reason.Staff getDormantReason() {
        return dormantReason;
    }
    public void setDormantReason(Reason.Staff dormantReason) {
        this.dormantReason = dormantReason;
    }

    
}
