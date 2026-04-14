package org.example.strategy.chain;

import org.example.strategy.chain.ch.CreditFeeRule;
import org.example.strategy.chain.ch.FeeRuleChain;
import org.example.strategy.chain.ch.InstallmentFeeRule;
import org.example.strategy.chain.st.FeeCalculatorStrategy;
import org.example.strategy.chain.st.FeeStrategyFactory;

import java.util.List;

public class FeeCalculatorService {

    private final FeeRuleChain chain;

    FeeCalculatorService() {
       chain = new FeeRuleChain(
                List.of(new CreditFeeRule(), new InstallmentFeeRule())
       );
    }

    public void process(PaymentMethod type, double amount, int installments) {
        FeeCalculatorStrategy strategy = FeeStrategyFactory.getStrategy(type);
        double baseFee = strategy.calculateFee(amount);

        Transaction context = new Transaction(amount, type, installments, baseFee);

        Transaction result = chain.execute(context);

        System.out.println("Type: " + result.paymentMethod());
        System.out.println("Amount: " + result.amount());
        System.out.println("Installments: " + result.installments());
        System.out.println("Total Fee: " + result.fee());
    }


}
