package se.mycompany.fin.track.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/callback")
public class TrueLayerCallbackController {

    public ResponseEntity<String> handleCallback(@RequestParam("code") String code) {
        log.info("Received authorization code: {}", code);
        return ResponseEntity.ok(code);
    }
}
