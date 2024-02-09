package com.example.Carshop.Controller;

import com.example.Carshop.Authentification.JwtUtil;
import com.example.Carshop.Model.Messages;
import com.example.Carshop.Service.MessagesService;
import com.example.Carshop.api.APIResponse;

import io.jsonwebtoken.Claims;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/carshop/Messagess")

public class MessagesController {

    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private MessagesService MessagesService;

    @GetMapping
    public ResponseEntity<APIResponse> getAllMessagess() {
        try {
            List<Messages>  valeure = MessagesService.getAllMessagess();
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/contacter/{id}")
    public ResponseEntity<APIResponse> getMessagesByPrroprietaire(@PathVariable int id, @RequestHeader(name = "Authorization") String authorizationHeader) {
         try {
             int iduser = 0;
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String token = authorizationHeader.substring(7);
                Claims claims = jwtUtil.parseJwtClaims(token);                
                iduser = JwtUtil.getUserId(claims);
            }
            int idmes=MessagesService.geIdMessages(iduser, id);
            Messages valeure = new Messages();
            if(idmes == 0){
                valeure.setId_expediteur(iduser);
                valeure.setId_recepteur(id);
                valeure=MessagesService.saveMessages(valeure);
            }else{
                valeure = MessagesService.getMessagesById(idmes);
            }
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getMessagesById(@PathVariable int id) {
         try {
            Messages valeure = MessagesService.getMessagesById(id);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<APIResponse> saveMessages(@RequestBody Messages Messages) {
        try {
            Messages  valeure = MessagesService.saveMessages(Messages);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteMessages(@PathVariable int id) {
        try {
            MessagesService.deleteMessages(id);
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
