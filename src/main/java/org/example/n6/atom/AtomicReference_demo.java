package org.example.n6.atom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AtomicReference_demo {
}


class DecimalAccountUnsafe implements DecimalAccount {
    BigDecimal balance;
    public DecimalAccountUnsafe(BigDecimal balance) {
        this.balance = balance;
    }
    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    // 取款任务
    @Override
    public void withdraw(BigDecimal amount) {
        BigDecimal balance = this.getBalance();
        this.balance = balance.subtract(amount);
    }
}


interface DecimalAccount {

    // 获取金额的方法
    BigDecimal getBalance();

    // 取款的方法
    void withdraw(BigDecimal amount);
}

