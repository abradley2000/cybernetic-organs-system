package com.cybernetic;

import java.util.Random;

public abstract class SimulationOrgan {
    private int health = 100;
    private int attribute;
    // Range down from 100
    private final int attributeRange;
    private final Random rand = new Random();

    public SimulationOrgan(int initialAttribute, int inputAttributeRange) {
        attribute = initialAttribute;
        attributeRange = inputAttributeRange;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int inputHealth) {
        health = Math.max(0, Math.min(100, inputHealth));
    }

    public int getAttribute() {
        return attribute;
    }

    public void setAttribute(int inputAttribute) {
        attribute = Math.max(100 - attributeRange, Math.min(100, inputAttribute));
    }

    public void updateOrgan(int attributeDependency, int healthDependency) {
        int randomFluctuation = rand.nextInt((getUpperBound() - getLowerBound()) + 1) + getLowerBound();
        // Messy comment to log things in terminal for testing
        // System.out.println("New Attribute = " + attribute + " + " + "(" + attributeDependency + " / " + getDivisor() + ") - " + getSubtrahend() + " + " + randomFluctuation + " = " + (attribute + (attributeDependency / getDivisor()) - getSubtrahend() + randomFluctuation));
        setAttribute(attribute + (attributeDependency / getDivisor()) - getSubtrahend() + randomFluctuation);
        setHealth(health + (-1 + (healthDependency / 25) - 2));
    }

    // Child classes (specific organs) will override these with their specific values
    protected abstract String getName();
    protected abstract int getDivisor();
    protected abstract int getSubtrahend();
    protected abstract int getLowerBound();
    protected abstract int getUpperBound();
}