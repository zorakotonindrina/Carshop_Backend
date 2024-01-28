package com.example.Carshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Carshop.Model.Type_carburant;


@Repository
public interface Type_carburantRepository extends JpaRepository<Type_carburant,Integer>{
    
}
