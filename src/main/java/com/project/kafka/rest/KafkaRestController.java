package com.project.kafka.rest;

import com.project.kafka.producer.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaRestController {

    private final KafkaProducer kafkaProducer;


    public KafkaRestController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/consume")
    public ResponseEntity<String> consume(@RequestBody KafkaTopic kafkaTopic) throws InterruptedException {
        kafkaProducer.sendMessage(kafkaTopic);
        return ResponseEntity.ok().build();
    }

}
