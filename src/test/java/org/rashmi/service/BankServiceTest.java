package org.rashmi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rashmi.model.Customer;
import org.rashmi.utility.Helper;

public class BankServiceTest {
        private ArrayList<Customer> customers;
        private BankService bankService;

        @Test
        void testIsAccountExist() {
                assertTrue(bankService.isAccountExist("123456789", "Bhai"));
                assertTrue(bankService.isAccountExist("12345678", "banty"));
                assertFalse(bankService.isAccountExist("12345678", "Banty"));
                assertFalse(bankService.isAccountExist("12345678afda", "Banty"));
        }

        @BeforeEach
        private void addData() {
                customers = new ArrayList<>();

                customers.add(new Customer("123456789", "Maguni sahoo", "maguni69@gmail.com",
                                "985690424",
                                "Bhai", 10000));

                customers.add(new Customer("12345678", "Smruti Ranjan Nayak", "smruti67@gmail.com",
                                "905699424",
                                "banty", 1000));

                customers.add(
                                new Customer(Helper.getRandomNumber(11), "Prangya", "prangya@gmail.com", "9876543210",
                                                "lizu", 3000));

                bankService = new BankService(customers);
        }

        /**
         * This is the test where we simply call the parameterized constructer of
         * BankService by passing array list
         * and then the arraylist intialize the array list of BankService class,
         * Now i call the size method after the process of both the arraylist if the
         * value get added the our data raeches its
         * destinition.
         */

        @Test
        void testAddCustomer() {
                Customer customer = new Customer(Helper.getRandomNumber(11), "Gudu", "Biswa123@gmail.com", "12321313",
                                "Biswa123", 37000);
                int oldSize = customers.size();
                bankService.addCustomer(customer);
                assertEquals(oldSize + 1, bankService.getSizeOfInstanceArrayList());
        }

        @Test
        void testGetSizeOfInstanceArrayList() {
                assertEquals(customers.size(), bankService.getSizeOfInstanceArrayList());
        }

        @Test
        void testAddBalanceForValidUser() {
                String accountNumber = "12345678";
                int position = bankService.isAccountExist(accountNumber);

                double oldBalance = customers.get(position).getCurrentBalance();
                bankService.addBalance(accountNumber, 1000);
                assertEquals(oldBalance + 1000, customers.get(position).getCurrentBalance());

        }

        @Test
        void testAddBalanceForInValidUser() {
                String accountNumber = "123456780";
                assertThrows(RuntimeException.class, () -> bankService.addBalance(accountNumber, 100));

        }
}
