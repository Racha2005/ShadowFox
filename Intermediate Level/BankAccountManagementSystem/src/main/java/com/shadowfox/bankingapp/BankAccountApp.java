package com.shadowfox.bankingapp;

import java.util.Scanner;

public class BankAccountApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount("Rachana R", 5000);

        while (true) {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance");
            System.out.println("4. Summary");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    int dep = sc.nextInt();
                    account.deposit(dep);
                    System.out.println("✅ Amount deposited: " + dep);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    int wd = sc.nextInt();
                    try {
                        account.withdraw(wd);
                        System.out.println("✅ Amount withdrawn: " + wd);
                    } catch (IllegalArgumentException e) {
                        System.out.println("❌ " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Balance: " + account.getBalance());
                    break;

                case 4:
                    System.out.println(account.transactionSummary());
                    break;

                case 5:
                    System.out.println("✅ Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice.");
            }
        }
    }
}