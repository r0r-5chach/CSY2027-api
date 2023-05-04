package com.r0r5chach.woodlands.entities.qualification;

import java.util.Date;

public class Qualification {
    private Grade grade;
    private Level level;
    private Date dateReceived;


    public Qualification(Grade grade, Level level, Date dateReceived) {
        this.grade = grade;
        this.level = level;
        this.dateReceived = dateReceived;
    }
    public Grade getGrade() {
        return grade;
    }
    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    public Level getLevel() {
        return level;
    }
    public void setLevel(Level level) {
        this.level = level;
    }
    public Date getDateReceived() {
        return dateReceived;
    }
    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }
}
