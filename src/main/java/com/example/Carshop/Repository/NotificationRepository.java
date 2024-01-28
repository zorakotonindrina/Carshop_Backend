package com.example.Carshop.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Carshop.Model.Notification;
@Repository
public interface NotificationRepository extends MongoRepository<Notification,Integer>{
    
}
