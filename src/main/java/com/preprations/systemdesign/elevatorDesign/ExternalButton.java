package com.preprations.systemdesign.elevatorDesign;

class ExternalButton {
    private Direction direction;
    private int floor;

    public ExternalButton(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public void press(ElevatorController controller) {
        controller.requestElevator(floor, direction);
    }
}