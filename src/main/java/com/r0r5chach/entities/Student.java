package com.r0r5chach.entities;

import java.util.List;

public class Student extends Profile {
    private List<Course> courses;
    private List<Qualification> entryQualifications;
    private Staff personalTutor;

    public Student(Name name, Status recordStatus, Reason dormantReason, String phoneNumber, String email, User profile) {
        super(name, recordStatus, dormantReason, phoneNumber, email, profile);
    }
    public Student(int id, Name name, Status recordStatus, Reason dormantReason, String phoneNumber, String email, User profile) {
        super(id, name, recordStatus, dormantReason, phoneNumber, email, profile);
    }

    public Student(Name name, Status recordStatus, Reason dormantReason, String phoneNumber, String email, User profile, List<Qualification> entryQualifications) {
        super(name, recordStatus, dormantReason, phoneNumber, email, profile);
        this.entryQualifications = entryQualifications;
    }
    public Student(int id, Name name, Status recordStatus, Reason dormantReason, String phoneNumber, String email, User profile, List<Qualification> entryQualifications) {
        super(id, name, recordStatus, dormantReason, phoneNumber, email, profile);
        this.entryQualifications = entryQualifications;
    }

    public Student(Name name, Status recordStatus, Reason dormantReason, String phoneNumber, String email, User profile, List<Qualification> entryQualifications, List<Course> courses) {
        this(name, recordStatus, dormantReason, phoneNumber, email, profile, entryQualifications);
        this.courses = courses;
    }
    public Student(int id, Name name, Status recordStatus, Reason dormantReason, String phoneNumber, String email, User profile, List<Qualification> entryQualifications, List<Course> courses) {
        this(id, name, recordStatus, dormantReason, phoneNumber, email, profile, entryQualifications);
        this.courses = courses;
    }

    public Student(Name name, Status recordStatus, Reason dormantReason, String phoneNumber, String email, User profile, List<Qualification> entryQualifications, List<Course> courses, Staff personalTutor) {
        this(name, recordStatus, dormantReason, phoneNumber, email, profile, entryQualifications, courses);
        this.personalTutor = personalTutor;
    }
    public Student(int id, Name name, Status recordStatus, Reason dormantReason, String phoneNumber, String email, User profile, List<Qualification> entryQualifications, List<Course> courses, Staff personalTutor) {
        this(id, name, recordStatus, dormantReason, phoneNumber, email, profile, entryQualifications, courses);
        this.personalTutor = personalTutor;
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

    
}
