package com.project.kafka.producer;

import com.project.kafka.rest.KafkaTopic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Component
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(KafkaTopic kafkaTopic) {

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(kafkaTopic.topic(), kafkaTopic.message());

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Sent message=[" + kafkaTopic.message() + "] with topic=[" + kafkaTopic.topic() + "] and offset=[" + result.getRecordMetadata()
                        .offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("Unable to send message=[" + kafkaTopic.message() + "] with topic=[" + kafkaTopic.topic() + "] due to : " + ex.getMessage());
            }
        });

    }

}
