package com.example.Carshop.Controller;

import com.example.Carshop.Model.Marque;
import com.example.Carshop.Service.MarqueService;
import com.example.Carshop.api.APIResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/carshop/Marques")

public class MarqueController {

    
    @Autowired
    private MarqueService MarqueService;

     @GetMapping
    public ResponseEntity<APIResponse> getAllMarques() {
        try {
            System.out.println((SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
            List<Marque>  valeure = MarqueService.getAllMarques();
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getMarqueById(@PathVariable int id) {
         try {
            Marque valeure = MarqueService.getMarqueById(id);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<APIResponse> saveMarque(@RequestBody Marque Marque) {
        try {
            Marque  valeure = MarqueService.saveMarque(Marque);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteMarque(@PathVariable int id) {
        try {
            MarqueService.deleteMarque(id);
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
