package se.mycompany.fin.track.model.money;

import java.math.BigDecimal;
import java.util.Currency;
import lombok.Builder;

@Builder
public record Money(BigDecimal amount, Currency currency) {}
