package com.example.Carshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Carshop.Model.Type_carburant;
import com.example.Carshop.Repository.Type_carburantRepository;

import java.util.List;

@Service
public class Type_carburantService {

    @Autowired
    private Type_carburantRepository Type_carburantRepository;

    public List<Type_carburant> getAllType_carburants() {
        return Type_carburantRepository.findAll();
    }

    public Type_carburant getType_carburantById(int id) {
        return Type_carburantRepository.findById(id).orElse(null);
    }

    public Type_carburant saveType_carburant(Type_carburant Type_carburant) {
        return Type_carburantRepository.save(Type_carburant);
    }

    public void deleteType_carburant(int id) {
        Type_carburantRepository.deleteById(id);
    }

    // Autres méthodes CRUD personnalisées si nécessaire
}

