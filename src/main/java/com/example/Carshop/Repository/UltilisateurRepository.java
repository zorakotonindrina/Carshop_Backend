package com.example.Carshop.Repository;

import com.example.Carshop.Model.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UltilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    public Utilisateur findByEmail(@Param("email") String email);
}
