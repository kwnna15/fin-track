package se.mycompany.fin.track.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.mycompany.fin.track.model.auth.AccessToken;
import se.mycompany.fin.track.model.user.UserId;
import se.mycompany.fin.track.remote.truelayer.TrueLayerRemoteService;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerTransactionsResponse;
import se.mycompany.fin.track.repository.TokenRepository;
import se.mycompany.fin.track.service.TransactionService;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TrueLayerRemoteService trueLayerRemoteService;
    private final TokenRepository tokenRepository;

    @Override
    public TrueLayerTransactionsResponse getTransactions(UserId userId, String accountId) {
        AccessToken accessToken = tokenRepository.getToken(userId);
        return trueLayerRemoteService.getTransactions(accessToken,accountId);
    }
}
