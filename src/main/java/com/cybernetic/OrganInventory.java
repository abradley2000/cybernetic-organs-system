package com.cybernetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrganInventory {
    private ArrayList<CyberneticOrgan> inventory;

    // Constructor
    public OrganInventory() {
        inventory = new ArrayList<>();
    }

    public void addOrgan(CyberneticOrgan organ) {
        inventory.add(organ);
        System.out.println("Added " + organ.getModel() + " to inventory.");
    }

    public void removeOrgan(String model) {
        for (CyberneticOrgan organ : inventory) {
            if (organ.getModel().equals(model)) {
                inventory.remove(organ);
                System.out.println("Organ successfully removed.");
                return;
            }
        }
        System.out.println("Could not find matching organ to remove.");
    }

    public CyberneticOrgan getOrgan(String model) {
        for (CyberneticOrgan organ : inventory) {
            if (organ.getModel().equals(model)) return organ;
        }
        return null;
    }

    public ArrayList<CyberneticOrgan> getOrganList() {
        return new ArrayList<>(inventory);
    }

    public ArrayList<CyberneticOrgan> searchOrganByFunctionality(String functionality) {
        ArrayList<CyberneticOrgan> matchingOrgans = new ArrayList<>();
        for (CyberneticOrgan organ : inventory) {
            if (organ.getFunctionality().equals(functionality)) matchingOrgans.add(organ);
        }
        return matchingOrgans;
    }

    public ArrayList<CyberneticOrgan> sortOrgansByModel() {
        ArrayList<CyberneticOrgan> organs = new ArrayList<>(inventory);
        organs.sort(Comparator.comparing(CyberneticOrgan::getModel));
        return organs;
    }
}
