package sshukla.java.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import sshukla.java.entity.WikimediaData;
import sshukla.java.repository.WikimediaRepository;

import java.util.UUID;

/**
 * @author 'Seemant Shukla' on '08/10/2022'
 */

@Service
public class KafkaDatabaseConsumer {

	Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

	private final WikimediaRepository wikimediaRepository;

	public KafkaDatabaseConsumer(WikimediaRepository wikimediaRepository) {
		this.wikimediaRepository = wikimediaRepository;
	}

	@KafkaListener(topics = "wikimedia_live_changes", groupId = "wikimedia-group")
	public void consumeMessage(String eventMessage) {
		LOGGER.info("KafkaDatabaseConsumer.consumeMessage() :::: {}", eventMessage);
		WikimediaData wikimediaData = new WikimediaData();
		wikimediaData.setId(UUID.randomUUID().toString());
		wikimediaData.setWikimediaEventData(eventMessage);
		wikimediaRepository.save(wikimediaData);
	}

}
