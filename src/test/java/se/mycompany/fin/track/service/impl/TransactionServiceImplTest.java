package se.mycompany.fin.track.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.mycompany.fin.track.exception.AccessTokenNotFoundException;
import se.mycompany.fin.track.mapper.TransactionMapper;
import se.mycompany.fin.track.model.account.AccountId;
import se.mycompany.fin.track.model.auth.AccessToken;
import se.mycompany.fin.track.model.user.UserId;
import se.mycompany.fin.track.remote.truelayer.TrueLayerRemoteService;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerTransaction;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerTransactionsResponse;
import se.mycompany.fin.track.repository.TokenRepository;
import se.mycompany.fin.track.repository.TransactionRepository;
import se.mycompany.fin.track.repository.entity.TransactionEntity;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {

    @Mock
    private TrueLayerRemoteService trueLayerRemoteService;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private TokenRepository tokenRepository;

    @Mock
    private TransactionMapper transactionMapper;

    @InjectMocks
    private TransactionServiceImpl service;

    @Test
    void success() {
        UserId userId = UserId.randomId();
        AccountId accountId = new AccountId(UUID.randomUUID());
        AccessToken accessToken = new AccessToken("test", 0, "test", "test");
        TrueLayerTransactionsResponse transactionsResponse = TrueLayerTransactionsResponse.builder()
                .results(List.of(TrueLayerTransaction.builder().build()))
                .build();

        when(tokenRepository.getToken(userId)).thenReturn(accessToken);
        when(trueLayerRemoteService.getTransactions(accessToken, accountId)).thenReturn(transactionsResponse);
        when(transactionMapper.toEntity(any(TrueLayerTransaction.class))).thenReturn(new TransactionEntity());

        TrueLayerTransactionsResponse result = service.getTransactions(userId, accountId);

        assertEquals(transactionsResponse, result);
        verify(tokenRepository, times(1)).getToken(userId);
        verify(trueLayerRemoteService, times(1)).getTransactions(accessToken, accountId);
        verify(transactionMapper, times(1)).toEntity(any(TrueLayerTransaction.class));
        verify(transactionRepository, times(1)).saveAll(any());
    }

    @Test
    void noTokenFound() {
        UserId userId = UserId.randomId();
        AccountId accountId = new AccountId(UUID.randomUUID());

        when(tokenRepository.getToken(userId)).thenReturn(null);

        assertThrows(AccessTokenNotFoundException.class, () -> service.getTransactions(userId, accountId));

        verify(tokenRepository, times(1)).getToken(userId);
        verifyNoInteractions(trueLayerRemoteService, transactionMapper, transactionRepository);
    }
}
