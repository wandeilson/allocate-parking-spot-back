package br.edu.ifpb.dac.wandeilson.projeto2jpa.services;

import br.edu.ifpb.dac.wandeilson.projeto2jpa.models.ParkingSpot;
import br.edu.ifpb.dac.wandeilson.projeto2jpa.repositories.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.wandeilson.projeto2jpa.models.Apartment;
import br.edu.ifpb.dac.wandeilson.projeto2jpa.repositories.ApartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ApartmentService {
	
	@Autowired
	private ApartmentRepository apartmentRepository;
	@Autowired
	private ParkingSpotRepository parkingSpotRepository;
	
	public void create(String block, String nameLocator, String number) {
		Apartment apartment = new Apartment(block, nameLocator, number);
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
			apt.setBlock(apartment.getBlock());
			apt.setNumber(apartment.getNumber());
			apt.setNameLocator(apartment.getNameLocator());
			apartmentRepository.save(apt);
			System.out.println("Update performed successfully.");
		}
	}

	public Apartment readById(Long idApartment) {
		Optional<Apartment> apartmentSaved = apartmentRepository.findById(idApartment);
		if(apartmentSaved.isPresent()){
			Apartment apt = apartmentSaved.get();
			return apt;
		}
		return null;
	}

	public List<Apartment> showAll() {
		return apartmentRepository.findAll();
	}

	public void setParkingSpot(Long idParkingSpot, Long parkingSpot) {
		Optional<Apartment> aptOptional = apartmentRepository.findById(idParkingSpot);
		if (aptOptional.isPresent()){
			Apartment apt = aptOptional.get();
			Optional<ParkingSpot> pkSpotOptional = parkingSpotRepository.findById(idParkingSpot);
			if(pkSpotOptional.isPresent()){
				ParkingSpot pkSpot = pkSpotOptional.get();
				apt.setParkingSpot(pkSpot);
				apartmentRepository.save(apt);
			}
		}

	}
}
