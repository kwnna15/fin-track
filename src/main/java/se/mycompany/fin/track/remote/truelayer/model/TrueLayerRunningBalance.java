package se.mycompany.fin.track.remote.truelayer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
public record TrueLayerRunningBalance(@JsonProperty("amount") String amount, @JsonProperty("currency") String currency) {
}
