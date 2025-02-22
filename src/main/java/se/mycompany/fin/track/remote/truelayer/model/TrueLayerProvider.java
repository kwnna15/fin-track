package se.mycompany.fin.track.remote.truelayer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
public record TrueLayerProvider(@JsonProperty("provider_id") String providerId) {}
