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
public class WilliamQueries extends javax.swing.JFrame {

    /**
     * Creates new form WilliamQueries
     */
    DBAccess DBA;

    public WilliamQueries() {
        initComponents();
        setDefaultCloseOperation(WilliamQueries.DISPOSE_ON_CLOSE);
        DBA = new DBAccess();
        custIdCombo.removeAllItems();
        custIdCombo.addItem("Select a customer id:");
        for (int i = 0; i < DBA.getAllCusIds().size(); i++) {
            custIdCombo.addItem(DBA.getAllCusIds().get(i).toString());
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
        task1Ans = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tasksArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        task2Ans = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        task3Ans = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        task4Ans = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        custIdCombo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Task1: Find the names of the cashiers who joined the same branch in the same year. Output will look like a pair:");

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

        jLabel2.setText("Task 2: Find the average salary of the cashiers that work in branch of Beirut and street of Ashrafieh: ");

        task2Ans.setText("Task 2 Answer");
        task2Ans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                task2AnsActionPerformed(evt);
            }
        });

        jLabel3.setText("Task 3: Find the highest price product for each manufacturer:");

        task3Ans.setText("Task 3 Answer");
        task3Ans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                task3AnsActionPerformed(evt);
            }
        });

        jLabel4.setText("Task 4: Find all the customers names, last names and age for those who have 6 characters in their first name and paid for the order in cash");

        task4Ans.setText("Task 4 Answer");
        task4Ans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                task4AnsActionPerformed(evt);
            }
        });

        jLabel5.setText("Task 5: Find all the products bought by the customer");

        custIdCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custIdComboActionPerformed(evt);
            }
        });

        jLabel6.setText("and the quantity bought of each product");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(task1Ans, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(task2Ans, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(task3Ans, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(custIdCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6))
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(task4Ans, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(task1Ans))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(task2Ans))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(task3Ans))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(task4Ans))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(custIdCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void task1AnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_task1AnsActionPerformed
        tasksArea.setText(null);
        ArrayList<String> cashAtt = DBA.Wtask1();
        for (int i = 0; i < cashAtt.size();) {
            tasksArea.append(cashAtt.get(i++) + "\t");
            tasksArea.append(cashAtt.get(i++) + "\n");
        }
    }//GEN-LAST:event_task1AnsActionPerformed

    private void task2AnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_task2AnsActionPerformed
        tasksArea.setText(null);
        tasksArea.setText("Average Salary:\n");
        tasksArea.append(String.valueOf(DBA.Wtask2()) + " $");
    }//GEN-LAST:event_task2AnsActionPerformed

    private void task3AnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_task3AnsActionPerformed
        tasksArea.setText(null);
        ArrayList<String> manfMaxPrice = DBA.Wtask3();
        for (int i = 0; i < manfMaxPrice.size();) {
            tasksArea.append(manfMaxPrice.get(i++) + "\t");
            tasksArea.append(manfMaxPrice.get(i++) + " $\n");
        }
    }//GEN-LAST:event_task3AnsActionPerformed

    private void task4AnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_task4AnsActionPerformed
        tasksArea.setText(null);
        ArrayList<String> custAtt = DBA.Wtask4();
        for (int i = 0; i < custAtt.size();) {
            tasksArea.append(custAtt.get(i++) + "\t");
            tasksArea.append(custAtt.get(i++) + "\t");
            tasksArea.append(custAtt.get(i++) + "\n");
        }
    }//GEN-LAST:event_task4AnsActionPerformed

    private void custIdComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custIdComboActionPerformed
        tasksArea.setText(null);
        if (custIdCombo.getSelectedItem().toString().equals("Select a customer id:") == false) {
            int selectedCusId = Integer.parseInt(custIdCombo.getSelectedItem().toString());
            ArrayList<String> prodBought = DBA.Wtask5(selectedCusId);
            if (prodBought.isEmpty()) {
                tasksArea.setText("No orders made for this customer yet");
            } else {
                for (int i = 0; i < prodBought.size();) {
                    tasksArea.append(prodBought.get(i++)+" \t");
                    tasksArea.append(prodBought.get(i++) + "\n");
                }
            }
        }
    }//GEN-LAST:event_custIdComboActionPerformed

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
            java.util.logging.Logger.getLogger(WilliamQueries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WilliamQueries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WilliamQueries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WilliamQueries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WilliamQueries().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> custIdCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton task1Ans;
    private javax.swing.JButton task2Ans;
    private javax.swing.JButton task3Ans;
    private javax.swing.JButton task4Ans;
    private javax.swing.JTextArea tasksArea;
    // End of variables declaration//GEN-END:variables
}