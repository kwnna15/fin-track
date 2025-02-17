package se.mycompany.fin.track.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import se.mycompany.fin.track.model.account.Account;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerAccount;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerProvider;
import se.mycompany.fin.track.repository.entity.AccountEntity;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(source = "provider.providerId", target = "providerId", qualifiedByName = "mapToProviderId")
    Account toDomain(TrueLayerAccount remote);

    Account toDomain(AccountEntity entity);

    @Mapping(source = "provider.providerId", target = "providerId", qualifiedByName = "mapToProviderId")
    AccountEntity toEntity(TrueLayerAccount remote);

    AccountEntity toEntity(Account entity);

    @Named("mapToProviderId")
    static String mapToProviderId(TrueLayerProvider provider) {
        return provider != null ? provider.providerId() : null;
    }
}
