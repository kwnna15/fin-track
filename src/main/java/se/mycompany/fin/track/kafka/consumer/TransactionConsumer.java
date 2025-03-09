package se.mycompany.fin.track.kafka.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import se.mycompany.fin.track.kafka.processor.TransactionProcessor;
import se.mycompany.fin.track.model.transaction.Transaction;

@Service
@RequiredArgsConstructor
public class TransactionConsumer {
    private final TransactionProcessor transactionProcessor;

    @KafkaListener(topics = "transactions-topic", groupId = "fin-track-group")
    public void processTransaction(Transaction transaction) {
        transactionProcessor.processTransaction(transaction);
    }
}
