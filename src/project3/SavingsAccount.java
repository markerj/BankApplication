/*****************************************************************
Holds values and methods for manipulating and instantiating
a savings account 

@author John Marker
@version Fall 2015
 *****************************************************************/
package project3;
import java.util.GregorianCalendar;

public class SavingsAccount extends Account{
    
	/** value of the serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** current value of minBalance */
	private double minBalance;
	
	/** current value of interestRate */
	private double interestRate;

	
	/*****************************************************************
    Constructor creates a savings account with an account number, 
    account owner, account balance, date the account was opened, 
    minimum balance, and interest rate
    @param account number associated with the account
    @param account owner associated with the account
    @param account balance associated with the account
    @param date the account was opened 
    @param minimum balance associated with the savings account
    @param interest rate associated with the savings account
	 *****************************************************************/
	public SavingsAccount(int number, String owner, double balance,
			GregorianCalendar dateOpened, double minBalance, 
			double interestRate) {
		
		//ask parent to initialize these variables
		super(number, owner, balance, dateOpened);
		this.minBalance = minBalance;
		this.interestRate = interestRate;

	}
	
	/*****************************************************************
    Returns the serialVerisionUID associated with the savings account
    @return SerialVersionUID of the savings account
	 *****************************************************************/
	public long getSerialVersionUID() {
		
		return 1L;
	}
	
	
	/*****************************************************************
    Returns the minimum balance associated with the savings account
    @return minimum balance of the savings account
	 *****************************************************************/
	public double getMinBalance() {
		
		return minBalance;
	}

	
	/*****************************************************************
    Sets the minimum balance associated with the savings account
    @param minimum balance of the savings account
	 *****************************************************************/
	public void setMinBalance(double minBalance) {
		
		this.minBalance = minBalance;
	}

	
	/*****************************************************************
    Returns the interest rate associated with the savings account
    @return interest rate of the savings account
	 *****************************************************************/
	public double getInterestRate() {
		
		return interestRate;
	}

	
	/*****************************************************************
    Sets the interest rate associated with the savings account
    @param interest rate of the savings account
	 *****************************************************************/
	public void setInterestRate(double interestRate) {
		
		this.interestRate = interestRate;
	}
	
	
	/*****************************************************************
    Converts all values into string values and concatenates those values
	 *****************************************************************/
	@Override
	public String toString() {
	
		//convert all values to strings
		String num = Integer.toString(this.getNumber());
		String own = this.getOwner();
		String bal = Double.toString(this.getBalance());
		String dO = formatDate(this.getDateOpened());
		String minB = Double.toString(this.getMinBalance());
		String intR = Double.toString(this.getInterestRate());
		
		//concatenate into one string
		return num + " " + dO + " " + 
		own + " " + bal + " " + "0" + " " +
		minB + " " + intR;
	}
	
	
	/*****************************************************************
    Compares two accounts and returns a boolean value based on
    whether or not they are equivalent
    @param Object to be compared 
    @return true or false if one object equals another or doesn't
	 *****************************************************************/
	public boolean equals(Object o){
		if (o instanceof SavingsAccount){
			SavingsAccount given = (SavingsAccount) o;
			if (this.getBalance() == given.getBalance() &&
					this.getDateOpened() == given.getDateOpened() &&
					this.getInterestRate() == given.getInterestRate() &&
					this.getMinBalance() == given.getMinBalance() &&
					this.getNumber() == given.getNumber() &&
					this.getOwner() == given.getOwner() &&
					this.getSerialVersionUID() == given.getSerialVersionUID())
				return true;
			return false;
		}
		return false;
	}		
}