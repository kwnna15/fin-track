package se.mycompany.fin.track.model.transaction;

import java.time.Instant;
import java.util.Set;
import lombok.Builder;
import se.mycompany.fin.track.model.money.Money;

@Builder
public record Transaction(
        TransactionId transactionId,
        Instant timestamp,
        String description,
        Money amount,
        String transactionType,
        String transactionCategory,
        Set<String> transactionClassification,
        String merchantName,
        RunningBalance runningBalance,
        TransactionMeta meta) {}
