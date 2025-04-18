package bank_managment_system;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Bank {

	// Array of accounts
	Account[] accounts = new Account[100];
	
	// count Accounts
	int count =0;
	
	// Is account exist or not
	boolean accountExist = false;
	
	// get user account by user name of account
	public Account findAccountByName(String name) {
		for(int i=0; i<count; i++) {
			if(accounts[i].getUserName().equals(name)) {
				accountExist = true;
				return accounts[i];
			}
		}
		return null;
	}
	
	// get user account by number of account
	public Account findAccountByAccountNumber(int num) {
		for(int i=0; i<count; i++) {
			if(accounts[i].getAccountNumber() == num) {
				accountExist = true;
				return accounts[i];
			}
		}
		return null;
	}
	
	// read data of Users from txt file
	public void reader() {
		try {
			for(int i=0; i<100; i++) {
				accounts[i] = new Account("User", 0.0, 0);
			}
			
			FileReader reader = new FileReader("C:\\Users\\DELL\\Downloads\\Bank Managment System\\src\\bank_managment_system\\accounts.txt");
			Scanner input = new Scanner(reader);
			
			int k=0;
			while(input.hasNextLine()) {
				String user = input.nextLine();
				String balance = input.nextLine();
				String accountNumber = input.nextLine();
				Account account = new Account(user, Double.parseDouble(balance), 
						Integer.parseInt(accountNumber));
				accounts[k++] = account;
				count++;
			}
			
			input.close();
			reader.close();
		}
		catch(Exception e) {
			System.out.println("File Not Found!?");
		}
	}
	
	// write data of Users in txt file
	public void writer() {
		try {
			PrintWriter output = new PrintWriter("C:\\Users\\DELL\\Downloads\\Bank Managment System\\src\\bank_managment_system\\accounts.txt");
			for(int i=0; i<count; i++) {
				output.println(accounts[i].getUserName());
				output.println(accounts[i].getBalance());
				output.println(accounts[i].getAccountNumber());
			}
			output.close();
		}catch(Exception ex) {
			System.out.println("file not found!?");
		}
	}
	
	// Create Account
	public void openAccount() {
		int mn=1, mx=100;
		System.out.println("Welcome!"+"\n"+"please Enter Your Name");
		Scanner user = new Scanner(System.in);
		Random rand = new Random();
		accounts[count++] = new Account(user.nextLine(), 0.0, rand.nextInt(mx-mn+1)+mn);
		System.out.println("You Successfully sign in");
		System.out.println("Your account number is "+ accounts[--count].getAccountNumber());
		count++;
	}
	
	// deposit Amount
    public void deposit() {
    	System.out.println("Enter your Account Number for depositig!");
    	Scanner AccNumber = new Scanner(System.in);
    	int numOfAccount = AccNumber.nextInt();
    	
    	Account account = findAccountByAccountNumber(numOfAccount);
    	if(accountExist == true) {
    		System.out.println("Enter The amount of deposit of your account");
			Scanner depositAmount = new Scanner(System.in);
			account.deposit(depositAmount.nextDouble());
			System.out.println("You successfully Deposit!");
    	}
    	else {
    		System.out.println("Your Account Not Sign In!");
    	}
    	accountExist = false;
    }
	
    // withdarw Amount
    public void withdraw() {
    	System.out.println("Enter Your Account Number for Withdraw!");
    	Scanner AccNumber = new Scanner(System.in);
    	int numOfAccount = AccNumber.nextInt();
    	Account account = findAccountByAccountNumber(numOfAccount);
    	if(accountExist == true) {
			System.out.println("Enter The amount of withDraw from your account");
			Scanner withdrawAmount = new Scanner(System.in);
			account.withdraw(withdrawAmount.nextDouble());
			System.out.println("You successfully Withdraw!");
    	}
    	else {
    		System.out.println("Your Account Not Sign In!");
    	}
    	accountExist = false;
    }
    
    // get user By Name
    public void findByUserName() {
    	System.out.println("Enter Your Name For Searching!");
    	Scanner name = new Scanner(System.in);
    	String userName = name.nextLine();
    	
    	Account account = findAccountByName(userName);
    	if(accountExist == true) {
    		account.printInfo();
    	}
    	else {
    		System.out.println("Your Account Not Found!");
    	}
    	accountExist = false;
    }
    
    // get user By Account Number
    public void findByAccountNumber() {
    	System.out.println("Enter Your Account Number For Searching!");
    	Scanner AccNumber = new Scanner(System.in);
    	int numOfAccount = AccNumber.nextInt();
    	
    	Account account = findAccountByAccountNumber(numOfAccount);
    	if(accountExist == true) {
    		account.printInfo();
    	}
    	else {
    		System.out.println("Your Account Not Found!");
    	}
    	accountExist = false;
    }
    
    //find Users That Has Amount Greater Than specific amount
    public void findUsersHasAmountGreaterThan() {
    	System.out.println("Enter the amount for find users Has Amount GreaterThan it");
    	Scanner input = new Scanner(System.in);
    	Double amount = input.nextDouble();
    	for(int i=0; i<count; i++) {
    		if(amount < accounts[i].getBalance()) {
    			accounts[i].printInfo();
    			accountExist = true;
    		}
    	}
    	if(accountExist == false) {
    		System.out.printf("No Users has amount greater than %d", amount);
    	}
    	accountExist = false;
    }
    
    // print all userse
	public void showList() {
		for(int i=0; i<count; i++) {
			accounts[i].printInfo();
		}
	}
	
}
