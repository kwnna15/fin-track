package se.mycompany.fin.track.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.mycompany.fin.track.exception.AccessTokenNotFoundException;
import se.mycompany.fin.track.mapper.AccountMapper;
import se.mycompany.fin.track.model.auth.AccessToken;
import se.mycompany.fin.track.model.user.UserId;
import se.mycompany.fin.track.remote.truelayer.TrueLayerRemoteService;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerAccount;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerAccountsResponse;
import se.mycompany.fin.track.repository.AccountRepository;
import se.mycompany.fin.track.repository.TokenRepository;
import se.mycompany.fin.track.repository.entity.AccountEntity;

@ExtendWith(MockitoExtension.class)
class AccountsServiceImplTest {

    @Mock
    private TrueLayerRemoteService trueLayerRemoteService;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TokenRepository tokenRepository;

    @Mock
    private AccountMapper accountMapper;

    @InjectMocks
    private AccountsServiceImpl service;

    @Test
    void success() {
        UserId userId = UserId.randomId();
        AccessToken accessToken = new AccessToken("test", 0, "test", "test");
        TrueLayerAccountsResponse trueLayerAccountsResponse = TrueLayerAccountsResponse.builder()
                .results(List.of(TrueLayerAccount.builder().build()))
                .build();

        when(tokenRepository.getToken(userId)).thenReturn(accessToken);
        when(trueLayerRemoteService.getAccounts(accessToken)).thenReturn(trueLayerAccountsResponse);
        when(accountMapper.toEntity(any(TrueLayerAccount.class))).thenReturn(new AccountEntity());

        TrueLayerAccountsResponse result = service.getAccounts(userId);

        assertEquals(trueLayerAccountsResponse, result);
        verify(tokenRepository, times(1)).getToken(userId);
        verify(trueLayerRemoteService, times(1)).getAccounts(accessToken);
        verify(accountMapper, times(1)).toEntity(any(TrueLayerAccount.class));
        verify(accountRepository, times(1)).saveAll(any());
    }

    @Test
    void noTokenFound() {
        UserId userId = UserId.randomId();

        when(tokenRepository.getToken(userId)).thenReturn(null);

        assertThrows(AccessTokenNotFoundException.class, () -> service.getAccounts(userId));

        verify(tokenRepository, times(1)).getToken(userId);
        verifyNoInteractions(trueLayerRemoteService, accountMapper, accountRepository);
    }
}
