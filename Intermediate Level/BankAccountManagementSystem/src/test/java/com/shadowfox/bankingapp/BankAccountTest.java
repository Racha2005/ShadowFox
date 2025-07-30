package com.shadowfox.bankingapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
    BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("Rachana R", 5000);
    }

    @Test
    void testDeposit() {
        account.deposit(1500);
        assertEquals(6500, account.getBalance());
    }

    @Test
    void testWithdraw() {
        account.withdraw(1000);
        assertEquals(4000, account.getBalance());
    }

    @Test
    void testInvalidWithdraw() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(6000));
    }

    @Test
    void testTransactionSummary() {
        String summary = account.transactionSummary();
        assertTrue(summary.contains("Account Holder: Rachana R"));
        assertTrue(summary.contains("Balance: 5000"));
    }
}