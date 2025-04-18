package bank_managment_system;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Bank bank = new Bank();
		int exit =1;
		bank.reader();
		while(exit==1) {
			System.out.println("1-) Open an account");
			System.out.println("2-) Show all accounts");
			System.out.println("Please Enter Your Choice!?");
			
			Scanner choice = new Scanner(System.in);
			switch(choice.nextInt()) {
				case 1 :
					bank.openAccount();
					break;
				case 2 :
					bank.showList();
					break;
				case 9 :
					exit=0;
					System.out.println("Bye See You Soon!");
					break;
			}
		}
	}
}
