package se.mycompany.fin.track.model.transaction;

import java.time.Instant;
import java.util.Set;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;
import se.mycompany.fin.track.model.money.Money;

@Builder
@Jacksonized
public record Transaction(
        TransactionId transactionId,
        Instant timestamp,
        Description description,
        Money amount,
        TransactionType transactionType,
        TransactionCategory transactionCategory,
        Set<TransactionClassificationValue> transactionClassification,
        MerchantName merchantName,
        RunningBalance runningBalance,
        TransactionMeta meta) {}
