package bank_managment_system;

import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class Bank {

	Account[] accounts = new Account[100];
	int count =0;
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
	
	public void openAccount() {
		System.out.println("Welcome!"+"\n"+"please Enter Your Name");
		Scanner user = new Scanner(System.in);
		Random rand = new Random();
		accounts[count++] = new Account(user.nextLine(), 0.0, rand.nextInt(100));
		System.out.println("You Successfully sign in");
		System.out.println("Your account number is "+ accounts[--count].getAccountNumber());
		count++;
	}
	
	public void showList() {
		for(int i=0; i<count; i++) {
			accounts[i].printInfo();
		}
	}
	
}
