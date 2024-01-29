package com.example.Carshop.Controller;

import com.example.Carshop.Model.Annonce;
import com.example.Carshop.Model.Annonce_refus;
import com.example.Carshop.Service.AnnonceService;
import com.example.Carshop.Service.Annonce_refusService;
import com.example.Carshop.api.APIResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;


@RestController
@RequestMapping("/carshop/Annonce_refuss")

public class Annonce_refusController {

    
    @Autowired
    private Annonce_refusService Annonce_refusService;

    @Autowired
    private AnnonceService AnnonceService;

    @GetMapping("/{id_annonce}")
    public ResponseEntity<APIResponse> saveAnnonce_refus(@PathVariable int id_annonce) {
        try {

            java.util.Date currentDate = Calendar.getInstance().getTime();
            Date sqlDate = new java.sql.Date(currentDate.getTime());

            Annonce_refus af= new Annonce_refus();
            af.setId_annonce(id_annonce);
            af.setDate_refus(sqlDate);
            Annonce_refus  valeure = Annonce_refusService.saveAnnonce_refus(af);
            Annonce a= AnnonceService.getAnnonceById(id_annonce);
            a.setEtat(2);
            AnnonceService.saveAnnonce(a);
            APIResponse api = new APIResponse(null, valeure);
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
            List<Annonce_refus>  valeure = Annonce_refusService.getAllAnnonce_refuss();
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    
}

