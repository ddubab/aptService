package com.example.aptService.kafka.producer;

import com.example.aptService.kafka.config.KafkaPubRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    ObjectMapper objectMapper = new ObjectMapper();
    public void send(KafkaPubRequestDto kafkaPubRequestDto) throws JsonProcessingException {
        log.info("> Kafka Producer Send Start [message] : {}", kafkaPubRequestDto);

        String jsonString = objectMapper.writeValueAsString(kafkaPubRequestDto);
        kafkaTemplate.send("your-topic-1", jsonString);

        log.info("> Kafka Producer Send End [message] : {}", kafkaPubRequestDto);
    }

}