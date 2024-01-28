package com.example.Carshop.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Carshop.Model.Vehicule_photo;
import com.example.Carshop.Repository.Vehiule_photoRepository;

import java.util.List;

@Service
public class Vehicule_photoService {

    @Autowired
    private Vehiule_photoRepository Vehicule_photoRepository;


    public List<Vehicule_photo> getAllVehicule_photos() {
        return Vehicule_photoRepository.findAll();
    }

    public Vehicule_photo getVehicule_photoById(int id) {
        return Vehicule_photoRepository.findById(id).orElse(null);
    }

    public Vehicule_photo saveVehicule_photo(Vehicule_photo Vehicule_photo) {
        return Vehicule_photoRepository.save(Vehicule_photo);
    }

    public void deleteVehicule_photo(int id) {
        Vehicule_photoRepository.deleteById(id);
    }

    // Autres méthodes CRUD personnalisées si nécessaire
}


