package org.example.strategy.chain.ch;

import org.example.strategy.chain.Transaction;

public interface FeeRule {
    Transaction apply(Transaction transaction);
}
