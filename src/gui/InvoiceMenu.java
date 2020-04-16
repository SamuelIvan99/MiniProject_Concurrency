package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.InvoiceController;
import model.Invoice;

public class InvoiceMenu extends JFrame implements Updatable {

    InvoiceMenu frame;
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

    private JTextArea textFieldTitle;
    private JTextArea textFieldDescription;
    private JTextArea textFieldSolution;

    private JButton btnCreate;
    private JButton btnUpdate;
    private JButton btnDelete;

    private InvoiceController invoiceController;
    private DefaultTableModel tableModelInvoice;
    private boolean canCreate;

    {
        canCreate = true;
        invoiceController = new InvoiceController();
        tableModelInvoice = new DefaultTableModel(new Object[][]{},
                new String[]{"InvoiceID", "Title", "Description", "Solution"}) {
            /**
             *
             */
            private static final long serialVersionUID = 1L;
            boolean[] canEdit = {false, false, false, false};

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
    public void start() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new InvoiceMenu();
                    frame.setTitle("Invoice Menu");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public InvoiceMenu getFrame() {
        return frame;
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

        JScrollPane scrollPane = new JScrollPane(invoicesTable);
        scrollPane.setBounds(5, 155, 675, 200);
        contentPane.add(scrollPane);
        invoicesTable.getTableHeader().setReorderingAllowed(false);

        initDetailsPanel();
        initInvoiceTable();
        manageButtonPermissions();

        invoicesTable.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                Invoice invoice = getSelectedInvoice();
                if (invoice != null)
                    populateTextFields(invoice);
            }
        });
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

        textFieldTitle = new JTextArea();
        textFieldTitle.setBounds(150, 40, 100, 50);
        textFieldTitle.setLineWrap(true);
        textFieldTitle.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textFieldTitle);
        scrollPane.setBounds(150, 40, 100, 50);
        panel.add(scrollPane);

        lblDescription = new JLabel("Description: ");
        lblDescription.setBounds(300, 15, 100, 20);
        lblDescription.setFont(new Font("Ubuntu", Font.PLAIN, 13));
        panel.add(lblDescription);

        textFieldDescription = new JTextArea();
        textFieldDescription.setBounds(300, 40, 125, 75);
        textFieldDescription.setLineWrap(true);
        textFieldDescription.setWrapStyleWord(true);
        JScrollPane scrollPane1 = new JScrollPane(textFieldDescription);
        scrollPane1.setBounds(300, 40, 125, 75);
        panel.add(scrollPane1);

        lblSolution = new JLabel("Solution: ");
        lblSolution.setBounds(450, 15, 100, 20);
        lblSolution.setFont(new Font("Ubuntu", Font.PLAIN, 13));
        panel.add(lblSolution);

        textFieldSolution = new JTextArea();
        textFieldSolution.setBounds(450, 40, 125, 75);
        textFieldSolution.setLineWrap(true);
        textFieldSolution.setWrapStyleWord(true);
        JScrollPane scrollPane2 = new JScrollPane(textFieldSolution);
        scrollPane2.setBounds(450, 40, 125, 75);
        panel.add(scrollPane2);

        btnCreate = new JButton("Create");
        btnCreate.setBounds(595, 15, 75, 25);
        btnCreate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                createInvoice();
            }
        });
        btnCreate.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        panel.add(btnCreate);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(595, 55, 75, 25);
        btnUpdate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                updateInvoice();
                StartUp.getRefreshNotifier().signalRefresh(InvoiceMenu.this);
            }
        });
        btnUpdate.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        panel.add(btnUpdate);

        btnDelete = new JButton("Delete");
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

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(15, 70, 75, 25);
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                clearInputFields();
            }
        });
        btnClear.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        panel.add(btnClear);

        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.setBounds(15, 110, 100, 25);
        btnRefresh.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//				initInvoiceTable();
                StartUp.getRefreshNotifier().signalRefresh(InvoiceMenu.this);
            }
        });
        btnRefresh.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        panel.add(btnRefresh);

        lblVersionNo = new JLabel("Version No.: " + tableVersion);
        lblVersionNo.setBounds(15, 40, 100, 20);
        lblVersionNo.setFont(new Font("Ubuntu", Font.PLAIN, 13));
        panel.add(lblVersionNo);

        contentPane.add(panel);
    }

    public void update() {
        System.out.println("Table .update method");
        initInvoiceTable();
    }

    private void initInvoiceTable() {
        clearInvoiceTable();
        try {
            invoiceController.getAllInvoices(false).forEach((x) -> tableModelInvoice
                    .addRow(new String[]{Integer.toString(x.getInvoiceID()), x.getTitle(), x.getDescription(), x.getSolution()}));
            tableVersion = invoiceController.getVersion();
            lblVersionNo.setText("Version No.: " + tableVersion);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void clearInputFields() {
        canCreate = true;
        manageButtonPermissions();
        lblID.setText("Invoice ID:");
        textFieldTitle.setText("");
        textFieldDescription.setText("");
        textFieldSolution.setText("");
    }

    private void clearInvoiceTable() {
        tableModelInvoice.getDataVector().removeAllElements();
    }

    private Invoice getSelectedInvoice() {
        Invoice invoice = null;
        int row = invoicesTable.getSelectedRow();

        if (row > -1) {
            int invoiceID = Integer.parseInt((String) invoicesTable.getValueAt(row, 0));
            try {
                invoice = invoiceController.findInvoiceByID(invoiceID, false);
                canCreate = false;
                manageButtonPermissions();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return invoice;
    }

    private void populateTextFields(Invoice invoice) {
        canCreate = false;
        manageButtonPermissions();
        lblID.setText("Invoice ID: " + invoice.getInvoiceID());
        textFieldTitle.setText(invoice.getTitle());
        textFieldDescription.setText(invoice.getDescription());
        textFieldSolution.setText(invoice.getSolution());
    }

    private void manageButtonPermissions() {
        if (canCreate) {
            btnCreate.setEnabled(true);
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
        } else {
            btnCreate.setEnabled(false);
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
        }
    }

    private void createInvoice() {
        int currentVersionNo = -1;
        try {
            currentVersionNo = invoiceController.getVersion();
        } catch (Exception e) {
            System.out.println(e);
        }
        if (tableVersion != currentVersionNo)
            System.out.println("Please update the table first.");
        else {
            if (textFieldTitle.getText().isEmpty() || textFieldDescription.getText().isEmpty())
                System.out.println("Please set title and description for the invoice.");
            else {
                Invoice invoice = new Invoice(textFieldTitle.getText(), textFieldDescription.getText(), textFieldSolution.getText());
                boolean created = false;
                try {
                    created = invoiceController.createInvoice(invoice);
                    if (created) {
                        invoiceController.updateVersionNo(++currentVersionNo);
                        initInvoiceTable();
                    }
                } catch (Exception e) {
                    System.out.println("Couldn't create invoice object.\n" + e.toString());
                }
            }
        }
    }

    private void updateInvoice() {
        Thread updateThread = new Thread(() -> {
            int currentVersionNo = -1;
            try {
                currentVersionNo = invoiceController.getVersion();
            } catch (Exception e) {
                System.out.println(e);
            }
            if (tableVersion != currentVersionNo)
                System.out.println("Please update the table first.");
            else {
                Invoice invoice = getSelectedInvoice();
                if (invoice == null)
                    System.out.println("Please choose the invoice to update.");
                else {
                    boolean updated = false;
                    try {
                        System.out.println("--Beginning update--");
                        updated = invoiceController.updateInvoice(invoice, textFieldTitle.getText().isEmpty() ? invoice.getTitle() : textFieldTitle.getText(),
                                textFieldDescription.getText().isEmpty() ? invoice.getDescription() : textFieldDescription.getText(), LocalDate.now(),
                                textFieldSolution.getText(), false);
                        if (updated) {
                            invoiceController.updateVersionNo(++currentVersionNo);
                            initInvoiceTable();
                        }
                        System.out.println("--Update Finished--");
                    } catch (Exception e) {
                        System.out.println("Couldn't update invoice object.\n" + e.toString());
                    }
                }
            }
        });
        updateThread.start();
    }

    private void deleteInvoice() {
        int currentVersionNo = -1;
        try {
            currentVersionNo = invoiceController.getVersion();
        } catch (Exception e) {
            System.out.println(e);
        }
        if (tableVersion != currentVersionNo)
            System.out.println("Please update the table first.");
        else {
            Invoice invoice = getSelectedInvoice();
            if (invoice == null)
                System.out.println("Please choose the invoice to delete.");
            else {
                boolean deleted = false;
                try {
                    deleted = invoiceController.deleteInvoice(invoice.getInvoiceID());
                    if (deleted) {
                        invoiceController.updateVersionNo(++currentVersionNo);
                        initInvoiceTable();
                    }
                } catch (Exception e) {
                    System.out.println("Couldn't delete invoice object.\n" + e.toString());
                }
            }
        }
    }
}
