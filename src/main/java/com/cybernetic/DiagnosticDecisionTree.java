package com.cybernetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DiagnosticDecisionTree {
    private DiagnosticNode root;
    private List<String> diagnosticPath;

    public DiagnosticDecisionTree() {
        this.diagnosticPath = new ArrayList<>();
    }

    // Add this getter method that was missing
    public List<String> getDiagnosticPath() {
        return new ArrayList<>(diagnosticPath);  // Return a copy for encapsulation
    }

    public void addDiagnosticCriteria(String measurementType, double threshold, String diagnosis) {
        root = addDiagnosticCriteriaRecursive(root, measurementType, threshold, diagnosis);
    }

    public DiagnosticNode addDiagnosticCriteriaRecursive(DiagnosticNode node, String measurementType, double threshold, String diagnosis) {
        if (node == null)
            return new DiagnosticNode(measurementType, threshold, diagnosis);
        if (threshold < node.thresholdValue)
            node.left = addDiagnosticCriteriaRecursive(node.left, measurementType, threshold, diagnosis);
        else if (threshold >= node.thresholdValue)
            node.right = addDiagnosticCriteriaRecursive(node.right, measurementType, threshold, diagnosis);
        return node;
    }

    // Method to diagnose patient
    public String diagnosePatient(Map<String, Double> measurements) {
        diagnosticPath.clear();  // Clear previous diagnostic path
        return diagnosePatientRecursive(root, measurements, 1);
    }

    private String diagnosePatientRecursive(DiagnosticNode node, Map<String, Double> measurements, int level) {
        // ??????????
    }

    // Utility method to print tree structure
    public void printTree() {
        System.out.println("\nDiagnostic Tree Structure:");
        printTreeRec(root, "", true);
    }

    private void printTreeRec(DiagnosticNode node, String prefix, boolean isLeft) {
       throw new IllegalArgumentException("Method not implemented");
    }
}