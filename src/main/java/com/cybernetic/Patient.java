package com.cybernetic;

import java.util.ArrayList;

public class Patient {
    private String name;
    private int age;
    private String medicalHistory;
    private ArrayList<CyberneticOrgan> installedOrgans;

    // Constructor
    public Patient(String inputName, int inputAge, String inputMedicalHistory) {
        name = inputName;
        age = inputAge;
        medicalHistory = inputMedicalHistory;
        installedOrgans = new ArrayList<>();
    }

    public void addOrgan(CyberneticOrgan organ) {
        installedOrgans.add(organ);
    }
    public String getPatientInfo() {
        StringBuilder patientInfo = new StringBuilder();
        patientInfo.append(String.format("Name: %s, Age: %d, Medical History: %s, Installed Organs:", name, age, medicalHistory));
        // Appends each organ in the CyberneticOrgan ArrayList to the returned info
        installedOrgans.forEach(i -> patientInfo.append(i.getModel()));
        return patientInfo.toString();
    }
}
