package com.cybernetic;

public class Main {
    public static void main(String[] args) {

        CyberneticOrgan heart = new CyberneticOrgan("1", "Heart", "Pump blood", "A+");

        OrganInventory inventory = new OrganInventory();
        inventory.addOrgan(heart);

        Patient patient = new Patient("John Doe", 30, "None");
        patient.addOrgan(inventory.getOrgan("Heart"));

        System.out.println(patient.getPatientInfo());

    }
}