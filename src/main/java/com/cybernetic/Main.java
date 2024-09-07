package com.cybernetic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create an instance of OrganInventory and add organs
        System.out.println("Adding organs to inventory...");

        // build the organ inventory from buildOrganInventory method then add the organs to the inventory
        List<CyberneticOrgan> organs = buildOrganInventory();
        OrganInventory inventory = new OrganInventory();
        for (CyberneticOrgan organ: organs) {
            inventory.addOrgan(organ);
        }


        // Create an instance of Patient and add an organ
        Patient patient = new Patient("John Doe", 30, "Healthy");
        System.out.println("Adding organs to patient " + patient.getName() + "...");
        //get one random organ from the inventory and add it to the patient using math.random

        int i = (int) (Math.random() * inventory.getOrganList().size());
        patient.addOrgan(inventory.getOrganList().get(i));
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

    private static List<CyberneticOrgan> buildOrganInventory() {
        //read the csv file
        String csvFile = "src/main/resources/sample-organ-list.csv";
        String line;
        String cvsSplitBy = ",";
        List<CyberneticOrgan> inventory = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); // skip the header
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] organ = line.split(cvsSplitBy);
                CyberneticOrgan newOrgan = new CyberneticOrgan(organ[0].trim(), organ[1].trim(), organ[2].trim(), organ[3].trim());
                inventory.add(newOrgan);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventory;
    }
}