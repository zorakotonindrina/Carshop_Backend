package com.example.Carshop.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Stat_categorie")
public class Stat_categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_categorie;
    String categorie;
    int nombre;
    
    public Stat_categorie() {
    }
    public Stat_categorie(String categorie, int nombre) {
        this.categorie = categorie;
        this.nombre = nombre;
    }
    public String getCategorie() {
        return categorie;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    public int getNombre() {
        return nombre;
    }
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

}