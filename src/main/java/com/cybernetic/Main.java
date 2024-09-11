package com.cybernetic;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Patient patient1 = new Patient("John Doe", 20, "N/A");
        OrganInventory inventory = new OrganInventory();
        CyberneticOrgan organ1 = new CyberneticOrgan("ORG001", "CyberHeartX1", "Pumps blood", "Type O");
        CyberneticOrgan organ2 = new CyberneticOrgan("ORG002", "CyberEyeV2", "Enhanced vision", "Type A");

        System.out.println("Adding organs to inventory...");
        inventory.addOrgan(organ1);
        inventory.addOrgan(organ2);

        System.out.println("Adding organs to patient John Doe...");
        patient1.addOrgan(organ1);

        System.out.println("Listing installed organs for John Doe:");
        for (CyberneticOrgan organ : patient1.getOrganList()) {
            System.out.println("- " + organ.getModel() + ": " + organ.getFunctionality());
        }

        ArrayList<CyberneticOrgan> matchingOrgans = inventory.searchOrganByFunctionality("Enhanced vision");
        System.out.println("Searching for organs with functionality 'Enhanced vision'...");
        System.out.println("Found " + matchingOrgans.size() + " organ(s):");
        for (CyberneticOrgan organ : matchingOrgans) {
            System.out.println("- " + organ.getModel() + ": " + organ.getFunctionality());
        }

        System.out.println("Sorting organs by model name in inventory...");
        System.out.println("Sorted organs:");
        for (CyberneticOrgan organ : inventory.sortOrgansByModel()) {
            System.out.println("- " + organ.getModel());
        }
    }
}