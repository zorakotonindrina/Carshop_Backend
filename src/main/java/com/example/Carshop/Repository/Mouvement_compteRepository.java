package com.example.Carshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Carshop.Model.Mouvement_compte;


@Repository
public interface Mouvement_compteRepository extends JpaRepository<Mouvement_compte,Integer>{
    
}
