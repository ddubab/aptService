package com.example.aptService.kafka.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
public class KafkaPubRequestDto {
    @JsonProperty("topic")
    private String topic;          // 메시지를 발행할 토픽 이름
    @JsonProperty("key")
    private String key;            // 메시지 키
    @JsonProperty("payload")
    private String payload;        // 메시지 내용


    @JsonProperty("metadata")
    private String metadata;
}
