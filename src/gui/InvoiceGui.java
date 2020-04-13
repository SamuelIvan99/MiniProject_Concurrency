package gui;

import controller.InvoiceController;
import db.DataAccessException;
import model.Invoice;

import javax.swing.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author dragon
 */
public class InvoiceGui extends JFrame {

    private InvoiceController invoiceController;
    private List<Invoice> currentInvoices;
    private Invoice clickedInvoice;

    public InvoiceGui() {
        invoiceController = new InvoiceController();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        invoicesScrollPane = new JScrollPane();
        invoicesPanel = new JPanel();
        textsScrollPane = new JScrollPane();
        textsPanel = new JPanel();
        solutionScrollPane = new JScrollPane();
        solutionEditor = new JEditorPane();
        titleScrollPane = new JScrollPane();
        titleEditor = new JEditorPane();
        descriptScrollPane = new JScrollPane();
        descriptEditor = new JEditorPane();
        commitChanges = new JButton();

        //jTextField1.setText("The solution is to take the fosset and some hot glue gun and then what you need to do is to ...");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        invoicesScrollPane.setForeground(new java.awt.Color(182, 182, 182));
        invoicesScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        invoicesScrollPane.setViewportView(invoicesPanel);

        textsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        textsScrollPane.setToolTipText("");

        solutionScrollPane.setViewportView(solutionEditor);

        titleScrollPane.setViewportView(titleEditor);

        descriptScrollPane.setViewportView(descriptEditor);

        commitChanges.setBackground(new java.awt.Color(2, 180, 41));
        commitChanges.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        commitChanges.setForeground(new java.awt.Color(254, 254, 254));
        commitChanges.setText("Commit changes");
        commitChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commitChangesActionPerformed(evt);
            }
        });

        GroupLayout jPanel3Layout = new GroupLayout(textsPanel);
        textsPanel.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(titleScrollPane, GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)
                                        .addComponent(descriptScrollPane, GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)
                                        .addComponent(solutionScrollPane, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(commitChanges, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(2051, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleScrollPane, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(descriptScrollPane, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(solutionScrollPane, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(commitChanges, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(89, Short.MAX_VALUE))
        );

        textsScrollPane.setViewportView(textsPanel);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(invoicesScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textsScrollPane, GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(invoicesScrollPane, GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(textsScrollPane, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
        );
        pullAndRefresh();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void commitChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commitChangesActionPerformed
        String title = titleEditor.getText();
        String descript = descriptEditor.getText();
        String solution = solutionEditor.getText();
        LocalDate date = LocalDate.now();

        try {
            invoiceController.updateInvoice(clickedInvoice, title, descript, null, solution, true);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_commitChangesActionPerformed

    private void invoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        String evtText = evt.toString();
        int pos = evt.getComponent().getY();
        int tempID = 1;
        while (pos >= 133) {
            pos -= 133;
            tempID++;
        }

        final int ID = tempID;

        clickedInvoice = currentInvoices.stream().filter(x -> x.getInvoiceID() == ID).findFirst().get();
        titleEditor.setText(clickedInvoice.getTitle());
        descriptEditor.setText(clickedInvoice.getDescription());
        solutionEditor.setText(clickedInvoice.getSolution());

    }//GEN-LAST:event_jLabel1MouseClicked

    public void pullAndRefresh() {
        try {
            currentInvoices = invoiceController.getAllInvoices(false);
            JLabel[] invoiceLabels = new JLabel[currentInvoices.size()];

            for (int i = 0; i < currentInvoices.size(); i++) {
                invoiceLabels[i] = createInvoice(currentInvoices.get(i));
            }
            refreshInvoicesPanel(invoiceLabels);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    private JLabel createInvoice(Invoice data) {
        String ID = Integer.toString(data.getInvoiceID());
        String title = data.getTitle();
        String date = "23.05.2000 23:23";//data.getDate().toString();
        String descript = data.getDescription();
        String solution = data.getSolution();
        String descriptFormatted = (descript.length() > 30) ? (descript.substring(0, 27) + " ...") : (descript);
        String solutionFormatted = (solution.length() > 30) ? (solution.substring(0, 27) + " ...") : (solution);

        JLabel newInvoice = new JLabel();

        String invoiceFormatted = String.format("<html>ID: %s \"%s\"<br>%s<br>%s<br>%s</html>", ID, title, date, descriptFormatted, solutionFormatted);

        newInvoice.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        newInvoice.setForeground(new java.awt.Color(58, 58, 58));
        newInvoice.setText(invoiceFormatted);
        newInvoice.setVerticalAlignment(SwingConstants.TOP);
        newInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoiceMouseClicked(evt);
            }
        });
        return newInvoice;
    }

    private void refreshInvoicesPanel(JLabel[] invoices) {
        GroupLayout jPanelLayout = new GroupLayout(invoicesPanel);
        invoicesPanel.setLayout(jPanelLayout);
        invoicesPanel.removeAll();

        GroupLayout.ParallelGroup itemsGroupH = jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
        for (int i = 0; i < invoices.length; i++) {
            itemsGroupH.addComponent(invoices[i], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
        }
        GroupLayout.SequentialGroup itemsGroupV = jPanelLayout.createSequentialGroup();

        for (int i = 0; i < invoices.length; i++) {
            itemsGroupV.addComponent(invoices[i], GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18);
        }

        GroupLayout.ParallelGroup parallelGroupH = jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(itemsGroupH)
                        .addContainerGap());

        GroupLayout.ParallelGroup parallelGroupV = jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(itemsGroupV)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));


        jPanelLayout.setHorizontalGroup(parallelGroupH);
        jPanelLayout.setVerticalGroup(parallelGroupV);
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoiceGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvoiceGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton commitChanges;
    private JEditorPane solutionEditor;
    private JEditorPane titleEditor;
    private JEditorPane descriptEditor;
    private JPanel invoicesPanel;
    private JPanel textsPanel;
    private JScrollPane invoicesScrollPane;
    private JScrollPane textsScrollPane;
    private JScrollPane solutionScrollPane;
    private JScrollPane titleScrollPane;
    private JScrollPane descriptScrollPane;
    // End of variables declaration//GEN-END:variables
}
