package com.example.Carshop.Controller;

import com.example.Carshop.Model.Annonce;
import com.example.Carshop.Service.AnnonceService;
import com.example.Carshop.api.APIResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carshop/Annonces")
public class AnnonceController {

    
    @Autowired
    private AnnonceService AnnonceService;

    @PostMapping
    public  ResponseEntity<APIResponse> saveAnnonce(@RequestBody Annonce Annonce) {
         try {
            Annonce te = AnnonceService.saveAnnonce(Annonce);
            APIResponse api = new APIResponse(null, te);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
       
    }

    @GetMapping
    public ResponseEntity<APIResponse> getAllCategories() {
        try {
            List<Annonce>  valeure = AnnonceService.getAllAnnonces();
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


   

}

