package org.example.strategy.chain.ch;

import org.example.strategy.chain.PaymentMethod;
import org.example.strategy.chain.Transaction;

import static org.example.strategy.chain.PaymentMethod.MASTERCARD_CREDIT;

public class CreditFeeRule implements FeeRule {

    @Override
    public Transaction apply(Transaction ctx) {
        if(!(ctx.paymentMethod().equals(MASTERCARD_CREDIT) || ctx.paymentMethod().equals(PaymentMethod.VISA_CREDIT))) {
            return ctx.withInstallments(1);
        }
        return ctx;
    }
}
