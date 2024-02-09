package com.example.Carshop.Controller;

import com.example.Carshop.Authentification.JwtUtil;
import com.example.Carshop.Model.Annonce_favoris;
import com.example.Carshop.Model.Detail_annonce;
import com.example.Carshop.Model.Messages;
import com.example.Carshop.Model.Utilisateur;
import com.example.Carshop.Service.Annonce_favorisService;
import com.example.Carshop.Service.UtilisateurService;
import com.example.Carshop.api.APIResponse;

import io.jsonwebtoken.Claims;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/carshop/Utilisateurs")

public class UtilisateurController {

    
    @Autowired
    private UtilisateurService UtilisateurService;

    @Autowired
    private Annonce_favorisService Annonce_favorisService;

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

    @GetMapping("/voirMesMessages")
    public ResponseEntity<APIResponse> getAllMessages(@RequestHeader(name = "Authorization") String authorizationHeader) {
        try {
            int iduser = 0;
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String token = authorizationHeader.substring(7);
                Claims claims = jwtUtil.parseJwtClaims(token);                
                iduser = JwtUtil.getUserId(claims);
            }
            List<Messages>  valeure = UtilisateurService.getMesAMessages(iduser);
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


    @GetMapping("/favoris/{id}")
    public ResponseEntity<APIResponse> meettrefavoris(@RequestHeader(name = "Authorization") String authorizationHeader, @PathVariable int id) {
         try {
            int iduser = 0;
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String token = authorizationHeader.substring(7);
                Claims claims = jwtUtil.parseJwtClaims(token);                
                iduser = JwtUtil.getUserId(claims);
            }
            Annonce_favoris valeure= Annonce_favorisService.getAnnonce_favorisByDeuxID(id, iduser);
            
            if(valeure == null)
            {
                valeure= new Annonce_favoris();
                valeure.setId_annonce(id);
                valeure.setId_utilisateur(iduser);
                valeure.setDate_favoris(Date.valueOf(LocalDate.now()));
                valeure = Annonce_favorisService.saveAnnonce_favoris(valeure);
            }

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
