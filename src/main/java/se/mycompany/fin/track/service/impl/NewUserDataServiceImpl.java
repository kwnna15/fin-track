package se.mycompany.fin.track.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import se.mycompany.fin.track.model.user.User;
import se.mycompany.fin.track.repository.AccountRepository;
import se.mycompany.fin.track.repository.UserRepository;
import se.mycompany.fin.track.service.AccountsService;
import se.mycompany.fin.track.service.NewUserDataService;
import se.mycompany.fin.track.service.TransactionService;

@Slf4j
@Service
@RequiredArgsConstructor
public class NewUserDataServiceImpl implements NewUserDataService {

    private final UserRepository userRepository;
    private final AccountsService accountsService;
    private final TransactionService transactionService;
    private final AccountRepository accountRepository;

    @Override
    public void processUser(User user) {
        accountsService.getAccounts(user.userId());

        accountRepository.findByUserId(user.userId().id());

        // transactionService.getTransactions(user.userId(), );

        log.info("Processed user {}", user);
    }
}
