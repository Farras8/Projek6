/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ivanderlibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author mfarr
 */
public class Customer extends javax.swing.JFrame {

    /**
     * Creates new form Homepage
     */

    DefaultTableModel model;        
    public Customer() {
        initComponents();
        insertCustomerDetail();
    }
    
    public void insertCustomerDetail(){
        try{
            Connection cn = ConnectionDB.getConnection();
            Statement state = cn.createStatement();
            String sql = "select * from customer";
            ResultSet rs = state.executeQuery(sql);
            
            while(rs.next()){
                int CustomerID = rs.getInt("CustomerID");
                String Name = rs.getString("Name");
                int PhoneNumber = rs.getInt("PhoneNumber");
                String Gender = rs.getString("Gender");
                String Date = rs.getString("Date");

                
                Object[] obj = {CustomerID,Name,PhoneNumber,Gender,Date};
                model = (DefaultTableModel) tbl_customer.getModel();
                model.addRow(obj);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
            
    }
    public boolean saveCustomer(String Name, int PhoneNum, String Gender){
        
        boolean alreadySaved = false;    
        try {
            Connection cn = ConnectionDB.getConnection();
            String sql = "INSERT INTO customer( Name, PhoneNumber, Gender, Date) VALUES (?,?,?,CURRENT_DATE)";
            PreparedStatement prp = cn.prepareStatement(sql);
            
            prp.setString(1, Name);
            prp.setInt(2, PhoneNum);
            prp.setString(3, Gender);
              
            int rowCount = prp.executeUpdate();
            if(rowCount > 0){
                alreadySaved = true;
            }else{
                alreadySaved = false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return alreadySaved;
    }
    
    public boolean updateCustomer(String Name, int PhoneNum, String Gender, int CustomerID){
        boolean alreadyUpdated = false;        
         try {
            Connection cn = ConnectionDB.getConnection();
            String sql = "update customer set Name = ?,PhoneNumber = ?,Gender = ? where CustomerID = ?";
            PreparedStatement prp = cn.prepareStatement(sql);
            

            prp.setString(1, Name);
            prp.setInt(2, PhoneNum);
            prp.setString(3, Gender);
            prp.setInt(4,CustomerID);

            
            int rowCount = prp.executeUpdate();
            if(rowCount > 0){
                alreadyUpdated = true;
            }else{
                alreadyUpdated = false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return alreadyUpdated;
        
    }
    public  boolean deleteCustomer(int CustomerID){
        boolean alreadyDeleted = false;

        
        try{
            Connection cn = ConnectionDB.getConnection();
            String sql = "delete from customer where CustomerID = ?";
            PreparedStatement prp = cn.prepareStatement(sql);
            
            prp.setInt(1, CustomerID);

            
            int rowCount = prp.executeUpdate();
            if(rowCount > 0){
                alreadyDeleted = true;
            }else{
                alreadyDeleted = false;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return alreadyDeleted;
    }
    
    //clear table
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_customer.getModel();
        model.setRowCount(0);
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
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txf_customer = new app.bolivia.swing.JCTextField();
        btn_save = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        txf_name = new app.bolivia.swing.JCTextField();
        txf_PhoneNum = new app.bolivia.swing.JCTextField();
        combo_Gender = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_customer = new rojeru_san.complementos.RSTableMetro();
        btn_HomePage = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/log000.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setName(""); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(229, 178, 153));

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Customer ID");

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Name");

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Phone Number");

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Gender");

        txf_customer.setEditable(false);
        txf_customer.setBackground(new java.awt.Color(229, 178, 153));
        txf_customer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 132, 108)));
        txf_customer.setForeground(new java.awt.Color(255, 255, 255));
        txf_customer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txf_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_customerActionPerformed(evt);
            }
        });

        btn_save.setBackground(new java.awt.Color(180, 132, 108));
        btn_save.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_save.setForeground(new java.awt.Color(255, 255, 255));
        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(180, 132, 108));
        btn_delete.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(180, 132, 108));
        btn_update.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        txf_name.setBackground(new java.awt.Color(229, 178, 153));
        txf_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 132, 108)));
        txf_name.setForeground(new java.awt.Color(0, 0, 0));
        txf_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txf_name.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        txf_PhoneNum.setBackground(new java.awt.Color(229, 178, 153));
        txf_PhoneNum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 132, 108)));
        txf_PhoneNum.setForeground(new java.awt.Color(0, 0, 0));
        txf_PhoneNum.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txf_PhoneNum.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        combo_Gender.setBackground(new java.awt.Color(229, 178, 153));
        combo_Gender.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        combo_Gender.setForeground(new java.awt.Color(0, 0, 0));
        combo_Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        combo_Gender.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        combo_Gender.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txf_customer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txf_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txf_PhoneNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(combo_Gender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txf_customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txf_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txf_PhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combo_Gender, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save)
                    .addComponent(btn_delete))
                .addGap(18, 18, 18)
                .addComponent(btn_update)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 690));

        jPanel5.setBackground(new java.awt.Color(252, 222, 192));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Customer");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 120, 30));

        tbl_customer.setAutoCreateRowSorter(true);
        tbl_customer.setBackground(new java.awt.Color(252, 222, 192));
        tbl_customer.setForeground(new java.awt.Color(0, 0, 0));
        tbl_customer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Name", "Phone Number", "Gender", "Date"
            }
        ));
        tbl_customer.setColorBackgoundHead(new java.awt.Color(255, 204, 0));
        tbl_customer.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_customer.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        tbl_customer.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tbl_customer.setRowHeight(35);
        tbl_customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_customerMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_customer);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 730, 290));

        btn_HomePage.setBackground(new java.awt.Color(180, 132, 108));
        btn_HomePage.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btn_HomePage.setForeground(new java.awt.Color(255, 255, 255));
        btn_HomePage.setText("<< HOME PAGE");
        btn_HomePage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_HomePage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HomePageActionPerformed(evt);
            }
        });
        jPanel5.add(btn_HomePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 40));

        jButton1.setBackground(new java.awt.Color(180, 132, 108));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("X");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, -1, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 780, 690));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        if(saveCustomer(txf_name.getText(), Integer.parseInt(txf_PhoneNum.getText()), combo_Gender.getSelectedItem().toString()) == true){
            clearTable();
            insertCustomerDetail();
            clearTextField();
        }else{
            JOptionPane.showMessageDialog(this, "Failed");
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        if(deleteCustomer(Integer.parseInt(txf_customer.getText()))== true){
            clearTable();
            insertCustomerDetail();
            clearTextField();
        }else{
            JOptionPane.showMessageDialog(this, "Failed");
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        if(updateCustomer(txf_name.getText(), Integer.parseInt(txf_PhoneNum.getText()), combo_Gender.getSelectedItem().toString(), Integer.parseInt(txf_customer.getText()))== true){
            clearTable();
            insertCustomerDetail();
            clearTextField();
        }else{
            JOptionPane.showMessageDialog(this, "Failed");
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void txf_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_customerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_customerActionPerformed

    private void tbl_customerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_customerMouseClicked
        int rowNumber = tbl_customer.getSelectedRow();
        TableModel model = tbl_customer.getModel();
        
        txf_customer.setText(model.getValueAt(rowNumber, 0).toString());
        txf_name.setText(model.getValueAt(rowNumber, 1).toString());
        txf_PhoneNum.setText(model.getValueAt(rowNumber, 2).toString());

                                                
    }//GEN-LAST:event_tbl_customerMouseClicked

    private void btn_HomePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HomePageActionPerformed
        Homepage HPage = new Homepage();
        HPage.setVisible(true);
        clearTextField();
        this.dispose();
    }//GEN-LAST:event_btn_HomePageActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    // clear text field
    private void clearTextField(){
        txf_PhoneNum.setText(null);
        txf_customer.setText(null);
        txf_name.setText(null);
    }
    
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
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_HomePage;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> combo_Gender;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private rojeru_san.complementos.RSTableMetro tbl_customer;
    private app.bolivia.swing.JCTextField txf_PhoneNum;
    private app.bolivia.swing.JCTextField txf_customer;
    private app.bolivia.swing.JCTextField txf_name;
    // End of variables declaration//GEN-END:variables
}