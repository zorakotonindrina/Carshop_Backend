package com.example.Carshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Carshop.Model.Commission;


@Repository
public interface CommissionRepository extends JpaRepository<Commission,Integer>{
    
}
