package com.cybernetic;

import java.time.LocalDateTime;

public class TransplantRecord {
    private String operationId;
    private String patientId;
    private String organId;
    private LocalDateTime timestamp;
    private String surgeon;
    private String outcome;
    private TransplantRecord next;

    public TransplantRecord(String operationId, String patientId, String organId, String surgeon, String outcome) {
        this.operationId = operationId;
        this.patientId = patientId;
        this.organId = organId;
        this.surgeon = surgeon;
        this.outcome = outcome;
    }

    public String getPatientId() {
        return patientId;
    }

    public TransplantRecord getNext() {
        return next;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setNext(TransplantRecord next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return operationId + ": " + patientId + " (" + outcome + ")";
    }
}