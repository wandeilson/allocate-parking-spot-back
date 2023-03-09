package br.edu.ifpb.dac.wandeilson.projeto2jpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.wandeilson.projeto2jpa.models.Apartment;
import br.edu.ifpb.dac.wandeilson.projeto2jpa.repositories.ApartmentRepository;

import java.util.Optional;

@Service
public class ApartmentService {
	
	@Autowired
	private ApartmentRepository apartmentRepository;
	
	public void create(String block, String nameLocator, String number) {
		Apartment apartment = new Apartment(block, nameLocator, number);
		System.out.println(apartment);
		apartmentRepository.save(apartment);
		System.out.println("Apartment saved successfully.");
	}

    public void deleteById(Long idApartment) {
		apartmentRepository.deleteById(idApartment);
		System.out.println("Apartment successfully deleted.");
    }

	public void update(Long idApartment, Apartment apartment) {
		Optional<Apartment> apartmentSaved = apartmentRepository.findById(idApartment);
		if(apartmentSaved.isPresent()){
			Apartment apt = apartmentSaved.get();
			apt.setIdApartment(apartment.getIdApartment());
			apt.setBlock(apartment.getBlock());
			apt.setNumber(apartment.getNumber());
			apt.setNameLocator(apartment.getNameLocator());
			apartmentRepository.save(apt);
			System.out.println("Update performed successfully.");
		}
	}
}
