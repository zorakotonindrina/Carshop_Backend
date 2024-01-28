package com.example.Carshop.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Type_carburant")
public class Type_carburant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_type_carburant;
    String nom_type;
    
    public Type_carburant(int id_type_carburant, String nom_type) {
        this.id_type_carburant = id_type_carburant;
        this.nom_type = nom_type;
    }

    public Type_carburant() {
    }

    public int getId_type_carburant() {
        return id_type_carburant;
    }

    public void setId_type_carburant(int id_type_carburant) {
        this.id_type_carburant = id_type_carburant;
    }

    public String getNom_type() {
        return nom_type;
    }

    public void setNom_type(String nom_type) {
        this.nom_type = nom_type;
    }

    

    
}
