package com.example.Carshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Carshop.Model.Annonce_refus;
import com.example.Carshop.Repository.Annonce_refusRepository;

import java.util.List;

@Service
public class Annonce_refusService {

    @Autowired
    private Annonce_refusRepository Annonce_refusRepository;

    public List<Annonce_refus> getAllAnnonce_refuss() {
        return Annonce_refusRepository.findAll();
    }

    public Annonce_refus getAnnonce_refusById(int id) {
        return Annonce_refusRepository.findById(id).orElse(null);
    }

    public Annonce_refus saveAnnonce_refus(Annonce_refus Annonce_refus) {
        return Annonce_refusRepository.save(Annonce_refus);
    }

    public void deleteAnnonce_refus(int id) {
        Annonce_refusRepository.deleteById(id);
    }

    // Autres méthodes CRUD personnalisées si nécessaire
}
