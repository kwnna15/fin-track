package se.mycompany.fin.track.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@Slf4j
@RestController
@RequestMapping("/auth")
public class TrueLayerAuthController {

    @Value("${true.layer.client.id}")
    private String clientId;
    @Value("${true.layer.redirect.uri}")
    private String redirectUri;
    @Value("${true.layer.scope}")
    private String scope;

    @GetMapping("/login")
    public ResponseEntity<String> redirectToTrueLayer() {
        return ResponseEntity.status(HttpStatus.FOUND).header(HttpHeaders.LOCATION, getAuthUri()).build();
    }

    private String getAuthUri() {
        var uri = "https://auth.truelayer-sandbox.com/?" +
                "response_type=code" +
                "&client_id=" + clientId +
                "&redirect_uri=" + redirectUri +
                "&scope=" + scope +
                "&providers=uk-ob-all";
        log.info(uri);
        return uri;
    }
}
