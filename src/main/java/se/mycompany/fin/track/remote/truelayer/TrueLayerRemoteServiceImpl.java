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
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerAccountsResponse;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerTransactionsResponse;

@Slf4j
@Service
public class TrueLayerRemoteServiceImpl implements TrueLayerRemoteService {

    @Value("${truelayer.client-id}")
    private String clientId;
    @Value("${truelayer.client-secret}")
    private String clientSecret;
    @Value("${truelayer.auth-url}")
    private String trueLayerAuthUrl;
    @Value("${truelayer.api-url}")
    private String trueLayerApiUrl;
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
        ResponseEntity<AccessToken> response = restTemplate.exchange(trueLayerAuthUrl + "/connect/token", HttpMethod.POST, requestEntity, AccessToken.class);

        log.info("Token response: {}", response.getBody());
        return response.getBody();
    }

    @Override
    public TrueLayerAccountsResponse getAccounts(AccessToken accessToken) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken.accessToken());
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<TrueLayerAccountsResponse> response = restTemplate.exchange(trueLayerApiUrl + "/data/v1/accounts", HttpMethod.GET, entity, TrueLayerAccountsResponse.class);
        log.info("Accounts response: {}", response.getBody());
        return response.getBody();
    }

    @Override
    public TrueLayerTransactionsResponse getTransactions(AccessToken accessToken, String accountId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken.accessToken());
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<TrueLayerTransactionsResponse> response = restTemplate.exchange(trueLayerApiUrl + "/data/v1/accounts/" + accountId + "/transactions", HttpMethod.GET, entity, TrueLayerTransactionsResponse.class);
        log.info("Transactions response: {}", response.getBody());
        return response.getBody();
    }
}
