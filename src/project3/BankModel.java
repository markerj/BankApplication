package project3;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.AbstractListModel;
import javax.swing.table.DefaultTableModel;

public class BankModel extends AbstractListModel{

	private static ArrayList<Account> acts;

	public BankModel() {
		acts = new ArrayList();

	}

	public void updateAcc(int index, Account a) {
		acts.add(index, a);	
		System.out.println("added to arraylist");
		//fireContentsChanged(this, acts.size()-1, acts.size()-1);
		
	}
	public void saveToText() throws FileNotFoundException {
	    PrintWriter pw = new PrintWriter(new FileOutputStream("C:\\Users\\John\\BankApp\\accountsText"));
	    for (Account acc : acts)
	        pw.println(acc.toString());
	    pw.close();
	    
	}
	public void saveToBinary() throws IOException {
		//PrintWriter pw = new PrintWriter(new FileOutputStream("C:\\Users\\John\\BankApp\\accountsText"));
	    
            ObjectOutputStream outputStream =
            		new ObjectOutputStream(
                            new FileOutputStream ("C:\\Users\\John\\BankApp\\accountsBinary"));
            for (Account acc : acts) {
            outputStream.writeObject(acc);
            outputStream.close( );
       
	}
	}
	
	public void addAcc(Account a) {
		acts.add(a);		
		System.out.println("added to arraylist");
		//fireIntervalAdded(this, acts.size()-1, acts.size()-1);
	}
	public int getArraySize() {
		return acts.size();
	}
	
	public void deleteAll() {
		
		acts.clear();
		System.out.println("arraylist cleared");
	}
	public void deleteAcc(int index) {

		acts.remove(index);
		System.out.println("removed from arraylist");
		//fireIntervalRemoved(this, acts.size()-1, acts.size()-1);
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