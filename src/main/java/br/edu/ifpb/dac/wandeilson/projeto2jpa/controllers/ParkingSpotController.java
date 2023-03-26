package br.edu.ifpb.dac.wandeilson.projeto2jpa.controllers;

import br.edu.ifpb.dac.wandeilson.projeto2jpa.dtos.ParkingSpotDTO;
import br.edu.ifpb.dac.wandeilson.projeto2jpa.models.ParkingSpot;
import br.edu.ifpb.dac.wandeilson.projeto2jpa.services.ParkingSpotService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parking-spot")
public class ParkingSpotController {

    @Autowired
    private ParkingSpotService parkingSpotService;

    @PostMapping
    public ResponseEntity<Object> create (@RequestBody @Valid ParkingSpot parkingSpot){
       return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.create(parkingSpot));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById( @PathVariable(value = "id") Long id){
        parkingSpotService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> update (@PathVariable(value = "id") Long id, @RequestBody @Valid ParkingSpotDTO parkingSpotDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body( parkingSpotService.update(parkingSpotDTO, id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping()
    public ResponseEntity<Object> showAll() {
       return ResponseEntity.status(HttpStatus.OK).body( parkingSpotService.showAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> readById( @PathVariable(value = "id") Long id ){
        try {
           return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.readById(id));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
