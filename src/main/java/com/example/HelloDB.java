package com.example;

import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class HelloDB {




    MongoTemplate mongoTemplate;


    public HelloDB(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public User putUser(User user){
        return mongoTemplate.save(user, "users");

    }
    public User getUser(User user){
        return mongoTemplate.findById(user.getName(), User.class,"users");
    }
}
