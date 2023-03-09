package br.edu.ifpb.dac.wandeilson.projeto2jpa;

import br.edu.ifpb.dac.wandeilson.projeto2jpa.controllers.ParkingSpotController;
import br.edu.ifpb.dac.wandeilson.projeto2jpa.services.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifpb.dac.wandeilson.projeto2jpa.controllers.ApartmentController;

import java.util.Scanner;

@SpringBootApplication
public class ProjetoJpaApplication implements CommandLineRunner{
	
	@Autowired
	private ApartmentController apartmentController;
	@Autowired
	private ParkingSpotController parkingSpotController;
	@Autowired
	private ReadService readService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String menu = "1- Create new Apartment. "
				+ "\n2- Show all Apartments."
				+ "\n3- Show Aparment by ID."
				+ "\n4- Update Apartment by ID."
				+ "\n5- Delete Apartment by ID."
				+ "\n6- Create new Parking Spot. "
				+ "\n7- Show all Parking Spots."
				+ "\n8- Show Parking Spot by ID."
				+ "\n9- Update Parking Spot by ID."
				+ "\n10- Delete Parking Spot by ID.";
		System.out.println(menu);
		System.out.print("Option:");

		Integer opcao = Integer.parseInt(readService.read.nextLine());

		while(opcao != 0) {
			System.out.println(menu);
			System.out.print("Option:");
			opcao = Integer.parseInt(readService.read.nextLine());

			if(opcao == 1) {

			}
			if(opcao == 2) {

			}
			if(opcao == 3) {

			}
			if(opcao == 4) {

			}
			if(opcao == 5) {

			}
			if(opcao == 6) {
				System.out.print("Number: ");
				parkingSpotController.create(readService.read.nextLine());
			}
			if(opcao == 7) {

			}
			if(opcao == 8) {

			}
			if(opcao == 9) {

			}
			if(opcao == 10) {

			}
		}
		
	}
}
