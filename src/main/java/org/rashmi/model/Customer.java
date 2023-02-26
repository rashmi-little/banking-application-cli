package org.rashmi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // This annotation consist of setter getters hashcode()  equlas() toString() 
@AllArgsConstructor // A constructor having all the nonstatic field as parameter and intialize the instance variable
@Builder //To access setter method directly like for setAccountNumber() we can access by only accountNumber().It supports builder design pattern.
@NoArgsConstructor // To create Zero parameterized constructor.
public class Customer {
    private String accountNumber;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private double currentBalance;
}