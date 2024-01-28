package com.example.Carshop.Model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "Commission")
public class Commission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_commission ;
    Date date_commission;
    int id_annonce ;
    double pourcentage ;
    double valeure ;
    int etat ;

    
    public Commission() {
    }


    public Commission(int id_commission, int id_annonce, double pourcentage, double valeure, int etat) {
        this.id_commission = id_commission;
        this.id_annonce = id_annonce;
        this.pourcentage = pourcentage;
        this.valeure = valeure;
        this.etat = etat;
    }


    public int getId_commission() {
        return id_commission;
    }


    public void setId_commission(int id_commission) {
        this.id_commission = id_commission;
    }


    public int getId_annonce() {
        return id_annonce;
    }


    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }


    public double getPourcentage() {
        return pourcentage;
    }


    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;
    }


    public double getValeure() {
        return valeure;
    }


    public void setValeure(double valeure) {
        this.valeure = valeure;
    }


    public int getEtat() {
        return etat;
    }


    public void setEtat(int etat) {
        this.etat = etat;
    }

    

}
