package se.mycompany.fin.track.model.transaction;

import lombok.Builder;

@Builder
public record TransactionMeta(String bankTransactionId, String providerCategory) {}
