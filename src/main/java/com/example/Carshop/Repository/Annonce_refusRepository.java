package com.example.Carshop.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Carshop.Model.Annonce_refus;

@Repository
public interface Annonce_refusRepository extends JpaRepository<Annonce_refus,Integer>{
    
}

