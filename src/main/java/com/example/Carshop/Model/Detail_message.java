package com.example.Carshop.Model;

import java.time.LocalDateTime;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "detail_message")
public class Detail_message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_detail_message;
    int id_message;
    int id_messageur;
    String nom_messageur;
    String contenu ;
    LocalDateTime date_message ;
    
    public Detail_message(int id_detail_message, int id_message, int id_messageur, String nom_messageur, String contenu,
            LocalDateTime date_message) {
        this.id_detail_message = id_detail_message;
        this.id_message = id_message;
        this.id_messageur = id_messageur;
        this.nom_messageur = nom_messageur;
        this.contenu = contenu;
        this.date_message = date_message;
    }




    public Detail_message() {
    }

   


    public String getNom_messageur() {
        return nom_messageur;
    }

    public void setNom_messageur(String nom_messageur) {
        this.nom_messageur = nom_messageur;
    }


    public int getId_detail_message() {
        return id_detail_message;
    }

    public void setId_detail_message(int id_detail_message) {
        this.id_detail_message = id_detail_message;
    }

    public int getId_message() {
        return id_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }

    public int getId_messageur() {
        return id_messageur;
    }

    public void setId_messageur(int id_messageur) {
        this.id_messageur = id_messageur;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public LocalDateTime getDate_message() {
        return date_message;
    }

    public void setDate_message(LocalDateTime date_message) {
        this.date_message = date_message;
    }


}
