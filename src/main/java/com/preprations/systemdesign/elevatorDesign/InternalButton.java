package com.preprations.systemdesign.elevatorDesign;

class InternalButton {
    private Elevator elevator;

    public InternalButton(Elevator elevator) {
        this.elevator = elevator;
    }

    public void press(int floor) {
        elevator.addRequest(floor);
    }
}