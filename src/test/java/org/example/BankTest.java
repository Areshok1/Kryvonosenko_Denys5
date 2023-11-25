package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void createAccount() {
        Bank bank = new Bank();
        BankAccount account = bank.createAccount("John Doe", 1000);

        assertNotNull(account);
        assertEquals("John Doe", account.getAccountName());
        assertEquals(1000, account.getBalance());
    }

    @Test
    void findAccount() {
        Bank bank = new Bank();
        BankAccount account1 = bank.createAccount("John Doe", 1000);

        BankAccount foundAccount = bank.findAccount(account1.getAccountNumber());

        assertNotNull(foundAccount);
        assertEquals(account1, foundAccount);
    }

    @Test
    void transferMoney() {
        Bank bank = new Bank();
        BankAccount account1 = bank.createAccount("John Doe", 1000);
        BankAccount account2 = bank.createAccount("Jane Doe", 2000);

        bank.transferMoney(account2.getAccountNumber(), account1.getAccountNumber(), 500);

        assertEquals(2500, account1.getBalance());
        assertEquals(1500, account2.getBalance());
    }
}