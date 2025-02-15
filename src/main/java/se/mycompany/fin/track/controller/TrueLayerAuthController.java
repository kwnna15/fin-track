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

    @Deprecated
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

// https://swimlanes.io/#fZBNT4NAEIbv+yveIyVBkN4aPxKjbYyNPUjjoeGwwrRMWHaTZaHir3dB00ZjvM4878eMY6dogVdShWkIzqA9cqOkpvaCjRBi25JFdIMl6yizsqgX2K0eshyx7FwVK3Ng/U1dRT+oeZJiudk+3+fIbEdrOXhmFBnLH9Kx0egsI2ANVxEqkiXZ2TnxJPJeheKizrEe0yB1efIh9CwnvfcS4hz0Z+VCKvXmB7eFKen6Mp0LcYJ+R6ZJgs1T/g8xea7ITWX862rSCLK7R3+D0Mb5t74QIQx3+04ptIN28h2mJ9szHfMgPvg2ZId4XEdf61kYYm8sGmMJJTnJqv0E
