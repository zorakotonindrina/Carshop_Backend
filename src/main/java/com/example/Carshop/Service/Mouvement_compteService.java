package com.example.Carshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Carshop.Model.Mouvement_compte;
import com.example.Carshop.Repository.Mouvement_compteRepository;


import java.util.List;

@Service
public class Mouvement_compteService {

    @Autowired
    private Mouvement_compteRepository Mouvement_compteRepository;

    public List<Mouvement_compte> getAllMouvement_comptes() {
        return Mouvement_compteRepository.findAll();
    }

    public Mouvement_compte getMouvement_compteById(int id) {
        return Mouvement_compteRepository.findById(id).orElse(null);
    }

    public Mouvement_compte saveMouvement_compte(Mouvement_compte Mouvement_compte) {
        return Mouvement_compteRepository.save(Mouvement_compte);
    }

    public void deleteMouvement_compte(int id) {
        Mouvement_compteRepository.deleteById(id);
    }

    // Autres méthodes CRUD personnalisées si nécessaire
}

