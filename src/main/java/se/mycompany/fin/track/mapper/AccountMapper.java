package se.mycompany.fin.track.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import se.mycompany.fin.track.model.account.Account;
import se.mycompany.fin.track.model.account.AccountId;
import se.mycompany.fin.track.model.provider.ProviderId;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerAccount;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerProvider;
import se.mycompany.fin.track.repository.entity.AccountEntity;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(source = "provider", target = "providerId")
    Account toDomain(TrueLayerAccount remote);

    Account toDomain(AccountEntity entity);

    @Mapping(source = "provider", target = "providerId")
    AccountEntity toEntity(TrueLayerAccount remote);

    AccountEntity toEntity(Account entity);

    default ProviderId mapToProviderId(TrueLayerProvider provider) {
        return provider != null ? new ProviderId(provider.providerId()) : null;
    }

    default ProviderId mapToProviderId(String providerId) {
        return new ProviderId(providerId);
    }

    default AccountId mapToAccountId(String accountId) {
        return new AccountId(accountId);
    }

    default String mapToString(AccountId accountId) {
        return accountId.id();
    }

    default String mapToString(ProviderId provider) {
        return provider.id();
    }

    default String mapToString(TrueLayerProvider provider) {
        return provider.providerId();
    }
}
