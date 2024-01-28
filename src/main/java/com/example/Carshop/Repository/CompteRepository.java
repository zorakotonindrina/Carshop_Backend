package com.example.Carshop.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Carshop.Model.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte,Integer>{
    
}