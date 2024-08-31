package com.cybernetic;

import java.util.ArrayList;
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
}