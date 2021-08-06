package com.example;

import com.example.model.Greeting;
import com.example.model.User;
import com.example.model.UserInvocation;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.function.Function;


@Component
public class Hello implements Function<Mono<UserInvocation
        >, Mono<User>> {




    @Autowired
    HelloDB helloDB;



    public Mono<User> apply(Mono<UserInvocation> mono) {
        UserInvocation userInvocation = mono.block();
        User user;
        if ("GET".equals(userInvocation.getMethod())){
            user = helloDB.getUser(userInvocation.getUser());

        } else {
            user = helloDB.putUser(userInvocation.getUser());
        }

        return mono.just(user);
    }





}
