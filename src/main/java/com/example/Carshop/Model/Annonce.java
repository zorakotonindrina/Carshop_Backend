package com.example.Carshop.Model;
import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "annonce")
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_annonce ;
    int id_vehicule ;
    String descriptions;
    double prix ;
    Date date_annonce ;
    int validations ;
    int etat ;
    
    public Annonce(int id_annonce, int id_vehicule, String descriptions, double prix, Date date_annonce,
            int validations, int etat) {
        this.id_annonce = id_annonce;
        this.id_vehicule = id_vehicule;
        this.descriptions = descriptions;
        this.prix = prix;
        this.date_annonce = date_annonce;
        this.validations = validations;
        this.etat = etat;
    }

    public Annonce() {
    }

    public Annonce(int id_annonce, int id_vehicule, double prix, Date date_annonce, int validations, int etat) {
        this.id_annonce = id_annonce;
        this.id_vehicule = id_vehicule;
        this.prix = prix;
        this.date_annonce = date_annonce;
        this.validations = validations;
        this.etat = etat;
    }

    public int getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public int getId_vehicule() {
        return id_vehicule;
    }

    public void setId_vehicule(int id_vehicule) {
        this.id_vehicule = id_vehicule;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Date getDate_annonce() {
        return date_annonce;
    }

    public void setDate_annonce(Date date_annonce) {
        this.date_annonce = date_annonce;
    }

    public int getValidations() {
        return validations;
    }

    public void setValidations(int validations) {
        this.validations = validations;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    
}
