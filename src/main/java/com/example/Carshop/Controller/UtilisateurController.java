package com.example.Carshop.Controller;

import com.example.Carshop.Authentification.JwtUtil;
import com.example.Carshop.Model.Detail_annonce;
import com.example.Carshop.Model.Utilisateur;
import com.example.Carshop.Service.UtilisateurService;
import com.example.Carshop.api.APIResponse;

import io.jsonwebtoken.Claims;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/carshop/Utilisateurs")

public class UtilisateurController {

    
    @Autowired
    private UtilisateurService UtilisateurService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/voirMesAnnonces")
    public ResponseEntity<APIResponse> getMes_annonces(@RequestHeader(name = "Authorization") String authorizationHeader) {
        try {
            int iduser = 0;
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String token = authorizationHeader.substring(7);
                Claims claims = jwtUtil.parseJwtClaims(token);                
                iduser = JwtUtil.getUserId(claims);
            }
            List<Detail_annonce>  valeure = UtilisateurService.getMesAnnonces(iduser);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/voirMesFavoris")
    public ResponseEntity<APIResponse> getAllDetail_annonces(@RequestHeader(name = "Authorization") String authorizationHeader) {
        try {
            int iduser = 0;
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String token = authorizationHeader.substring(7);
                Claims claims = jwtUtil.parseJwtClaims(token);                
                iduser = JwtUtil.getUserId(claims);
            }
            List<Detail_annonce>  valeure = UtilisateurService.getMesAnnoncesFavoris(iduser);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

   @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getUtilisateurById(@PathVariable int id) {
         try {
            Utilisateur valeure = UtilisateurService.getUtilisateurById(id);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<APIResponse> saveUtilisateur(@RequestBody Utilisateur Utilisateur) {
        try {
            Utilisateur  valeure = UtilisateurService.saveUtilisateur(Utilisateur);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteUtilisateur(@PathVariable int id) {
        try {
            UtilisateurService.deleteUtilisateur(id);
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
