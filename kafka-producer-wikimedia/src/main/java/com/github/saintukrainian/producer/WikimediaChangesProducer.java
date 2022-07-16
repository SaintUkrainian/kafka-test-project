package com.github.saintukrainian.producer;

import com.github.saintukrainian.handler.WikimediaChangesHandler;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.EventSource.Builder;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class WikimediaChangesProducer {

  private final KafkaTemplate<String, String> kafkaTemplate;

  public void sendMessage() throws InterruptedException {
    // reading real time stream data from wikimedia using event source
    EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate);
    String url = "https://stream.wikimedia.org/v2/stream/recentchange";
    EventSource eventSource = new Builder(eventHandler, URI.create(url)).build();

    eventSource.start();

    TimeUnit.MINUTES.sleep(10);
  }
}
