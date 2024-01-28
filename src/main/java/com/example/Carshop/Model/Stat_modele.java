package com.example.Carshop.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Stat_modele")
public class Stat_modele {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_modele;
    String modele;
    int nombre;
    
    public Stat_modele() {
    }
    public Stat_modele(String modele, int nombre) {
        this.modele = modele;
        this.nombre = nombre;
    }
    public String getModele() {
        return modele;
    }
    public void setModele(String modele) {
        this.modele = modele;
    }
    public int getNombre() {
        return nombre;
    }
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

}