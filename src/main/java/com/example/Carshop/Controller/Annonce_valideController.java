package com.example.Carshop.Controller;

import com.example.Carshop.Model.Annonce;
import com.example.Carshop.Model.Annonce_valide;
import com.example.Carshop.Service.AnnonceService;
import com.example.Carshop.Service.Annonce_valideService;
import com.example.Carshop.api.APIResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;


@RestController
@RequestMapping("/carshop/Annonce_valides")

public class Annonce_valideController {

    
    @Autowired
    private Annonce_valideService Annonce_valideService;

    @Autowired
    private AnnonceService AnnonceService;

     @GetMapping("/{id}")
    public ResponseEntity<APIResponse> saveAnnonce_valide(@PathVariable int id) {
        try {

            java.util.Date currentDate = Calendar.getInstance().getTime();
            Date sqlDate = new java.sql.Date(currentDate.getTime());

            Annonce_valide af= new Annonce_valide();
            af.setId_annonce(id);
            af.setDate_valide(sqlDate);
            Annonce_valide  valeure = Annonce_valideService.saveAnnonce_valide(af);
            Annonce a= AnnonceService.getAnnonceById(id);
            a.setEtat(1);
            AnnonceService.saveAnnonce(a);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);

        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

}


