package org.rashmi.view;

import static org.rashmi.utility.Helper.*;

import java.util.Scanner;

import org.rashmi.model.Customer;
import org.rashmi.service.BankService;

public class ViewBlock {
    private final BankService bankService;
    private final Scanner scanner;

    public ViewBlock(BankService bankService) {
        this.bankService = bankService;
        scanner = new Scanner(System.in);
    }

    void addBalanceBlock(Customer customer) {
        logMessage("Enter the amount you want to add");
        double amount = Double.parseDouble(scanner.nextLine());
        bankService.addBalance(customer.getAccountNumber(), amount);

        logMessage(PREFIX + "Balance Added" + PREFIX);
    }

    void withdrawBlock(Customer customer) {
        logMessage("Enter the amount you want to withdraw");
        double amount = Double.parseDouble(scanner.nextLine());
        boolean isWithdraw = bankService.withdrawBalance(customer, amount);
        if (isWithdraw) {
            logMessage("Balance withdraw");
        } else {
            logMessage("INSUFFICIENT BALANCE");
        }
    }

    void transferBlock(Customer customer) {
        logMessage("Enter the account number to which you want to transfer");
        String accountNumber = scanner.nextLine();
        int position = bankService.isAccountExist(accountNumber);

        if (position != -1) {
            logMessage("Enter the amount you want to transfer");
            double transferAmount = Double.parseDouble(scanner.nextLine());
            bankService.withdrawBalance(customer, transferAmount);
            bankService.addBalance(accountNumber, transferAmount);
            logMessage(PREFIX + "Payment successfull" + PREFIX);
        } else {
            final String msg = "Sorry there is no account linked to this number so we are unable to make this transfer";
            logMessage(msg);
        }
    }
}
