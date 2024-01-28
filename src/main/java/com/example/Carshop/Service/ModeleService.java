package com.example.Carshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Carshop.Model.Modele;
import com.example.Carshop.Repository.ModeleRepository;

import java.util.List;

@Service
public class ModeleService {

    @Autowired
    private ModeleRepository ModeleRepository;

    public List<Modele> getAllModeles() {
        return ModeleRepository.findAll();
    }

    public Modele getModeleById(int id) {
        return ModeleRepository.findById(id).orElse(null);
    }

    public Modele saveModele(Modele Modele) {
        return ModeleRepository.save(Modele);
    }

    public void deleteModele(int id) {
        ModeleRepository.deleteById(id);
    }

    // Autres méthodes CRUD personnalisées si nécessaire
}

