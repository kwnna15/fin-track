package se.mycompany.fin.track.mapper;

import java.util.Currency;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import se.mycompany.fin.track.model.account.Account;
import se.mycompany.fin.track.model.account.AccountId;
import se.mycompany.fin.track.model.account.DisplayName;
import se.mycompany.fin.track.model.account.ExternalAccountId;
import se.mycompany.fin.track.model.provider.ProviderId;
import se.mycompany.fin.track.model.user.UserId;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerAccount;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerProvider;
import se.mycompany.fin.track.repository.entity.AccountEntity;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(source = "provider", target = "providerId")
    @Mapping(source = "accountId", target = "externalAccountId")
    Account toDomain(TrueLayerAccount remote);

    Account toDomain(AccountEntity entity);

    @Mapping(source = "provider", target = "providerId")
    @Mapping(source = "accountId", target = "externalAccountId")
    AccountEntity toEntity(TrueLayerAccount remote);

    AccountEntity toEntity(Account entity);

    default ExternalAccountId mapToExternalAccountId(String accountId) {
        return new ExternalAccountId(accountId);
    }

    default ProviderId mapToProviderId(String providerId) {
        return new ProviderId(providerId);
    }

    default UserId mapToUserId(UUID userId) {
        return new UserId(userId);
    }

    default AccountId mapToAccountId(UUID id) {
        return new AccountId(id);
    }

    default UUID mapToUUID(UserId userId) {
        return userId.id();
    }

    default UUID mapToUUID(AccountId id) {
        return id.id();
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

    default String mapToString(ExternalAccountId externalAccountId) {
        return externalAccountId.id();
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
