package com.preprations.systemdesign.elevatorDesign;

import java.util.PriorityQueue;

class Elevator {
    private int id;
    private int currentFloor = 0;
    private Direction direction = Direction.IDLE;
    private PriorityQueue<Integer> requests = new PriorityQueue<>();

    public Elevator(int id) {
        this.id = id;
    }

    public void addRequest(int floor) {
        requests.offer(floor);
    }

    public void move() {
        if (requests.isEmpty()) {
            direction = Direction.IDLE;
            return;
        }

        int target = requests.peek();
        if (target > currentFloor) {
            currentFloor++;
            direction = Direction.UP;
        } else if (target < currentFloor) {
            currentFloor--;
            direction = Direction.DOWN;
        } else {
            System.out.println("Elevator " + id + " stopped at floor: " + currentFloor);
            requests.poll();
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getId() {
        return id;
    }
}
