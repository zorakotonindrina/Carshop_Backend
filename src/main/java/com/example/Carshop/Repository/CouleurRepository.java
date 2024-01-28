package com.example.Carshop.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Carshop.Model.Couleur;


@Repository
public interface CouleurRepository extends JpaRepository<Couleur,Integer>{
    
}

