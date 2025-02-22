package se.mycompany.fin.track.remote.truelayer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import java.util.Set;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
public record TrueLayerTransaction(
        @JsonProperty("transaction_id") String transactionId,
        @JsonProperty("timestamp") Instant timestamp,
        @JsonProperty("description") String description,
        @JsonProperty("amount") String amount,
        @JsonProperty("currency") String currency,
        @JsonProperty("transaction_type") String transactionType,
        @JsonProperty("transaction_category") String transactionCategory,
        @JsonProperty("transaction_classification") Set<String> transactionClassification,
        @JsonProperty("merchant_name") String merchantName,
        @JsonProperty("running_balance") TrueLayerRunningBalance runningBalance,
        @JsonProperty("meta") TrueLayerTransactionMeta meta) {}
