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

    //2
    public void addOrgan(CyberneticOrgan organ) {
        inventory.add(organ);
        System.out.println("Added "+organ.getModel()+" to inventory");

    }

    public List<CyberneticOrgan> getOrganList() {
        return new ArrayList<>(inventory);
    }

    public void removeOrgan(String organ) {
        List<CyberneticOrgan> removedOrgans = new ArrayList<>();
        for (CyberneticOrgan invOrgan : inventory) {
            if (invOrgan.getModel().equals(organ)) {
                removedOrgans.add(invOrgan);
                inventory.remove(invOrgan);
            }
        }
        System.out.println("Organ removed from inventory: " + removedOrgans);
    }



    //3. search organs by functionality
    public List<CyberneticOrgan> searchOrganByFunctionality(String functionality) {
        List<CyberneticOrgan> result = new ArrayList<>();
        for (CyberneticOrgan organ : inventory) {
            if (organ.getFunctionality().equals(functionality)) {
                result.add(organ);
            }
        }
        return result;
    }


    //4. sort organs by model

    public List<CyberneticOrgan> sortOrgansByModel() {
        inventory.sort(Comparator.comparing(CyberneticOrgan::getModel));
        return new ArrayList<>(inventory);
    }


    //4 sort organs by functionality using bubble sort
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