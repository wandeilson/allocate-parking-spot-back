package br.edu.ifpb.dac.wandeilson.projeto2jpa.services;

import br.edu.ifpb.dac.wandeilson.projeto2jpa.dtos.ParkingSpotDTO;
import br.edu.ifpb.dac.wandeilson.projeto2jpa.models.ParkingSpot;
import br.edu.ifpb.dac.wandeilson.projeto2jpa.repositories.ParkingSpotRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParkingSpotService {

    @Autowired
    private ParkingSpotRepository parkingSpotRepository;


    public ParkingSpotDTO create(ParkingSpot parkingSpot) {
        ParkingSpotDTO parkingSpotDTO = new ParkingSpotDTO();
        BeanUtils.copyProperties(parkingSpotRepository.save(parkingSpot),
                parkingSpotDTO);
        return parkingSpotDTO;
    }

    public void deleteById(Long idParkingSpot) {
        parkingSpotRepository.deleteById(idParkingSpot);
    }

    public ParkingSpotDTO update(ParkingSpotDTO parkingSpotDTO, Long id) throws Exception {
        Optional<ParkingSpot> parkingSpotSaved = parkingSpotRepository.findById(id);
        if(parkingSpotSaved.isPresent()){
            ParkingSpot pkSpot = parkingSpotSaved.get();
            BeanUtils.copyProperties(parkingSpotDTO,pkSpot);
            parkingSpotRepository.save(pkSpot);
            return parkingSpotDTO;
        }
        throw new Exception("Error when updating.");
    }

    public ParkingSpotDTO readById(Long idParkingSpot) throws Exception {
        Optional<ParkingSpot> parkingSpotSaved = parkingSpotRepository.findById(idParkingSpot);
        if(parkingSpotSaved.isPresent()){
            ParkingSpot pkSpot = parkingSpotSaved.get();
            ParkingSpotDTO pkSpotDTO = new ParkingSpotDTO();
            BeanUtils.copyProperties(pkSpot, pkSpotDTO);
            return pkSpotDTO;
        }
        throw new Exception("Error when updating.");
    }

    public List<ParkingSpot> showAll() {
        return parkingSpotRepository.findAll();
        //List<ParkingSpotDTO> parkingSpotDTOS = new ArrayList<>();
       // for (ParkingSpot pkSpot: parkingSpots) {
         //   ParkingSpotDTO pkSpotDTO = new ParkingSpotDTO();
         //   BeanUtils.copyProperties(pkSpot, pkSpotDTO);
         //   parkingSpotDTOS.add(pkSpotDTO);
     //   }
     //   return parkingSpotDTOS;
    }
}
