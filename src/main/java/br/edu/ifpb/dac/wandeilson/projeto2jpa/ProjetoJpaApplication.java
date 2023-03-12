package br.edu.ifpb.dac.wandeilson.projeto2jpa;

import br.edu.ifpb.dac.wandeilson.projeto2jpa.controllers.ParkingSpotController;
import br.edu.ifpb.dac.wandeilson.projeto2jpa.models.Apartment;
import br.edu.ifpb.dac.wandeilson.projeto2jpa.models.ParkingSpot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifpb.dac.wandeilson.projeto2jpa.controllers.ApartmentController;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ProjetoJpaApplication implements CommandLineRunner{
	
	@Autowired
	private ApartmentController apartmentController;
	@Autowired
	private ParkingSpotController parkingSpotController;

	
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
				+ "\n10- Delete Parking Spot by ID."
				+ "\n11- Add Parking Spot to Apartment."
				+ "\n0- Exit.";


		String option = "1";

		while(!option.equals("0")) {
			System.out.print(menu);
			System.out.print("\nOption:");

			option = readInput().nextLine();

			switch (option) {
				case "1":
					System.out.print("Block: ");
					String block = readInput().nextLine();
					System.out.print("Name: ");
					String nameLocator = readInput().nextLine();
					System.out.print("Number: ");
					String number = readInput().nextLine();
					apartmentController.create(block, nameLocator, number);
					break;

				case "2":
					List<Apartment> allApartents = apartmentController.showAll();
					for (Apartment apt : allApartents) {
						System.out.println(apt + "\n________________________________________");
					}
					break;

				case "3":
					System.out.print("Id: ");
					Long id = Long.parseLong(readInput().nextLine());
					apartmentController.readByID(id);
					break;

				case "4":
					System.out.print("Id: ");
					id = Long.parseLong(readInput().nextLine());
					System.out.println("Please enter updated values.");
					System.out.print("Block: ");
					block = readInput().nextLine();
					System.out.print("Name: ");
					nameLocator = readInput().nextLine();
					System.out.print("Number: ");
					number = readInput().nextLine();
					Apartment apartment = new Apartment(block, nameLocator, number);
					apartmentController.update(id, apartment);
					break;

				case "5":
					System.out.print("Id: ");
					apartmentController.deleteById(Long.parseLong(readInput().nextLine()));
					break;

				case "6":
					System.out.print("Number: ");
					parkingSpotController.create(readInput().nextLine());
					break;

				case "7":
					List<ParkingSpot> allParkingSpots = parkingSpotController.showAll();
					for (ParkingSpot pkSpt : allParkingSpots) {
						System.out.println(pkSpt + "\n___________________________" +
								"________________________________________________");
					}
					break;

				case "8":
					System.out.print("Id: ");
					parkingSpotController.readByID(Long.parseLong(readInput().nextLine()));
					break;

				case "9":
					System.out.print("Id: ");
					id = Long.parseLong(readInput().nextLine());
					System.out.print("Please enter updated values.\nNumber: ");
					number = readInput().nextLine();
					ParkingSpot pk = new ParkingSpot(number);
					parkingSpotController.update(id, pk);
					break;

				case "10":
					System.out.print("Id: ");
					parkingSpotController.deleteById(Long.parseLong(readInput().nextLine()));
					break;

				case "11":
					System.out.print("Id Apartment:");
					Long idAparment = Long.parseLong(readInput().nextLine());
					System.out.print("Id Parking Spot");
					Long idParkingSpot = Long.parseLong(readInput().nextLine());
					apartmentController.setParkingSpot(idParkingSpot, idParkingSpot);
					break;
				default:
					System.out.println("Invalid option.");
			}
		}
	}

	public Scanner readInput (){
		return new Scanner(System.in);
	}

}
