package com.cybernetic;

public class Heart extends SimulationOrgan{
    private final String name = "Heart";
    private final int divisor = 10;
    private final int subtrahend = 5;
    private final int lowerBound = -4;
    private final int upperBound = 3;

    public Heart() {
        super(70, 60);
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