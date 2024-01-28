package com.example.Carshop.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Carshop.Model.Commission;
import com.example.Carshop.Repository.CommissionRepository;


import java.util.List;

@Service
public class CommissionService {

    @Autowired
    private CommissionRepository CommissionRepository;

    public List<Commission> getAllCommissions() {
        return CommissionRepository.findAll();
    }

    public Commission getCommissionById(int id) {
        return CommissionRepository.findById(id).orElse(null);
    }

    public Commission saveCommission(Commission Commission) {
        return CommissionRepository.save(Commission);
    }

    public void deleteCommission(int id) {
        CommissionRepository.deleteById(id);
    }

    // Autres méthodes CRUD personnalisées si nécessaire
}
