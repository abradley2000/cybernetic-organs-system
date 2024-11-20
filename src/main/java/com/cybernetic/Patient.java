package com.cybernetic;

import java.time.LocalDate;
import java.util.Set;

public class Patient {
    private String id;
    private String name;
    private int age;
    private String bloodType;
    private String organNeeded;
    private int urgencyLevel;
    private LocalDate registrationDate;
    private String status;

    public Patient(String id, String name, int age, String bloodType, String organNeeded, int urgencyLevel, LocalDate registrationDate, String status) {

        if (age < 0 || age > 120) throw new IllegalArgumentException("Patient age is invalid.");
        if (!Set.of("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-").contains(bloodType)) throw new IllegalArgumentException("Patient blood type is invalid.");
        if (urgencyLevel < 1 || urgencyLevel > 10) throw new IllegalArgumentException("Patient urgency level is invalid.");
        if (!Set.of("HEART", "LUNG", "KIDNEY", "LIVER").contains(organNeeded)) throw new IllegalArgumentException("Patient organ needed is invalid.");
        if (!status.equals("WAITING")) throw new IllegalArgumentException("Patient status is invalid");

        this.id = id;
        this.name = name;
        this.age = age;
        this.bloodType = bloodType;
        this.organNeeded = organNeeded;
        this.urgencyLevel = urgencyLevel;
        this.registrationDate = registrationDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String getOrganNeeded() {
        return organNeeded;
    }
}