package se.mycompany.fin.track.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "account")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String accountId;
    private String accountType;
    private String displayName;
    private String currency;
    private String providerId;
    private Instant timestamp;
}
