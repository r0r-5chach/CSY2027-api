package com.r0r5chach.woodlands.entities.user;

import java.util.List;

import com.r0r5chach.woodlands.entities.Course;
import com.r0r5chach.woodlands.entities.qualification.Qualification;


public class Student extends Profile {
    private List<Course> courses;
    private List<Qualification> entryQualifications;
    private Staff personalTutor;
    private Address termAddress, nonTermAddress;
    private Reason.Student dormantReason;

    public Student(Name name, Status recordStatus, String phoneNumber, String email, User profile, Address nonTermAddress) {
        super(name, recordStatus, phoneNumber, email, profile);
        this.nonTermAddress = nonTermAddress;
    }
    public Student(int id, Name name, Status recordStatus, String phoneNumber, String email, User profile, Address nonTermAddress) {
        super(id, name, recordStatus, phoneNumber, email, profile);
        this.nonTermAddress = nonTermAddress;
    }

    public Student(Name name, Status recordStatus, String phoneNumber, String email, User profile, Address nonTermAddress, List<Qualification> entryQualifications) {
        this(name, recordStatus, phoneNumber, email, profile, nonTermAddress);
        this.entryQualifications = entryQualifications;
    }
    public Student(int id, Name name, Status recordStatus, String phoneNumber, String email, User profile, Address nonTermAddress, List<Qualification> entryQualifications) {
        this(id, name, recordStatus, phoneNumber, email, profile, nonTermAddress);
        this.entryQualifications = entryQualifications;
    }

    public Student(Name name, Status recordStatus, String phoneNumber, String email, User profile, Address nonTermAddress, List<Qualification> entryQualifications, Address termAddress, List<Course> courses) {
        this(name, recordStatus, phoneNumber, email, profile, nonTermAddress, entryQualifications);
        this.termAddress = termAddress;
        this.courses = courses;
    }
    public Student(int id, Name name, Status recordStatus, String phoneNumber, String email, User profile, Address nonTermAddress, List<Qualification> entryQualifications, Address termAddress, List<Course> courses) {
        this(id, name, recordStatus, phoneNumber, email, profile, nonTermAddress);
        this.termAddress = termAddress;
        this.courses = courses;
    }

    public Student(Name name, Status recordStatus, String phoneNumber, String email, User profile, Address nonTermAddress, List<Qualification> entryQualifications, Address termAddress, List<Course> courses, Staff personalTutor) {
        this(name, recordStatus, phoneNumber, email, profile, nonTermAddress, entryQualifications, termAddress, courses);
        this.personalTutor = personalTutor;
    }
    public Student(int id, Name name, Status recordStatus, String phoneNumber, String email, User profile, Address nonTermAddress, List<Qualification> entryQualifications, Address termAddress, List<Course> courses, Staff personalTutor) {
        this(id, name, recordStatus, phoneNumber, email, profile, nonTermAddress, entryQualifications, termAddress, courses);
        this.personalTutor = personalTutor;
    }

    public Student(Name name, Status recordStatus, String phoneNumber, String email, User profile, Address nonTermAddress, List<Qualification> entryQualifications, Address termAddress, List<Course> courses, Staff personalTutor, Reason.Student dormantReason) {
        this(name, recordStatus, phoneNumber, email, profile, nonTermAddress, entryQualifications, termAddress, courses, personalTutor);
        this.dormantReason = dormantReason;
    }
    public Student(int id, Name name, Status recordStatus, String phoneNumber, String email, User profile, Address nonTermAddress, List<Qualification> entryQualifications, Address termAddress, List<Course> courses, Staff personalTutor, Reason.Student dormantReason) {
        this(id, name, recordStatus, phoneNumber, email, profile, nonTermAddress, entryQualifications, termAddress, courses, personalTutor);
        this.dormantReason = dormantReason;
    }
    
    public List<Course> getCourses() {
        return courses;
    }
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    public List<Qualification> getEntryQualifications() {
        return entryQualifications;
    }
    public void setEntryQualifications(List<Qualification> entryQualifications) {
        this.entryQualifications = entryQualifications;
    }
    public Staff getPersonalTutor() {
        return personalTutor;
    }
    public void setPersonalTutor(Staff personalTutor) {
        this.personalTutor = personalTutor;
    }
    public Address getTermAddress() {
        return termAddress;
    }
    public void setTermAddress(Address termAddress) {
        this.termAddress = termAddress;
    }
    public Address getNonTermAddress() {
        return nonTermAddress;
    }
    public void setNonTermAddress(Address nonTermAddress) {
        this.nonTermAddress = nonTermAddress;
    }
    public Reason.Student getDormantReason() {
        return dormantReason;
    }
    public void setDormantReason(Reason.Student dormantReason) {
        this.dormantReason = dormantReason;
    }

    
}
