package com.example.Carshop.Controller;

import com.example.Carshop.Authentification.JwtUtil;
import com.example.Carshop.Model.Notification;
import com.example.Carshop.Service.NotificationService;
import com.example.Carshop.api.APIResponse;

import io.jsonwebtoken.Claims;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/carshop/Notifications")

public class NotificationController {

    
    @Autowired
    private NotificationService NotificationService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping
    public ResponseEntity<APIResponse> getAllNotifications(@RequestHeader(name = "Authorization") String authorizationHeader) {
        try {
            int iduser = 0;
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String token = authorizationHeader.substring(7);
                Claims claims = jwtUtil.parseJwtClaims(token);                
                iduser = JwtUtil.getUserId(claims);
            }
            List<Notification>  valeure = NotificationService.getMesNotif(iduser);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getNotificationById(@PathVariable int id) {
         try {
            Notification valeure = NotificationService.getNotificationById(id);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<APIResponse> saveNotification(@RequestBody Notification Notification) {
        try {
            Notification  valeure = NotificationService.saveNotification(Notification);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteNotification(@PathVariable int id) {
        try {
            NotificationService.deleteNotification(id);
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
