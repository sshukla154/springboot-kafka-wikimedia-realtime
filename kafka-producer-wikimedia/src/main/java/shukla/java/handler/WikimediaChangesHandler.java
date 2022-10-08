package shukla.java.handler;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author 'Seemant Shukla' on '08/10/2022'
 */
public class WikimediaChangesHandler implements EventHandler {

    Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesHandler.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topicName;

    public WikimediaChangesHandler(KafkaTemplate kafkaTemplate, String topicName) {
        this.kafkaTemplate = kafkaTemplate;
        this.topicName = topicName;
    }

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {

        LOGGER.info("WikimediaChangesHandler.onMessage() - New Changes from Wikimedia ::::::: {}", messageEvent.getData());
        //Read real time data from https://stream.wikimedia.org/v2/stream/recentchange
        kafkaTemplate.send(topicName, messageEvent.getData());

    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
