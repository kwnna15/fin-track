package se.mycompany.fin.track.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.mycompany.fin.track.model.auth.AccessToken;
import se.mycompany.fin.track.model.user.UserId;
import se.mycompany.fin.track.remote.truelayer.TrueLayerRemoteService;
import se.mycompany.fin.track.repository.TokenRepository;
import se.mycompany.fin.track.service.AccountsService;

@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements AccountsService {

    private final TrueLayerRemoteService trueLayerRemoteService;
    private final TokenRepository tokenRepository;

    @Override
    public String getAccounts(UserId userId) {
        AccessToken token = tokenRepository.getToken(userId);
        return trueLayerRemoteService.getAccounts(token);
    }
}
