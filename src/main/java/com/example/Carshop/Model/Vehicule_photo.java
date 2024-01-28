package com.example.Carshop.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "vehicule_photo")
public class Vehicule_photo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_vehicule_photo ;
    int id_vehicule ;
    String photo ;

    public Vehicule_photo() {
    }

      public Vehicule_photo(int id_vehicule_photo, int id_vehicule, String photo) {
        this.id_vehicule_photo = id_vehicule_photo;
        this.id_vehicule = id_vehicule;
        this.photo = photo;
    }

    public int getId_vehicule_photo() {
        return id_vehicule_photo;
    }

    public void setId_vehicule_photo(int id_vehicule_photo) {
        this.id_vehicule_photo = id_vehicule_photo;
    }

    public int getId_vehicule() {
        return id_vehicule;
    }

    public void setId_vehicule(int id_vehicule) {
        this.id_vehicule = id_vehicule;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
}
