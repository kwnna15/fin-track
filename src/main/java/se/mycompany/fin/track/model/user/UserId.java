package se.mycompany.fin.track.model.user;

import java.util.UUID;

public record UserId(UUID id) {
    public static UserId randomId() {
        return new UserId(UUID.randomUUID());
    }
}
