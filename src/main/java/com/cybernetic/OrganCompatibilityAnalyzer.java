package com.cybernetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OrganCompatibilityAnalyzer {
    private List<Organ> organs;
    private List<Patient> patients;

    public OrganCompatibilityAnalyzer() {
        organs = new ArrayList<>();
        patients = new ArrayList<>();
    }

    public void addOrgan(Organ organ) {
        organs.add(organ);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }


    public List<Organ> getCompatibleOrgans(Patient patient) {
        return organs.stream()
            .filter(organ -> isCompatible(organ, patient))
            .collect(Collectors.toList());
    }

    private boolean isCompatible(Organ organ, Patient patient) {
        int bloodTypeCompatibility = calculateBloodTypeCompatibility(organ.getBloodType(), patient.getBloodType());
        int weightCompatibility = calculateWeightCompatibility(organ.getWeight(), patient.getWeight());
        return bloodTypeCompatibility > 0 && weightCompatibility > 0;
    }

    public Map<Patient, List<Double>> calculateCompatibilityScores() {
        return patients.stream()
            .collect(Collectors.toMap(
                patient -> patient,
                patient -> organs.stream()
                    .map(organ -> calculateCompatibilityScore(organ, patient))
                    .collect(Collectors.toList())
            ));
    }

    public double calculateCompatibilityScore(Organ organ, Patient patient) {
        double bloodTypeScore = calculateBloodTypeCompatibility(organ.getBloodType(), patient.getBloodType());
        double weightScore = calculateWeightCompatibility(organ.getWeight(), patient.getWeight());
        double hlaScore = calculateHlaCompatibility(organ.getHlaType(), patient.getHlaType());
        return (bloodTypeScore * 0.4) + (weightScore * 0.3) + (hlaScore * 0.3);
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
        return compatibilityScore;
    }

    private int calculateHlaCompatibility(String organHla, String patientHla) {
        String[] organHlaNumbers = organHla.split("-");
        String[] patientHlaNumbers = patientHla.split("-");
        int matchedNumbers = 0;
        for (int i = 0; i < organHlaNumbers.length; i++) {
            if (organHlaNumbers[i].equals(patientHlaNumbers[i])) matchedNumbers++;
        }
        return (int) ((double) matchedNumbers / organHlaNumbers.length * 100);
    }



}