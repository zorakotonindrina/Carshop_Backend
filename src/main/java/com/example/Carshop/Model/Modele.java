package com.example.Carshop.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "modele")
public class Modele {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_modele ;
    String nom_modele;
    
    public Modele() {
    }

    public Modele(int id_modele, String nom_modele) {
        this.id_modele = id_modele;
        this.nom_modele = nom_modele;
    }

    public int getId_modele() {
        return id_modele;
    }

    public void setId_modele(int id_modele) {
        this.id_modele = id_modele;
    }

    public String getNom_modele() {
        return nom_modele;
    }

    public void setNom_modele(String nom_modele) {
        this.nom_modele = nom_modele;
    }

    
}
