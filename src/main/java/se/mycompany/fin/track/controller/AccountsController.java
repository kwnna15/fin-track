package se.mycompany.fin.track.controller;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.mycompany.fin.track.model.user.UserId;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerAccountsResponse;
import se.mycompany.fin.track.service.AccountsService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountsController {

    private final AccountsService accountsService;

    @GetMapping("/user-id/{userId}")
    public ResponseEntity<TrueLayerAccountsResponse> getAccounts(@PathVariable UUID userId) {
        TrueLayerAccountsResponse accounts = accountsService.getAccounts(new UserId(userId));
        return ResponseEntity.ok(accounts);
    }
}
