package com.example.Carshop.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Carshop.Model.Detail_message;


@Repository
public interface Detail_messagesRepository extends MongoRepository<Detail_message,Integer>{
    
}
