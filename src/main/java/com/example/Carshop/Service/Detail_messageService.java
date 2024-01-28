package com.example.Carshop.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Carshop.Model.Detail_message;
import com.example.Carshop.Repository.Detail_messagesRepository;

import java.util.List;

@Service
public class Detail_messageService {

    @Autowired
    private Detail_messagesRepository Detail_messageRepository;

    public List<Detail_message> getAllDetail_messages() {
        return Detail_messageRepository.findAll();
    }

    public Detail_message getDetail_messageById(int id) {
        return Detail_messageRepository.findById(id).orElse(null);
    }

    public Detail_message saveDetail_message(Detail_message Detail_message) {
        return Detail_messageRepository.save(Detail_message);
    }

    public void deleteDetail_message(int id) {
        Detail_messageRepository.deleteById(id);
    }

    // Autres méthodes CRUD personnalisées si nécessaire
}
