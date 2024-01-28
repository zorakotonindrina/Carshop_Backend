package com.example.Carshop.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Carshop.Model.Vehicule;
import com.example.Carshop.Repository.VehiculeRepository;

import java.util.List;

@Service
public class VehiculeService {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    public List<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }

    public Vehicule getVehiculeById(int id) {
        return vehiculeRepository.findById(id).orElse(null);
    }

    public Vehicule saveVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    public void deleteVehicule(int id) {
        vehiculeRepository.deleteById(id);
    }

    public int getLatsVehicule() {
        return vehiculeRepository.maxExist();

    }



    // Autres méthodes CRUD personnalisées si nécessaire
}

