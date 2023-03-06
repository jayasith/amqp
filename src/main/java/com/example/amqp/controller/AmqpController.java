package com.example.amqp.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1.0/amqp")
public class AmqpController {

//    private final RabbitmqMessageProducer producer;
//
//    @Autowired
//    public AmqpController(RabbitmqMessageProducer producer) {
//        this.producer = producer;
//    }

    private final KafkaTemplate<String,String> kafkaTemplate;

    public AmqpController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/producer")
    public void setProducer(@RequestBody String request){
        kafkaTemplate.send("notification",request);
    }
}
