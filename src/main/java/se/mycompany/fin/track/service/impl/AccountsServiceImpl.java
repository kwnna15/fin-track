package se.mycompany.fin.track.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.mycompany.fin.track.mapper.AccountMapper;
import se.mycompany.fin.track.model.auth.AccessToken;
import se.mycompany.fin.track.model.user.UserId;
import se.mycompany.fin.track.remote.truelayer.TrueLayerRemoteService;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerAccountsResponse;
import se.mycompany.fin.track.repository.AccountRepository;
import se.mycompany.fin.track.repository.TokenRepository;
import se.mycompany.fin.track.repository.entity.AccountEntity;
import se.mycompany.fin.track.service.AccountsService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements AccountsService {

    private final TrueLayerRemoteService trueLayerRemoteService;
    private final AccountRepository accountRepository;
    private final TokenRepository tokenRepository;
    private final AccountMapper accountMapper;

    @Override
    public TrueLayerAccountsResponse getAccounts(UserId userId) {
        AccessToken token = tokenRepository.getToken(userId);
        TrueLayerAccountsResponse response = trueLayerRemoteService.getAccounts(token);

        List<AccountEntity> accounts = response.results()
                .stream()
                .map(accountMapper::toEntity)
                .toList();

        accountRepository.saveAll(accounts);
        return response;
    }
}
