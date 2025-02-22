package se.mycompany.fin.track.remote.truelayer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
public record TrueLayerAccount(
        @JsonProperty("account_id") String accountId,
        @JsonProperty("account_type") String accountType,
        @JsonProperty("display_name") String displayName,
        @JsonProperty("currency") String currency,
        @JsonProperty("account_number") TrueLayerAccountNumber accountNumber,
        @JsonProperty("provider") TrueLayerProvider provider,
        @JsonProperty("update_timestamp") Instant updateTimestamp) {}
