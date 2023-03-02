package org.rashmi.view;

import static org.rashmi.utility.Helper.*;

import java.util.Scanner;

import org.rashmi.model.Customer;
import org.rashmi.service.BankService;

public class UserInterface {
    private final Scanner scanner;
    private final BankService bankService;
    private final ViewBlock viewBlock;

    public UserInterface() {
        scanner = new Scanner(System.in);
        bankService = new BankService();
        viewBlock = new ViewBlock(bankService);
    }

    public void showMenuPage() {
        logMessage("press 1 for signup");
        logMessage("press 2 for login");
        logMessage("Press 0 for exiting");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 0 -> exitPage();
            case 1 -> {
                bankService.addCustomer(signUpPage());
                showMenuPage();
            }
            case 2 -> {
                Customer customer = loginPage();
                if (customer != null) {
                    accountOperation(customer);
                } else {
                    showMenuPage();
                }
            }
            default -> {
                logMessage("Invalid choice Please make a valid choice");
                showMenuPage();
            }
        }
    }

    public Customer signUpPage() {
        logMessage("Enter account holders name");
        String name = scanner.nextLine();
        logMessage("Enter your email number");
        String email = scanner.nextLine();
        logMessage("Enter your phone number");
        String phoneNumber = scanner.nextLine();
        logMessage("Thanks for your cooperation we are generating account number for you ");
        String accountNumber = getRandomNumber(10);
        logMessage("Your account number is " + accountNumber);
        logMessage("Set a Strong password for your bank account");
        String password = scanner.nextLine();
        logMessage("Enter the amount you want to add as a opening balance");
        double balance = Double.parseDouble(scanner.nextLine());

        logMessage("-----ACCOUNT CREATED SUCCESSFULLY-----");
        return new Customer(accountNumber, name, email, phoneNumber, password, balance);

    }

    public void exitPage() {
        logMessage("Thank you for visiting us...");
        System.exit(0);
    }

    public Customer loginPage() {
        logMessage("Enter your Account number");
        String accountNumber = scanner.nextLine();
        logMessage("Enter your password");
        String password = scanner.nextLine();
        if (bankService.isAccountExist(accountNumber, password)) {
            return bankService.getCustomer(bankService.isAccountExist(accountNumber));
        } else {
            logMessage("Account doesn't exist ");
            return null;
        }
    }

    public void accountOperation(Customer customer) {
        int choice = 0;
        do {
            choice = accountOperationPage(customer.getName());
            switch (choice) {
                case 1 -> profilePrint(customer);
                case 2 -> logMessage("Current Balance: " + customer.getCurrentBalance());
                case 3 -> viewBlock.addBalanceBlock(customer);
                case 4 -> viewBlock.withdrawBlock(customer);
                case 5 -> viewBlock.transferBlock(customer);
                case 6 -> {
                    break;
                }
                default -> logMessage("invalid option");
            }
        } while (choice != 6);

        showMenuPage();
    }

    public int accountOperationPage(String customerName) {
        logMessage("Hi " + customerName);
        logMessage("Choice operation what you want to perform");
        logMessage("Press 1 >> for profile");
        logMessage("Press 2 >> for current balance");
        logMessage("Press 3 >> for deposite balance");
        logMessage("Press 4 >> for withdrawl");
        logMessage("Press 5 >> for transfer");
        logMessage("Press 6 >> for logout");

        return Integer.parseInt(scanner.nextLine());
    }

    public void profilePrint(Customer customer) {
        logMessage("Name of the account holder -> " + customer.getName());
        logMessage("Account number -> " + customer.getAccountNumber());
        logMessage("Email id -> " + customer.getEmail());
        logMessage("Phone number -> " + customer.getPhoneNumber());
    }
}