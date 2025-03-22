package se.mycompany.fin.track.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.mycompany.fin.track.exception.AccessTokenNotFoundException;
import se.mycompany.fin.track.mapper.AccountMapper;
import se.mycompany.fin.track.model.auth.AccessToken;
import se.mycompany.fin.track.model.user.UserId;
import se.mycompany.fin.track.remote.truelayer.TrueLayerRemoteService;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerAccountsResponse;
import se.mycompany.fin.track.repository.AccountRepository;
import se.mycompany.fin.track.repository.TokenRepository;
import se.mycompany.fin.track.repository.entity.AccountEntity;
import se.mycompany.fin.track.service.AccountsService;

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
        if (token == null) {
            throw new AccessTokenNotFoundException(userId);
        }
        TrueLayerAccountsResponse response = trueLayerRemoteService.getAccounts(token);

        List<AccountEntity> accounts = response.results().stream()
                .map(accountMapper::toEntity)
                .peek(accountEntity -> accountEntity.setUserId(userId.id()))
                .toList();

        accountRepository.saveAll(accounts);
        return response;
    }
}
