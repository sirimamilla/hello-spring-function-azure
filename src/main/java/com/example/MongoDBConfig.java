package com.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.stereotype.Component;

@Configuration
public class MongoDBConfig {

    @Bean
    public MongoClient mongoClient(){

        return MongoClients.create("mongodb://jd-mongodb:6DMXe53uFrFcSWJo3YSZRJDn1VFYUKUCYfiQFbv6yuIifMnlWdl3hIyVoY5DtNlDnxjnNUEcyIsxHWq39b8XGA==@jd-mongodb.mongo.cosmos.azure.com:10255/?ssl=true&retrywrites=false&replicaSet=globaldb&minpoolsize=2&maxIdleTimeMS=3600000&appName=@jd-mongodb@");
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient){
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(mongoClient, "db"));
    }
}
