package com.example.Carshop.Model;

import java.sql.Date;
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
    Date date_notif ;

     public Notification() {
    }

    public Notification(int id_message, int id_utilisateur, String nom_messageur, String contenu, Date date_notif) {
        this.id_message = id_message;
        this.id_utilisateur = id_utilisateur;
        this.nom_messageur = nom_messageur;
        this.contenu = contenu;
        this.date_notif = date_notif;
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

    public Date getDate_notif() {
        return date_notif;
    }

    public void setDate_notif(Date date_notif) {
        this.date_notif = date_notif;
    }
    
    
   

  


}
