package com.cybernetic;

import java.time.Duration;
import java.time.LocalDateTime;

public class EmergencyCase {
    private String caseId;
    private Patient patient;
    private int severityLevel;
    private LocalDateTime registrationTime;
    private EmergencyCase left, right;

    public EmergencyCase(String caseId, Patient patient, int severityLevel, LocalDateTime registrationTime) {
        this.caseId = caseId;
        this.patient = patient;
        this.severityLevel = severityLevel;
        this.registrationTime = registrationTime;
        this.left = this.right = null;
    }

    public int getSeverityLevel() {
        return severityLevel;
    }

    public void setLeft(EmergencyCase emergencyCase) {
        left = emergencyCase;
    }

    public EmergencyCase getLeft() {
        return left;
    }

    public void setRight(EmergencyCase emergencyCase) {
        right = emergencyCase;
    }

    public EmergencyCase getRight() {
        return right;
    }

    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }

    public String getId() {
        return caseId;
    }

    public void setSeverityLevel(int severityLevel) {
        this.severityLevel = severityLevel;
    }

    @Override
    public String toString() {
        return caseId + " (Severity " + severityLevel + ", Wait time: " + Duration.between(registrationTime, LocalDateTime.now()).toMinutes() + " min)";
    }
}
