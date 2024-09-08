package com.cybernetic;

import com.cybernetic.organs.Organ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrganInventory {
    private List<Organ> inventory;

    public OrganInventory() {
        this.inventory = new ArrayList<>();
    }

    //2
    public void addOrgan(Organ organ) {
        inventory.add(organ);
        System.out.println("Added "+organ.getModel()+" to inventory");

    }

    public List<Organ> getOrganList() {
        return Collections.unmodifiableList(inventory);
    }

    //3.3
    public Organ findOrganByModel(String model){
        return findOrganByModel(model,0);
    }

    private Organ findOrganByModel(String model, int index){
        if(index >= inventory.size()){
            return null;
        }
        if(inventory.get(index).getModel().equals(model)){
            return inventory.get(index);
        }
        return findOrganByModel(model,index+1);
    }

    //3.2
    public void removeDuplicateOrgans(){
        removeDuplicateOrgans(0);
    }

    private void removeDuplicateOrgans(int i) {
        if (i >= inventory.size()) {
            return;
        }
        Organ organ = inventory.get(i);
        for (int j = i + 1; j < inventory.size(); j++) {
            if (organ.getModel().equals(inventory.get(j).getModel())) {
                inventory.remove(j);
                j--;
            }
        }
        removeDuplicateOrgans(i + 1);
    }

}