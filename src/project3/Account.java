/*****************************************************************
Holds default values and methods for manipulating and instantiating
checking and savings accounts 

@author John Marker
@version Fall 2015
 *****************************************************************/
package project3;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util. GregorianCalendar;

public abstract class Account implements Serializable {

	/** value of the serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** current value of the account number */
	private int number;
	
	/** current value of the account owner */
	private String owner;
	
	/** current value of the date the account is opened */
	private GregorianCalendar dateOpened;
	
	/** current value of the balance for the account */
	private double balance;
	

	 /*****************************************************************
    Constructor creates a default account with an account number, 
    account owner, account balance, and date the account was opened 
    @param account number associated with the account
    @param account owner associated with the account
    @param account balance associated with the account
    @param date the account was opened 
    *****************************************************************/
	public Account(int number, String owner, double balance,
			GregorianCalendar dateOpened) 
	{
		this.number = number;
		this.owner = owner;
		this.balance = balance;
		this.dateOpened = dateOpened;
	}
	
	
	/*****************************************************************
    Returns the serialVerisionUID associated with the account
    @return SerialVersionUID of the account
	 *****************************************************************/
	public long getSerialVersionUID() {
		return 1L;
	}
	
	
	/*****************************************************************
    Returns the account number associated with the account
    @return account number of the account
	 *****************************************************************/
	public int getNumber() {
		return number;
	}

	
	/*****************************************************************
    Sets the account number associated with the account
    @param account number of the account
	 *****************************************************************/
	public void setNumber(int number) {
		this.number = number;
	}
	
	
	/*****************************************************************
    Returns the account owner associated with the account
    @return account owner of the account
	 *****************************************************************/
	public String getOwner() {
		return owner;
	}

	
	/*****************************************************************
    Sets the account owner associated with the account
    @param account owner of the account
	 *****************************************************************/
	public void setOwner(String owner) {
		this.owner = owner;
	}

	
	/*****************************************************************
    Returns the date the account was opened
    @return dateOpened of the account
	 *****************************************************************/
	public GregorianCalendar getDateOpened() {
		return dateOpened;
	}

	
	/*****************************************************************
    Sets the date the account was opened
    @param dateOpened of the account
	 *****************************************************************/
	public void setDateOpened(GregorianCalendar dateOpened) {
		this.dateOpened = dateOpened;
	}

	
	/*****************************************************************
    Returns the account balance associated with the account
    @return account balance of the account
	 *****************************************************************/
	public double getBalance() {
		return balance;
	}
	
	
	/*****************************************************************
    Sets the account balance associated with the account
    @param account balance of the account
	 *****************************************************************/
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	/*****************************************************************
    An abstract to be overridden by checkingAccount and
    SavingsAccount classes to convert account variables into a string
	 *****************************************************************/
	public abstract String toString();

	
	/*****************************************************************
    An abstract to be overridden by checkingAccount and
    SavingsAccount classes to compare accounts to see if they are equal
	 *****************************************************************/
	public abstract boolean equals(Object o); 

	
	/*****************************************************************
    Returns a string version of the date opened value associated with
    the account
    @param calendar is converted into a string format
    @return dateFormatted a string version of the date opened
	 *****************************************************************/
	public static String formatDate(GregorianCalendar calendar){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		sdf.setCalendar(calendar);
		String dateFormatted = sdf.format(calendar.getTime());
		return dateFormatted;  
	}

}
