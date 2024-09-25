package com.cybernetic;

import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrganInventory {
    private final List<Organ> inventory;

    public OrganInventory() {
        this.inventory = new ArrayList<>();
    }

    public void addOrgan(Organ organ) {
        inventory.add(organ);
        System.out.println("Added "+organ.getModel()+" to inventory");
    }

    public List<Organ> getOrganList() {
        return Collections.unmodifiableList(inventory);
    }

    //ability to sort by multiple properties in order.
    public List<Organ> sortOrganBy(String ...props){
        throw new UnsupportedOperationException("Not implemented yet");
    }
}