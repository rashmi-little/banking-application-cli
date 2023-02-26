package org.rashmi;

import org.rashmi.model.Customer;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
        Customer customer = Customer.builder()
                .accountNumber("12345678")
                .name("little")
                .email("fhaklfnak@1312")
                .phoneNumber("993894292")
                .password("i love pubg")
                .currentBalance(1000000).build();

        System.out.println(customer);
    }
}
