package gui;

import javax.swing.*;

/**
 * @author dragon
 */
public class InvoiceGui extends JFrame {

    public InvoiceGui() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new JTextField();
        jScrollPane1 = new JScrollPane();
        invoicesPanel = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jScrollPane2 = new JScrollPane();
        jPanel3 = new JPanel();
        jScrollPane4 = new JScrollPane();
        jEditorPane2 = new JEditorPane();
        jScrollPane5 = new JScrollPane();
        jEditorPane3 = new JEditorPane();
        jScrollPane6 = new JScrollPane();
        jEditorPane4 = new JEditorPane();
        commitChanges = new JButton();

        jTextField1.setText("The solution is to take the fosset and some hot glue gun and then what you need to do is to ...");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setForeground(new java.awt.Color(182, 182, 182));
        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(58, 58, 58));
        jLabel1.setText("<html>ID: 0 \"My Sink is broken pls halp\"<br>23.05.2020 23::23::23<br>\"Hello, this is Nicoleta and I....\"</html>");
        jLabel1.setVerticalAlignment(SwingConstants.TOP);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoiceMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(58, 58, 58));
        jLabel2.setText("<html>ID: 0 \"My Sink is broken pls halp\"<br>23.05.2020 23::23::23<br>\"Hello, this is Nicoleta and I....\"</html>");
        jLabel2.setVerticalAlignment(SwingConstants.TOP);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(58, 58, 58));
        jLabel3.setText("<html>ID: 0 \"My Sink is broken pls halp\"<br>23.05.2020 23::23::23<br>\"Hello, this is Nicoleta and I....\"</html>");
        jLabel3.setVerticalAlignment(SwingConstants.TOP);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(58, 58, 58));
        jLabel4.setText("<html>ID: 0 \"My Sink is broken pls halp\"<br>23.05.2020 23::23::23<br>\"Hello, this is Nicoleta and I....\"</html>");
        jLabel4.setVerticalAlignment(SwingConstants.TOP);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(58, 58, 58));
        jLabel5.setText("<html>ID: 0 \"My Sink is broken pls halp\"<br>23.05.2020 23::23::23<br>\"Hello, this is Nicoleta and I....\"</html>");
        jLabel5.setVerticalAlignment(SwingConstants.TOP);

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(58, 58, 58));
        jLabel6.setText("<html>ID: 0 \"My Sink is broken pls halp\"<br>23.05.2020 23::23::23<br>\"Hello, this is Nicoleta and I....\"</html>");

        GroupLayout jPanel2Layout = new GroupLayout(invoicesPanel);
        invoicesPanel.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(invoicesPanel);

        jScrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setToolTipText("");

        jScrollPane4.setViewportView(jEditorPane2);

        jScrollPane5.setViewportView(jEditorPane3);

        jScrollPane6.setViewportView(jEditorPane4);

        commitChanges.setBackground(new java.awt.Color(2, 180, 41));
        commitChanges.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        commitChanges.setForeground(new java.awt.Color(254, 254, 254));
        commitChanges.setText("Commit changes");
        commitChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commitChangesActionPerformed(evt);
            }
        });

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane5, GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)
                                        .addComponent(jScrollPane6, GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)
                                        .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(commitChanges, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(2051, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane6, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(commitChanges, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(89, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel3);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void commitChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commitChangesActionPerformed
        JLabel[] labels = new JLabel[6];

        labels[0] = createInvoice(new String[]{"0", "Title0", "23.05.2020 10:23:09", "This is a sample description, if it's too long then it's going to be trimmed.", "Just a sample solution here."});
        labels[1] = createInvoice(new String[]{"1", "Title1", "23.05.2020 10:23:09", "This is a sample description, if it's too long then it's going to be trimmed.", "Just a sample solution here."});
        labels[2] = createInvoice(new String[]{"2", "Title2", "23.05.2020 10:23:09", "This is a sample description, if it's too long then it's going to be trimmed.", "Just a sample solution here."});
        labels[3] = createInvoice(new String[]{"3", "Title3", "23.05.2020 10:23:09", "This is a sample description, if it's too long then it's going to be trimmed.", "Just a sample solution here."});
        labels[4] = createInvoice(new String[]{"4", "Title4", "23.05.2020 10:23:09", "This is a sample description, if it's too long then it's going to be trimmed.", "Just a sample solution here."});
        labels[5] = createInvoice(new String[]{"5", "Title5", "23.05.2020 10:23:09", "This is a sample description, if it's too long then it's going to be trimmed.", "Just a sample solution here."});

        resetInvoices(labels);
    }//GEN-LAST:event_commitChangesActionPerformed

    private void invoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.out.print("HEllo Boy!");
    }//GEN-LAST:event_jLabel1MouseClicked

    private JLabel createInvoice(String[] data) {
        String ID = data[0];
        String title = data[1];
        String date = data[2];
        String descript = (data[3].length() > 30) ? (data[3].substring(0, 27) + " ...") : (data[3]);
        String solution = (data[4].length() > 30) ? (data[4].substring(0, 27) + " ...") : (data[4]);


        JLabel newInvoice = new JLabel();

        String invoiceFormatted = String.format("<html>ID: %s \"%s\"<br>%s<br>%s<br>%s</html>", ID, title, date, descript, solution);

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

    private void resetInvoices(JLabel[] invoices) {
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
    private JEditorPane jEditorPane2;
    private JEditorPane jEditorPane3;
    private JEditorPane jEditorPane4;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JPanel invoicesPanel;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JScrollPane jScrollPane6;
    private JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
