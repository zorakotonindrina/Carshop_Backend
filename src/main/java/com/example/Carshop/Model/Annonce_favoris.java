package com.example.Carshop.Model;
import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "Annonce_favoris")
public class Annonce_favoris {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_annonce_favoris ;
    int id_annonce ;
    int id_utilisateur ;
    Date date_favoris ;
    
    public Annonce_favoris() {
    }

    public Annonce_favoris(int id_annonce_favoris, int id_annonce, int id_utilisateur, Date date_favoris) {
        this.id_annonce_favoris = id_annonce_favoris;
        this.id_annonce = id_annonce;
        this.id_utilisateur = id_utilisateur;
        this.date_favoris = date_favoris;
    }

    public int getId_annonce_favoris() {
        return id_annonce_favoris;
    }

    public void setId_annonce_favoris(int id_annonce_favoris) {
        this.id_annonce_favoris = id_annonce_favoris;
    }

    public int getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public Date getDate_favoris() {
        return date_favoris;
    }

    public void setDate_favoris(Date date_favoris) {
        this.date_favoris = date_favoris;
    }

    
}
