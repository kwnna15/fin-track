package se.mycompany.fin.track.service;

import se.mycompany.fin.track.model.account.AccountId;
import se.mycompany.fin.track.model.user.UserId;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerTransactionsResponse;

public interface TransactionService {

    TrueLayerTransactionsResponse getTransactions(UserId userId, AccountId accountId);
}
