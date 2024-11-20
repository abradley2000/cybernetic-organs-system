package com.cybernetic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransplantHistory {
    private TransplantRecord head;

    public void addTransplantRecordAtBeginning(TransplantRecord record) {
        record.setNext(head);
        head = record;
    }

    public List<TransplantRecord> findTransplantByPatient(String patientId) {
        List<TransplantRecord> result = new ArrayList<>();
        TransplantRecord current = head;
        while (current != null) {
            if (current.getPatientId().equals(patientId)) result.add(current);
            current = current.getNext();
        }
        return result;
    }

    public List<TransplantRecord> getRecentTransplants(int count) {
        List<TransplantRecord> result = new ArrayList<>();
        TransplantRecord current = head;
        for (int i = 0; current != null && i < count; i++) {
            result.add(current);
            current = current.getNext();
        }
        return result;
    }

    public List<TransplantRecord> getAllTransplantsByDate(LocalDateTime date) {
        List<TransplantRecord> result = new ArrayList<>();
        TransplantRecord current = head;
        while (current != null) {
            if (current.getTimestamp().equals(date)) result.add(current);
            current = current.getNext();
        }
        return result;
    }
}
