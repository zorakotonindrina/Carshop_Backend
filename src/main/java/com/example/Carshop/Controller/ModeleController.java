package com.example.Carshop.Controller;

import com.example.Carshop.Model.Modele;
import com.example.Carshop.Service.ModeleService;
import com.example.Carshop.api.APIResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/carshop/Modeles")

public class ModeleController {

    
    @Autowired
    private ModeleService ModeleService;

    @GetMapping
    public ResponseEntity<APIResponse> getAllModeles() {
        try {
            List<Modele>  valeure = ModeleService.getAllModeles();
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getModeleById(@PathVariable int id) {
         try {
            Modele valeure = ModeleService.getModeleById(id);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<APIResponse> saveModele(@RequestBody Modele Modele) {
        try {
            Modele  valeure = ModeleService.saveModele(Modele);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteModele(@PathVariable int id) {
        try {
            ModeleService.deleteModele(id);
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
