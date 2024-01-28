package com.example.Carshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Carshop.Model.Notification;
import com.example.Carshop.Repository.NotificationRepository;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository NotificationRepository;

    public List<Notification> getAllNotifications() {
        return NotificationRepository.findAll();
    }

    public Notification getNotificationById(int id) {
        return NotificationRepository.findById(id).orElse(null);
    }

    public Notification saveNotification(Notification Notification) {
        return NotificationRepository.save(Notification);
    }

    public void deleteNotification(int id) {
        NotificationRepository.deleteById(id);
    }

    // Autres méthodes CRUD personnalisées si nécessaire
}

