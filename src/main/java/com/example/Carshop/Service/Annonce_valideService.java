package com.example.Carshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Carshop.Model.Annonce_valide;
import com.example.Carshop.Repository.Annonce_valideRepository;

import java.util.List;

@Service
public class Annonce_valideService {

    @Autowired
    private Annonce_valideRepository Annonce_valideRepository;

    public List<Annonce_valide> getAllAnnonce_valides() {
        return Annonce_valideRepository.findAll();
    }

    public Annonce_valide getAnnonce_valideById(int id) {
        return Annonce_valideRepository.findById(id).orElse(null);
    }

    public Annonce_valide saveAnnonce_valide(Annonce_valide Annonce_valide) {
        return Annonce_valideRepository.save(Annonce_valide);
    }

    public void deleteAnnonce_valide(int id) {
        Annonce_valideRepository.deleteById(id);
    }

    // Autres méthodes CRUD personnalisées si nécessaire
}
