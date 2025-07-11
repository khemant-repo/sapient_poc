package com.preprations.systemdesign.elevatorDesign;

import java.util.List;

class Scheduler {
    public Elevator scheduleElevator(List<Elevator> elevators, int floor, Direction direction) {
        // Simplified logic: choose elevator closest to requested floor
        Elevator best = elevators.get(0);
        int minDistance = Math.abs(floor - best.getCurrentFloor());

        for (Elevator elevator : elevators) {
            int distance = Math.abs(floor - elevator.getCurrentFloor());
            if (distance < minDistance) {
                best = elevator;
                minDistance = distance;
            }
        }

        return best;
    }
}
