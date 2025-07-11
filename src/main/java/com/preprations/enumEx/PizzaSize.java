package com.preprations.enumEx;

enum PizzaSize {
    SMALL(8), MEDIUM(12), LARGE(16);

    private final int diameter;

    // Constructor
    PizzaSize(int diameter) {
        this.diameter = diameter;
    }

    public int getDiameter() {
        return diameter;
    }

    @Override
    public String toString() {
        return this.name() + " (" + diameter + " inches)";
    }
}
