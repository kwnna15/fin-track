package se.mycompany.fin.track.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic transactionsTopic() {
        return new NewTopic("transactions-topic", 2, (short) 1);
    }
}
