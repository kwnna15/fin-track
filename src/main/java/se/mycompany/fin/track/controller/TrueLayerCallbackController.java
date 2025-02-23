package se.mycompany.fin.track.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.mycompany.fin.track.model.auth.AccessToken;
import se.mycompany.fin.track.model.auth.AuthorizationCode;
import se.mycompany.fin.track.service.AuthorizationService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/callback")
public class TrueLayerCallbackController {

    private final AuthorizationService authorizationService;

    @GetMapping
    public ResponseEntity<AccessToken> handleCallback(@RequestParam("code") String code) {
        log.info("Received authorization code: {}", code);
        AccessToken response = authorizationService.getAccessToken(new AuthorizationCode(code));
        return ResponseEntity.ok(response);
    }
}
