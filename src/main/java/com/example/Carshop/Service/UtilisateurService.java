package com.example.Carshop.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Carshop.Model.Annonce_favoris;
import com.example.Carshop.Model.Detail_annonce;
import com.example.Carshop.Model.Messages;
import com.example.Carshop.Model.Utilisateur;
import com.example.Carshop.Repository.MessagesRepository;
import com.example.Carshop.Repository.UltilisateurRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UltilisateurRepository UtilisateurRepository;
    @Autowired
    private Detail_annonceService ar ;
    @Autowired
    private Annonce_favorisService af ;

    @Autowired
    private MessagesRepository mr ;


    public List<Utilisateur> getAllUtilisateurs() {
        return UtilisateurRepository.findAll();
    }

    public List<Detail_annonce> getMesAnnonces(int id_utilisateur) {
        List<Detail_annonce> rep= new ArrayList<>();
        List<Detail_annonce> listes=ar.getAllDetail_annonces();
        for (int i = 0; i < listes.size(); i++) {
            if(listes.get(i).getId_utilisateur() == id_utilisateur){
                rep.add(listes.get(i));
            }
        }
        return rep;
    }


    public List<Detail_annonce> getMesAnnoncesFavoris(int id_utilisateur) {

        List<Detail_annonce> rep= new ArrayList<>();
        List<Annonce_favoris> listes=af.getAllAnnonce_favoriss();
        for (int i = 0; i < listes.size(); i++) {
            if(listes.get(i).getId_utilisateur() == id_utilisateur){
                Detail_annonce da= af.getAnnonce(listes.get(i).getId_annonce());
                rep.add(da);
            }
        }
        return rep;
    }

    public List<Messages> getMesAMessages(int id_utilisateur) {
        List<Messages> rep= new ArrayList<>();
        List<Messages> listes= mr.findAll();
        for (int i = 0; i < listes.size(); i++) {
            if((listes.get(i).getId_expediteur() == id_utilisateur) || (listes.get(i).getId_recepteur() == id_utilisateur)){
                rep.add(listes.get(i));
            }
        }
        return rep;
    }

    

    public Utilisateur getUtilisateurById(int id) {
        return UtilisateurRepository.findById(id).orElse(null);
    }

    public Utilisateur saveUtilisateur(Utilisateur Utilisateur) {
        return UtilisateurRepository.save(Utilisateur);
    }

    public void deleteUtilisateur(int id) {
        UtilisateurRepository.deleteById(id);
    }

    // Autres méthodes CRUD personnalisées si nécessaire
}
