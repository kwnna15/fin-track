package se.mycompany.fin.track.kafka.user.topic.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import se.mycompany.fin.track.model.transaction.Transaction;
import se.mycompany.fin.track.model.user.User;

@Service
@RequiredArgsConstructor
public class UserProducer {
    private final KafkaTemplate<String, User> kafkaTemplate;

    public void sendTransaction(User user) {
        kafkaTemplate.send("users-topic", user);
    }
}
