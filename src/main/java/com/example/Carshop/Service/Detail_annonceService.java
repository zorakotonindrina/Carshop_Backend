package com.example.Carshop.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;
import com.example.Carshop.Model.Detail_annonce;
import com.example.Carshop.Repository.Detail_annonceRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class Detail_annonceService {

    @Autowired
    private Detail_annonceRepository Detail_annonceRepository;

    private NamedParameterJdbcTemplate JdbcTemplate; 

    public List<Detail_annonce> getAllDetail_annonces() {
        return Detail_annonceRepository.findAll();
    }


    public List<Detail_annonce> getAllDetail_annoncesNonValides() {
        List<Detail_annonce> liste = Detail_annonceRepository.findAll();
        List<Detail_annonce> rep = new ArrayList<>();
        for (int i = 0; i < liste.size() ; i++) {
            if(liste.get(i).getEtat() == 0){
                rep.add(liste.get(i));
            }
        }
        return rep;
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



    public List<Detail_annonce> rechercheMulticritere(Detail_annonce annonce,Double prix1,Double prix2,Date date1,Date date2) {
        String sql = "SELECT * FROM v_annonce WHERE 1=1";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        
        if (annonce != null) {
            if (annonce.getDescriptions() != null) {
                sql += " AND descriptions  LIKE :nom";
                parameters.addValue("nom", "%" + annonce.getNom() + "%");
            }
    
            if (annonce.getMarque() != null) {
                sql += " AND marque LIKE :marque";
                parameters.addValue("marque", "%" + annonce.getMarque() + "%");
            }
    
            if (annonce.getModele() != null) {
                sql += " AND modele LIKE :modele";
                parameters.addValue("modele", "%" + annonce.getModele() + "%");
            }
    
            if (annonce.getTypes() != null) {
                sql += " AND types LIKE :type_energie";
                parameters.addValue("type_energie", "%" + annonce.getTypes() + "%");
            }
    
    
        }
        
        if (prix1 != null && prix2 != null) {
            sql += " AND prix  BETWEEN :prix1 AND :prix2";
            parameters.addValue("prix1",prix1);
            parameters.addValue("prix2",prix2);
        }

        if (date1 != null && date2 != null) {
            sql += " AND date_annonce  BETWEEN :date1 AND :date2";
            parameters.addValue("date1",date1);
            parameters.addValue("date2",date2);
        }        

        System.out.println(sql);
    
        return JdbcTemplate.query(sql, parameters, new BeanPropertyRowMapper<>(Detail_annonce.class));
    }


    // Autres méthodes CRUD personnalisées si nécessaire
}
