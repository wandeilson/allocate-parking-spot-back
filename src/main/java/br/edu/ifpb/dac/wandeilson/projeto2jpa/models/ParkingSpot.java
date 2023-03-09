package br.edu.ifpb.dac.wandeilson.projeto2jpa.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="parking_spot")
public class ParkingSpot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
		return "ParkingSpot [id=" + idParkingSpot + ", number=" + number + "]";
	}

}
