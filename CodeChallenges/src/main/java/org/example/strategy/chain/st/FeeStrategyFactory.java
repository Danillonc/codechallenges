package org.example.strategy.chain.st;

import org.example.strategy.chain.PaymentMethod;

import java.util.Map;

public class FeeStrategyFactory {

    private static final Map<PaymentMethod, FeeCalculatorStrategy> strategies = Map.of(
            PaymentMethod.MASTERCARD_CREDIT, new MasterCreditFeeStrategy(),
            PaymentMethod.VISA_CREDIT, new VisaCreditFeeStrategy(),
            PaymentMethod.VISA_DEBIT, new VisaDebitFeeStrategy()
    );

    public static FeeCalculatorStrategy getStrategy(PaymentMethod paymentMethod) {
        return strategies.get(paymentMethod);
    }
}
