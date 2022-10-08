package     shukla.java.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author 'Seemant Shukla' on '08/10/2022'
 */

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic createMultiModuleKafkaTopic() {
        return TopicBuilder.name("wikimedia_live_changes").replicas(1).partitions(1).build();
    }

}
