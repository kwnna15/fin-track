package se.mycompany.fin.track.repository.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@Entity
@Table(name = "transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String transactionId;
    private String description;
    private BigDecimal amount;
    private String currency;
    private String transactionType;
    private String transactionCategory;
    private Set<String> transactionClassification;
    private String merchantName;
    private String runningBalanceAmount;
    private String runningBalanceCurrency;
    private String metaBankTransactionId;
    private String metaProviderCategory;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant timestamp;
}
