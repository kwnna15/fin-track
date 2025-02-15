package se.mycompany.fin.track.service;

import se.mycompany.fin.track.model.auth.AccessToken;
import se.mycompany.fin.track.model.auth.AuthorizationCode;

public interface AuthorizationService {
    AccessToken getAccessToken(AuthorizationCode authorizationCode);
}
