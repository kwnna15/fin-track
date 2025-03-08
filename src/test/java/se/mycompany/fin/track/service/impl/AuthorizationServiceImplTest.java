package se.mycompany.fin.track.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.mycompany.fin.track.model.auth.AccessToken;
import se.mycompany.fin.track.model.auth.AuthorizationCode;
import se.mycompany.fin.track.remote.truelayer.TrueLayerRemoteService;
import se.mycompany.fin.track.repository.TokenRepository;

@ExtendWith(MockitoExtension.class)
class AuthorizationServiceImplTest {

    @Mock
    private TrueLayerRemoteService trueLayerRemoteService;

    @Mock
    private TokenRepository tokenRepository;

    @InjectMocks
    private AuthorizationServiceImpl service;

    @Test
    void success() {
        AuthorizationCode authorizationCode = new AuthorizationCode("test");
        AccessToken accessToken = new AccessToken("test", 0, "test", "test");

        when(trueLayerRemoteService.getAccessToken(authorizationCode)).thenReturn(accessToken);

        AccessToken result = service.getAccessToken(authorizationCode);

        assertEquals(accessToken, result);
        verify(trueLayerRemoteService, times(1)).getAccessToken(eq(authorizationCode));
        verify(tokenRepository, times(1)).saveToken(any(), eq(accessToken));
    }
}
