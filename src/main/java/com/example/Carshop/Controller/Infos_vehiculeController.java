package com.example.Carshop.Controller;

import com.example.Carshop.Model.Infos_vehicule;
import com.example.Carshop.Service.Infos_vehiculeService;
import com.example.Carshop.api.APIResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/carshop/Infos_vehicules")

public class Infos_vehiculeController {

    
    @Autowired
    private Infos_vehiculeService Infos_vehiculeService;

    @GetMapping
    public ResponseEntity<APIResponse> getAllInfos_vehicules() {
        try {
            List<Infos_vehicule>  valeure = Infos_vehiculeService.getAllInfos_vehicules();
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getInfos_vehiculeById(@PathVariable int id) {
         try {
            Infos_vehicule valeure = Infos_vehiculeService.getInfos_vehiculeById(id);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<APIResponse> saveInfos_vehicule(@RequestBody Infos_vehicule Infos_vehicule) {
        try {
            Infos_vehicule  valeure = Infos_vehiculeService.saveInfos_vehicule(Infos_vehicule);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteInfos_vehicule(@PathVariable int id) {
        try {
            Infos_vehiculeService.deleteInfos_vehicule(id);
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
