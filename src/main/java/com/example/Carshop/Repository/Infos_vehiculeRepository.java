package com.example.Carshop.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Carshop.Model.Infos_vehicule;

@Repository
public interface Infos_vehiculeRepository extends JpaRepository<Infos_vehicule,Integer>{
    
}