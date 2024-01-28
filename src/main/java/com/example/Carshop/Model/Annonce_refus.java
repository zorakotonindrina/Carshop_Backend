package com.example.Carshop.Model;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "Annonce_refus")
public class Annonce_refus {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_annonce_refus ;
    int id_annonce;
    Date date_refus ;

    public Annonce_refus() {
    }

    public Annonce_refus(int id_annonce_refus, int id_annonce, Date date_refus) {
        this.id_annonce_refus = id_annonce_refus;
        this.id_annonce = id_annonce;
        this.date_refus = date_refus;
    }

    public int getId_annonce_refus() {
        return id_annonce_refus;
    }

    public void setId_annonce_refus(int id_annonce_refus) {
        this.id_annonce_refus = id_annonce_refus;
    }

    public int getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public Date getDate_refus() {
        return date_refus;
    }

    public void setDate_refus(Date date_refus) {
        this.date_refus = date_refus;
    }

    
    
}
