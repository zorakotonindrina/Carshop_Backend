package com.example.Carshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Carshop.Model.Stat_marque;
import com.example.Carshop.Repository.Stat_marqueRepository;

import java.util.List;

@Service
public class Stat_marqueService {

    @Autowired
    private Stat_marqueRepository Stat_marqueRepository;

    public List<Stat_marque> getAllStat_marques() {
        return Stat_marqueRepository.findAll();
    }

    public Stat_marque getStat_marqueById(int id) {
        return Stat_marqueRepository.findById(id).orElse(null);
    }

    public Stat_marque saveStat_marque(Stat_marque Stat_marque) {
        return Stat_marqueRepository.save(Stat_marque);
    }

    public void deleteStat_marque(int id) {
        Stat_marqueRepository.deleteById(id);
    }

    // Autres méthodes CRUD personnalisées si nécessaire
}

