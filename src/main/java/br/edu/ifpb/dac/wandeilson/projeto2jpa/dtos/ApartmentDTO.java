package br.edu.ifpb.dac.wandeilson.projeto2jpa.dtos;

import br.edu.ifpb.dac.wandeilson.projeto2jpa.models.ParkingSpot;
import jakarta.persistence.Column;

public class ApartmentDTO {

    private ParkingSpot parkingSpot;
    @Column(nullable = false)
    private String block;

    @Column(nullable = false)
    private String nameLocator;

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getNameLocator() {
        return nameLocator;
    }

    public void setNameLocator(String nameLocator) {
        this.nameLocator = nameLocator;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Column (nullable = false)
    private String number;
}
