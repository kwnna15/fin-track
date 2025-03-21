package se.mycompany.fin.track.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import se.mycompany.fin.track.model.user.User;
import se.mycompany.fin.track.repository.AccountRepository;
import se.mycompany.fin.track.repository.UserRepository;
import se.mycompany.fin.track.repository.entity.ClassifiedTransactionEntity;
import se.mycompany.fin.track.repository.entity.UserEntity;
import se.mycompany.fin.track.service.AccountsService;
import se.mycompany.fin.track.service.NewUserDataService;
import se.mycompany.fin.track.service.TransactionService;

import java.util.UUID;

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

        accountRepository.findByAccountId()

        transactionService.getTransactions(user.userId(), );

        log.info("Processed user {}", user);
    }
}
