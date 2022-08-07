package com.project.kafka.consumer.topic_1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BarConsumer {

    @KafkaListener(topics = "${message.topic_1.name}", groupId = "bar", containerFactory = "barKafkaListenerContainerFactory")
    public void listenGroupBar(String message) {
        log.info("Received Message in group 'bar': " + message);
    }

}
