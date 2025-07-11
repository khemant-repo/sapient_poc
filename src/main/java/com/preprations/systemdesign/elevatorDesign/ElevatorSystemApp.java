package com.preprations.systemdesign.elevatorDesign;// ElevatorSystemApp.java (Main)
import java.util.*;

public class ElevatorSystemApp {
    public static void main(String[] args) {
        ElevatorController controller = new ElevatorController(2); // 2 elevators

        // Simulate external requests
        controller.requestElevator(3, Direction.UP);
        controller.requestElevator(5, Direction.DOWN);

        // Simulate internal requests (elevator 0)
        controller.getElevators().get(0).addRequest(6);
        controller.getElevators().get(0).addRequest(1);

        // Simulate system steps
        for (int i = 0; i < 10; i++) {
            System.out.println("--- Step " + (i + 1) + " ---");
            controller.step();
        }
    }
}