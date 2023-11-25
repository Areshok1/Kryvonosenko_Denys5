package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getAccountNumber() {
        BankAccount account = new BankAccount(1, "John Doe", 1000);
        assertEquals(1, account.getAccountNumber());
    }

    @Test
    void getAccountName() {
        BankAccount account = new BankAccount(1, "John Doe", 1000);
        assertEquals("John Doe", account.getAccountName());
    }

    @Test
    void getBalance() {
        BankAccount account = new BankAccount(1, "John Doe", 1000);
        assertEquals(1000, account.getBalance());
    }

    @Test
    void deposit() {
        BankAccount account = new BankAccount(1, "John Doe", 1000);
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    void withdraw() {
        BankAccount account = new BankAccount(1, "John Doe", 1000);
        account.withdraw(500);
        assertEquals(500, account.getBalance());
    }

    @Test
    void withdrawInsufficientFunds() {
        BankAccount account = new BankAccount(1, "John Doe", 1000);

        assertThrows(InsufficientFundsException.class, () -> account.withdraw(1500));
    }

    @Test
    void depositNegativeAmount() {
        BankAccount account = new BankAccount(1, "John Doe", 1000);

        assertThrows(NegativeAmountException.class, () -> account.deposit(-500));
    }

    @Test
    void withdrawNegativeAmount() {
        BankAccount account = new BankAccount(1, "John Doe", 1000);

        assertThrows(NegativeAmountException.class, () -> account.withdraw(-500));
    }

    @Test
    void getAccountSummary() {
        BankAccount account = new BankAccount(1, "John Doe", 1000);
        String expectedSummary = "Account Number: 1\nAccount Name: John Doe\nBalance: $1000.0";
        assertEquals(expectedSummary, account.getAccountSummary());
    }
}
