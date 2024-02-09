package com.example.Carshop.Controller;

import com.example.Carshop.Model.Detail_message;
import com.example.Carshop.Service.Detail_messageService;
import com.example.Carshop.api.APIResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/carshop/Detail_messages")
public class Detail_messageController {

    
    @Autowired
    private Detail_messageService Detail_messageService;

    @GetMapping
    public ResponseEntity<APIResponse> getAllDetail_messages() {
        try {
            List<Detail_message>  valeure = Detail_messageService.getAllDetail_messages();
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getDetail_messageById(@PathVariable int id) {
         try {
            Detail_message valeure = Detail_messageService.getDetail_messageById(id);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @GetMapping("/messages/{id}")
    public ResponseEntity<APIResponse> getDetail_messageByIdMessage(@PathVariable int id) {
         try {
            List<Detail_message> valeure = Detail_messageService.getDetail_messageByIdMessage(id);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<APIResponse> saveDetail_message(@RequestBody Detail_message Detail_message) {
        try {
            Detail_message  valeure = Detail_messageService.saveDetail_message(Detail_message);
            APIResponse api = new APIResponse(null, valeure);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteDetail_message(@PathVariable int id) {
        try {
            Detail_messageService.deleteDetail_message(id);
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
