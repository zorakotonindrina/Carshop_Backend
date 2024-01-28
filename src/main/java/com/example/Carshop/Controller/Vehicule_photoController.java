package com.example.Carshop.Controller;

import com.example.Carshop.Model.Vehicule_photo;
import com.example.Carshop.Service.Vehicule_photoService;
import com.example.Carshop.api.APIResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/carshop/Vehicule_photos")

public class Vehicule_photoController {

    
    @Autowired
    private Vehicule_photoService Vehicule_photoService;

    @GetMapping
    public ResponseEntity<APIResponse> getAllVehicule_photos() {
        try {
            List<Vehicule_photo>  valeure = Vehicule_photoService.getAllVehicule_photos();
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getVehicule_photoById(@PathVariable int id) {
         try {
            Vehicule_photo valeure = Vehicule_photoService.getVehicule_photoById(id);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<APIResponse> saveVehicule_photo(@RequestBody Vehicule_photo Vehicule_photo) {
        try {
            Vehicule_photo  valeure = Vehicule_photoService.saveVehicule_photo(Vehicule_photo);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteVehicule_photo(@PathVariable int id) {
        try {
            Vehicule_photoService.deleteVehicule_photo(id);
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
