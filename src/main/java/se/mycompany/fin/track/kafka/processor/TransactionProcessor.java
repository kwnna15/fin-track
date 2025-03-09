package se.mycompany.fin.track.kafka.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import se.mycompany.fin.track.model.transaction.Transaction;

@Slf4j
@Service
public class TransactionProcessor {

    public void processTransaction(Transaction transaction) {
        log.info("Processed transaction {}", transaction);
    }
}
