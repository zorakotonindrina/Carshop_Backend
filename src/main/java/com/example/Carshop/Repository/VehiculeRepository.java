package com.example.Carshop.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Carshop.Model.Vehicule;


@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule,Integer>{

     @Query(value = "select max(id_velicule) as n  from livraison ", nativeQuery = true)
    Integer maxExist( ) ;
    
}

