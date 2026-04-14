package org.example.strategy.chain.st;

public class MasterCreditFeeStrategy implements FeeCalculatorStrategy {

    @Override
    public double calculateFee(double amount) {
        return amount * 0.25;
    }
}
