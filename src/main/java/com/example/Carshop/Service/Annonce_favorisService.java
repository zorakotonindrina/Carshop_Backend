package com.example.Carshop.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Carshop.Model.Annonce_favoris;
import com.example.Carshop.Model.Detail_annonce;
import com.example.Carshop.Repository.Annonce_favorisRepository;

import java.util.List;

@Service
public class Annonce_favorisService {

    @Autowired
    private Annonce_favorisRepository Annonce_favorisRepository;
    @Autowired
    private Detail_annonceService ar ;
    public List<Annonce_favoris> getAllAnnonce_favoriss() {
        return Annonce_favorisRepository.findAll();
    }

    public Annonce_favoris getAnnonce_favorisById(int id) {
        return Annonce_favorisRepository.findById(id).orElse(null);
    }


    public Detail_annonce getAnnonce(int id) {
        Detail_annonce rep= null;
        List<Detail_annonce> listes=ar.getAllDetail_annonces();
        for (int i = 0; i < listes.size(); i++) {
            if(listes.get(i).getId_annonce() == id){
               rep = listes.get(i);
            }
        }
        return rep;
    }

    public  Annonce_favoris getAnnonce_favorisByDeuxID(int id, int iduser) {
        List<Annonce_favoris> liste= Annonce_favorisRepository.findAll();
        for (int i = 0; i < liste.size() ; i++) {
            if(liste.get(i).getId_annonce() == id && liste.get(i).getId_utilisateur() == iduser){
                return liste.get(i);
            }
        }
        return null;
    }

    public Annonce_favoris saveAnnonce_favoris(Annonce_favoris Annonce_favoris) {
        return Annonce_favorisRepository.save(Annonce_favoris);
    }

    public void deleteAnnonce_favoris(int id) {
        Annonce_favorisRepository.deleteById(id);
    }

    // Autres méthodes CRUD personnalisées si nécessaire
}

