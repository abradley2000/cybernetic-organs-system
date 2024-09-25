package com.cybernetic;

import com.cybernetic.organs.Brain;
import com.cybernetic.organs.Heart;
import com.cybernetic.organs.Lung;
import com.cybernetic.organs.Organ;

import java.util.Random;

public class OrganSimulator {

    public static Random random = new Random();
    public static void main(String[] args) {
        // Initialize organs
        Heart heart = new Heart("HeartEX1", "Pump blood", "A+");
        Lung lung = new Lung("LungXS1", "Oxygenate blood", "A+");
        Brain brain = new Brain("BrainZ2", "Control body functions", "A+");

        // Print initial state
        System.out.println("Time: 100");
        System.out.println("Initial State:");
        System.out.println("Heart Health: " + heart.getHealth());
        System.out.println("Lung Health: " + lung.getHealth());
        System.out.println("Brain Health: " + brain.getHealth());
        System.out.println();

        // start simulation
        simulate(heart, lung, brain, 100);
    }


    public static void simulate(Heart heart, Lung lung, Brain brain, int time) {

        //base case: end of simulation when time is 0 or health of any organ is 0
        if (time == 0 || heart.getHealth() == 0 || lung.getHealth() == 0 || brain.getHealth() == 0) {
            printFinalSummary(heart, lung, brain, 100 - time);
            return;
        }

        // Update organs and print state for each time step
        heart.update(lung, brain, random);
        lung.update(heart, brain, random);
        brain.update(heart, lung, random);

        //print current state
        System.out.println();
        System.out.println("Time: " + time);
        System.out.println("Heart Health: " + heart.getHealth() + " | Pump Rate: " + heart.getPumpRate());
        System.out.println("Lung Health: " + lung.getHealth() + " | Oxygen Level: " + lung.getOxygenLevel());
        System.out.println("Brain Health: " + brain.getHealth() + " | Control Efficiency: " + brain.getControlEfficiency());
        System.out.println();

        // Check for critical health levels
        checkHealthThresholds(heart, lung, brain, time);
        // Handle possible random events
        handleRandomEvent(heart, lung, brain, time);

        // Recursive call for next time step
        simulate(heart, lung, brain, time - 1);
    }

    // 10% chance of a random health change event
    private static void handleRandomEvent(Heart heart, Lung lung, Brain brain, int time) {
        if (random.nextDouble() < 0.1) { // 10% chance
            Organ targetOrgan = new Organ[]{heart, lung, brain}[random.nextInt(3)];
            int healthChange = random.nextInt(11) - 30;
            targetOrgan.updateHealth(healthChange);
            System.out.println("EVENT at Time " + time + ": Random health change for " + targetOrgan.getName() + " by " + healthChange + "%");
        }
    }

    private static void checkHealthThresholds(Heart heart, Lung lung, Brain brain, int time) {
        for (Organ organ : new Organ[]{heart, lung, brain}) {
            if (organ.getHealth() < 25) {
                System.out.println("ALERT at Time " + time + ": " + organ.getName() + " Critical! Health at " + organ.getHealth() + "%");
            }
        }
    }


    private static void printFinalSummary(Heart heart, Lung lung, Brain brain, int totalSteps) {

        System.out.println("Simulation Ended:");
        System.out.println("Time: " + totalSteps);
        System.out.println("Final States:");
        System.out.println("Heart Health: " + heart.getHealth());
        System.out.println("Lung Health: " + lung.getHealth());
        System.out.println("Brain Health: " + brain.getHealth());
        System.out.println("Simulation Result: " + (heart.getHealth() == 0 || lung.getHealth() == 0 || brain.getHealth() == 0 ? "Failure" : "Success"));
    }
}
