package br.edu.ifpb.dac.wandeilson.projeto2jpa.dtos;

import jakarta.persistence.Column;

public class ParkingSpotDTO {
    @Column(nullable = false)
    private String number;

    private Long idParkingSpot;

    public Long getIdParkingSpot() {
        return idParkingSpot;
    }
    public void setIdParkingSpot(Long idParkingSpot) {
        this.idParkingSpot = idParkingSpot;
    }

    public void setNumber(String number){
        this.number = number;
    }
    public String getNumber(){
        return this.number;
    }
}
