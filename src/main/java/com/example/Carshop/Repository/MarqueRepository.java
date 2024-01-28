package com.example.Carshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Carshop.Model.Marque;



@Repository
public interface MarqueRepository extends JpaRepository<Marque,Integer>{
    
}

