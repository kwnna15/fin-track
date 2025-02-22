package se.mycompany.fin.track.remote.truelayer.model;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Jacksonized
@Builder
public record TrueLayerTransactionsResponse(List<TrueLayerTransaction> results) {
}
