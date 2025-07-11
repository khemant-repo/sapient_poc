package com.preprations.systemdesign.parkinglot;

class ExitPanel {
    String panelId;

    public ExitPanel(String panelId) {
        this.panelId = panelId;
    }

    public void scanTicketAndExit(ParkingLot lot, Vehicle vehicle) {
        lot.exitVehicle(vehicle);
    }
}