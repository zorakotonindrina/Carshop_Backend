package com.example.Carshop.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Stat_marque")
public class Stat_marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_marque;
    String marque;
    int nombre;
    
    public Stat_marque() {
    }
    public Stat_marque(String marque, int nombre) {
        this.marque = marque;
        this.nombre = nombre;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public int getNombre() {
        return nombre;
    }
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

}