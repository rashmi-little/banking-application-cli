package org.rashmi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        }

        @BeforeEach
        private void addData() {
                customers = new ArrayList<>();
                bankService = new BankService();

                customers.add(new Customer(Helper.getRandomNumber(11), "Maguni sahoo", "maguni69@gmail.com",
                                "985690424",
                                "Bhai", 10000));

                customers.add(new Customer(Helper.getRandomNumber(11), "Smruti Ranjan Nayak", "smruti67@gmail.com",
                                "905699424",
                                "banty", 1000));

                customers.add(
                                new Customer(Helper.getRandomNumber(11), "Prangya", "prangya@gmail.com", "9876543210",
                                                "lizu", 3000));
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
                BankService ref = new BankService(customers);
                assertEquals(customers.size(), ref.getSizeOfInstanceArrayList());
                assertEquals(customers.get(0), ref.getArraylist(0));
                assertEquals(customers.get(1), ref.getArraylist(1));
                assertEquals(customers.get(2), ref.getArraylist(2));
        }

        @Test
        void testGetSizeOfInstanceArrayList() {
                BankService ref = new BankService(customers);
                assertEquals(customers.size(), ref.getSizeOfInstanceArrayList());
        }
}
