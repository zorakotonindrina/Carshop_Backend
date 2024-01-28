package com.example.Carshop.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "messages")
public class Messages {
   

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_message;
    int id_expediteur;
    int id_recepteur;

    public Messages() {
    }

    public Messages(int id_message, int id_expediteur, int id_recepteur) {
        this.id_message = id_message;
        this.id_expediteur = id_expediteur;
        this.id_recepteur = id_recepteur;
    }
   

    public int getId_message() {
        return id_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }

    public int getId_expediteur() {
        return id_expediteur;
    }

    public void setId_expediteur(int id_expediteur) {
        this.id_expediteur = id_expediteur;
    }

   
    public int getId_recepteur() {
        return id_recepteur;
    }

    public void setId_recepteur(int id_recepteur) {
        this.id_recepteur = id_recepteur;
    }

   

}
