package com.cybernetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrganInventory {
    private final List<Organ> inventory;

    public OrganInventory() {
        this.inventory = new ArrayList<>();
    }

    public void addOrgan(Organ organ) {
        inventory.add(organ);
    }

    public List<Organ> getOrganList() {
        return Collections.unmodifiableList(inventory);
    }

    //ability to sort by multiple properties in order. name, model, compatibility using built-in sort
    public List<Organ> sortOrganByNameModelAndCompatibilityUsingBuiltInSort(List<Organ> unmodifiableOrganList) {
        List<Organ> organList = new ArrayList<>(unmodifiableOrganList);
        organList.sort(Comparator.comparing(Organ::getName).thenComparing(Organ::getModel).thenComparing(Organ::getCompatibility));
        return organList;
    }

    //ability to sort by multiple properties in order. name, model, compatibility using quicksort
    public List<Organ> quickSortOrganByNameModelAndCompatibility(List<Organ> unmodifiableOrganList) {
        List<Organ> organList = new ArrayList<>(unmodifiableOrganList);
        quickSort(organList, 0, organList.size() - 1);
        return organList;
    }

    private void quickSort(List<Organ> organs, int min, int max) {
        if (min < max) {
            Organ pivot = organs.get(max);
            Comparator<Organ> organComparator = Comparator.comparing(Organ::getName).thenComparing(Organ::getModel).thenComparing(Organ::getCompatibility);
            int i = min - 1;
            for (int j = min; j < max; j++) {
                if (organComparator.compare(organs.get(j), pivot) <= 0) {
                    i++;
                    Organ temp = organs.get(i);
                    organs.set(i, organs.get(j));
                    organs.set(j, temp);
                }
            }
            Organ temp = organs.get(i + 1);
            organs.set(i + 1, organs.get(max));
            organs.set(max, temp);

            int pivotIndex = i + 1;
            quickSort(organs, min, pivotIndex - 1);
            quickSort(organs, pivotIndex + 1, max);
        }
    }
}