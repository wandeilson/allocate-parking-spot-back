package br.edu.ifpb.dac.wandeilson.projeto2jpa.controllers;

import br.edu.ifpb.dac.wandeilson.projeto2jpa.models.Apartment;
import br.edu.ifpb.dac.wandeilson.projeto2jpa.models.ParkingSpot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.ifpb.dac.wandeilson.projeto2jpa.services.ApartmentService;

import java.util.UUID;

@Controller
public class ApartmentController {
	
	@Autowired
	private ApartmentService apartmentService;
	
	public void create (String block, String nameLocator, String number) {
		apartmentService.create(block, nameLocator, number);
	}

	public void deleteById(Long idApartment){
		apartmentService.deleteById(idApartment);
	}

	public void update (Long idApartment, Apartment apartment){
		apartmentService.update(idApartment, apartment);
	}

	public void readByID (Long idApartment) {

	}
}
