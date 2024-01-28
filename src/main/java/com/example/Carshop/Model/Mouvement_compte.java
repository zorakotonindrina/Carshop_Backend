package com.example.Carshop.Model;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "Mouvement_compte")
public class Mouvement_compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_mouvement_compte ;
    int id_compte ;
    Date date_mouvement ;
    double valeure ;
    int statut ;

    public Mouvement_compte() {
    }
    public Mouvement_compte(int id_mouvement_compte, int id_compte, Date date_mouvement, double valeure, int statut) {
        this.id_mouvement_compte = id_mouvement_compte;
        this.id_compte = id_compte;
        this.date_mouvement = date_mouvement;
        this.valeure = valeure;
        this.statut = statut;
    }
    
    public int getId_mouvement_compte() {
        return id_mouvement_compte;
    }
    public void setId_mouvement_compte(int id_mouvement_compte) {
        this.id_mouvement_compte = id_mouvement_compte;
    }
    public int getId_compte() {
        return id_compte;
    }
    public void setId_compte(int id_compte) {
        this.id_compte = id_compte;
    }
    public Date getDate_mouvement() {
        return date_mouvement;
    }
    public void setDate_mouvement(Date date_mouvement) {
        this.date_mouvement = date_mouvement;
    }
    public double getValeure() {
        return valeure;
    }
    public void setValeure(double valeure) {
        this.valeure = valeure;
    }
    public int getStatut() {
        return statut;
    }
    public void setStatut(int statut) {
        this.statut = statut;
    }

    
}
