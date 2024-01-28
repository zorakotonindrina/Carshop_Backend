package com.example.Carshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Carshop.Model.Annonce;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce,Integer>{
   

}