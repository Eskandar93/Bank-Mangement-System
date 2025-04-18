package bank_managment_system;

public class Account {
	
	private String userName;
	
	private Double balance;
	
	private int accountNumber;

	// Filelds Constructor
	
	public Account(String userName, Double balance, int accountNumber) {
		this.userName = userName;
		this.balance = balance;
		this.accountNumber = accountNumber;
	}
	
	// deposit method
	
	public void deposit(Double amount) {
		balance += amount;
	}
	
	//withsraw method
	
	public void withdraw(Double amount) {
		if(balance<amount) {
			System.out.println("Your Balance Not Enough");
			return ;
		}
		
		balance -= amount;
	}
	
	// print data of user
	
	public void printInfo() {
		System.out.print("User account number "+"-> "+ accountNumber);
		System.out.print(" User name "+"-> "+ userName);
		System.out.println(" Balance amount "+"-> "+ balance);
	}
//	public void setUser(String userName) {
//		this.userName = userName;
//	}
//	
//	public void setBalance(Double balance) {
//		this.balance = balance;
//	}
//	
//	public void setAccountNumber(int accountNumber) {
//		this.accountNumber = accountNumber;
//	}
	
	// getter method
	
	public String getUserName() {
		return userName;
	}
	
	public Double getBalance() {
		return balance;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
}
