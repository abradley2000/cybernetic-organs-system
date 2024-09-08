package com.cybernetic;

import com.cybernetic.organs.Organ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        // Create an instance of OrganInventory and add organs
        System.out.println("Adding organs to inventory...");

        // build the organ inventory from buildOrganInventory method then add the organs to the inventory
        List<Organ> organs = buildOrganInventory();
        OrganInventory inventory = new OrganInventory();
        for (Organ organ : organs) {
            inventory.addOrgan(organ);
        }


        //1. search in OrganInventory
        String organToSearch = "CyberLiverQ4";
        Organ organ = inventory.findOrganByModel(organToSearch);
        if (organ == null) {
            System.out.println("Organ: " + organToSearch + " not found");
        } else {
            System.out.println("Organ: " + organToSearch + " found detail: " + organ.getDetails());
        }


        //2. deduplicate the inventory
        System.out.println("Before deduplication: Total organs in inventory: " + inventory.getOrganList().size());
        inventory.removeDuplicateOrgans();
        System.out.println("After deduplication: Total organs in inventory: " + inventory.getOrganList().size());

    }

    //3.1
    private static List<Organ> buildOrganInventory() {
        //read the csv file
        String csvFile = "src/main/resources/sample-organ-list.csv";
        String line;
        String cvsSplitBy = ",";
        List<Organ> inventory = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); // skip the header
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] organ = line.split(cvsSplitBy);
                Organ newOrgan = new Organ(UUID.randomUUID().toString(), organ[0].trim(), organ[1].trim(), organ[2].trim());
                inventory.add(newOrgan);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventory;
    }
}