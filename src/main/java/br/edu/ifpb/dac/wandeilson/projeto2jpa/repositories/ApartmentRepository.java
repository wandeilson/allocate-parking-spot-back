package br.edu.ifpb.dac.wandeilson.projeto2jpa.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.wandeilson.projeto2jpa.models.Apartment;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long>{
}
