package com.example.Carshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Carshop.Model.Categorie;


@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Integer>{
    
}

