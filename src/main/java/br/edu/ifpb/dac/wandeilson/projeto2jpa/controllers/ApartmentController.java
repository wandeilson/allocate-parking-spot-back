package br.edu.ifpb.dac.wandeilson.projeto2jpa.controllers;

import br.edu.ifpb.dac.wandeilson.projeto2jpa.models.Apartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.ifpb.dac.wandeilson.projeto2jpa.services.ApartmentService;

import java.util.List;

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
		System.out.println(apartmentService.readById(idApartment).toString());
	}

	public List<Apartment> showAll() {
		return apartmentService.showAll();
	}

	public void setParkingSpot(Long idApartment, Long idParkingSpot){
		apartmentService.setParkingSpot( idApartment ,idParkingSpot);
	}
}
