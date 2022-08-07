package com.project.kafka.rest;

public record KafkaTopic(String topic, Integer partition, String key, String data) {

}
