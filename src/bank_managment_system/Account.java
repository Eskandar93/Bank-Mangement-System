package bank_managment_system;

public class Account {
	private String userName;
	
	private Double balance;
	
	private int accountNumber;

	public Account(String user, Double balance, int accountNumber) {
		this.userName = user;
		this.balance = balance;
		this.accountNumber = accountNumber;
	}
	
	public void deposit(Double amount) {
		balance += amount;
	}
	
	public void withdraw(Double amount) {
		if(balance<amount) {
			System.out.println("Your Balance Not Enough");
			return ;
		}
		
		balance -= amount;
	}
	
	public void printInfo() {
		System.out.print("User account number "+"-> "+ accountNumber);
		System.out.print(" User name "+"-> "+ userName);
		System.out.println(" Balance amount "+"-> "+ balance);
	}
//	public void setUser(String user) {
//		this.userName = user;
//	}
//	
//	public void setBalance(Double balance) {
//		this.balance = balance;
//	}
//	
//	public void setAccountNumber(int accountNumber) {
//		this.accountNumber = accountNumber;
//	}
	
	public String getUser() {
		return userName;
	}
	
	public Double getBalance() {
		return balance;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
}
