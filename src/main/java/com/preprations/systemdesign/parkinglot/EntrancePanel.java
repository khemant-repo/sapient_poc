package com.preprations.systemdesign.parkinglot;

class EntrancePanel {
    String panelId;

    public EntrancePanel(String panelId) {
        this.panelId = panelId;
    }

    public ParkingTicket printTicket(ParkingLot lot, Vehicle vehicle) {
        return lot.getNewParkingTicket(vehicle);
    }
}