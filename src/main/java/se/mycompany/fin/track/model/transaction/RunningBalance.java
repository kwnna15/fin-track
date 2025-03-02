package se.mycompany.fin.track.model.transaction;

import lombok.Builder;

@Builder
public record RunningBalance(String amount, String currency) {}
