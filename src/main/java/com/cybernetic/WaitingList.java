package com.cybernetic;

import lombok.Data;

@Data
public class WaitingList {
    private WaitingListNode head;

    public void addPatient(Patient patient, int priority) {
        WaitingListNode newPatientNode = new WaitingListNode(patient, priority);
        if (head == null || head.getPriority() < newPatientNode.getPriority()) {
            newPatientNode.setNext(head);
            head = newPatientNode;
        } else {
            WaitingListNode currentNode = head;
            while (currentNode.getNext() != null && currentNode.getNext().getPriority() > newPatientNode.getPriority()) {
                currentNode = currentNode.getNext();
            }
            newPatientNode.setNext(currentNode.getNext());
            currentNode.setNext(newPatientNode);
        }
    }
    public Patient removeHighestPriority() {
        Patient highestPriorityPatient = head.getPatient();
        head = head.getNext();
        return highestPriorityPatient;
    }
    public void updatePriority(String patientId, int newPriority) {
        WaitingListNode removedNode = removePatient(patientId);
        addPatient(removedNode.getPatient(), newPriority);
    }
    // I changed the return type from void to WaitingListNode so that it would be easier to update the priority above
    public WaitingListNode removePatient(String patientId) {
        if (head.getPatient().getId().equals(patientId)) {
            WaitingListNode removedNode = head;
            head = head.getNext();
            return removedNode;
        }
        WaitingListNode currentNode = head;
        while (currentNode.getNext() != null && !currentNode.getNext().getPatient().getId().equals(patientId)) {
            currentNode = currentNode.getNext();
        }
        WaitingListNode removedNode = currentNode.getNext();
        currentNode.setNext(currentNode.getNext().getNext());
        return removedNode;
    }
    public void displayWaitingList() {
        WaitingListNode currentNode = head;
        int position = 1;
        while (currentNode != null) {
            System.out.println(position + ". " + currentNode.getPatient().getName() + " (Priority: " + currentNode.getPriority() + ")");
            currentNode = currentNode.getNext();
            position++;
        }
    }
    public int getPosition(String patientId) {
        WaitingListNode currentNode = head;
        int position = 1;
        while (currentNode != null) {
            if (currentNode.getPatient().getId().equals(patientId)) {
                return position;
            }
            currentNode = currentNode.getNext();
            position++;
        }
        return -1;
    }
    public WaitingListNode getHead() {
        return head;
    }
}
