package se.mycompany.fin.track.model.user;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;
import se.mycompany.fin.track.model.account.Account;

import java.util.Set;

@Builder
@Jacksonized
public record User(
        UserId userId,
        String name
) {
}
