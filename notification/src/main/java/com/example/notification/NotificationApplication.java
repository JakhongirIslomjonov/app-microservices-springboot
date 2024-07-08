package com.example.notification;

import com.example.amqp.RabbitMQMessageProducer;
import lombok.Data;
import org.springframework.amqp.core.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication(
        scanBasePackages = {
                "com.example.notification","com.example.amqp"
        }
)
public class NotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

    @Bean
    public TopicExchange internalTopicExchange() {
        return new TopicExchange("myinternalexchange");
    }

    @Bean
    public Queue notificationQueue() {
        return new Queue("myqueue");
    }

    @Bean
    public Binding notificationBinding(){
        return BindingBuilder
                .bind(notificationQueue())
                .to(internalTopicExchange())
                .with("secret-key");
    }

/*    @Bean
    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer){
        return args -> {
            producer.publish(new Data("esmat",12),"myinternalexchange","secret-key");
        };
    }*/
//    record Data(String name , Integer age){}
}
