package com.example.Carshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Carshop.Model.Compte;
import com.example.Carshop.Repository.CompteRepository;


import java.util.List;

@Service
public class CompteService {

    @Autowired
    private CompteRepository CompteRepository;

    public List<Compte> getAllComptes() {
        return CompteRepository.findAll();
    }

    public Compte getCompteById(int id) {
        return CompteRepository.findById(id).orElse(null);
    }

    public Compte saveCompte(Compte Compte) {
        return CompteRepository.save(Compte);
    }

    public void deleteCompte(int id) {
        CompteRepository.deleteById(id);
    }

    // Autres méthodes CRUD personnalisées si nécessaire
}

