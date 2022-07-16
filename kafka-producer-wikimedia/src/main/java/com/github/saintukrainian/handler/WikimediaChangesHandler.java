package com.github.saintukrainian.handler;

import static com.github.saintukrainian.config.KafkaTopicConfig.TOPIC_NAME;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
@RequiredArgsConstructor
public class WikimediaChangesHandler implements EventHandler {

  private final KafkaTemplate<String, String> kafkaTemplate;

  @Override
  public void onOpen() throws Exception {

  }

  @Override
  public void onClosed() throws Exception {

  }

  @Override
  public void onMessage(String s, MessageEvent messageEvent) throws Exception {
    String data = messageEvent.getData();
    log.info("Event data -> {}", data);
    kafkaTemplate.send(TOPIC_NAME, data);
  }

  @Override
  public void onComment(String s) throws Exception {

  }

  @Override
  public void onError(Throwable throwable) {

  }
}
