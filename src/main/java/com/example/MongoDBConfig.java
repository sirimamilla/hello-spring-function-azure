package com.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoDBConfig {

    @Value("${CUSTOMCONNSTR_MONGODB_CONNECTION}")
    String mongoConnectionString;

    @Bean
    public MongoClient mongoClient(){

        return MongoClients.create(mongoConnectionString);
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient){
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(mongoClient, "db"));
    }
}
