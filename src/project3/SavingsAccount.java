package project3;

import java.util.GregorianCalendar;

public class SavingsAccount extends Account{

	private static final long serialVersionUID = 1L;
	private double minBalance;
	private double interestRate;

	public SavingsAccount(int number, String owner, double balance,
			GregorianCalendar dateOpened, double minBalance, 
			double interestRate) {
		super(number, owner, balance, dateOpened);
		this.minBalance = minBalance;
		this.interestRate = interestRate;

	}
	public long getSerialVersionUID() {
		return 1L;
	}
	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public String toString() {
		//overridden
		String num = Integer.toString(this.getNumber());
		String own = this.getOwner();
		String bal = Double.toString(this.getBalance());
		String dO = formatDate(this.getDateOpened());
		String minB = Double.toString(this.getMinBalance());
		String intR = Double.toString(this.getInterestRate());
		
		return "Number:" + num + " " + "Owner:" + own + " " + "Balance:" + 
		bal + " " + "Date:" + dO + " " + "Min Balance(Savings Exclusively):" + 
		minB + " " + "Interest Rate(Savings Exclusively):" + intR;
	}
	
	//equals method
	
	
	
}
