package com.example.Carshop.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "compte")
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_compte;
    int id_utilisateur;
    String numero_compte;
    String code;
    
    public Compte(int id_compte, int id_utilisateur, String numero_compte, String code) {
        this.id_compte = id_compte;
        this.id_utilisateur = id_utilisateur;
        this.numero_compte = numero_compte;
        this.code = code;
    }
    public Compte() {
    }
    public int getId_compte() {
        return id_compte;
    }
    public void setId_compte(int id_compte) {
        this.id_compte = id_compte;
    }
    public int getId_utilisateur() {
        return id_utilisateur;
    }
    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }
    public String getNumero_compte() {
        return numero_compte;
    }
    public void setNumero_compte(String numero_compte) {
        this.numero_compte = numero_compte;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    
}
