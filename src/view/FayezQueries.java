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
public class FayezQueries extends javax.swing.JFrame {

    /**
     * Creates new form FayezQueries
     */
    DBAccess DBA;
    public FayezQueries() {
        initComponents();
        setDefaultCloseOperation(FayezQueries.DISPOSE_ON_CLOSE);
        DBA=new DBAccess();
        cashCombo.removeAllItems();
        cashCombo.addItem("Select a cashier id:");
        for (int i = 0; i < DBA.getAllCasIds().size(); i++) {
            cashCombo.addItem(DBA.getAllCasIds().get(i).toString());
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tasksArea = new javax.swing.JTextArea();
        task1Ans = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cashCombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        task3Ans = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Task 1: Display the name of the product with the highest price:");

        tasksArea.setEditable(false);
        tasksArea.setColumns(20);
        tasksArea.setRows(5);
        jScrollPane1.setViewportView(tasksArea);

        task1Ans.setText("Task 1 Answer");
        task1Ans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                task1AnsActionPerformed(evt);
            }
        });

        jLabel2.setText("Task 2: Display the phone number of the customer who ordered an order made by cashier:");

        cashCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashComboActionPerformed(evt);
            }
        });

        jLabel3.setText("Task 3: Dsiplay the numbers of cashiers that work in hamra: ");

        task3Ans.setText("Task 3 Answer");
        task3Ans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                task3AnsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(task1Ans, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cashCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(task3Ans, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(task1Ans))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cashCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(task3Ans))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void task1AnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_task1AnsActionPerformed
        String name=DBA.Ftask1().get(0);
        String price=DBA.Ftask1().get(1);
        tasksArea.setText("name:\tprice:\n"+name+"\t"+price+" $");
    }//GEN-LAST:event_task1AnsActionPerformed

    private void cashComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashComboActionPerformed
        tasksArea.setText(null);
        if(cashCombo.getSelectedItem().toString().equals("Select a cashier id:")==false){
            int selectedCasId=Integer.parseInt(cashCombo.getSelectedItem().toString());
        ArrayList<String> pNumbers=DBA.Ftask2(selectedCasId);
        if(pNumbers.isEmpty())
            tasksArea.setText("No orders made by this cashier yet");
        else{
            for(int i=0;i<pNumbers.size();i++)
                tasksArea.append(pNumbers.get(i)+"\n");
        }
        }
    }//GEN-LAST:event_cashComboActionPerformed

    private void task3AnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_task3AnsActionPerformed
        int count=DBA.Ftask3();
        tasksArea.setText(String.valueOf(count));
    }//GEN-LAST:event_task3AnsActionPerformed

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
            java.util.logging.Logger.getLogger(FayezQueries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FayezQueries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FayezQueries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FayezQueries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FayezQueries().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cashCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton task1Ans;
    private javax.swing.JButton task3Ans;
    private javax.swing.JTextArea tasksArea;
    // End of variables declaration//GEN-END:variables
}
