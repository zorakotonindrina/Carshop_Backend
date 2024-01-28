package com.example.Carshop.Controller;

import com.example.Carshop.Model.Mouvement_compte;
import com.example.Carshop.Service.Mouvement_compteService;
import com.example.Carshop.api.APIResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/carshop/Mouvement_comptes")

public class Mouvement_compteController {

    
    @Autowired
    private Mouvement_compteService Mouvement_compteService;

    @GetMapping
    public ResponseEntity<APIResponse> getAllMouvement_comptes() {
        try {
            List<Mouvement_compte>  valeure = Mouvement_compteService.getAllMouvement_comptes();
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getMouvement_compteById(@PathVariable int id) {
         try {
            Mouvement_compte valeure = Mouvement_compteService.getMouvement_compteById(id);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<APIResponse> saveMouvement_compte(@RequestBody Mouvement_compte Mouvement_compte) {
        try {
            Mouvement_compte  valeure = Mouvement_compteService.saveMouvement_compte(Mouvement_compte);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteMouvement_compte(@PathVariable int id) {
        try {
            Mouvement_compteService.deleteMouvement_compte(id);
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
