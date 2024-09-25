package com.cybernetic.organs;


import java.util.Random;

public class Lung extends Organ {
    private static final String ORGAN_NAME = "Lung";

    private int oxygenLevel;
    private static final int MAX_OXYGEN_FLUCTUATION = 4;

    public Lung(String model, String functionality, String compatibility) {
        super(model, ORGAN_NAME, functionality, compatibility);
        oxygenLevel = 95; // Initial oxygen level
    }

    public void update(Heart heart, Brain brain, Random random) {
        // Random fluctuation in oxygen level (-2 to +1 percent)
        int randomFluctuation = random.nextInt(MAX_OXYGEN_FLUCTUATION) - (MAX_OXYGEN_FLUCTUATION / 2);
        // Update oxygen level based on heart pump rate and brain control efficiency
        oxygenLevel = Math.max(70, Math.min(100, oxygenLevel + heart.getPumpRate() / 20 - 3 + randomFluctuation));
        updateHealth(-1 + brain.getControlEfficiency() / 25 - 2);
    }

    public int getOxygenLevel() {
        return oxygenLevel;
    }
}