package com.example.Carshop.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Carshop.Model.Detail_message;
import com.example.Carshop.Model.Messages;
import com.example.Carshop.Model.Notification;
import com.example.Carshop.Repository.Detail_messagesRepository;
import com.example.Carshop.Repository.NotificationRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class Detail_messageService {

    @Autowired
    private Detail_messagesRepository Detail_messageRepository;

    @Autowired
    private NotificationRepository NotificationRepository;

    @Autowired
    private MessagesService MessagesService;

    public List<Detail_message> getAllDetail_messages() {
        return Detail_messageRepository.findAll();
    }

    public Detail_message getDetail_messageById(int id) {
        return Detail_messageRepository.findById(id).orElse(null);
    }


    public List<Detail_message> getDetail_messageByIdMessage(int idmes) {
        List<Detail_message> liste = Detail_messageRepository.findAll();
        List<Detail_message> rep = new ArrayList<>();
        for (int i = 0; i < liste.size() ; i++) {
            if(liste.get(i).getId_message() == idmes){
                rep.add(liste.get(i));
            }
        }
        return rep;
    }





    public Detail_message saveDetail_message(Detail_message Detail_message) {
        Messages mes= MessagesService.getMessagesById(Detail_message.getId_message());
        int id_user = mes.getId_expediteur();
        if(Detail_message.getId_messageur() == mes.getId_expediteur()){
            id_user = mes.getId_recepteur();
        }
        Notification notif = new Notification();
        notif.setId_message(mes.getId_message());
        notif.setId_utilisateur(id_user);
        notif.setContenu(Detail_message.getContenu());
        notif.setDate_notif(Detail_message.getDate_message());
        notif.setEtat(0);
        NotificationRepository.save(notif);
        return Detail_messageRepository.save(Detail_message);
    }

    public void deleteDetail_message(int id) {
        Detail_messageRepository.deleteById(id);
    }

    // Autres méthodes CRUD personnalisées si nécessaire
}
