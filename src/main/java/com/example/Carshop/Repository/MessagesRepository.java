package com.example.Carshop.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Carshop.Model.Messages;


@Repository
public interface MessagesRepository extends MongoRepository<Messages,Integer>{
    
}
