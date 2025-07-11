package com.preprations.systemdesign.elevatorDesign;

// Button classes (not actively used in test, but part of design)
class Button {
    protected int floor;

    public Button(int floor) {
        this.floor = floor;
    }

    public void press() {
        System.out.println("Button pressed at floor: " + floor);
    }
}