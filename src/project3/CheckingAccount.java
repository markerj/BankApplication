/*****************************************************************
Holds values and methods for manipulating and instantiating
a checking account 

@author John Marker
@version Fall 2015
 *****************************************************************/
package project3;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class CheckingAccount extends Account{
	
	/** value of the serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** current value of the monthly fee */
	private double monthlyFee;


	/*****************************************************************
    Constructor creates a checking account with an account number, 
    account owner, account balance, date the account was opened, 
    and monthly fee 
    @param account number associated with the account
    @param account owner associated with the account
    @param account balance associated with the account
    @param date the account was opened 
    @param monthly fee associated with the checking account
	 *****************************************************************/
	public CheckingAccount(int number, String owner, double balance,
			GregorianCalendar dateOpened, double monthlyFee) {
		
		//ask parent to initialize these variables
		super(number, owner, balance, dateOpened);
		this.monthlyFee = monthlyFee;
	}
	
	
	/*****************************************************************
    Returns the serialVerisionUID associated with the checking account
    @return SerialVersionUID of the checking account
	 *****************************************************************/
	public long getSerialVersionUID() {
		
		return 1L;
	}

	
	/*****************************************************************
    Returns the monthly fee associated with the checking account
    @return monthly fee of the checking account
	 *****************************************************************/
	public double getMonthlyFee() {
		
		return monthlyFee;
	}

	
	/*****************************************************************
    Sets the monthly fee associated with the checking account
    @param monthly fee of the checking account
	 *****************************************************************/
	public void setMonthlyFee(double monthlyFee) {
		
		this.monthlyFee = monthlyFee;
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
		String mFee = Double.toString(this.monthlyFee);	
		
		//concatenate into one string
		return num + " "+  dO + " " + 
		own + " "+  bal + " " + mFee + " " + "0" + " " + "0";
	}
	
	
	/*****************************************************************
    Compares two accounts and returns a boolean value based on
    whether or not they are equivalent
    @param Object to be compared 
    @return true or false if one object equals another or doesn't
	 *****************************************************************/
	public boolean equals(Object o){
		
		//check which instance of account
		if (o instanceof CheckingAccount){
			CheckingAccount e = ((CheckingAccount) o);
			
			//check if accounts are equivalent
			if (this.getBalance() == e.getBalance() &&
					this.getDateOpened() == e.getDateOpened() &&
					this.getMonthlyFee() == e.getMonthlyFee() &&
					this.getNumber() == e.getNumber() &&
					this.getOwner() == e.getOwner() &&
					this.getSerialVersionUID() == e.getSerialVersionUID()) 
				return true;
			return false;
		}
		return false;
	}
}
