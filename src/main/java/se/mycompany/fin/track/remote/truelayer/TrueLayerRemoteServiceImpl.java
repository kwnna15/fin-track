package se.mycompany.fin.track.remote.truelayer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import se.mycompany.fin.track.model.auth.AccessToken;
import se.mycompany.fin.track.model.auth.AuthorizationCode;

@Slf4j
@Service
public class TrueLayerRemoteServiceImpl implements TrueLayerRemoteService {

    @Value("${truelayer.client-id}")
    private String clientId;
    @Value("${truelayer.client-secret}")
    private String clientSecret;
    @Value("${truelayer.token-url}")
    private String tokenUrl;
    @Value("${truelayer.redirect-uri}")
    private String redirectUri;
    @Value("${truelayer.scope}")
    private String scope;

    @Override
    public AccessToken getAccessToken(AuthorizationCode authorizationCode) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("grant_type", "authorization_code");
        requestBody.add("client_id", clientId);
        requestBody.add("client_secret", clientSecret);
        requestBody.add("redirect_uri", redirectUri);
        requestBody.add("code", authorizationCode.code());

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<AccessToken> response = restTemplate.exchange(tokenUrl, HttpMethod.POST, requestEntity, AccessToken.class);

        log.info("Token response: {}", response.getBody());
        return response.getBody();
    }
}
