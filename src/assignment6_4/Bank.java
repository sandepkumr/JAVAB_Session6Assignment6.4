package assignment6_4;
import java.util.Scanner;

/**
 * Class BankATM to Deposit and Withdram from ATM, and Throw exception if Withdraw amount greater than balance or if balance is less than 10000
 * 
 * @author Sandeep
 *
 */
class BankAtm {						// Class Bank ATM to withdraw and deposit into ATM 
	int atmId;						// Instance variable ATM ID
	String bankName;				// Instance variable Bank Name
	String location;				// Instance varialbe location of ATM
	double balance;					// Instance variable balance in ATM
	
	BankAtm(int atmId, String bankName, String location, double balance){ // Constructor of Bank ATM 
		this.atmId=atmId;			// Assigning atm ID to instance variable
		this.bankName=bankName;		// Assigning Bank name to instance variable
		this.location=location;		// Assigning location to instance variable
		this.balance=balance;		// Assigning balance to instance variable
		
		System.out.println("ATM with id: "+atmId+" belonging to "+bankName+" at "+location+" intialized with balance"+balance); // ATM details at object creation
	}
	
	/**
	 * Method to withdram Balance from ATM
	 * 
	 * If Balance in ATM is less than 10000 or if Amount is greater than balance, Method throws exception
	 * 
	 * @param amt
	 * @throws BankATMException
	 */
	void withdraw(double amt) throws BankATMException { // Withdram method to withdram from ATM
		if (balance<10000)								// If balance less than 10000
			throw new BankATMException("Balance in the ATM"+atmId+" is less than 10000, unable to withdraw"); // Throw BankATMException
		else if (balance<amt)							// If balance less than amount entered	
			throw new BankATMException("The amount to be withdraw is not available in ATM"+atmId+", Please enter lesser amount and try again"); // Throw BankATMException
		else
			balance=balance-amt;						// Else reduce the amount to calculaye new Balance
			System.out.println("Withdraw successful. Balance in atm"+atmId+" is "+balance); // Print successful message and new Balance
		
	}
	
	/**
	 * Method adds the amount and calculates new Balance
	 * 
	 * @param amt
	 */
	void deposit(double amt) { 							// Method deposit amount into ATM
		
		balance=balance+amt;							// Add amount to balance to calculate new balance
		System.out.println("Amount deposited successfully"); // Print message
	}
		
}

/**
 * Exception class to throw BankATMException
 * 
 * @author Sandeep
 *
 */
class BankATMException extends Exception { 				// Class extends parent Exception class
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	BankATMException(String message){					// Constructor with message	
		super(message);									// Parent constructor to throw the Exception message	
	}
	
}

/**
 * Class bank with 3 ATM objects to demonstrate withdrawal and Exception thrown when balance less than 10000
 * 
 * @author Sandeep
 *
 */
public class Bank { // Class bank
	
	public static void main(String[] args) { 							// main method starts
		
		BankAtm atm1= new BankAtm(1,"SBI", "Adyar, Chennai",30000);		// Create object 1 for bankatm
		BankAtm atm2= new BankAtm(2,"SBI", "T-Nagar, Chennai",30000);	// Create object 2 for bankatm
		BankAtm atm3= new BankAtm(3,"SBI", "Saidapet, Chennai",9000);	// Create object 3 for bankatm
		
		Scanner scanner = new Scanner(System.in);						// Creating Scanner object
		
		int exitBank=1;													// Local variable to keep in loop or exit to take imput
		while(exitBank==1) {											// Loop to continue withdraw process
			
			System.out.println("Enter the atm id you want to withdram from :"); // Print message to withdram from one of three ATM
			int atmId=scanner.nextInt();								// Assigning atm id to local variable
			
			if (atmId==1) {												// To with draw from ATM 1
				
				try {													// Try block
					System.out.println("Enter the amount you want to withdraw from atm1:"); // Print message to enter amount to withdra
					atm1.withdraw(scanner.nextDouble());				// Call withdraw method from atm1
				}
				catch (BankATMException be) { 							// catch to catch exception
					be.printStackTrace();								// Print error trace
				}
			}
			
			else if (atmId==2) {										// To with draw from ATM 2
				
				try {
					System.out.println("Enter the amount you want to withdraw from atm2 :"); // Print message to enter amount to withdraw
					atm2.withdraw(scanner.nextDouble());				// Call withdraw method from atm2
				}
				catch (BankATMException be) { 
					be.printStackTrace();								// Print error trace
				}
			}
			
			else if (atmId==3) {										// To with draw from ATM 3
				
				try {
					System.out.println("Enter the amount you want to withdraw from atm3:"); // Print message to enter amount to withdraw
					atm3.withdraw(scanner.nextDouble());				// Call withdraw method from atm3
				}
				catch (BankATMException be) { 
					be.printStackTrace();								// Print error trace
				}
			}
			else
				System.out.println("Please enter a valid ATM id");		// Print message if entered an invalid ATM id
			
			System.out.println("Enter 0 to exit or 1 to continue :");	// Print message to continue or exit out of Bank for withdrawal 
			exitBank=scanner.nextInt();									// Reassigning to exit or continue with loop
			
		}
		
		scanner.close();												// Close scanner object
	}

}// Class closed
