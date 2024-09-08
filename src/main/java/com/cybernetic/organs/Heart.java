package com.cybernetic.organs;


import java.util.Random;
import java.util.UUID;

// Brain organ class
public class Heart extends Organ {
    private static final String ORGAN_NAME = "Heart";
    private int pumpRate;
    private static final int MAX_HEART_RATE_FLUCTUATION = 8;


    public Heart(String model, String functionality, String compatibility) {
        super(model, ORGAN_NAME, functionality, compatibility);
        pumpRate = 70; // Initial pump rate
    }

    // Update heart state based on lung and brain states
    public void update(Lung lung, Brain brain, Random random) {
        // Random fluctuation in heart rate (-4 to +3 beats per minute)
        int randomFluctuation = random.nextInt(MAX_HEART_RATE_FLUCTUATION) - (MAX_HEART_RATE_FLUCTUATION / 2);

        pumpRate = Math.max(40, Math.min(100, pumpRate + brain.getControlEfficiency() / 10 - 5 + randomFluctuation));
        updateHealth(-1 + lung.getOxygenLevel() / 25 - 2);
    }

    public int getPumpRate() {
        return pumpRate;
    }
}