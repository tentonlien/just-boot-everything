package com.vancone.justbootkafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class KafkaProducer {

    private static final String TOPIC = "just-boot-kafka";

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping("/kafka/async/{msg}")
    public void sendMessageAsync(@PathVariable("msg") String msg) {
        kafkaTemplate.send(TOPIC, msg);
    }

    @GetMapping("/kafka/sync/{msg}")
    public void sendMessageSync(@PathVariable("msg") String msg) throws Exception {
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(TOPIC, msg);
        SendResult<String, Object> result = future.get(3, TimeUnit.SECONDS);
        log.info("Send result: {}", result.getProducerRecord().value());
    }
}
