package br.edu.ifpb.dac.wandeilson.projeto2jpa.models;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table (name="parking_spot")
public class ParkingSpot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_parking_spot")
	private Long idParkingSpot;
	@Column (nullable = false)
	private String number;

	public ParkingSpot(String number) {
		this.number = number;
	}

	public ParkingSpot (){

	}

	public Long getId() {
		return idParkingSpot;
	}
	public void setId(Long id) {
		this.idParkingSpot = idParkingSpot;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "ParkingSpot [id=" + idParkingSpot + ", number=" + number +"]" ;
	}

}
