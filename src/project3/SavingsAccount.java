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
	@Override
	public String toString() {
	
		String num = Integer.toString(this.getNumber());
		String own = this.getOwner();
		String bal = Double.toString(this.getBalance());
		String dO = formatDate(this.getDateOpened());
		String minB = Double.toString(this.getMinBalance());
		String intR = Double.toString(this.getInterestRate());
		
		return num + " " +own + " " + 
		bal + " " + dO + " " + 
		minB + " " + intR;
	}
	
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
