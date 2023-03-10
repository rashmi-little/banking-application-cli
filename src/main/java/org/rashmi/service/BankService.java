package org.rashmi.service;

import java.util.ArrayList;

import org.rashmi.model.Customer;

/**
 * @description
 * @author
 * @version
 */
public class BankService {
  private ArrayList<Customer> customers;

  /**
   * @postcondition
   * @precondition
   * @return
   * @param
   * @brief - This is a non parameterized constructer of the BankSerivce class
   *        which internally creating the object of ArrayList and assign it to the
   *        Arraylist reference customers
   */
  public BankService() {
    customers = new ArrayList<>();
  }

  /**
   * @postcondition
   * @precondition
   * @return
   * @param customers()
   * @breif
   *        This is a parameterized constructer of the BankSerivce class which
   *        takes a arrylist of customer
   *        and assign that array list to instance arraylist of BankService class.
   * 
   */
  public BankService(ArrayList<Customer> customers) {
    this.customers = customers;
  }

  /**
   * @postcondition
   * @precondition
   * @return
   * @breif This non static method of BankService class takes Customer class as
   *        argument and add it to the instance arraylist of BankService class.
   * @param customer
   * @ return void
   */
  public void addCustomer(Customer customer) { // TESTED
    customers.add(customer);
  }

  /**
   * @postcondition
   * @precondition
   * @param
   * This        is a method which returns the number of object currently present
   *             in the
   *             banking class.
   * 
   * @return int(size of arraylist in the bank service class)
   */
  public int getSizeOfInstanceArrayList() { // Tested
    return customers.size();
  }

  /**
   * @postcondition
   * @precondition
   * @return
   * @breif - This is a non static method of BankService class which is used to
   *        add balance to the customer account
   * @param String(accountnumber) , double(balance)
   */
  public void addBalance(String accountNumber, double balance) {
    int accountPosition = isAccountExist(accountNumber);
    if (accountPosition == -1)
      throw new RuntimeException("Account do not exists");
    Customer customer = customers.get(accountPosition);
    customer.setCurrentBalance(customer.getCurrentBalance() + balance);
  }

  public boolean withdrawBalance(Customer customer, double balance) {
    if (customer.getCurrentBalance() >= balance) {
      addBalance(customer.getAccountNumber(), -balance); // Negative add
      return true;
    }
    return false;
  }

  /**
   * @postcondition
   * @precondition
   *               This is a non static method of Bankservice class which cehcks
   *               for the account
   *               exist or not in the bank through account number.This is for
   *               only internal
   *               use.
   * 
   * @param accountNumber
   * @return -1 for false and index number of that object in array list
   */
  public int isAccountExist(String accountNumber) { // Modified this method to private from public
    int count = -1;

    for (Customer customer : customers) {
      count++;
      if (customer.getAccountNumber().equals(accountNumber)) {
        return count;
      }
    }
    return count;
  }

  /**
   * @postcondition
   * @precondition
   *               This is a public method so that Customer can check is the
   *               account with the
   *               email and password they are providing is exist or not.
   * 
   * @param accountNumber
   * @param password
   * @return boolean
   */
  public boolean isAccountExist(String accountNumber, String password) {
    int index = isAccountExist(accountNumber);
    return ((index != -1)
        && (customers.get(index).getPassword().equals(password)));
  }

  public Customer getCustomer(int position) {
    return customers.get(position);
  }

  public int CustomerCount() {
    return customers.size();
  }
}