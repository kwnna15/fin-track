package se.mycompany.fin.track.model.account;

import java.time.Instant;
import lombok.Builder;

@Builder
public record Account(
        String accountId,
        String accountType,
        String displayName,
        String currency,
        String providerId,
        Instant timestamp) {}
