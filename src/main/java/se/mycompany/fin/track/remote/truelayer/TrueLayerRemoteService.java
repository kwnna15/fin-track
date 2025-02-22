package se.mycompany.fin.track.remote.truelayer;

import se.mycompany.fin.track.model.auth.AccessToken;
import se.mycompany.fin.track.model.auth.AuthorizationCode;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerAccountsResponse;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerTransactionsResponse;

public interface TrueLayerRemoteService {
    AccessToken getAccessToken(AuthorizationCode authorizationCode);

    TrueLayerAccountsResponse getAccounts(AccessToken accessToken);

    TrueLayerTransactionsResponse getTransactions(AccessToken accessToken, String accountId);
}
