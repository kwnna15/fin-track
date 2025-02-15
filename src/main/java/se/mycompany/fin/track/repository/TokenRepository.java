package se.mycompany.fin.track.repository;

import org.springframework.stereotype.Repository;
import se.mycompany.fin.track.model.auth.AccessToken;
import se.mycompany.fin.track.model.user.UserId;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TokenRepository {
    private final ConcurrentHashMap<UserId, AccessToken> tokenStore = new ConcurrentHashMap<>();

    public void saveToken(UserId userId, AccessToken accessToken) {
        tokenStore.put(userId, accessToken);
    }

    public AccessToken getToken(UserId userId) {
        return tokenStore.get(userId);
    }

    public void removeToken(UserId userId) {
        tokenStore.remove(userId);
    }
}
