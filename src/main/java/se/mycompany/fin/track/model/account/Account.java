package se.mycompany.fin.track.model.account;

import lombok.Builder;

import java.time.Instant;

@Builder
public record Account(String accountId,
                      String accountType,
                      String displayName,
                      String currency,
                      String providerId,
                      Instant timestamp) {
}
