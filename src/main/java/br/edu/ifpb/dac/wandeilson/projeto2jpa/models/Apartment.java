package br.edu.ifpb.dac.wandeilson.projeto2jpa.models;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table (name="apartment")
public class Apartment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_apartment")
	private Long idApartment;

	@OneToOne
	@JoinColumn(name = "id_parking_spot")
	private ParkingSpot parkingSpot;
	
	@Column(nullable = false)
	private String block;
	
	@Column(nullable = false, name="name_locator")
	private String nameLocator;
	
	@Column (nullable = false)
	private String number;
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setParkingSpot (ParkingSpot parkingSpot){
		this.parkingSpot = parkingSpot;
	}

	public ParkingSpot getParkingSpot(){
		return this.parkingSpot;
	}

	public Long getIdApartment() {
		return idApartment;
	}

	public void setIdApartment(Long idApartment) {
		this.idApartment = idApartment;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getNameLocator() {
		return nameLocator;
	}

	public void setNameLocator(String nameLocator) {
		this.nameLocator = nameLocator;
	}

	public Apartment () {
	}
	
	public Apartment(String block, String nameLocator, String number) {
		this.block = block;
		this.nameLocator = nameLocator;
		this.number = number;
	}

	@Override
	public String toString() {
		return "Apartment{" +
				"idApartment=" + idApartment +
				", parkingSpot=" + parkingSpot +
				", block='" + block + '\'' +
				", nameLocator='" + nameLocator + '\'' +
				", number='" + number + '\'' +
				'}';
	}
}
