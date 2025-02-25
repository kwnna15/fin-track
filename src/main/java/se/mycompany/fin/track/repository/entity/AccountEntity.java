package se.mycompany.fin.track.repository.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import se.mycompany.fin.track.model.account.AccountType;

@Getter
@Setter
@Entity
@Table(name = "account")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String accountId;
    private AccountType accountType;
    private String displayName;
    private String currency;
    private String providerId;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant timestamp;
}
