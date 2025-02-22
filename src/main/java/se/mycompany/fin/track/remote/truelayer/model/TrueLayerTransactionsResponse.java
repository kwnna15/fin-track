package se.mycompany.fin.track.remote.truelayer.model;

import java.util.List;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
public record TrueLayerTransactionsResponse(List<TrueLayerTransaction> results) {}
