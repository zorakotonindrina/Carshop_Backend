package com.example.Carshop.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Carshop.Model.Annonce_valide;

@Repository
public interface Annonce_valideRepository extends JpaRepository<Annonce_valide,Integer>{
    
}
