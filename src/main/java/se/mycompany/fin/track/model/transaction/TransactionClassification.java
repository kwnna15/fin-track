package se.mycompany.fin.track.model.transaction;

import java.util.Arrays;
import java.util.Optional;

public enum TransactionClassification {
    UNCATEGORIZED("Uncategorized"),
    ENTERTAINMENT("Entertainment"),
    EDUCATION("Education"),
    SHOPPING("Shopping"),
    PERSONAL_CARE("Personal Care"),
    HEALTH_AND_FITNESS("Health & Fitness"),
    FOOD_AND_DINING("Food & Dining"),
    GIFTS_AND_DONATIONS("Gifts & Donations"),
    INVESTMENTS("Investments"),
    BILLS_AND_UTILITIES("Bills & Utilities"),
    AUTO_AND_TRANSPORT("Auto & Transport"),
    TRAVEL("Travel"),
    FEES_AND_CHARGES("Fees & Charges"),
    BUSINESS_SERVICES("Business Services"),
    PERSONAL_SERVICES("Personal Services"),
    TAXES("Taxes"),
    GAMBLING("Gambling"),
    HOME("Home"),
    PENSIONS_AND_INSURANCES("Pension and Insurances");

    private final String value;

    TransactionClassification(String value) {
        this.value = value;
    }

    public static Optional<TransactionClassification> fromString(String value) {
        return Arrays.stream(values())
                .filter(e -> e.value.equalsIgnoreCase(value))
                .findFirst();
    }
}
