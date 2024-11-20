package com.cybernetic;

import java.util.ArrayList;
import java.util.Collections;

public class OrganInventory {
    private ArrayList<CyberneticOrgan> organs = new ArrayList<>();
    private int maxCapacity = 1000;

    public void addOrgan(CyberneticOrgan organ) {
        if (organs.size() >= maxCapacity) throw new IllegalStateException("Maximum capacity for organ inventory reached.");
        for (CyberneticOrgan existingOrgan : organs) if (existingOrgan.getId().equals(organ.getId())) throw new IllegalStateException("Organ with same ID already exists.");
        organs.add(organ);
    }

    public ArrayList<CyberneticOrgan> sortByPowerLevel() {
        ArrayList<CyberneticOrgan> sortedList = new ArrayList<>(organs);
        quickSort(sortedList, 0, sortedList.size() - 1);
        return sortedList;
    }

    private void quickSort(ArrayList<CyberneticOrgan> list, int low, int high) {
        if (low < high) {
            int pivot = partition(list, low, high);
            quickSort(list, low, pivot - 1);
            quickSort(list, pivot + 1, high);
        }
    }

    private int partition(ArrayList<CyberneticOrgan> list, int low, int high) {
        CyberneticOrgan pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).getPowerLevel() > pivot.getPowerLevel()) {
                i++;
                CyberneticOrgan temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        Collections.swap(list, i + 1, high);
        return i + 1;
    }

    public ArrayList<CyberneticOrgan> sortByManufactureDate() {
        return mergeSort(new ArrayList<>(organs));
    }

    private ArrayList<CyberneticOrgan> mergeSort(ArrayList<CyberneticOrgan> sortedOrgans) {
        if (sortedOrgans.size() < 2) return sortedOrgans;
        int mid = sortedOrgans.size() / 2;
        ArrayList<CyberneticOrgan> left = new ArrayList<>(sortedOrgans.subList(0, mid));
        ArrayList<CyberneticOrgan> right = new ArrayList<>(sortedOrgans.subList(mid, sortedOrgans.size()));
        return merge(mergeSort(left), mergeSort(right));
    }

    private ArrayList<CyberneticOrgan> merge(ArrayList<CyberneticOrgan> left, ArrayList<CyberneticOrgan> right) {
        ArrayList<CyberneticOrgan> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getManufactureDate().isAfter(right.get(j).getManufactureDate())) merged.add(left.get(i++));
            else merged.add(right.get(j++));
        }
        while (i < left.size()) merged.add(left.get(i++));
        while (j < right.size()) merged.add(right.get(j++));
        return merged;
    }

    public ArrayList<CyberneticOrgan> sortByCompatibilityScore() {
        ArrayList<CyberneticOrgan> organsSorted = new ArrayList<>(organs);
        for (int i = 0; i < organsSorted.size() - 1; i++) {
            for (int j = 0; j < organsSorted.size() - (i + 1); j++) {
                if (organsSorted.get(j).getCompatibilityScore() < organsSorted.get(j + 1).getCompatibilityScore()) {
                    Collections.swap(organsSorted, j, j + 1);
                }
            }
        }
        return organsSorted;
    }
}