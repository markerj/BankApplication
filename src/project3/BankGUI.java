package project3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
//gitHub update
//hitHub update2
public class BankGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JButton btnAdd;
	private CheckingAccount checkingEx;	
	private BankModel b;
	private int selections[];
	private int index;
	private JRadioButton rdbtnChecking;
	private JRadioButton rdbtnSavings;
	private JList accountsList;
	private DefaultListModel listModel;
	private DefaultTableModel tableModel;
	private JTable accountsTable;

	public static void main(String[] args) {

		BankGUI frame = new BankGUI();
		frame.setVisible(true);

	}

	public BankGUI() {

		b = new BankModel();

		//listModel = new DefaultListModel();
		//JList accountsList = new JList(listModel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 650);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Load From Binary");
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save As Binary");
		mnNewMenu.add(mntmNewMenuItem_1);

		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Load From text");
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Save As Text");
		mnNewMenu.add(mntmNewMenuItem_3);

		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Load From XML");
		mnNewMenu.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Save As XML");
		mnNewMenu.add(mntmNewMenuItem_5);

		JSeparator separator_2 = new JSeparator();
		mnNewMenu.add(separator_2);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Quit");
		mnNewMenu.add(mntmNewMenuItem_6);

		JMenu mnNewMenu_1 = new JMenu("Sort");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("By Account Number");
		mnNewMenu_1.add(mntmNewMenuItem_7);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("By Account Owner");
		mnNewMenu_1.add(mntmNewMenuItem_8);

		JMenuItem mntmNewMenuItem_9 = new JMenuItem("By Date Opened");
		mnNewMenu_1.add(mntmNewMenuItem_9);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				if (rdbtnChecking.isSelected() && rdbtnSavings.isSelected()) {
					JOptionPane.showMessageDialog(null, "You must pick either checkings or savings");
				}
				/**************************date********************/
				int days = 0, month = 0, year = 0;
				String dateS = textField_2.getText();
				try {
					String[] splitDate = dateS.split("-");
					days = Integer.parseInt(splitDate[0]);
					month = (Integer.parseInt(splitDate[1])-1);
					year = Integer.parseInt(splitDate[2]);
					if (days >31 || days < 1 || month >12 || month <0 || year <0)
						JOptionPane.showMessageDialog(null, "Invalid Date");
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Date format is dd-mm-yyyy");
				}
				GregorianCalendar gDate = new GregorianCalendar(year, month, days);
				String formattedDate = Account.formatDate(gDate);
				/**************************accountNum********************/

				String accNumS = textField.getText();
				int accNum = 0;			
				
				if (accNumS.equals("")) {
					accNum = 0;
				}
				else {
					try {
					accNum = Integer.parseInt(accNumS);
					}
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Invalid account number");
						
					}
				}

				/**************************AccountOwner********************/
				String accOwner = textField_1.getText();

				/**************************CurrentBalance********************/
				String cBalS = textField_3.getText();
				double cBal=0;
				if (cBalS.equals("")) {
					cBal = 0;
				}
				else {
					try {
						cBal = Double.parseDouble(cBalS);
						}
						catch(Exception e) {
							JOptionPane.showMessageDialog(null, "Invalid current balance");
						}
					
				}
				/**************************MonthlyFee********************/
				String mFeeS = textField_4.getText();
				double mFee=0;
				if (mFeeS.equals("")) {
					mFee = 0;
				}
				else {
					try {
						mFee = Double.parseDouble(mFeeS);
						}
						catch(Exception e) {
							JOptionPane.showMessageDialog(null, "Invalid monthly fee");
						}
					
				}
				/**************************MinBalance********************/
				String minBalS = textField_5.getText();
				double minBal=0;
				if (minBalS.equals("")) {
					minBal = 0;
				}
				else {
					try {
						minBal = Double.parseDouble(minBalS);
						}
						catch(Exception e) {
							JOptionPane.showMessageDialog(null, "Invalid minimun balance");
						}
							
				}
				/**************************IntRate********************/
				String intRateS = textField_6.getText();
				double intRate=0;
				if (intRateS.equals("")) {
					intRate = 0;
				}
				else {
					try {
						intRate = Double.parseDouble(intRateS);
						}
						catch(Exception e) {
							JOptionPane.showMessageDialog(null, "Invalid account number");
						}	
				}		
				if (textField_4.isEditable() && textField_5.isEditable()) {
					JOptionPane.showMessageDialog
					(null, "You must choose either checking or savings");
				}
				if (textField_4.isEditable() && cBal > 0 && mFee >0){
					
					Account a = new CheckingAccount(accNum, accOwner, cBal,
							gDate, mFee);
					b.addAcc(a);
					DefaultTableModel tableModel = (DefaultTableModel)
							accountsTable.getModel();
					tableModel.addRow(new Object[]{accNum,
							formattedDate ,accOwner,cBal,
							mFee});
				}
				if (textField_5.isEditable() && cBal > 0 && minBal > 0 && intRate > 0) {
					Account a = new SavingsAccount(accNum, accOwner, cBal,
							gDate, minBal, intRate);

					b.addAcc(a);
					DefaultTableModel tableModel = (DefaultTableModel)
							accountsTable.getModel();
					tableModel.addRow(new Object[]{accNum,
							formattedDate ,accOwner,cBal,
							"", minBal, intRate});
				}

			}
		});
		btnAdd.setBounds(606, 423, 89, 23);	
		contentPane.add(btnAdd);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnChecking.isSelected() && rdbtnSavings.isSelected()) {
					JOptionPane.showMessageDialog(null, "You must pick either checkings or savings");
				}
				int index = getIndex();
				b.deleteAcc(index);
				//tableModel.removeRow(index);
				DefaultTableModel tableModel = (DefaultTableModel)
						accountsTable.getModel();
				tableModel.removeRow(index);

				//	int index = getIndex();
				//	b.deleteAcc(index);
				//	listModel.remove(index);
				//int numCols = accountsTable.getModel().getColumnCount();

			}
		});
		btnDelete.setBounds(606, 457, 89, 23);
		contentPane.add(btnDelete);	

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnChecking.isSelected() && rdbtnSavings.isSelected()) {
					JOptionPane.showMessageDialog(null, "You must pick either checkings or savings");
				}

				//				b.updateAcc(index, a);
				//				listModel.remove(index);
				//				listModel.add(index, a);


				tableModel = (DefaultTableModel) accountsTable.getModel();
				if (accountsTable.getSelectedRow()==-1){
					if(accountsTable.getRowCount() ==0) {
						JOptionPane.showMessageDialog
						(null, "Table is empty"); 
					}
					else {
						JOptionPane.showMessageDialog
						(null, "You must select a row"); 
					}
				}

				int days = 0, month = 0, year = 0;
				String dateS = textField_2.getText();
				try {
					String[] splitDate = dateS.split("-");
					days = Integer.parseInt(splitDate[0]);
					month = (Integer.parseInt(splitDate[1])-1);
					year = Integer.parseInt(splitDate[2]);
					if (days >31 || days < 1 || month >12 || month <0 || year <0)
						JOptionPane.showMessageDialog(null, "Invalid Date");
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Date format is dd-mm-yyyy");
				}
				GregorianCalendar gDate = new GregorianCalendar(year, month, days);
				String formattedDate = Account.formatDate(gDate);
				/**************************accountNum********************/

				String accNumS = textField.getText();
				int accNum = 0;
				
				
				if (accNumS.equals("")) {
					accNum = 0;
				}
				else {
					try {
					accNum = Integer.parseInt(accNumS);
					}
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Invalid account number");
						
					}
				}
				/**************************AccountOwner********************/
				String accOwner = textField_1.getText();

				/**************************CurrentBalance********************/
				String cBalS = textField_3.getText();
				double cBal=0;
				if (cBalS.equals("")) {
					cBal = 0;
				}
				else {
					try {
						cBal = Double.parseDouble(cBalS);
						}
						catch(Exception e) {
							JOptionPane.showMessageDialog(null, "Invalid current balance");
						}				
				}
				/**************************MonthlyFee********************/
				String mFeeS = textField_4.getText();
				double mFee=0;
				if (mFeeS.equals("")) {
					mFee = 0;
				}
				else {
					try {
						mFee = Double.parseDouble(mFeeS);
						}
						catch(Exception e) {
							JOptionPane.showMessageDialog(null, "Invalid monthly fee");
						}					
				}
				/**************************MinBalance********************/
				String minBalS = textField_5.getText();
				double minBal=0;
				if (minBalS.equals("")) {
					minBal = 0;
				}
				else {
					try {
						minBal = Double.parseDouble(minBalS);
						}
						catch(Exception e) {
							JOptionPane.showMessageDialog(null, "Invalid minimun balance");
						}				
				}
				/**************************IntRate********************/
				String intRateS = textField_6.getText();
				double intRate=0;
				if (intRateS.equals("")) {
					intRate = 0;
				}
				else {
					try {
						intRate = Double.parseDouble(intRateS);
						}
						catch(Exception e) {
							JOptionPane.showMessageDialog(null, "Invalid interest rate number");
						}				
				}
	
				if (textField_4.isEditable() && textField_5.isEditable()) {
					JOptionPane.showMessageDialog
					(null, "You must choose either checking or savings");
				}
				if (textField_4.isEditable() && cBal > 0 && mFee > 0){
					Account a = new CheckingAccount(accNum, accOwner, cBal,
							gDate, mFee);
				
					int index = getIndex();		
					//set each col for index row, textfield is 0,
					//texfield1 is 1, and so on for each update click
					tableModel.setValueAt(accNum, index, 0);
					tableModel.setValueAt(formattedDate, index, 1);
					tableModel.setValueAt(accOwner, index, 2);
					tableModel.setValueAt(cBal, index, 3);
					tableModel.setValueAt(mFee, index, 4);
					tableModel.setValueAt("", index, 5);
					tableModel.setValueAt("", index, 6);
					b.updateAcc(index, a);
				}

				if (textField_5.isEditable() && cBal > 0 && minBal > 0 && intRate > 0) {
					Account a = new SavingsAccount(accNum, accOwner, cBal,
							gDate, minBal, intRate);
	
					int index = getIndex();		
					//set each col for index row, textfield is 0, texfield1 is 1, and so on for each update click
					tableModel.setValueAt(accNum, index, 0);
					tableModel.setValueAt(formattedDate, index, 1);
					tableModel.setValueAt(accOwner, index, 2);
					tableModel.setValueAt(cBal, index, 3);
					tableModel.setValueAt("", index, 4);
					tableModel.setValueAt(minBal, index, 5);
					tableModel.setValueAt(intRate, index, 6);
					b.updateAcc(index, a);

				}
			}
		});
		btnUpdate.setBounds(606, 491, 89, 23);
		contentPane.add(btnUpdate);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				((DefaultTableModel)accountsTable.getModel()).setNumRows(0);
				b.deleteAll();
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");

			}
		});
		btnClear.setBounds(606, 525, 89, 23);
		contentPane.add(btnClear);

		JLabel lblNewLabel = new JLabel("Date Opened");
		lblNewLabel.setBounds(10, 450, 113, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Account Balance");
		lblNewLabel_1.setBounds(10, 478, 113, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Monthly Fee");
		lblNewLabel_2.setBounds(10, 506, 113, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Interest Rate");
		lblNewLabel_3.setBounds(10, 534, 113, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Account Owner");
		lblNewLabel_4.setBounds(10, 424, 113, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Account Number");
		lblNewLabel_5.setBounds(10, 395, 113, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Minimum Balance");
		lblNewLabel_6.setBounds(10, 562, 113, 14);
		contentPane.add(lblNewLabel_6);

		rdbtnChecking = new JRadioButton("Checking");
		rdbtnChecking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if (textField_5.isEditable()) {
					textField_5.setEditable(false);
					textField_6.setEditable(false);
					textField_5.setText("");
					textField_6.setText("");
				}
				else {
					textField_5.setEditable(true);
					textField_6.setEditable(true);
				}
			}
		});
		rdbtnChecking.setBounds(243, 362, 89, 23);
		contentPane.add(rdbtnChecking);

		rdbtnSavings = new JRadioButton("Savings");
		rdbtnSavings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if (textField_4.isEditable())
				{
					textField_4.setEditable(false);
					textField_4.setText("");
				}
				else {
					textField_4.setEditable(true);
				}
			}
		});
		rdbtnSavings.setBounds(403, 362, 89, 23);
		contentPane.add(rdbtnSavings);

		textField = new JTextField();
		textField.setBounds(133, 392, 435, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(133, 419, 435, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(133, 447, 435, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(133, 475, 435, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(133, 503, 435, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(133, 531, 435, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(133, 559, 435, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel(" Number");
		lblNewLabel_7.setBounds(43, 7, 50, 14);
		contentPane.add(lblNewLabel_7);

		JLabel lblDateOpened = new JLabel("Date Opened");
		lblDateOpened.setBounds(113, 7, 76, 14);
		contentPane.add(lblDateOpened);

		JLabel lblAccountOwner = new JLabel("Account Owner");
		lblAccountOwner.setBounds(209, 7, 100, 14);
		contentPane.add(lblAccountOwner);

		JLabel lblCurrentBalance = new JLabel("Current Balance");
		lblCurrentBalance.setBounds(313, 7, 103, 14);
		contentPane.add(lblCurrentBalance);

		JLabel lblNewLabel_8 = new JLabel("Monthly Fee");
		lblNewLabel_8.setBounds(423, 7, 89, 14);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Min Balance");
		lblNewLabel_9.setBounds(515, 7, 76, 14);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("Interest Rate");
		lblNewLabel_10.setBounds(606, 7, 89, 14);
		contentPane.add(lblNewLabel_10);


		tableModel = new DefaultTableModel();
		accountsTable = new JTable(tableModel);
		accountsTable.setModel(new DefaultTableModel(
				new Object[][] {

				},
				new String[] {
						"New Column", "New column", "New column", "New column",
						"New column", "New column", "New column"
				}
				));

		accountsTable.getColumnModel().getColumn(0).setPreferredWidth(84);
		accountsTable.getColumnModel().getColumn(1).setPreferredWidth(90);
		accountsTable.getColumnModel().getColumn(2).setPreferredWidth(90);
		accountsTable.getColumnModel().getColumn(3).setPreferredWidth(90);
		accountsTable.getColumnModel().getColumn(4).setPreferredWidth(90);
		accountsTable.getColumnModel().getColumn(5).setPreferredWidth(90);
		accountsTable.getColumnModel().getColumn(6).setPreferredWidth(90);
		accountsTable.setBounds(30, 32, 665, 301);
		contentPane.add(accountsTable);


		accountsTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					JTable target = (JTable)e.getSource();
					int row = target.getSelectedRow();
					int column = target.getSelectedColumn();
					System.out.println(row);
					// do some action if appropriate column
					setIndex(row);
				}
			}
		});

	}
	public void setIndex(int i) {
		index = i;
	}
	public int getIndex(){
		return index;
	}
}