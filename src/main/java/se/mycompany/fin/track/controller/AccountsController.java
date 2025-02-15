package se.mycompany.fin.track.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.mycompany.fin.track.model.user.UserId;
import se.mycompany.fin.track.service.AccountsService;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
public class AccountsController {

    private final AccountsService accountsService;

    @GetMapping("/{userId}")
    public ResponseEntity<String> getAccounts(@PathVariable UUID userId) {
        String accounts = accountsService.getAccounts(new UserId(userId));
        return ResponseEntity.ok(accounts);
    }
}
