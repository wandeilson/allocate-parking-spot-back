package br.edu.ifpb.dac.wandeilson.projeto2jpa.controllers;

import br.edu.ifpb.dac.wandeilson.projeto2jpa.models.ParkingSpot;
import br.edu.ifpb.dac.wandeilson.projeto2jpa.services.ParkingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class ParkingSpotController {

    @Autowired
    private ParkingSpotService parkingSpotService;

    public void create (String number){
        parkingSpotService.create(number);
    }

    public void deleteById(Long idParkingSpot){
        parkingSpotService.deleteById(idParkingSpot);
    }

    public void update (Long idParkingSpot, ParkingSpot parkingSpot){
        parkingSpotService.update(idParkingSpot, parkingSpot);
    }

    public void readByID (Long idParkingSpot){
        System.out.println(parkingSpotService.readById(idParkingSpot).toString());
    }
}
