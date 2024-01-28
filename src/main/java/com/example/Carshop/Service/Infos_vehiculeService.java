package com.example.Carshop.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Carshop.Model.Infos_vehicule;
import com.example.Carshop.Repository.Infos_vehiculeRepository;

import java.util.List;

@Service
public class Infos_vehiculeService {

    @Autowired
    private Infos_vehiculeRepository Infos_vehiculeRepository;


    public List<Infos_vehicule> getAllInfos_vehicules() {
        return Infos_vehiculeRepository.findAll();
        
    }

    public Infos_vehicule getInfos_vehiculeById(int id) {
        return Infos_vehiculeRepository.findById(id).orElse(null);
    }

    public Infos_vehicule saveInfos_vehicule(Infos_vehicule Infos_vehicule) {
        return Infos_vehiculeRepository.save(Infos_vehicule);
    }

    public void deleteInfos_vehicule(int id) {
        Infos_vehiculeRepository.deleteById(id);
    }

    // Autres méthodes CRUD personnalisées si nécessaire
}
