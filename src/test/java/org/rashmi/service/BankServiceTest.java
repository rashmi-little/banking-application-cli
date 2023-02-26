package org.rashmi.service;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rashmi.model.Customer;
import org.rashmi.utility.Helper;

public class BankServiceTest {
    ArrayList<Customer> customers;

    @Test
    void testIsAccountExist() {
        
    }

    @BeforeEach
    private void addData() {
        customers = new ArrayList<>();

        customers.add(new Customer(Helper.getRandomNumber(11), "Maguni sahoo", "maguni69@gmail.com", "985690424",
                "Bhai", 10000));

        customers.add(new Customer(Helper.getRandomNumber(11), "Smruti Ranjan Nayak", "smruti67@gmail.com", "905699424",
                "banty", 1000));

        customers.add(
                new Customer(Helper.getRandomNumber(11), "Prangya", "prangya@gmail.com", "9876543210", "lizu", 3000));
    }
}
