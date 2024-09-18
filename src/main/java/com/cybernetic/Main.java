package com.cybernetic;

public class Main {
    public static void main(String[] args) {
        Simulation sim = new Simulation(new Heart(), new Lung(), new Brain());
        sim.run();
    }
}