package com.cybernetic;

public class WaitingListNode {
    private Patient patient;
    private int priority;
    private WaitingListNode next;

    public WaitingListNode(Patient patient, int priority) {
        this.patient = patient;
        this.priority = priority;
        this.next = null;
    }

    public Patient getPatient() {
        return patient;
    }
    public int getPriority() {
        return priority;
    }
    public WaitingListNode getNext() {
        return next;
    }
    public void setNext(WaitingListNode next) {
        this.next = next;
    }
}
