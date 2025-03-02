package se.mycompany.fin.track.mapper;

import java.util.Currency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import se.mycompany.fin.track.model.account.Account;
import se.mycompany.fin.track.model.account.AccountId;
import se.mycompany.fin.track.model.account.DisplayName;
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

    default AccountId mapToAccountId(String accountId) {
        return new AccountId(accountId);
    }

    default ProviderId mapToProviderId(String providerId) {
        return new ProviderId(providerId);
    }

    default DisplayName mapToDisplayName(String displayName) {
        return new DisplayName(displayName);
    }

    default Currency mapToCurrency(String currency) {
        return Currency.getInstance(currency);
    }

    default ProviderId mapToProviderId(TrueLayerProvider provider) {
        return provider != null ? new ProviderId(provider.providerId()) : null;
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

    default String mapToString(DisplayName displayName) {
        return displayName.name();
    }

    default String mapToString(Currency currency) {
        return currency.getCurrencyCode();
    }
}
