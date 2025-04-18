package bank_managment_system;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Bank bank = new Bank();
		bank.reader();
		int exit =1;
		while(exit==1) {
			System.out.println("1-) Open an account");
			System.out.println("2-) Show all accounts");
			System.out.println("3-) Deposit");
			System.out.println("4-) Withdraw");
			System.out.println("5-) Search an account by User Name");
			System.out.println("6-) Search an account by Account Number");
			System.out.println("7-) find Users Has Amount Greater Than specific amount");
			System.out.println("9-) Save");
			System.out.println("10-) Exit");
			System.out.println("Please Enter Your Choice!?");
			
			Scanner choice = new Scanner(System.in);
			switch(choice.nextInt()) {
				case 1 :
					bank.openAccount();
					break;
				case 2 :
					bank.showList();
					break;
				case 3 :
					bank.deposit();
					break;
				case 4 :
					bank.withdraw();
					break;
				case 5 :
					bank.findByUserName();
					break;
				case 6 :
					bank.findByAccountNumber();
					break;
				case 7 :
					bank.findUsersHasAmountGreaterThan();
					break;
				case 9 :
					bank.writer();
					System.out.println("Update Is Done");
					break;
				case 10 :
					exit=0;
					System.out.println("Bye See You Soon!");
					break;
			}
		}
	}
}
