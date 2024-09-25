package com.cybernetic.organs;


import java.util.Random;

public class Brain extends Organ {
    private static final String ORGAN_NAME = "Brain";
    private int controlEfficiency;
    private static final int MAX_CONTROL_FLUCTUATION = 4;

    public Brain(String model, String functionality, String compatibility) {
        super(model, ORGAN_NAME, functionality, compatibility);
        controlEfficiency = 90; // Initial control efficiency
    }

    public void update(Heart heart, Lung lung, Random random) {
        // Random fluctuation in control efficiency (-2 to +1 percent)
        int randomFluctuation = random.nextInt(MAX_CONTROL_FLUCTUATION) - (MAX_CONTROL_FLUCTUATION / 2);

        controlEfficiency = Math.max(50, Math.min(100, controlEfficiency + lung.getOxygenLevel() / 20 - 3 + randomFluctuation));

        updateHealth(-1 + heart.getPumpRate() / 25 - 2);
    }

    public int getControlEfficiency() {
        return controlEfficiency;
    }
}