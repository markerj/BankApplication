package project3;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util. GregorianCalendar;

public abstract class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	private int number;
	private String owner;
	private GregorianCalendar dateOpened;
	private double balance;

	public Account(int number, String owner, double balance,
			GregorianCalendar dateOpened) 
	{
		this.number = number;
		this.owner = owner;
		this.balance = balance;
		this.dateOpened = dateOpened;
	}
	public long getSerialVersionUID() {
		return 1L;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public GregorianCalendar getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(GregorianCalendar dateOpened) {
		this.dateOpened = dateOpened;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String ToStrig() {
		
		return number + owner + dateOpened + balance;
	}
	
	public static String formatDate(GregorianCalendar calendar){
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
	    sdf.setCalendar(calendar);
	    String dateFormatted = sdf.format(calendar.getTime());
	    return dateFormatted;  
	}

}
