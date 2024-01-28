package com.example.Carshop.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "Infos_vehicule")
public class Infos_vehicule {

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_infos_vehicule ;
    int id_vehicule ;
    int climatiseur ;
    int chaise_bebe ;
    int gps ;
    int confre ;
    int musique ;
    int ceinture_securite ;
    int bleutooth ;
    int tableau_bord ;
    int verouillage_centralise ;
    int verouillage_distance ;
    int kit_vehicule ;
    public Infos_vehicule() {
    }


     public Infos_vehicule(int id_infos_vehicule, int id_vehicule, int climatiseur, int chaise_bebe, int gps, int confre,
            int musique, int ceinture_securite, int bleutooth, int tableau_bord, int verouillage_centralise,
            int verouillage_distance, int kit_vehicule) {
        this.id_infos_vehicule = id_infos_vehicule;
        this.id_vehicule = id_vehicule;
        this.climatiseur = climatiseur;
        this.chaise_bebe = chaise_bebe;
        this.gps = gps;
        this.confre = confre;
        this.musique = musique;
        this.ceinture_securite = ceinture_securite;
        this.bleutooth = bleutooth;
        this.tableau_bord = tableau_bord;
        this.verouillage_centralise = verouillage_centralise;
        this.verouillage_distance = verouillage_distance;
        this.kit_vehicule = kit_vehicule;
    }


    public int getId_infos_vehicule() {
        return id_infos_vehicule;
    }


    public void setId_infos_vehicule(int id_infos_vehicule) {
        this.id_infos_vehicule = id_infos_vehicule;
    }


    public int getId_vehicule() {
        return id_vehicule;
    }


    public void setId_vehicule(int id_vehicule) {
        this.id_vehicule = id_vehicule;
    }


    public int getClimatiseur() {
        return climatiseur;
    }


    public void setClimatiseur(int climatiseur) {
        this.climatiseur = climatiseur;
    }


    public int getChaise_bebe() {
        return chaise_bebe;
    }


    public void setChaise_bebe(int chaise_bebe) {
        this.chaise_bebe = chaise_bebe;
    }


    public int getGps() {
        return gps;
    }


    public void setGps(int gps) {
        this.gps = gps;
    }


    public int getConfre() {
        return confre;
    }


    public void setConfre(int confre) {
        this.confre = confre;
    }


    public int getMusique() {
        return musique;
    }


    public void setMusique(int musique) {
        this.musique = musique;
    }


    public int getCeinture_securite() {
        return ceinture_securite;
    }


    public void setCeinture_securite(int ceinture_securite) {
        this.ceinture_securite = ceinture_securite;
    }


    public int getBleutooth() {
        return bleutooth;
    }


    public void setBleutooth(int bleutooth) {
        this.bleutooth = bleutooth;
    }


    public int getTableau_bord() {
        return tableau_bord;
    }


    public void setTableau_bord(int tableau_bord) {
        this.tableau_bord = tableau_bord;
    }


    public int getVerouillage_centralise() {
        return verouillage_centralise;
    }


    public void setVerouillage_centralise(int verouillage_centralise) {
        this.verouillage_centralise = verouillage_centralise;
    }


    public int getVerouillage_distance() {
        return verouillage_distance;
    }


    public void setVerouillage_distance(int verouillage_distance) {
        this.verouillage_distance = verouillage_distance;
    }


    public int getKit_vehicule() {
        return kit_vehicule;
    }


    public void setKit_vehicule(int kit_vehicule) {
        this.kit_vehicule = kit_vehicule;
    }
}
