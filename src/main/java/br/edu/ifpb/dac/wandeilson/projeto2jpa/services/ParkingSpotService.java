package br.edu.ifpb.dac.wandeilson.projeto2jpa.services;

import br.edu.ifpb.dac.wandeilson.projeto2jpa.models.ParkingSpot;
import br.edu.ifpb.dac.wandeilson.projeto2jpa.repositories.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ParkingSpotService {

    @Autowired
    private ParkingSpotRepository parkingSpotRepository;


    public void create(String number) {
        ParkingSpot parkingSpot = new ParkingSpot(number);
        parkingSpotRepository.save(parkingSpot);
        System.out.println("Parking Spot saved successfully.");
    }

    public void deleteById(Long idParkingSpot) {
        parkingSpotRepository.deleteById(idParkingSpot);
    }


    public void update(Long idParkingSpot, ParkingSpot parkingSpot) {
        Optional<ParkingSpot> parkingSpotSaved = parkingSpotRepository.findById(idParkingSpot);
        if(parkingSpotSaved.isPresent()){
            ParkingSpot pkSpot = parkingSpotSaved.get();
            pkSpot.setId(parkingSpot.getId());
            pkSpot.setNumber(parkingSpot.getNumber());
            parkingSpotRepository.save(pkSpot);
        }
    }

    public ParkingSpot readById(Long idParkingSpot) {
        Optional<ParkingSpot> parkingSpotSaved = parkingSpotRepository.findById(idParkingSpot);
        if(parkingSpotSaved.isPresent()){
            ParkingSpot pkSpot = parkingSpotSaved.get();
            return pkSpot;
        }
        return null;
    }
}
