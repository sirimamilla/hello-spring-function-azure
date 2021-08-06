package com.example;

import com.example.model.Greeting;
import com.example.model.User;
import com.example.model.UserInvocation;
import com.microsoft.azure.functions.ExecutionContext;
import com.redis.U;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloTest {

//    @Test
//    public void test() {
//        User user=new User("test", "test");
//        UserInvocation userInvocation=new UserInvocation("POST", user);
//        Mono<User> result = new Hello().apply(Mono.just(userInvocation));
//        assertThat(result.block().getName()).isEqualTo("test");
//    }

    @Test
    public void start() {
        FunctionInvoker<UserInvocation, User> handler = new FunctionInvoker<>(
                DemoApplication.class);
        User user=new User("test", "test");
        UserInvocation userInvocation=new UserInvocation("POST", user);
        User result = handler.handleRequest(userInvocation, new ExecutionContext() {
            @Override
            public Logger getLogger() {
                return Logger.getLogger(HelloTest.class.getName());
            }

            @Override
            public String getInvocationId() {
                return "id1";
            }

            @Override
            public String getFunctionName() {
                return "hello";
            }
        });
        handler.close();
        assertThat(result.getName()).isEqualTo("test");
    }
}
