package br.edu.ifpb.dac.wandeilson.projeto2jpa.dtos;

import jakarta.persistence.Column;

public class ParkingSpotDTO {
    @Column(nullable = false)
    private String number;
    public void setNumber(String number){
        this.number = number;
    }
    public String getNumber(){
        return this.number;
    }
}
