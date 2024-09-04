package com.cybernetic;

import java.util.ArrayList;

public class OrganInventory {
    private ArrayList<CyberneticOrgan> inventory;

    // Constructor
    public OrganInventory() {
        inventory = new ArrayList<>();
    }

    public void addOrgan(CyberneticOrgan organ) {
        inventory.add(organ);
    }
    public CyberneticOrgan getOrgan(String model) {
        for (CyberneticOrgan organ : inventory) {
            if (organ.getModel().equals(model)) return organ;
        }
        return null;
    }
}
