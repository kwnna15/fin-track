package se.mycompany.fin.track.service;

import se.mycompany.fin.track.model.user.UserId;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerAccountsResponse;

public interface AccountsService {
    TrueLayerAccountsResponse getAccounts(UserId userId);
}
