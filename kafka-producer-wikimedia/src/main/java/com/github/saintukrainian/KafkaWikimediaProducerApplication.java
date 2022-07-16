package com.github.saintukrainian;

import com.github.saintukrainian.producer.WikimediaChangesProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class KafkaWikimediaProducerApplication implements CommandLineRunner {

  private final WikimediaChangesProducer wikimediaChangesProducer;

  public static void main(String[] args) {
    SpringApplication.run(KafkaWikimediaProducerApplication.class);
  }

  @Override
  public void run(String... args) throws Exception {
    wikimediaChangesProducer.sendMessage();
  }
}
