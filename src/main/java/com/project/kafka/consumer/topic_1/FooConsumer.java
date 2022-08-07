package com.project.kafka.consumer.topic_1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FooConsumer {

    @KafkaListener(topics = "${message.topic_1.name}", groupId = "foo", containerFactory = "fooKafkaListenerContainerFactory")
    public void listenGroupFoo(String message) {
        log.info("Received Message in group 'foo': " + message);
    }

}
