package se.mycompany.fin.track.kafka.transaction.topic.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import se.mycompany.fin.track.model.transaction.Transaction;

@Service
@RequiredArgsConstructor
public class TransactionProducer {
    private final KafkaTemplate<String, Transaction> kafkaTemplate;

    public void sendTransaction(Transaction transaction) {
        kafkaTemplate.send("transactions-topic", transaction);
    }
}
