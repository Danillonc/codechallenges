package org.example.strategy.chain;

public record Transaction(
        double amount,
        PaymentMethod paymentMethod,
        int installments,
        double fee)
{
    public Transaction withInstallments(int installments) {
        return new Transaction(amount, paymentMethod, installments, fee);
    }

    public Transaction addFee(double extraFee) {
        return new Transaction(amount, paymentMethod, installments, fee + extraFee);
    }
}
