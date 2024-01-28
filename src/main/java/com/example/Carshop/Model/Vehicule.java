package com.example.Carshop.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "vehicule")
public class Vehicule
{ 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_vehicule;
    int id_modele ;
    int id_marque ;
    int id_categorie;
    int id_type_carburant;
    String  matriculation;
    int id_couleur;
    int  annee;
    double consommation ;
    double capacite_reservoir ;
    int nombre_place ;
    int transmission ;
    double kilometrage ;

    
    public Vehicule() {
    }


    public Vehicule(int id_vehicule, int id_modele, int id_marque, int id_categorie, int id_type_carburant,
            String matriculation, int id_couleur, int annee, double consommation, double capacite_reservoir,
            int nombre_place, int transmission, double kilometrage) {
        this.id_vehicule = id_vehicule;
        this.id_modele = id_modele;
        this.id_marque = id_marque;
        this.id_categorie = id_categorie;
        this.id_type_carburant = id_type_carburant;
        this.matriculation = matriculation;
        this.id_couleur = id_couleur;
        this.annee = annee;
        this.consommation = consommation;
        this.capacite_reservoir = capacite_reservoir;
        this.nombre_place = nombre_place;
        this.transmission = transmission;
        this.kilometrage = kilometrage;
    }


    public int getId_vehicule() {
        return id_vehicule;
    }


    public void setId_vehicule(int id_vehicule) {
        this.id_vehicule = id_vehicule;
    }


    public int getId_modele() {
        return id_modele;
    }


    public void setId_modele(int id_modele) {
        this.id_modele = id_modele;
    }


    public int getId_marque() {
        return id_marque;
    }


    public void setId_marque(int id_marque) {
        this.id_marque = id_marque;
    }


    public int getId_categorie() {
        return id_categorie;
    }


    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }


    public int getId_type_carburant() {
        return id_type_carburant;
    }


    public void setId_type_carburant(int id_type_carburant) {
        this.id_type_carburant = id_type_carburant;
    }


    public String getMatriculation() {
        return matriculation;
    }


    public void setMatriculation(String matriculation) {
        this.matriculation = matriculation;
    }


    public int getId_couleur() {
        return id_couleur;
    }


    public void setId_couleur(int id_couleur) {
        this.id_couleur = id_couleur;
    }


    public int getAnnee() {
        return annee;
    }


    public void setAnnee(int annee) {
        this.annee = annee;
    }


    public double getConsommation() {
        return consommation;
    }


    public void setConsommation(double consommation) {
        this.consommation = consommation;
    }


    public double getCapacite_reservoir() {
        return capacite_reservoir;
    }


    public void setCapacite_reservoir(double capacite_reservoir) {
        this.capacite_reservoir = capacite_reservoir;
    }


    public int getNombre_place() {
        return nombre_place;
    }


    public void setNombre_place(int nombre_place) {
        this.nombre_place = nombre_place;
    }


    public int getTransmission() {
        return transmission;
    }


    public void setTransmission(int transmission) {
        this.transmission = transmission;
    }


    public double getKilometrage() {
        return kilometrage;
    }


    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }







}