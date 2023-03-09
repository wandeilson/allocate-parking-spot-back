package br.edu.ifpb.dac.wandeilson.projeto2jpa.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="apartment")
public class Apartment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idApartment;
	
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
		return "Apartment [id=" + idApartment + ", block=" + block + ", nameLocator=" + nameLocator + "]";
	}
}
