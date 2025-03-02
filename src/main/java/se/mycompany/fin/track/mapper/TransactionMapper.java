package se.mycompany.fin.track.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import se.mycompany.fin.track.model.transaction.RunningBalance;
import se.mycompany.fin.track.model.transaction.Transaction;
import se.mycompany.fin.track.model.transaction.TransactionMeta;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerRunningBalance;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerTransaction;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerTransactionMeta;
import se.mycompany.fin.track.repository.entity.TransactionEntity;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    Transaction toDomain(TrueLayerTransaction remote);

    @Mapping(target = "runningBalance", source = ".")
    @Mapping(target = "meta", source = ".")
    Transaction toDomain(TransactionEntity entity);

    @Mapping(target = "runningBalanceAmount", source = "runningBalance.amount")
    @Mapping(target = "runningBalanceCurrency", source = "runningBalance.currency")
    @Mapping(target = "metaBankTransactionId", source = "meta.bankTransactionId")
    @Mapping(target = "metaProviderCategory", source = "meta.providerCategory")
    TransactionEntity toEntity(TrueLayerTransaction remote);

    @Mapping(target = "runningBalanceAmount", source = "runningBalance.amount")
    @Mapping(target = "runningBalanceCurrency", source = "runningBalance.currency")
    @Mapping(target = "metaBankTransactionId", source = "meta.bankTransactionId")
    @Mapping(target = "metaProviderCategory", source = "meta.providerCategory")
    TransactionEntity toEntity(Transaction domain);

    default RunningBalance mapToRunningBalance(TrueLayerRunningBalance trueLayerRunningBalance) {
        return RunningBalance.builder()
                .amount(trueLayerRunningBalance.amount())
                .currency(trueLayerRunningBalance.currency())
                .build();
    }

    default TransactionMeta mapToTransactionMeta(TrueLayerTransactionMeta trueLayerTransactionMeta) {
        return TransactionMeta.builder()
                .bankTransactionId(trueLayerTransactionMeta.bankTransactionId())
                .providerCategory(trueLayerTransactionMeta.providerCategory())
                .build();
    }

    default RunningBalance mapToRunningBalance(TransactionEntity entity) {
        return RunningBalance.builder()
                .amount(entity.getRunningBalanceAmount())
                .currency(entity.getRunningBalanceCurrency())
                .build();
    }

    default TransactionMeta mapToTransactionMeta(TransactionEntity entity) {
        return TransactionMeta.builder()
                .bankTransactionId(entity.getMetaBankTransactionId())
                .providerCategory(entity.getMetaProviderCategory())
                .build();
    }
}
