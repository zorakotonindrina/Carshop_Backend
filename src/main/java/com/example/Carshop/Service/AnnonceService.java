package com.example.Carshop.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Carshop.Model.Annonce;
import com.example.Carshop.Repository.AnnonceRepository;

import java.util.List;

@Service
public class AnnonceService {

    @Autowired
    private AnnonceRepository AnnonceRepository;

    public List<Annonce> getAllAnnonces() {
        return AnnonceRepository.findAll();
    }

    public Annonce getAnnonceById(int id) {
        return AnnonceRepository.findById(id).orElse(null);
    }

    public Annonce saveAnnonce(Annonce Annonce) {
        return AnnonceRepository.save(Annonce);
    }

    public void deleteAnnonce(int id) {
        AnnonceRepository.deleteById(id);
    }

    // Autres méthodes CRUD personnalisées si nécessaire
}

