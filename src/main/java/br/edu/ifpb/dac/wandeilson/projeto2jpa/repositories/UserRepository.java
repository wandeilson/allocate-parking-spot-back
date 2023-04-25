package br.edu.ifpb.dac.wandeilson.projeto2jpa.repositories;

import br.edu.ifpb.dac.wandeilson.projeto2jpa.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}
