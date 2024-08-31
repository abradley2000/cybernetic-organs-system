package com.cybernetic;

public class Main {
    public static void main(String[] args) {
        // Create instances of CyberneticOrgan
        CyberneticOrgan heart = new CyberneticOrgan("1", "CyberHeartX1", "Pumps blood", "A");
        CyberneticOrgan eye = new CyberneticOrgan("2", "CyberEyeV2", "Enhanced vision", "B");

        // Create an instance of OrganInventory and add organs
        OrganInventory inventory = new OrganInventory();
        System.out.println("Adding organs to inventory...");
        inventory.addOrgan(heart);
        System.out.println("Added " + heart.getModel() + " to inventory.");
        inventory.addOrgan(eye);
        System.out.println("Added " + eye.getModel() + " to inventory.");

        // Create an instance of Patient and add an organ
        Patient patient = new Patient("John Doe", 30, "Healthy");
        System.out.println("Adding organs to patient " + patient.getName() + "...");
        System.out.println(patient.addOrgan(heart));

        // List installed organs for the patient
        System.out.println("Listing installed organs for " + patient.getName() + ":");
        for (CyberneticOrgan organ : patient.getOrganList()) {
            System.out.println("- " + organ.getModel() + ": " + organ.getFunctionality());
        }

        // Search for organs with functionality 'Enhanced vision'
        System.out.println("Searching for organs with functionality 'Enhanced vision'...");
        var searchResults = inventory.searchOrganByFunctionality("Enhanced vision");
        System.out.println("Found " + searchResults.size() + " organ(s):");
        for (CyberneticOrgan organ : searchResults) {
            System.out.println("- " + organ.getModel() + ": " + organ.getFunctionality());
        }

        // Sort organs by model name in inventory
        System.out.println("Sorting organs by model name in inventory...");
        var sortedOrgans = inventory.sortOrgansByModel();
        System.out.println("Sorted organs:");
        for (CyberneticOrgan organ : sortedOrgans) {
            System.out.println("- " + organ.getModel());
        }
    }
}