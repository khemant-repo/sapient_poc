package com.preprations.systemdesign.elevatorDesign;

import java.util.ArrayList;
import java.util.List;

class ElevatorController {
    private List<Elevator> elevators;
    private Scheduler scheduler;

    public ElevatorController(int numElevators) {

        elevators = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            elevators.add(new Elevator(i));
        }
        scheduler = new Scheduler();
    }

    public void requestElevator(int floor, Direction direction) {
        Elevator elevator = scheduler.scheduleElevator(elevators, floor, direction);
        System.out.println("Request at floor " + floor + " assigned to Elevator " + elevator.getId());
        elevator.addRequest(floor);
    }

    public void step() {
        for (Elevator elevator : elevators) {
            elevator.move();
        }
    }

    public List<Elevator> getElevators() {
        return elevators;
    }
}