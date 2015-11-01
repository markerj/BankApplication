package project3;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.AbstractListModel;

public class BankModel extends AbstractListModel{

	private static ArrayList<Account> acts;

	public BankModel() {
		acts = new ArrayList();

	}
	//add method in gui for find?

	public void updateAcc(int index, Account a) {
		acts.add(a);	
		fireContentsChanged(this, acts.size()-1, acts.size()-1);

	}

	public void addAcc(Account a) {
		acts.add(a);		
		System.out.println("added to arraylist");
		fireIntervalAdded(this, acts.size()-1, acts.size()-1);
	}
	
	public void deleteAll() {
		acts.clear();
	}
	public void deleteAcc(int index) {

		acts.remove(index);
		fireIntervalRemoved(this, acts.size()-1, acts.size()-1);
	}

	@Override
	public Object getElementAt(int index) {
		return acts.get(index);
	}

	@Override
	public int getSize() {
		return acts.size();
	}

}