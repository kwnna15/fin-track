package se.mycompany.fin.track.remote.truelayer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
public record TrueLayerAccountNumber(@JsonProperty("iban") String iban,
                                     @JsonProperty("number") String number,
                                     @JsonProperty("sort_code") String sortCode,
                                     @JsonProperty("swift_bic") String swiftBic) {
}
