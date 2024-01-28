package com.example.Carshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Carshop.Model.Modele;


@Repository
public interface ModeleRepository extends JpaRepository<Modele,Integer>{
    
}

