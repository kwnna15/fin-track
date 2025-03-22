package se.mycompany.fin.track.controller;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.mycompany.fin.track.model.account.AccountId;
import se.mycompany.fin.track.model.user.UserId;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerTransactionsResponse;
import se.mycompany.fin.track.service.TransactionService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionsController {

    private final TransactionService transactionService;

    @GetMapping("/account-id/{id}/user-id/{userId}")
    public ResponseEntity<TrueLayerTransactionsResponse> getTransactions(
            @PathVariable UUID accountId, @PathVariable UUID userId) {
        TrueLayerTransactionsResponse transactionsResponse =
                transactionService.getTransactions(new UserId(userId), new AccountId(accountId));
        return ResponseEntity.ok(transactionsResponse);
    }
}
