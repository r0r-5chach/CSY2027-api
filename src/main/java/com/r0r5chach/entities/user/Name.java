package com.r0r5chach.entities.user;

import java.util.ArrayList;
import java.util.List;

public class Name {
    private String firstName, lastName;
    private List<String> middleNames;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Name(String firstName, String middleName, String lastName) {
        this(firstName, lastName);
        this.middleNames = new ArrayList<String>();
        this.middleNames.add(middleName);
    }

    public Name(String firstName, List<String> middleNames, String lastName) {
        this(firstName, lastName);
        this.middleNames = middleNames;
    }


    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getMiddleNames() {
        return this.middleNames;
    }

    public void setMiddleNames(List<String> middleNames) {
        this.middleNames = middleNames;
    }

    public void setMiddleName(String middleName) {
        this.middleNames = new ArrayList<String>();
        this.middleNames.add(middleName);
    }

    public String toString() {
        StringBuilder name = new StringBuilder(firstName);
        name.append(" ");

        for (String middleName : middleNames) {
            name.append(middleName);
            name.append(" ");
        }
        name.append(lastName);

        return name.toString();
    }

}
