package org.example.strategy.chain.ch;

import org.example.strategy.chain.Transaction;

public class InstallmentFeeRule implements FeeRule {
    @Override
    public Transaction apply(Transaction ctx) {
        if(ctx.installments() <= 1) {
            return ctx;
        }
        double extraFee = ctx.amount() * (0.01 * ctx.installments());
        return ctx.addFee(extraFee);
    }
}
