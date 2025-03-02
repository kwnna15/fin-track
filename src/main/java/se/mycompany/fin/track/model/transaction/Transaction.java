package se.mycompany.fin.track.model.transaction;

import java.time.Instant;
import java.util.Set;
import lombok.Builder;

@Builder
public record Transaction(
        String transactionId,
        Instant timestamp,
        String description,
        String amount,
        String currency,
        String transactionType,
        String transactionCategory,
        Set<String> transactionClassification,
        String merchantName,
        RunningBalance runningBalance,
        TransactionMeta meta) {}
