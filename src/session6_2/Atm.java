/*PROBLEM STATEMENT:
	Crate a class Bank ATM with the following properties and methods-
Properties:
atmId;
bankName;
location;
balance;

Methods:
withdraw(double amt)
deposit(double amt)

The withdraw method should check the available balance in the ATM before 
deducting the amount from the balance. If the balance is less than 10000 the
withddrawal should not be allowed and a user defined exception BankATMException
should be thrown. The withdrawal should also not be allowed if the amount to be withdrawn
is greaterthan the balance.

Create a user defined exception class BankATMException class that will be created whenever 
withdrawal is done for balance less than 10000.
Create an application Bank having 3 BankAtm objects. Every time withdraw
method is called on the BankAtm object the balance should be subtracted.*/

package session6_2;

import java.util.Scanner;

public class Atm extends BankAtm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Take input from user

		Scanner scanner = new Scanner(System.in);

		Atm atm1 = new Atm();

		// Try catch block to handle Exception
		try {
			while (true) {
				System.out.println("Enter 1 to deposit and 2 for withdrawl");
				int choice = scanner.nextInt();
				switch (choice) {

				case 1:
					System.out.println("Enter the amount to be deposit");
					double amount = scanner.nextDouble();
					double total_balance = atm1.deposit(amount);
					BankAtm.setBalance(total_balance);
					System.out.println("Now your available balance is " + BankAtm.getBalance());
					break;

				case 2:
					System.out.println("Enter amount to be withdrawn");
					double amount1 = scanner.nextDouble();

					double withdrawl_amt = atm1.withdraw(amount1);
					if (withdrawl_amt < 0) {
						throw new BankAtmException("Insufficient fund in your Account"); // throwing
																							// our
																							// created
																							// user
																							// defined
																							// exception
					} else if (withdrawl_amt < 10000) {
						throw new BankAtmException("Amount left is less than 10000");
					} else {
						System.out.println("Withdrawl is successfull amount left in your account is " + withdrawl_amt);
					}
					break;
				default:
					System.exit(0); // escape
				}
			}

		} catch (BankAtmException e) {
			System.out.println(e);
		}

	}

	// Override methods

	@Override
	double withdraw(double balance) throws BankAtmException {

		return BankAtm.getBalance() - balance;
	}

	@Override
	double deposit(double balance) {

		double available_balance = balance + BankAtm.getBalance();

		return available_balance;
	}

}