package se.mycompany.fin.track.mapper;

import java.math.BigDecimal;
import java.util.Currency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import se.mycompany.fin.track.model.money.Money;
import se.mycompany.fin.track.model.transaction.RunningBalance;
import se.mycompany.fin.track.model.transaction.Transaction;
import se.mycompany.fin.track.model.transaction.TransactionId;
import se.mycompany.fin.track.model.transaction.TransactionMeta;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerRunningBalance;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerTransaction;
import se.mycompany.fin.track.remote.truelayer.model.TrueLayerTransactionMeta;
import se.mycompany.fin.track.repository.entity.TransactionEntity;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mapping(target = "amount", source = ".")
    Transaction toDomain(TrueLayerTransaction remote);

    @Mapping(target = "amount", source = ".")
    @Mapping(target = "runningBalance", source = ".")
    @Mapping(target = "meta", source = ".")
    Transaction toDomain(TransactionEntity entity);

    @Mapping(target = "runningBalanceAmount", source = "runningBalance.amount")
    @Mapping(target = "runningBalanceCurrency", source = "runningBalance.currency")
    @Mapping(target = "metaBankTransactionId", source = "meta.bankTransactionId")
    @Mapping(target = "metaProviderCategory", source = "meta.providerCategory")
    TransactionEntity toEntity(TrueLayerTransaction remote);

    @Mapping(target = "amount", source = "amount.amount")
    @Mapping(target = "currency", source = "amount.currency")
    @Mapping(target = "runningBalanceAmount", source = "runningBalance.amount")
    @Mapping(target = "runningBalanceCurrency", source = "runningBalance.currency")
    @Mapping(target = "metaBankTransactionId", source = "meta.bankTransactionId")
    @Mapping(target = "metaProviderCategory", source = "meta.providerCategory")
    TransactionEntity toEntity(Transaction domain);

    default TransactionId mapToTransactionID(String trueLayerTransactionId) {
        return new TransactionId(trueLayerTransactionId);
    }

    default String mapToTransactionID(TransactionId transactionId) {
        return transactionId.id();
    }

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

    default Money mapToMoney(TransactionEntity entity) {
        return Money.builder()
                .amount(entity.getAmount())
                .currency(Currency.getInstance(entity.getCurrency()))
                .build();
    }

    default Money mapToMoney(TrueLayerTransaction trueLayerTransaction) {
        return Money.builder()
                .amount(new BigDecimal(trueLayerTransaction.amount()))
                .currency(Currency.getInstance(trueLayerTransaction.currency()))
                .build();
    }

    default String mapToCurrency(Currency currency) {
        return currency.getCurrencyCode();
    }

    default BigDecimal mapToAmount(String amount) {
        return new BigDecimal(amount);
    }
}
