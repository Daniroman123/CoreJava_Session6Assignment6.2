package session6_2;

//user defined exception
public class BankAtmException extends Exception {
	// Adding default constructor

	public BankAtmException(String message) {

		System.out.println(message);
	}
}
