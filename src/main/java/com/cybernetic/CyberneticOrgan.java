package com.cybernetic;

import java.time.LocalDate;
import java.util.Set;

public class CyberneticOrgan {
    private String id;
    private String type;
    private String model;
    private int powerLevel;
    private double compatibilityScore;
    private LocalDate manufactureDate;
    private String status;
    private String manufacturer;

    public CyberneticOrgan (String id, String type, String model, int powerLevel, double compatibilityScore, LocalDate manufactureDate, String status, String manufacturer) {

        if (manufactureDate.isAfter(LocalDate.now())) throw new IllegalArgumentException("Organ manufacture date is invalid.");
        if (powerLevel < 1 || powerLevel > 100) throw new IllegalArgumentException("Organ power level is invalid.");
        if (compatibilityScore < 0 || compatibilityScore > 1) throw new IllegalArgumentException("Organ compatibility score is invalid.");
        if (!Set.of("HEART", "LUNG", "KIDNEY", "LIVER").contains(type)) throw new IllegalArgumentException("Organ type is invalid.");

        this.id = id;
        this.type = type;
        this.model = model;
        this.powerLevel = powerLevel;
        this.compatibilityScore = compatibilityScore;
        this.manufactureDate = manufactureDate;
        this.status = status;
        this.manufacturer = manufacturer;
    }

    public String getId() {
        return id;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public String getType() {
        return type;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public double getCompatibilityScore() {
        return compatibilityScore;
    }
}