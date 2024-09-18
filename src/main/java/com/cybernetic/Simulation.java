package com.cybernetic;

import java.util.Random;

public class Simulation {
    private final Random rand = new Random();
    private final SimulationOrgan[] organs;
    private final SimulationOrgan heart;
    private final SimulationOrgan lung;
    private final SimulationOrgan brain;
    private int time = 100;

    public Simulation(SimulationOrgan inputHeart, SimulationOrgan inputLung, SimulationOrgan inputBrain) {
        heart = inputHeart;
        lung = inputLung;
        brain = inputBrain;
        organs = new SimulationOrgan[]{inputHeart, inputLung, inputBrain};
    }

    private void printSummary() {
        System.out.printf("Time: %d%n", 100 - time);
        System.out.printf("Heart Health: %d | Pump Rate: %d%n", heart.getHealth(), heart.getAttribute());
        System.out.printf("Lung Health: %d | Oxygen Level: %d%n", lung.getHealth(), lung.getAttribute());
        System.out.printf("Brain Health: %d | Control Efficiency: %d%n", brain.getHealth(), brain.getAttribute());
    }

    public void run() {
        // Initial print
        if (time == 100) System.out.printf("Time: %d\nInitial States:\nHeart Health: %d\nLung Health: %d\nBrain Health: %d%n", time, heart.getHealth(), lung.getHealth(), brain.getHealth());
        // Print out the summary for the current iteration
        printSummary();
        // If time went to 0, then that must mean the simulation was a success
        if (time == 0) {
            System.out.printf("Simulation Ended:\nTime: %d\nHeart Health: %d\nLung Health: %d\nBrain Health: %d%n", 100 - time, heart.getHealth(), lung.getHealth(), brain.getHealth());
            System.out.println("Simulation Result: Success");
            return;
        }
        // Check each organ on each loop
        for (SimulationOrgan organ : organs) {
            // On organ reaching 0 health, simulation is a failure, return and stop the loop
            if (organ.getHealth() == 0) {
                System.out.printf("Simulation Ended:\nTime: %d\nHeart Health: %d\nLung Health: %d\nBrain Health: %d%n", 100 - time, heart.getHealth(), lung.getHealth(), brain.getHealth());
                System.out.println("Simulation Result: Failure");
                return;
            }
            // On organ health dropping below 25, print alert
            if (organ.getHealth() < 25) {
                System.out.printf("ALERT at Time %d: %s Critical! Health at %d%%%n", 100 - time, organ.getName(), organ.getHealth());
            }
        }
        // Updating all the organs with their random fluctuations
        heart.updateOrgan(brain.getAttribute(), lung.getAttribute());
        lung.updateOrgan(heart.getAttribute(), heart.getAttribute());
        brain.updateOrgan(lung.getAttribute(), lung.getAttribute());
        // Random event, 10% chance, either subtracted or added to random organ health by 10
        if (rand.nextInt(10) < 1) {
            SimulationOrgan randomOrgan = organs[rand.nextInt(organs.length)];
            int randomHealth = rand.nextInt((10 - -10) + 1) + -10;
            randomOrgan.setHealth(randomOrgan.getHealth() + randomHealth);
            System.out.printf("EVENT at Time %d: Random health change for %s by %d%%%n", 100 - time, randomOrgan.getName(), randomHealth);
        }
        // Decrement time and do a recursive method call
        time--;
        run();
    }
}