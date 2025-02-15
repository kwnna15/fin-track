package se.mycompany.fin.track.remote.truelayer;

import se.mycompany.fin.track.model.auth.AccessToken;
import se.mycompany.fin.track.model.auth.AuthorizationCode;

public interface TrueLayerRemoteService {
    AccessToken getAccessToken(AuthorizationCode authorizationCode);

    String getAccounts(AccessToken accessToken);
}
