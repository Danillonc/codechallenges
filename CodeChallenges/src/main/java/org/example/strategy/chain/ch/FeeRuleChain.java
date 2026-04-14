package org.example.strategy.chain.ch;

import org.example.strategy.chain.Transaction;

import java.util.List;

public class FeeRuleChain {

    private final List<FeeRule> rules;

    public FeeRuleChain(List<FeeRule> rules) {
        this.rules = rules;
    }

    public Transaction execute(Transaction context) {
        Transaction current = context;

        for(FeeRule rule : rules) {
            current = rule.apply(current);
        }

        return current;
    }
}
