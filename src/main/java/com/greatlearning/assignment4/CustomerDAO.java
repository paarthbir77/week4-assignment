package com.greatlearning.assignment4;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import com.greatlearning.assignment4.Customers;
public class CustomerDAO {
	public void deposit(Customers customers,int amount) {
		try {
			writeToFile("amount "+amount+" deposited successfully", customers.getFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void withdraw(Customers customers, int amount) {
		try {
			writeToFile("amount "+amount+" withdrawn successfully", customers.getFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void transfer(Customers customers) {
		
		int otp = (int)(Math.random()*(9999-1000+1)+1000);
		System.out.println("Enter the otp");
		System.out.println(otp);
		
		Scanner input = new Scanner(System.in);
		int otpin = input.nextInt();
		input.nextLine();
		if(otp==otpin) {
			System.out.println("otp verification successful !!!");
			System.out.println("enter the amount and BankAccount no to which you want to transfer");
    		int amount = input.nextInt();
        	input.nextLine();
        	int transferAccount = input.nextInt();
        	input.nextLine();
			if(customers.getCustomerList().containsKey(transferAccount)) {
				//System.out.println("amount "+amount+" transferred successfully to bankAccount "+transferAccount);
				try {
					writeToFile("amount "+amount+" transferred successfully to bankAccount "+transferAccount, customers.getFile());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				try {
					writeToFile("Failed transfer transaction", customers.getFile());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else {
			System.out.println("Incorrect otp");
		}
		
	}
	private void writeToFile(String str, File file) throws IOException {
		FileWriter fw = new FileWriter(file, true);
		System.out.println(str);
		fw.write(str+"\n");
		fw.close();
	}
}
