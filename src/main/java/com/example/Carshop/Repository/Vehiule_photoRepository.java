package com.example.Carshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Carshop.Model.Vehicule_photo;

@Repository
public interface Vehiule_photoRepository extends JpaRepository<Vehicule_photo,Integer>{
    
}