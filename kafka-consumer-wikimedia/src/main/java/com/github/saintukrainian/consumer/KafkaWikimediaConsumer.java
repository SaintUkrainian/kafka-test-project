package com.github.saintukrainian.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@PropertySource("classpath:application.yml")
public class KafkaWikimediaConsumer {

  @KafkaListener(topics = "wikimedia_recentchange", groupId = "${spring.kafka.consumer.group-id}")
  public void consume(String eventMessage) {
    log.info("Message received -> {}", eventMessage);
  }
}
