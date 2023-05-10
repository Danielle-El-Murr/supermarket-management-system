/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.DBAccess;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class DanielleQueries extends javax.swing.JFrame {

    /**
     * Creates new form DanielleQueries
     */
    DBAccess DBA;
    public DanielleQueries() {
        initComponents();
        setDefaultCloseOperation(DanielleQueries.DISPOSE_ON_CLOSE);
        DBA=new DBAccess();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        task1Ans = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tasksArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        paymentCombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        task3Ans = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        task4Ans = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Task 1: Display the order number made for the customer whose phone number ends with 517:");

        task1Ans.setText("Task 1 Answer");
        task1Ans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                task1AnsActionPerformed(evt);
            }
        });

        tasksArea.setEditable(false);
        tasksArea.setColumns(20);
        tasksArea.setRows(5);
        jScrollPane1.setViewportView(tasksArea);

        jLabel2.setText("Task 2: List all the orders paid with:");

        paymentCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a payment type", "Cash", "Credit" }));
        paymentCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentComboActionPerformed(evt);
            }
        });

        jLabel3.setText("Task 3: Find the products that have the same price and are sold by the same cashier:");

        task3Ans.setText("Task 3 Answer");
        task3Ans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                task3AnsActionPerformed(evt);
            }
        });

        jLabel4.setText("Task 4: List the cashiers in descending order based on their salary:");

        task4Ans.setText("Task 4 Answer");
        task4Ans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                task4AnsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(paymentCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(task3Ans, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(task4Ans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(task1Ans, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(task1Ans))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(paymentCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(task3Ans))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(task4Ans))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void task1AnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_task1AnsActionPerformed
        tasksArea.setText(null);
        ArrayList<Integer> oNumbers=DBA.Dtask1();
        if(oNumbers.isEmpty())
            tasksArea.setText("No orders made for this customer yet");
        else{
            for(int i=0;i<oNumbers.size();i++)
                tasksArea.append(oNumbers.get(i)+"\n");
        }
    }//GEN-LAST:event_task1AnsActionPerformed

    private void paymentComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentComboActionPerformed
        tasksArea.setText(null);
        String selectedPayment=paymentCombo.getSelectedItem().toString();
        ArrayList<String> oNumbers=DBA.Dtask2New(selectedPayment);
        for(int i=0;i<oNumbers.size();){
            tasksArea.append(oNumbers.get(i++).toString()+"\t");
            tasksArea.append(oNumbers.get(i++)+"\t");
            tasksArea.append(oNumbers.get(i++)+"\n");}
    }//GEN-LAST:event_paymentComboActionPerformed

    private void task3AnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_task3AnsActionPerformed
        tasksArea.setText(null);
        ArrayList<String> pNames=DBA.Dtask3();
        for(int i=0;i<pNames.size();){
            tasksArea.append(pNames.get(i++)+"\t");
            tasksArea.append(pNames.get(i++));
        }
    }//GEN-LAST:event_task3AnsActionPerformed

    private void task4AnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_task4AnsActionPerformed
        tasksArea.setText(null);
        ArrayList<String> cashAtt=DBA.Dtask4();
        for(int i=0;i<cashAtt.size();){
            tasksArea.append(cashAtt.get(i++)+"\t");
            tasksArea.append(cashAtt.get(i++)+" $\n");
        }
    }//GEN-LAST:event_task4AnsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DanielleQueries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanielleQueries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanielleQueries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanielleQueries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DanielleQueries().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> paymentCombo;
    private javax.swing.JButton task1Ans;
    private javax.swing.JButton task3Ans;
    private javax.swing.JButton task4Ans;
    private javax.swing.JTextArea tasksArea;
    // End of variables declaration//GEN-END:variables
}
