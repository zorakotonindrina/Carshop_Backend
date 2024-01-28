package com.example.Carshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Carshop.Model.Stat_categorie;
import com.example.Carshop.Repository.Stat_categorieRepository;

import java.util.List;

@Service
public class Stat_categorieService {

    @Autowired
    private Stat_categorieRepository Stat_categorieRepository;

    public List<Stat_categorie> getAllStat_categories() {
        return Stat_categorieRepository.findAll();
    }

    public Stat_categorie getStat_categorieById(int id) {
        return Stat_categorieRepository.findById(id).orElse(null);
    }

    public Stat_categorie saveStat_categorie(Stat_categorie Stat_categorie) {
        return Stat_categorieRepository.save(Stat_categorie);
    }

    public void deleteStat_categorie(int id) {
        Stat_categorieRepository.deleteById(id);
    }

    // Autres méthodes CRUD personnalisées si nécessaire
}

