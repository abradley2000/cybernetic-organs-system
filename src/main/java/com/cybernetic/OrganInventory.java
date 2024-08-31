package com.cybernetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrganInventory {
    private List<CyberneticOrgan> inventory;

    public OrganInventory() {
        this.inventory = new ArrayList<>();
    }

    public void addOrgan(CyberneticOrgan organ) {
        inventory.add(organ);
        // Simplified confirmation message
        System.out.println("Organ added to inventory: " + organ.getDetails());
    }

    public CyberneticOrgan getOrgan(String model) {
        for (CyberneticOrgan organ : inventory) {
            if (organ.getModel().equals(model)) {
                return organ;
            }
        }
        // Return a dummy organ or a simple message for now
        System.out.println("Organ with model " + model + " not found.");
        return null;
    }

    public List<CyberneticOrgan> searchOrganByFunctionality(String functionality) {
        List<CyberneticOrgan> result = new ArrayList<>();
        for (CyberneticOrgan organ : inventory) {
            if (organ.getFunctionality().equals(functionality)) {
                result.add(organ);
            }
        }
        return result;
    }

    //sort organs by model
    public List<CyberneticOrgan> sortOrgansByModel() {
        Collections.sort(inventory, new Comparator<CyberneticOrgan>() {
            @Override
            public int compare(CyberneticOrgan o1, CyberneticOrgan o2) {
                return o1.getModel().compareTo(o2.getModel());
            }
        });
        return new ArrayList<>(inventory);
    }


    //sort organs by functionality using bubble sort
    public List<CyberneticOrgan> sortOrgansByFunctionality() {
        int n = inventory.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (inventory.get(j).getFunctionality().compareTo(inventory.get(j + 1).getFunctionality()) > 0) {
                    // Swap inventory[j] and inventory[j+1]
                    CyberneticOrgan temp = inventory.get(j);
                    inventory.set(j, inventory.get(j + 1));
                    inventory.set(j + 1, temp);
                }
            }
        }
        return new ArrayList<>(inventory);
    }
}