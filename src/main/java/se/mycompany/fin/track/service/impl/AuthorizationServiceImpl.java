package se.mycompany.fin.track.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import se.mycompany.fin.track.model.auth.AccessToken;
import se.mycompany.fin.track.model.auth.AuthorizationCode;
import se.mycompany.fin.track.model.user.UserId;
import se.mycompany.fin.track.remote.truelayer.TrueLayerRemoteService;
import se.mycompany.fin.track.repository.TokenRepository;
import se.mycompany.fin.track.service.AuthorizationService;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorizationServiceImpl implements AuthorizationService {

    private final TrueLayerRemoteService trueLayerRemoteService;
    private final TokenRepository tokenRepository;

    @Override
    public AccessToken getAccessToken(AuthorizationCode authorizationCode) {
        AccessToken accessToken = trueLayerRemoteService.getAccessToken(authorizationCode);
        UserId userId = UserId.randomId();
        log.info("UserId: {}", userId);
        tokenRepository.saveToken(userId, accessToken);
        return accessToken;
    }
}
