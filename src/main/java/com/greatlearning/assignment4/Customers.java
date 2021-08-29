package com.greatlearning.assignment4;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Customers {
	//private int bankAccountNo;
	//private String password;
	
	private HashMap<Integer, String> customers;
	private File file;
	Customers(){
		customers = new HashMap<Integer,String>();
		file = new File("transactions.txt");
	}
	
	public void addCustomer(int accountNo, String password) {
		customers.put(accountNo, password);
	}
	public void removeCustomer(int accountNo) {
		customers.remove(accountNo);
	}
	public void displayAllCustomers() {
		Iterator iterator = customers.entrySet().iterator();
		while(iterator.hasNext()) {
			//System.out.println(iterator.next());
			HashMap.Entry mapElement = (HashMap.Entry)iterator.next();
            //int accountNo = ((int)mapElement.getValue());
            System.out.println(mapElement.getKey());
		}
	}
	public boolean login(int accountNo, String password) {
		if(customers.containsKey(accountNo) && customers.get(accountNo).equals(password)) {
			System.out.println("Login successful for "+accountNo);
			return true;
		}
		return false;
	}
	public HashMap<Integer, String> getCustomerList(){
		return customers;
	}
	public File getFile() {
		return file;
	}
}
