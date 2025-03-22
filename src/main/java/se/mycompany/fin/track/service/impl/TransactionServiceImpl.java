package se.mycompany.fin.track.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.mycompany.fin.track.exception.AccessTokenNotFoundException;
import se.mycompany.fin.track.mapper.TransactionMapper;
import se.mycompany.fin.track.model.account.AccountId;
import se.mycompany.fin.track.model.auth.AccessToken;
import se.mycompany.fin.track.model.user.UserId;
import se.mycompany.fin.track.remote.truelayer.TrueLayerRemoteService;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerTransactionsResponse;
import se.mycompany.fin.track.repository.TokenRepository;
import se.mycompany.fin.track.repository.TransactionRepository;
import se.mycompany.fin.track.repository.entity.TransactionEntity;
import se.mycompany.fin.track.service.TransactionService;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TrueLayerRemoteService trueLayerRemoteService;
    private final TransactionRepository transactionRepository;
    private final TokenRepository tokenRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public TrueLayerTransactionsResponse getTransactions(UserId userId, AccountId accountId) {
        AccessToken accessToken = tokenRepository.getToken(userId);
        if (accessToken == null) {
            throw new AccessTokenNotFoundException(userId);
        }
        TrueLayerTransactionsResponse response = trueLayerRemoteService.getTransactions(accessToken, accountId);

        List<TransactionEntity> transactions = response.results().stream()
                .map(transactionMapper::toEntity)
                .peek(transactionEntity -> transactionEntity.setAccountID(accountId.id()))
                .toList();

        transactionRepository.saveAll(transactions);
        return response;
    }
}
