/*****************************************************************
Holds methods to manipulate an array list of accounts 

@author John Marker
@version Fall 2015
 *****************************************************************/
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
import javax.lang.model.element.Element;
import javax.swing.AbstractListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class BankModel extends AbstractListModel{

	//used DefaultTableModel and DefaultListModel in GUI 
	//for fire intervals instead of AbstractListModel
	//load methods in BankGUI

	/** values of a list of accounts */
	private static ArrayList<Account> acts;

	/*****************************************************************
    Constructor instantiates a list of accounts
	 *****************************************************************/
	public BankModel() {

		acts = new ArrayList();
	}


	/*****************************************************************
    Updates the list of accounts by adding an account at an index
    @param index of the list to be updated
    @param a account to put into the list
	 *****************************************************************/
	public void updateAcc(int index, Account a) {

		acts.add(index, a);	
		System.out.println("added to arraylist");
		//fireContentsChanged(this, acts.size()-1, acts.size()-1);
	}


	/*****************************************************************
    Saves the list of accounts to a text file
	 *****************************************************************/
	public void saveToXML() {

//		for(Account acc : acts){
//
//			Element account = new Element("Account");
//			account.addContent(new Element("acc Num")
//					.setText(acc.getNumber()));
//			account.addContent(new Element("acc Owner")
//					.setText(acc.getNumber()));
//			account.addContent(new Element("Date Opened")
//					.setText(acc.getDateOpened()));
//			account.addContent(new Element("Current Balance")
//					.setText(acc.getBalance()));
//			doc.getRootElement().addContent(account);
		
	}
	
	
	/*****************************************************************
    Saves the list of accounts to a text file
	 *****************************************************************/
	public void saveToText() throws FileNotFoundException {

		PrintWriter pw = new PrintWriter(new FileOutputStream
				("C:\\Users\\John\\BankApp\\accountsText"));

		//add each account in the list to the text file
		for (Account acc : acts)

			//use toString method to move accounts to text file
			pw.println(acc.toString());
		pw.close();
	}


	/*****************************************************************
    Saves the list of accounts to a binary file
	 *****************************************************************/
	public void saveToBinary() throws IOException {

		ObjectOutputStream outputStream =
				new ObjectOutputStream(
						new FileOutputStream 
						("C:\\Users\\John\\BankApp\\accountsBinary"));
		for (Account acc : acts) {
			outputStream.writeObject(acc);
			outputStream.close( );
		}
	}


	/*****************************************************************
    Adds an account to the list of accounts
    @param a account to put into the list
	 *****************************************************************/
	public void addAcc(Account a) {

		acts.add(a);		
		System.out.println("added to arraylist");
		//fireIntervalAdded(this, acts.size()-1, acts.size()-1);
	}


	/*****************************************************************
    Returns the number of accounts in the list
    @return the size of the list
	 *****************************************************************/
	public int getArraySize() {

		return acts.size();
	}


	/*****************************************************************
    Remove all accounts from the list
	 *****************************************************************/
	public void deleteAll() {

		acts.clear();
		System.out.println("arraylist cleared");
	}


	/*****************************************************************
    Remove an account from the list at a specified index
    @param index at which the account should be removed from the list
	 *****************************************************************/
	public void deleteAcc(int index) {

		acts.remove(index);
		System.out.println("removed from arraylist");
		//fireIntervalRemoved(this, acts.size()-1, acts.size()-1);
	}


	/*****************************************************************
    Returns the account at the specified index of the list
    @param index of the list
    @return account at the index
	 *****************************************************************/
	@Override
	public Object getElementAt(int index) {

		return acts.get(index);
	}


	/*****************************************************************
    Returns the number of accounts in the list
    @return the size of the list
	 *****************************************************************/
	@Override
	public int getSize() {

		return acts.size();
	}
}