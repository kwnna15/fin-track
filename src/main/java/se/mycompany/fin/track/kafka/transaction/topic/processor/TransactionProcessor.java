package se.mycompany.fin.track.kafka.transaction.topic.processor;

import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import se.mycompany.fin.track.model.transaction.Transaction;
import se.mycompany.fin.track.model.transaction.TransactionClassification;
import se.mycompany.fin.track.repository.ClassifiedTransactionRepository;
import se.mycompany.fin.track.repository.entity.ClassifiedTransactionEntity;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionProcessor {

    private final ClassifiedTransactionRepository classifiedTransactionRepository;

    public void processTransaction(Transaction transaction) {
        log.info("Processing transaction {}", transaction);
        TransactionClassification classification = transaction.transactionClassification().stream()
                .map(value -> TransactionClassification.fromString(value.value()))
                .flatMap(Optional::stream)
                .findFirst()
                .orElse(TransactionClassification.UNCATEGORIZED);

        ClassifiedTransactionEntity entity = ClassifiedTransactionEntity.builder()
                .id(UUID.randomUUID())
                .transactionClassification(classification)
                .build();

        classifiedTransactionRepository.save(entity);

        log.info("Processed transaction {}", transaction);
    }
}
