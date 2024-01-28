package com.example.Carshop.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "couleur")
public class Couleur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int  id_couleur ;
    String nom ;
    
    public Couleur() {
    }

    public Couleur(int id_couleur, String nom) {
        this.id_couleur = id_couleur;
        this.nom = nom;
    }

    public int getId_couleur() {
        return id_couleur;
    }

    public void setId_couleur(int id_couleur) {
        this.id_couleur = id_couleur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    
}
