package se.mycompany.fin.track.kafka.user.topic.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import se.mycompany.fin.track.model.user.User;
import se.mycompany.fin.track.service.NewUserDataService;

@Service
@RequiredArgsConstructor
public class UserConsumer {
    private final NewUserDataService newUserDataService;

    @KafkaListener(topics = "users-topic", groupId = "fin-track-group")
    public void processUser(User user) {
        newUserDataService.processUser(user);
    }
}
