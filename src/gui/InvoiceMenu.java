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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		initDetailsPanel();
	}
	
	private void initDetailsPanel() {
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 670, 50);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));
		// panel.setBorder(BorderFactory.createLineBorder(Color.black));

		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				createInvoice();
			}
		});
		btnCreate.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		panel.add(btnCreate);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updateInvoice();
			}
		});
		btnUpdate.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		panel.add(btnUpdate);


		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deleteInvoice();
			}
		});
		btnDelete.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		panel.add(btnDelete);
		JLabel lblFirstName = new JLabel("Version No.:" + tableVersion);
		lblFirstName.setFont(new Font("Ubuntu", Font.PLAIN, 13));
		contentPane.add(panel, BorderLayout.NORTH);
		
		initInvoiceTable();
	}
	
	private void initInvoiceTable() {
		JScrollPane scrollPane = new JScrollPane(invoicesTable);
		scrollPane.setBounds(10, 60, 670, 350);
		contentPane.add(scrollPane, BorderLayout.CENTER);
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
