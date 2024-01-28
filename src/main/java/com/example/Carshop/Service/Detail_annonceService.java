package com.example.Carshop.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Carshop.Model.Detail_annonce;
import com.example.Carshop.Repository.Detail_annonceRepository;
import java.util.List;

@Service
public class Detail_annonceService {

    @Autowired
    private Detail_annonceRepository Detail_annonceRepository;

    public List<Detail_annonce> getAllDetail_annonces() {
        return Detail_annonceRepository.findAll();
    }

    public Detail_annonce getDetail_annonceById(int id) {
        return Detail_annonceRepository.findById(id).orElse(null);
    }

    public Detail_annonce saveDetail_annonce(Detail_annonce Detail_annonce) {
        return Detail_annonceRepository.save(Detail_annonce);
    }

    public void deleteDetail_annonce(int id) {
        Detail_annonceRepository.deleteById(id);
    }



    public List<Detail_annonce> rechercherParNom_marque(String marque) {
        return Detail_annonceRepository.findByMarqueContaining(marque);
    }

    public List<Detail_annonce> rechercherParNom_modele(String modele) {
        return Detail_annonceRepository.findByModeleContaining(modele);
    }

    public List<Detail_annonce> rechercherParNom_categorie(String categorie) {
        return Detail_annonceRepository.findByCategorieContaining(categorie);
    }

    // public List<Detail_annonce> rechercherParyDate_annonce(Date date) {
    //     return Detail_annonceRepository.findByDate_annonceContains(date);
    // }


    public List<Detail_annonce> rechercherParPrix(double prixMin , double prixMax) {
        return Detail_annonceRepository.findByPrixBetween(prixMin, prixMax);
    }




    // Autres méthodes CRUD personnalisées si nécessaire
}
