package com.parking.parkinglot.common;

public class CarDTO
{
    Long id;
    String parkingSpot;
    String ownerName;
    String licensePlate;

    public CarDTO(String parkingSpot, String ownerName, Long id, String licensePlate) {
        this.parkingSpot = parkingSpot;
        this.ownerName = ownerName;
        this.id = id;
        this.licensePlate = licensePlate;
    }



    public String getLicensePlate() {
        return licensePlate;
    }

    public Long getId() {
        return id;
    }

    public String getParkingSpot() {
        return parkingSpot;
    }

    public String getOwnerName() {
        return ownerName;
    }

}
