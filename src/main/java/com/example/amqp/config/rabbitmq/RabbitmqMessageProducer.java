package com.example.amqp.config.rabbitmq;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RabbitmqMessageProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish(Object payload, String exchange, String routingKey){
        System.out.println("payload :"+payload );
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
    }
}
