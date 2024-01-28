package com.example.Carshop.Controller;

import com.example.Carshop.Authentification.JwtUtil;
import com.example.Carshop.Model.Annonce_favoris;
import com.example.Carshop.Service.Annonce_favorisService;
import com.example.Carshop.api.APIResponse;

import io.jsonwebtoken.Claims;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/carshop/Annonce_favoris")

public class Annonce_favorisController {

    
    @Autowired
    private Annonce_favorisService Annonce_favorisService;

    @Autowired
    private JwtUtil jwtUtil;


   

    @GetMapping
    public ResponseEntity<APIResponse> getAllAnnonce_favoriss() {
        try {
            List<Annonce_favoris> liste =  Annonce_favorisService.getAllAnnonce_favoriss();
            APIResponse api = new APIResponse(null, liste);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @PostMapping
    public ResponseEntity<APIResponse> saveAnnonce_favoris(@RequestBody Annonce_favoris Annonce_favoris, @RequestHeader(name = "Authorization") String authorizationHeader) {
        try {
            int iduser = 0;
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String token = authorizationHeader.substring(7);
                Claims claims = jwtUtil.parseJwtClaims(token);                
                iduser = JwtUtil.getUserId(claims);
            }
            Annonce_favoris.setId_utilisateur(iduser);
            Annonce_favoris  valeure = Annonce_favorisService.saveAnnonce_favoris(Annonce_favoris);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteAnnonce_favoris(@PathVariable int id,@RequestHeader(name = "Authorization") String authorizationHeader) {
        
        try {
            int iduser = 0;
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String token = authorizationHeader.substring(7);
                Claims claims = jwtUtil.parseJwtClaims(token);                
                iduser = JwtUtil.getUserId(claims);
            }
            Annonce_favoris valeure= Annonce_favorisService.getAnnonce_favorisByDeuxID(id, iduser);
            Annonce_favorisService.deleteAnnonce_favoris(valeure.getId_annonce_favoris());
            APIResponse api = new APIResponse(null, null);;
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }

    // Autres méthodes CRUD personnalisées si nécessaire

}

