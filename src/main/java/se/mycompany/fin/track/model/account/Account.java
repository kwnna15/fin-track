package se.mycompany.fin.track.model.account;

import lombok.Builder;
import se.mycompany.fin.track.model.provider.ProviderId;

import java.time.Instant;

@Builder
public record Account(
        AccountId accountId,
        AccountType accountType,
        String displayName,
        String currency,
        ProviderId providerId,
        Instant timestamp) {}
