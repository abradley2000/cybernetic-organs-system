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
        return Collections.unmodifiableList(inventory);
    }

    //3.3
    public CyberneticOrgan findOrganByModel(String model){
        return findOrganByModel(model,0);
    }

    private CyberneticOrgan findOrganByModel(String model,int index){
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
        CyberneticOrgan organ = inventory.get(i);
        for (int j = i + 1; j < inventory.size(); j++) {
            if (organ.getModel().equals(inventory.get(j).getModel())) {
                inventory.remove(j);
                j--;
            }
        }
        removeDuplicateOrgans(i + 1);
    }

}