package se.mycompany.fin.track.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Value("${truelayer.client-id}")
    private String clientId;
    @Value("${truelayer.redirect-uri}")
    private String redirectUri;
    @Value("${truelayer.scope}")
    private String scope;

    @GetMapping("/login")
    public ResponseEntity<String> redirectToTrueLayer() {
        return ResponseEntity.status(HttpStatus.FOUND).header(HttpHeaders.LOCATION, getAuthUri()).build();
    }

    private String getAuthUri() {
        var uri = "https://auth.truelayer-sandbox.com/?" +
                "response_type=code" +
                "&client_id=" + clientId +
                "&scope=" + scope+
                "&redirect_uri=" + redirectUri +
                "&providers=uk-cs-mock%20uk-ob-all%20uk-oauth-all";
        log.info(uri);
        return uri;
    }
}
