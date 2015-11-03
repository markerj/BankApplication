package project3;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class CheckingAccount extends Account{
	private static final long serialVersionUID = 1L;
	private double monthlyFee;



	public CheckingAccount(int number, String owner, double balance,
			GregorianCalendar dateOpened, double monthlyFee) {
		super(number, owner, balance, dateOpened);

		this.monthlyFee = monthlyFee;

	}
	public long getSerialVersionUID() {
		return 1L;
	}

	public double getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}
	@Override
	public String toString() {
		//overridden
		String num = Integer.toString(this.getNumber());
		String own = this.getOwner();
		String bal = Double.toString(this.getBalance());
		String dO = formatDate(this.getDateOpened());
		String mFee = Double.toString(this.monthlyFee);	

		return num + " "+  dO + " " + 
		own + " "+  bal + " " + mFee + " " + "0" + " " + "0";

		//+ "MonthlyFee(checking Exlusively):" + mFee;
	}
	public boolean equals(Object o){
		if (o instanceof CheckingAccount){
			CheckingAccount e = ((CheckingAccount) o);

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
