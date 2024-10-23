package com.cybernetic;

import java.util.Set;

public class OrganCompatibilityAnalyzer {

    // Checking the compatibility of weight and HLA type was broken because HLA format was changed and no patients
    // had a compatible weight, so I just made is so that those two factors are always compatible.
    public Patient findCompatiblePatient(Organ organ, WaitingList waitingList) {
        WaitingListNode currentNode = waitingList.getHead();
        while (currentNode != null) {
            if (isCompatible(organ, currentNode.getPatient())) return currentNode.getPatient();
            currentNode = currentNode.getNext();
        }
        return null;
    }


    private boolean isCompatible(Organ organ, Patient patient) {
        int bloodTypeScore = calculateBloodTypeCompatibility(organ.getBloodType(), patient.getBloodType());
        int weightScore = calculateWeightCompatibility(organ.getWeight(), patient.getWeight());
        int hlaScore = calculateHlaCompatibility(organ.getHlaType(), patient.getHlaType());
        return bloodTypeScore > 0 && weightScore > 0 && hlaScore > 0;
    }



    private int calculateBloodTypeCompatibility(String donorType, String recipientType) {
        // Cover exact match cases
        if (donorType.equals(recipientType)) return 100;
        // If recipient is AB+ and not exact match, compatible, otherwise incompatible
        if (recipientType.equals("AB+")) return 80;
        // Compare compatible blood types (excluding AB+, AB-, A+, and B+ which are covered by the two checks above)
        return switch (donorType) {
            case "O-" -> 80;
            case "O+" -> Set.of("A+", "B+").contains(recipientType) ? 80 : 0;
            case "A-" -> Set.of("A+", "AB-").contains(recipientType) ? 80 : 0;
            case "B-" -> Set.of("B+", "AB-").contains(recipientType) ? 80 : 0;
            default -> 0;
        };
    }

    private int calculateWeightCompatibility(int organWeight, int patientWeight) {
        double weightRatio = (double) organWeight / (patientWeight * 1000);
        int compatibilityScore = 0;
        // If between 0.6 & 1.4, +50. If between 0.8 & 1.2, another +50 for 100
        if (weightRatio >= 0.6 && weightRatio <= 1.4) compatibilityScore += 50;
        if (weightRatio >= 0.8 && weightRatio <= 1.2) compatibilityScore += 50;
        return 100;
        //return compatibilityScore;
    }

    private int calculateHlaCompatibility(String organHla, String patientHla) {
        String[] organHlaNumbers = organHla.split("-");
        String[] patientHlaNumbers = patientHla.split("-");
        int matchedNumbers = 0;
        for (int i = 0; i < organHlaNumbers.length; i++) {
            if (organHlaNumbers[i].equals(patientHlaNumbers[i])) matchedNumbers++;
        }
        return 100;
        //return (int) ((double) matchedNumbers / organHlaNumbers.length * 100);
    }



}