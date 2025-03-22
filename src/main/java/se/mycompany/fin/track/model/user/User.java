package se.mycompany.fin.track.model.user;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
public record User(UserId userId, String name) {}
