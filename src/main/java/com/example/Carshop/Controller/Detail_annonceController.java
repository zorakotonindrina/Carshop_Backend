package com.example.Carshop.Controller;

import com.example.Carshop.Model.Detail_annonce;
import com.example.Carshop.Service.Detail_annonceService;
import com.example.Carshop.api.APIResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;


@RestController
@RequestMapping("/carshop/Detail_annonces")

public class Detail_annonceController {

    
    @Autowired
    private Detail_annonceService Detail_annonceService;

    @GetMapping
    public ResponseEntity<APIResponse> getAllDetail_annonces() {
        try {
            List<Detail_annonce>  valeure = Detail_annonceService.getAllDetail_annonces();
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @GetMapping("/nonvalides")
    public ResponseEntity<APIResponse> getAllDetail_annoncesNonValides() {
        try {
            List<Detail_annonce>  valeure = Detail_annonceService.getAllDetail_annoncesNonValides();
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getDetail_annonceById(@PathVariable int id) {
         try {
            Detail_annonce valeure = Detail_annonceService.getDetail_annonceById(id);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<APIResponse> saveDetail_annonce(@RequestBody Detail_annonce Detail_annonce) {
        try {
            Detail_annonce  valeure = Detail_annonceService.saveDetail_annonce(Detail_annonce);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteDetail_annonce(@PathVariable int id) {
        try {
            Detail_annonceService.deleteDetail_annonce(id);
            APIResponse api = new APIResponse(null, null);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // Autres méthodes CRUD personnalisées si nécessaire





    @GetMapping("/rechercherParMarque")
    public ResponseEntity<APIResponse> rechercherParMarque(@RequestParam String marque){
        try {
            List<Detail_annonce>  valeure = Detail_annonceService.rechercherParNom_marque(marque);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @GetMapping("/rechercherParModele")
    public ResponseEntity<APIResponse> rechercherParModele(@RequestParam String modele){
        try {
            List<Detail_annonce>  valeure = Detail_annonceService.rechercherParNom_modele(modele);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/rechercherParCategorie")
    public ResponseEntity<APIResponse> rechercherParCategorie(@RequestParam String Categorie){
        try {
            List<Detail_annonce>  valeure = Detail_annonceService.rechercherParNom_categorie(Categorie);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    

    // @GetMapping("/rechercherParDate")
    // public List<Detail_annonce> rechercherParDate(@RequestParam Date date) {
    //     return Detail_annonceService.rechercherParyDate_annonce(date);
    // }

    
    @GetMapping("/rechercherParPrix")
    public ResponseEntity<APIResponse>  rechercherParPrix(@RequestParam double prixMin, double prixMax) {
        try {
            List<Detail_annonce>  valeure = Detail_annonceService.rechercherParPrix(prixMin, prixMax);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }



    @GetMapping("/searchmulti")
    public ResponseEntity<APIResponse> multiAnnonce(@RequestBody(required = false) Detail_annonce annonce,
    @RequestParam(name = "prix1", required = false) Double prix1,
    @RequestParam(name = "prix2", required = false) Double prix2,
    @RequestParam(name = "date1", required = false) Date date1,
    @RequestParam(name = "date2", required = false) Date date2) {
        try {
            List<Detail_annonce> list = Detail_annonceService.rechercheMulticritere(annonce,prix1,prix2,date1,date2);
            APIResponse api = new APIResponse(null, list);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    // Autres méthodes CRUD personnalisées si nécessaire

}


