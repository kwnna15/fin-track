package se.mycompany.fin.track.kafka.processor;

import java.util.Optional;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import se.mycompany.fin.track.model.transaction.Transaction;
import se.mycompany.fin.track.model.transaction.TransactionClassification;
import se.mycompany.fin.track.repository.ClassifiedTransactionRepository;
import se.mycompany.fin.track.repository.entity.ClassifiedTransactionEntity;

@Slf4j
@Service
public class TransactionProcessor {

    ClassifiedTransactionRepository classifiedTransactionRepository;

    public void processTransaction(Transaction transaction) {
        log.info("Processing transaction {}", transaction);
        Optional<TransactionClassification> maybeClassification = transaction.transactionClassification().stream()
                .map(value -> TransactionClassification.fromString(value.value()))
                .flatMap(Optional::stream)
                .findFirst();

        if (maybeClassification.isPresent()) {
            ClassifiedTransactionEntity entity = ClassifiedTransactionEntity.builder()
                    .id(UUID.randomUUID())
                    .transactionClassification(maybeClassification.get())
                    .build();

            classifiedTransactionRepository.save(entity);
        }
        log.info("Processed transaction {}", transaction);
    }
}
