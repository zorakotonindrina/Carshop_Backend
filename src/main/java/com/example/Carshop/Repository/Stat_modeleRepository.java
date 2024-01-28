package com.example.Carshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Carshop.Model.Stat_modele;

@Repository
public interface Stat_modeleRepository extends JpaRepository<Stat_modele,Integer>{
    
}

