package se.mycompany.fin.track.remote.truelayer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
public record TrueLayerTransactionMeta(@JsonProperty("bank_transaction_id") String bankTransactionId,
                                       @JsonProperty("provider_category") String providerCategory) {
}
