package com.example.Carshop.Controller;

import com.example.Carshop.Model.Couleur;
import com.example.Carshop.Service.CouleurService;
import com.example.Carshop.api.APIResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/carshop/Couleurs")

public class CouleurController {

    
    @Autowired
    private CouleurService CouleurService;

    @GetMapping
    public ResponseEntity<APIResponse> getAllCouleurs() {
        try {
            List<Couleur>  valeure = CouleurService.getAllCouleurs();
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getCouleurById(@PathVariable int id) {
         try {
            Couleur valeure = CouleurService.getCouleurById(id);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<APIResponse> saveCouleur(@RequestBody Couleur Couleur) {
        try {
            Couleur  valeure = CouleurService.saveCouleur(Couleur);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteCouleur(@PathVariable int id) {
        try {
            CouleurService.deleteCouleur(id);
            APIResponse api = new APIResponse(null, null);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // Autres méthodes CRUD personnalisées si nécessaire

}
