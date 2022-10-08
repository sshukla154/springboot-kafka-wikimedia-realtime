package shukla.java.service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import shukla.java.config.WikimediaChangesHandler;

import java.net.URI;
import java.util.concurrent.TimeUnit;

/**
 * @author 'Seemant Shukla' on '08/10/2022'
 */

@Service
public class WikimediaChangesProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesProducer.class);

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topicName;

    public WikimediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate, String topicName) {
        this.kafkaTemplate = kafkaTemplate;
        this.topicName = topicName;
    }

    public void sendMessage() throws InterruptedException {
        LOGGER.info("WikimediaChangesProducer.sendMessage()");
        EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, topicName);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource eventSource = new EventSource.Builder(eventHandler, URI.create(url)).build();
        eventSource.start();
        TimeUnit.MINUTES.sleep(10);
    }

}
