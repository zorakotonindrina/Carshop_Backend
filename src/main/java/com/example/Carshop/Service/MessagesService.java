package com.example.Carshop.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Carshop.Model.Messages;
import com.example.Carshop.Repository.MessagesRepository;


import java.util.List;

@Service
public class MessagesService {

    @Autowired
    private MessagesRepository MessagesRepository;

    public List<Messages> getAllMessagess() {
        return MessagesRepository.findAll();
    }

    public int geIdMessages(int id_utilisateur1, int id_utilisateur2) {
        List<Messages> liste=  MessagesRepository.findAll();
        for (int i = 0; i < liste.size() ; i++) {
            if((liste.get(i).getId_expediteur() == id_utilisateur1) || (liste.get(i).getId_recepteur() == id_utilisateur1))
            {
                if((liste.get(i).getId_expediteur() == id_utilisateur2) || (liste.get(i).getId_recepteur() == id_utilisateur2))
                {
                    return liste.get(i).getId_message();
                }
            }
        }
        return 0;
    }



    public Messages getMessagesById(int id) {
        return MessagesRepository.findById(id).orElse(null);
    }

    public Messages saveMessages(Messages Messages) {
        return MessagesRepository.save(Messages);
    }

    public void deleteMessages(int id) {
        MessagesRepository.deleteById(id);
    }

    // Autres méthodes CRUD personnalisées si nécessaire
}

