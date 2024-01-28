package com.example.Carshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Carshop.Model.Couleur;
import com.example.Carshop.Repository.CouleurRepository;

import java.util.List;

@Service
public class CouleurService {

    @Autowired
    private CouleurRepository CouleurRepository;

    public List<Couleur> getAllCouleurs() {
        return CouleurRepository.findAll();
    }

    public Couleur getCouleurById(int id) {
        return CouleurRepository.findById(id).orElse(null);
    }

    public Couleur saveCouleur(Couleur Couleur) {
        return CouleurRepository.save(Couleur);
    }

    public void deleteCouleur(int id) {
        CouleurRepository.deleteById(id);
    }

    // Autres méthodes CRUD personnalisées si nécessaire
}
