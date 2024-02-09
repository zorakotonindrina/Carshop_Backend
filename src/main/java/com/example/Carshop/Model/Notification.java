package com.example.Carshop.Model;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notification")
public class Notification {

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_message;
    int id_utilisateur;
    String nom_messageur;
    String contenu ;
    LocalDateTime date_notif ;
    int etat;

     public Notification(int id_message, int id_utilisateur, String nom_messageur, String contenu,
            LocalDateTime date_notif, int etat) {
        this.id_message = id_message;
        this.id_utilisateur = id_utilisateur;
        this.nom_messageur = nom_messageur;
        this.contenu = contenu;
        this.date_notif = date_notif;
        this.etat = etat;
    }


    public int getEtat() {
        return etat;
    }

    
    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Notification() {
    }

    

    public int getId_message() {
        return id_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getNom_messageur() {
        return nom_messageur;
    }

    public void setNom_messageur(String nom_messageur) {
        this.nom_messageur = nom_messageur;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public LocalDateTime getDate_notif() {
        return date_notif;
    }

    public void setDate_notif(LocalDateTime date_notif) {
        this.date_notif = date_notif;
    }
    
    
   

  


}
