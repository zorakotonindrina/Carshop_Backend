package com.example.Carshop.Model;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "detail_annonce")
public class Detail_annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_annonce;
    double prix;
    String descriptions;
    Date date_annonce;
    int validations;
    int etat;
    int id_vehicule;
    int id_utilisateur;
    String matriculation;
    int annee;
    double consommation;
    double capacite_reservoir;
    int nombre_place;
    int transmission;
    double kilometrage;
    String modele;
    String marque;
    String categorie;
    String types;
    String couleur;
    int climatiseur;
    int chaise_bebe ;
    int gps;
    int confre;
    int musique;
    int ceinture_securite;
    int bleutooth;
    int tableau_bord;
    int verouillage_centralise;
    int verouillage_distance;
    int kit_vehicule;
    String nom;
    String prenom;
    String email;
    String mdp;
    int profil;
    int reactions;

    
    public Detail_annonce() {
    }
    public Detail_annonce(int id_annonce, double prix, String descriptions, Date date_annonce, int validations,
            int etat, int id_vehicule, int id_utilisateur, String matriculation, int annee, double consommation,
            double capacite_reservoir, int nombre_place, int transmission, double kilometrage, String modele,
            String marque, String categorie, String types, String couleur, int climatiseur, int chaise_bebe, int gps,
            int confre, int musique, int ceinture_securite, int bleutooth, int tableau_bord, int verouillage_centralise,
            int verouillage_distance, int kit_vehicule, String nom, String prenom, Date date_naissance, String email,
            String mdp, int profil, int reactions) {
        this.id_annonce = id_annonce;
        this.prix = prix;
        this.descriptions = descriptions;
        this.date_annonce = date_annonce;
        this.validations = validations;
        this.etat = etat;
        this.id_vehicule = id_vehicule;
        this.id_utilisateur = id_utilisateur;
        this.matriculation = matriculation;
        this.annee = annee;
        this.consommation = consommation;
        this.capacite_reservoir = capacite_reservoir;
        this.nombre_place = nombre_place;
        this.transmission = transmission;
        this.kilometrage = kilometrage;
        this.modele = modele;
        this.marque = marque;
        this.categorie = categorie;
        this.types = types;
        this.couleur = couleur;
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
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.profil = profil;
        this.reactions = reactions;
    }
    public int getId_annonce() {
        return id_annonce;
    }
    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public String getDescriptions() {
        return descriptions;
    }
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
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
    public int getId_vehicule() {
        return id_vehicule;
    }
    public void setId_vehicule(int id_vehicule) {
        this.id_vehicule = id_vehicule;
    }
    public int getId_utilisateur() {
        return id_utilisateur;
    }
    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }
    public String getMatriculation() {
        return matriculation;
    }
    public void setMatriculation(String matriculation) {
        this.matriculation = matriculation;
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
    public String getModele() {
        return modele;
    }
    public void setModele(String modele) {
        this.modele = modele;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public String getCategorie() {
        return categorie;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    public String getTypes() {
        return types;
    }
    public void setTypes(String types) {
        this.types = types;
    }
    public String getCouleur() {
        return couleur;
    }
    public void setCouleur(String couleur) {
        this.couleur = couleur;
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
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public int getProfil() {
        return profil;
    }
    public void setProfil(int profil) {
        this.profil = profil;
    }
    public int getReactions() {
        return reactions;
    }
    public void setReactions(int reactions) {
        this.reactions = reactions;
    }

    
    
    
}
