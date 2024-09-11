package com.cybernetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Patient {
    private String name;
    private int age;
    private String medicalHistory;
    // Should probably make installedOrgans an ArrayList instead and only check the max size during addOrgan
    private CyberneticOrgan[] installedOrgans = new CyberneticOrgan[5];

    // Constructor
    public Patient(String inputName, int inputAge, String inputMedicalHistory) {
        name = inputName;
        age = inputAge;
        medicalHistory = inputMedicalHistory;
    }

    // In the future, this method should probably throw an exception if the array is already full
    // Assigns given organ to the first available(null) index in the installedOrgans array
    public void addOrgan(CyberneticOrgan organ) {
        for (int i = 0; i < installedOrgans.length; i++) {
            if (installedOrgans[i] == null) {
                installedOrgans[i] = organ;
                System.out.println("Added " + organ.getModel() + " to " + name + "'s installed organs.");
                return;
            }
        }
        System.out.println("Patient cannot have any additional organs added.");
    }

    public ArrayList<CyberneticOrgan> getOrganList() {
        return Arrays.stream(installedOrgans).filter(Objects::nonNull).collect(Collectors.toCollection(ArrayList::new));
    }

    public String getPatientInfo() {
        return String.format("Name: %s, Age: %d, Medical History: %s", name, age, medicalHistory);
    }
}
