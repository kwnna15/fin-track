package se.mycompany.fin.track.kafka.transaction.topic.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTransactionTopicConfig {
    @Bean
    public NewTopic transactionsTopic() {
        return new NewTopic("transactions-topic", 2, (short) 1);
    }
}
