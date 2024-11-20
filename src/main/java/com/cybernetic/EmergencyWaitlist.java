package com.cybernetic;

public class EmergencyWaitlist {
    private EmergencyCase root;

    public void addEmergencyCase(EmergencyCase node) {
        root = addEmergencyCaseRec(root, node);
    }
    private EmergencyCase addEmergencyCaseRec(EmergencyCase rootNode, EmergencyCase node) {
        if (rootNode == null) return node;
        if (node.getSeverityLevel() < rootNode.getSeverityLevel()) rootNode.setLeft(addEmergencyCaseRec(rootNode.getLeft(), node));
        else if (node.getSeverityLevel() > rootNode.getSeverityLevel()) rootNode.setRight(addEmergencyCaseRec(rootNode.getRight(), node));
        else {
            if (node.getRegistrationTime().isAfter(rootNode.getRegistrationTime())) rootNode.setLeft(addEmergencyCaseRec(rootNode.getLeft(), node));
            else rootNode.setRight(addEmergencyCaseRec(rootNode.getRight(), node));
        }
        return rootNode;
    }

    public EmergencyCase findCaseById(String caseId) {
        return findCaseByIdRec(root, caseId);
    }
    private EmergencyCase findCaseByIdRec(EmergencyCase rootNode, String caseId) {
        if (rootNode == null) return null;
        if (rootNode.getId().equals(caseId)) return rootNode;
        EmergencyCase leftResult = findCaseByIdRec(rootNode.getLeft(), caseId);
        if (leftResult != null) return leftResult;
        return findCaseByIdRec(rootNode.getRight(), caseId);
    }

    public void updateCaseSeverity(String caseId, int newLevel) {
        findCaseById(caseId).setSeverityLevel(newLevel);
    }

    public EmergencyCase getNextUrgentCase() {
        if (root == null) return null;
        EmergencyCase[] result = new EmergencyCase[1];
        root = getNextUrgentCaseRec(root, result);
        return result[0];
    }
    private EmergencyCase getNextUrgentCaseRec(EmergencyCase rootNode, EmergencyCase[] result) {
        if (rootNode == null) return null;
        if (rootNode.getRight() == null) {
            result[0] = rootNode;
            return rootNode.getLeft();
        }
        rootNode.setRight(getNextUrgentCaseRec(rootNode.getRight(), result));
        return rootNode;
    }
}
