package com.greatlearning.assignment4;
import com.greatlearning.assignment4.Customers;

import java.util.Scanner;

import com.greatlearning.assignment4.CustomerDAO;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "welcome to the login page" );
        Customers customers = new Customers();
        CustomerDAO customerDAO = new CustomerDAO();
        customers.addCustomer(1, "abc");
        customers.addCustomer(2, "xyz");
        customers.addCustomer(3, "pqr");
        Scanner in = new Scanner(System.in);
        System.out.println( "enter the bank Account no" );
        int loginId = in.nextInt();
    	in.nextLine();
    	System.out.println( "enter the password for the corresponding bank account no" );
    	String loginPass = in.nextLine();
    	if(customers.login(loginId, loginPass)) {
    		System.out.println( "!!!!! Welcome to Indian Bank !!!!!" );
    		
    		while(true) {
    			System.out.println( "Enter the operation that you want to perform" );
        		System.out.println( "1. Deposit" );
        		System.out.println( "2. Withdrawal" );
        		System.out.println( "3. Transfer" );
        		System.out.println( "0. Logout" );
            	int choice = in.nextInt();
            	in.nextLine();
            	switch(choice) {
            	case 1: 
            		System.out.println( "enter the amount you want to deposit" );
            		int amount = in.nextInt();
                	in.nextLine();
                	customerDAO.deposit(customers, amount);
                	break;
            	case 2: 
            		System.out.println( "enter the amount you want to withdraw" );
            		amount = in.nextInt();
                	in.nextLine();
            		customerDAO.withdraw(customers, amount);
            		break;
            	case 3: 
            		
            		customerDAO.transfer(customers);
            		break;
            	case 0: System.out.println( "Logout successful" );
            		return;
            	}
            }
    	}
    	else {
    		System.out.println( "Invalid Credentials" );
    	}
    }
}
