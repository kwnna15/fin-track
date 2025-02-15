package se.mycompany.fin.track.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;


@Slf4j
@RestController
@RequestMapping("/callback")
public class TrueLayerCallbackController {

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

    @GetMapping
    public ResponseEntity<String> handleCallback(@RequestParam("code") String code) {
        log.info("Received authorization code: {}", code);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("grant_type", "authorization_code");
        requestBody.add("client_id", clientId);
        requestBody.add("client_secret", clientSecret);
        requestBody.add("redirect_uri", redirectUri);
        requestBody.add("code", code);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> response = restTemplate.exchange(tokenUrl, HttpMethod.POST, requestEntity, String.class);

        log.info("Token response: {}", response.getBody());
        return ResponseEntity.ok(response.getBody());
    }
}
