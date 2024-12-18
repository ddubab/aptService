package com.example.aptService.kafka.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class KafkaSubRequestDto {

    private Long messageId;         // 메시지 고유 ID
    private String sender;          // 메시지를 보낸 주체
    private String messageContent;  // 메시지 내용
    private String timestamp;       // 메시지 생성 시간 (ISO 8601 형식)

    // 필요 시 추가적인 필드
}