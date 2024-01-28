package com.example.Carshop.Model;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "Annonce_valide")
public class Annonce_valide {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_annonce_valide ;
    int id_annonce ;
    Date date_valide ;


    public Annonce_valide() {
    }
    
    public Annonce_valide(int id_annonce_valide, int id_annonce, Date date_valide) {
        this.id_annonce_valide = id_annonce_valide;
        this.id_annonce = id_annonce;
        this.date_valide = date_valide;
    }

    public int getId_annonce_valide() {
        return id_annonce_valide;
    }

    public void setId_annonce_valide(int id_annonce_valide) {
        this.id_annonce_valide = id_annonce_valide;
    }

    public int getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public Date getDate_valide() {
        return date_valide;
    }

    public void setDate_valide(Date date_valide) {
        this.date_valide = date_valide;
    }

}
