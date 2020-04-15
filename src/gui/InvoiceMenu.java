package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.sun.org.apache.xerces.internal.util.TeeXMLDocumentFilterImpl;

import controller.InvoiceController;
import db.DataAccessException;
import model.Invoice;

public class InvoiceMenu extends JFrame {

	/**
	 * 
	 */
	private static int tableVersion = 0;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable invoicesTable;
	private JLabel lblVersionNo;
	private JLabel lblID;
	private JLabel lblTitle;
	private JLabel lblDescription;
	private JLabel lblSolution;
	
	private JTextField textFieldTitle;
	private JTextArea textFieldDescription;
	private JTextArea textFieldSolution;
	
	private InvoiceController invoiceController;
	private DefaultTableModel tableModelInvoice;
	{
		invoiceController = new InvoiceController();
		tableModelInvoice = new DefaultTableModel(new Object[][] {},
				new String[] { "InvoiceID", "Title", "Description", "Solution"}) {
			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = { false, false, false, false};

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return canEdit[column];
			}
		};
		invoicesTable = new JTable(tableModelInvoice);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvoiceMenu frame = new InvoiceMenu();
					frame.setTitle("Invoice Menu");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InvoiceMenu() {
		init();
	}
	
	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		initDetailsPanel();
		initInvoiceTable();
	}
	
	private void initDetailsPanel() {
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 675, 150);
		panel.setLayout(null);
		// panel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		lblID = new JLabel("Invoice ID: ");
		lblID.setBounds(15, 15, 100, 20);
		lblID.setFont(new Font("Ubuntu", Font.PLAIN, 13));
		panel.add(lblID);
		
		lblTitle = new JLabel("Title: ");
		lblTitle.setBounds(150, 15, 100, 20);
		lblTitle.setFont(new Font("Ubuntu", Font.PLAIN, 13));
		panel.add(lblTitle);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setBounds(150, 50, 100, 50);
		panel.add(textFieldTitle);
		
		lblDescription = new JLabel("Description: ");
		lblDescription.setBounds(300, 15, 100, 20);
		lblDescription.setFont(new Font("Ubuntu", Font.PLAIN, 13));
		panel.add(lblDescription);
		
		textFieldDescription = new JTextArea();
		textFieldDescription.setBounds(300, 50, 125, 75);
		panel.add(textFieldDescription);
		
		lblSolution = new JLabel("Solution: ");
		lblSolution.setBounds(450, 15, 100, 20);
		lblSolution.setFont(new Font("Ubuntu", Font.PLAIN, 13));
		panel.add(lblSolution);
		
		textFieldSolution = new JTextArea();
		textFieldSolution.setBounds(450, 50, 125, 75);
		panel.add(textFieldSolution);

		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(595, 15, 75, 25);
		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				createInvoice();
			}
		});
		btnCreate.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		panel.add(btnCreate);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(595, 55, 75, 25);
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updateInvoice();
			}
		});
		btnUpdate.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		panel.add(btnUpdate);


		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(595, 95, 75, 25);
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deleteInvoice();
			}
		});
		contentPane.setLayout(null);
		btnDelete.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		panel.add(btnDelete);
		lblVersionNo = new JLabel("Version No.:" + tableVersion);
		lblVersionNo.setBounds(15, 50, 100, 20);
		lblVersionNo.setFont(new Font("Ubuntu", Font.PLAIN, 13));
		panel.add(lblVersionNo);
		
		contentPane.add(panel);
	}
	
	private void initInvoiceTable() {
		JScrollPane scrollPane = new JScrollPane(invoicesTable);
		scrollPane.setBounds(5, 155, 675, 200);
		contentPane.add(scrollPane);
		invoicesTable.getTableHeader().setReorderingAllowed(false);
		
		clearInvoiceTable();
		try {
			invoiceController.getAllInvoices(false).forEach((x) -> tableModelInvoice
					.addRow(new String[] { Integer.toString(x.getInvoiceID()), x.getTitle(), x.getDescription(), x.getSolution()}));
			tableVersion = invoiceController.getVersion();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void clearInvoiceTable() {
		tableModelInvoice.getDataVector().removeAllElements();
	}
	
	private void createInvoice() {
		// Invoice invoice = new Invoice();
		// invoiceController.createInvoice(invoice);
		
	}

	private void updateInvoice() {
		// Invoice invoice = new Invoice();
		// invoiceController.updateInvoice(invoiceToUpdate, newTitle, newDescription, newDate, newSolution, resolved);
		
	}

	private void deleteInvoice() {
		// invoiceController.deleteInvoice(id);
	}
}
