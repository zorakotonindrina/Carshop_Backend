package com.example.Carshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Carshop.Model.Stat_marque;

@Repository
public interface Stat_marqueRepository extends JpaRepository<Stat_marque,Integer>{
    
}

