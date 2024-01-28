package com.example.Carshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Carshop.Model.Stat_modele;
import com.example.Carshop.Repository.Stat_modeleRepository;

import java.util.List;

@Service
public class Stat_modeleService {

    @Autowired
    private Stat_modeleRepository Stat_modeleRepository;

    public List<Stat_modele> getAllStat_modeles() {
        return Stat_modeleRepository.findAll();
    }

    public Stat_modele getStat_modeleById(int id) {
        return Stat_modeleRepository.findById(id).orElse(null);
    }

    public Stat_modele saveStat_modele(Stat_modele Stat_modele) {
        return Stat_modeleRepository.save(Stat_modele);
    }

    public void deleteStat_modele(int id) {
        Stat_modeleRepository.deleteById(id);
    }

    // Autres méthodes CRUD personnalisées si nécessaire
}

