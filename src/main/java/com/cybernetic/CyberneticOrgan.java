package com.cybernetic;

public class CyberneticOrgan {
    private String id;
    private String model;
    private String functionality;
    private String compatibility;

    // Constructor
    public CyberneticOrgan(String inputId, String inputModel, String inputFunctionality, String inputCompatibility) {
        id = inputId;
        model = inputModel;
        functionality = inputFunctionality;
        compatibility = inputCompatibility;
    }

    public String getDetails() {
        return String.format("ID: %d, Model: %s, Functionality: %s, Compatibility: %s", id, model, functionality, compatibility);
    }

    // Adding my own methods here to get an organ's information, so I can cleanly display it elsewhere
    public String getModel() {
        return model;
    }

    public String getFunctionality() {
        return functionality;
    }

    public boolean isCompatible(String patientCompatibility) {
        // I don't know  what criteria compatibility would need. Returning true as a placeholder
        return true;
    }
}
