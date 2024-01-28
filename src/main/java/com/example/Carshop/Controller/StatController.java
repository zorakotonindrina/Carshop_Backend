package com.example.Carshop.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Carshop.Model.Stat_categorie;
import com.example.Carshop.Model.Stat_marque;
import com.example.Carshop.Model.Stat_modele;
import com.example.Carshop.Service.Stat_categorieService;
import com.example.Carshop.Service.Stat_marqueService;
import com.example.Carshop.Service.Stat_modeleService;
import com.example.Carshop.api.APIResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/carshop/Stats")

public class StatController {

    
    @Autowired
    private Stat_categorieService Stat_categorieService;

    @Autowired
    private Stat_marqueService Stat_marqueService;


    @Autowired
    private Stat_modeleService Stat_modeleService;



    @GetMapping("/categorie")
    public ResponseEntity<APIResponse> getStatCategories() {
        try {
            List<Stat_categorie>  valeure = Stat_categorieService.getAllStat_categories();
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/marque")
    public ResponseEntity<APIResponse> getStatMarques() {
        try {
            List<Stat_marque>  valeure = Stat_marqueService.getAllStat_marques();
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/modele")
    public ResponseEntity<APIResponse> getStatmodeles() {
        try {
            List<Stat_modele>  valeure = Stat_modeleService.getAllStat_modeles();
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    






    

}

