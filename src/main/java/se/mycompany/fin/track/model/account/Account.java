package se.mycompany.fin.track.model.account;

import java.time.Instant;
import java.util.Currency;
import lombok.Builder;
import se.mycompany.fin.track.model.provider.ProviderId;

@Builder
public record Account(
        AccountId accountId,
        AccountType accountType,
        DisplayName displayName,
        Currency currency,
        ProviderId providerId,
        Instant timestamp) {}
