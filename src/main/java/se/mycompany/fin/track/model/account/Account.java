package se.mycompany.fin.track.model.account;

import java.time.Instant;
import java.util.Currency;
import lombok.Builder;
import se.mycompany.fin.track.model.provider.ProviderId;
import se.mycompany.fin.track.model.user.UserId;

@Builder
public record Account(
        AccountId id,
        ExternalAccountId externalAccountId,
        UserId userId,
        AccountType accountType,
        DisplayName displayName,
        Currency currency,
        ProviderId providerId,
        Instant timestamp) {}
