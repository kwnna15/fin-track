package se.mycompany.fin.track.exception;

import se.mycompany.fin.track.model.user.UserId;

public class AccessTokenNotFoundException extends RuntimeException {
    public AccessTokenNotFoundException(UserId userId) {
        super("Access token not found for user %s".formatted(userId.id()));
    }
}
