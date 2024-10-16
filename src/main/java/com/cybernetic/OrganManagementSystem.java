package com.cybernetic;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrganManagementSystem {
    private List<Organ> organs;
    private List<Patient> patients;

    public OrganManagementSystem(List<Organ> organs, List<Patient> patients) {
        this.organs = organs;
        this.patients = patients;
    }

    public Set<String> getUniqueBloodTypes() {
        return Stream.concat(
            organs.stream().map(Organ::getBloodType),
            patients.stream().map(Patient::getBloodType)
        ).collect(Collectors.toSet());
    }

    public Map<String, List<Patient>> groupPatientsByBloodType() {
        return patients.stream().collect(Collectors.groupingBy(Patient::getBloodType));
    }

    public List<Organ> sortOrgansByWeight() {
        List<Organ> sortedOrgans = new ArrayList<>(organs);
        sortedOrgans.sort(Comparator.comparingInt(Organ::getWeight));
        return sortedOrgans;
    }

    public List<Organ> getTopCompatibleOrgans(Patient patient, int n) {
        // I didn't know how else to get "top" compatibility scores besides creating a new analyzer class instance and use its scoring method
        OrganCompatibilityAnalyzer analyzer = new OrganCompatibilityAnalyzer();
        organs.forEach(analyzer::addOrgan);
        return organs.stream()
            .filter(organ -> analyzer.calculateCompatibilityScore(organ, patient) > 0)
            .sorted((organ1, organ2) -> Double.compare(analyzer.calculateCompatibilityScore(organ2, patient), analyzer.calculateCompatibilityScore(organ1, patient)))
            .limit(n)
            .collect(Collectors.toList());
    }




}
