package com.cybernetic;

public class Lung extends SimulationOrgan{
    private final String name = "Lung";
    private final int divisor = 20;
    private final int subtrahend = 3;
    private final int lowerBound = -2;
    private final int upperBound = 1;

    public Lung() {
        super(95, 30);
    }

    @Override
    protected String getName() {
        return name;
    }
    @Override
    protected int getDivisor() {
        return divisor;
    }
    @Override
    protected int getSubtrahend() {
        return subtrahend;
    }
    @Override
    protected int getLowerBound() {
        return lowerBound;
    }
    @Override
    protected int getUpperBound() {
        return upperBound;
    }
}