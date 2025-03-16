package se.mycompany.fin.track.repository.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import se.mycompany.fin.track.model.transaction.TransactionClassification;

@Builder
@Getter
@Setter
@Entity
@Table(name = "transaction")
public class ClassifiedTransactionEntity {
    @Id
    private UUID id;

    @Enumerated(EnumType.STRING)
    private TransactionClassification transactionClassification;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant timestamp;
}
