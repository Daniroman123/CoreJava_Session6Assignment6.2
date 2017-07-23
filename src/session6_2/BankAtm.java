package session6_2;

public abstract class BankAtm {

	// Making instance variable as private so that they can only be accessed via
	// getters and setter outside of the class

	private int atmId;
	public String bankName;
	public String location;
	private static double balance = 0;

	abstract double withdraw(double balance) throws BankAtmException;

	abstract double deposit(double balance);

	// getters and setters

	public static double getBalance() {
		return balance;
	}

	public static void setBalance(double balance) {
		BankAtm.balance = balance;
	}

}
