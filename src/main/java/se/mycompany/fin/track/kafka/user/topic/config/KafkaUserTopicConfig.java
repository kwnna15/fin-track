package se.mycompany.fin.track.kafka.user.topic.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaUserTopicConfig {
    @Bean
    public NewTopic usersTopic() {
        return new NewTopic("users-topic", 2, (short) 1);
    }
}
