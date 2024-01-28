package com.example.Carshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Carshop.Model.Stat_categorie;

@Repository
public interface Stat_categorieRepository extends JpaRepository<Stat_categorie,Integer>{
    
}

