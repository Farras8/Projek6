/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ivanderlibrary;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author mfarr
 */
public class ManageBook extends javax.swing.JFrame {

    /**
     * Creates new form Homepage
     */

    DefaultTableModel model;
    public ManageBook() {
        initComponents();
        insertBookDetail();
    }
    
    
    public void insertBookDetail(){
        try{
            Connection cn = ConnectionDB.getConnection();
            Statement state = cn.createStatement();
            String sql = "select * from book_details";
            ResultSet rs = state.executeQuery(sql);
            
            while(rs.next()){
                int BookID = rs.getInt("BookID");
                String Title = rs.getString("Title");
                String Author = rs.getString("Author");
                String Publisher = rs.getString("Publisher");
                String BookType = rs.getString("BookType");
                int Quantity = rs.getInt("Quantity");
                
                Object[] obj = {BookID,Title,Author,Publisher,BookType,Quantity};
                model = (DefaultTableModel) tbl_bookdetails.getModel();
                model.addRow(obj);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
            
    }
    
    public boolean saveBook(String Title, String Author, String Publisher, String BookType, int Quantity){
        
        boolean alreadySaved = false;
        
        try {
            Connection cn = ConnectionDB.getConnection();
            String sql = "insert into book_details( Title, Author, Publisher, BookType, Quantity) values (?,?,?,?,?)";
            PreparedStatement prp = cn.prepareStatement(sql);
            
            prp.setString(1, Title);
            prp.setString(2, Author);
            prp.setString(3, Publisher);
            prp.setString(4, BookType);
            prp.setInt(5, Quantity);
            
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
    
    public boolean updateBook( String Title, String Author, String Publisher, String BookType, int Quantity, int BookID){
        boolean alreadyUpdated = false;
        
         try {
            Connection cn = ConnectionDB.getConnection();
            String sql = "update book_details set Title = ?,Author = ?,Publisher = ?,BookType = ?,Quantity = ? where BookID = ?";
            PreparedStatement prp = cn.prepareStatement(sql);
            
            
            prp.setString(1, Title);
            prp.setString(2, Author);
            prp.setString(3, Publisher);
            prp.setString(4, BookType);
            prp.setInt(5, Quantity);
            prp.setInt(6, BookID);
            
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
    public  boolean deleteBook(int BookID){
        boolean alreadyDeleted = false;

        
        try{
            Connection cn = ConnectionDB.getConnection();
            String sql = "delete from book_details where BookID = ?";
            PreparedStatement prp = cn.prepareStatement(sql);
            prp.setInt(1, BookID);
            
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
        DefaultTableModel model = (DefaultTableModel) tbl_bookdetails.getModel();
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
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txf_BookID = new app.bolivia.swing.JCTextField();
        btn_save = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        txf_Title = new app.bolivia.swing.JCTextField();
        txf_Author = new app.bolivia.swing.JCTextField();
        txf_Publisher = new app.bolivia.swing.JCTextField();
        txf_BookType = new app.bolivia.swing.JCTextField();
        txf_Quantity = new app.bolivia.swing.JCTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bookdetails = new rojeru_san.complementos.RSTableMetro();
        jButton1 = new javax.swing.JButton();
        btn_HomePage = new javax.swing.JButton();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/log000.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setName(""); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(229, 178, 153));

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Book ID");

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Title");

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Author");

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Publisher");

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("BookType");

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Quantity");

        txf_BookID.setEditable(false);
        txf_BookID.setBackground(new java.awt.Color(229, 178, 153));
        txf_BookID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 132, 108)));
        txf_BookID.setForeground(new java.awt.Color(0, 0, 0));
        txf_BookID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txf_BookID.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txf_BookID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_BookIDActionPerformed(evt);
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

        txf_Title.setBackground(new java.awt.Color(229, 178, 153));
        txf_Title.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 132, 108)));
        txf_Title.setForeground(new java.awt.Color(0, 0, 0));
        txf_Title.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txf_Title.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        txf_Author.setBackground(new java.awt.Color(229, 178, 153));
        txf_Author.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 132, 108)));
        txf_Author.setForeground(new java.awt.Color(0, 0, 0));
        txf_Author.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txf_Author.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        txf_Publisher.setBackground(new java.awt.Color(229, 178, 153));
        txf_Publisher.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 132, 108)));
        txf_Publisher.setForeground(new java.awt.Color(0, 0, 0));
        txf_Publisher.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txf_Publisher.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        txf_BookType.setBackground(new java.awt.Color(229, 178, 153));
        txf_BookType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 132, 108)));
        txf_BookType.setForeground(new java.awt.Color(0, 0, 0));
        txf_BookType.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txf_BookType.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        txf_Quantity.setBackground(new java.awt.Color(229, 178, 153));
        txf_Quantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 132, 108)));
        txf_Quantity.setForeground(new java.awt.Color(0, 0, 0));
        txf_Quantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txf_Quantity.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txf_BookID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txf_Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txf_Author, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txf_Publisher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txf_BookType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txf_Quantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txf_BookID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txf_Title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txf_Author, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txf_Publisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txf_BookType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txf_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save)
                    .addComponent(btn_delete))
                .addGap(18, 18, 18)
                .addComponent(btn_update)
                .addContainerGap())
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 690));

        jPanel5.setBackground(new java.awt.Color(252, 222, 192));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Manage Book");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 170, 30));

        tbl_bookdetails.setBackground(new java.awt.Color(252, 222, 192));
        tbl_bookdetails.setForeground(new java.awt.Color(0, 0, 0));
        tbl_bookdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Title", "Author", "Publisher", "Book Type", "Quantity"
            }
        ));
        tbl_bookdetails.setColorBackgoundHead(new java.awt.Color(255, 204, 0));
        tbl_bookdetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bookdetails.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        tbl_bookdetails.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tbl_bookdetails.setFuenteFilas(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tbl_bookdetails.setFuenteFilasSelect(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tbl_bookdetails.setFuenteHead(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        tbl_bookdetails.setGridColor(new java.awt.Color(0, 0, 0));
        tbl_bookdetails.setRowHeight(35);
        tbl_bookdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bookdetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_bookdetails);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 700, 290));

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
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, -1, -1));

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

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 780, 690));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
      if(saveBook(txf_Title.getText(), txf_Author.getText(), txf_Publisher.getText(), txf_BookType.getText(), Integer.parseInt(txf_Quantity.getText())) == true){
          clearTable();
          insertBookDetail();
          clearTextField();
      }else{
          JOptionPane.showMessageDialog(this, "Failed");
      }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
     if(deleteBook(Integer.parseInt(txf_BookID.getText())) == true){
          clearTable();
          insertBookDetail();
          clearTextField();
      }else{
          JOptionPane.showMessageDialog(this, "Failed");
      }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
       if(updateBook(txf_Title.getText(), txf_Author.getText(), txf_Publisher.getText(), txf_BookType.getText(), Integer.parseInt(txf_Quantity.getText()), Integer.parseInt(txf_BookID.getText())) == true){
          clearTable();
          insertBookDetail();
          clearTextField();
      }else{
          JOptionPane.showMessageDialog(this, "Failed");
      }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void txf_BookIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_BookIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_BookIDActionPerformed

    private void tbl_bookdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookdetailsMouseClicked
        int rowNumber = tbl_bookdetails.getSelectedRow();
        TableModel model = tbl_bookdetails.getModel();
        
        txf_BookID.setText(model.getValueAt(rowNumber, 0).toString());
        txf_Title.setText(model.getValueAt(rowNumber, 1).toString());
        txf_Author.setText(model.getValueAt(rowNumber, 2).toString());
        txf_Publisher.setText(model.getValueAt(rowNumber, 3).toString());
        txf_BookType.setText(model.getValueAt(rowNumber, 4).toString());
        txf_Quantity.setText(model.getValueAt(rowNumber, 5).toString());
    }//GEN-LAST:event_tbl_bookdetailsMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_HomePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HomePageActionPerformed
        Homepage HPage = new Homepage();
        HPage.setVisible(true);
        clearTextField();
        this.dispose();
    }//GEN-LAST:event_btn_HomePageActionPerformed

    // clear text field
    public void clearTextField(){
        txf_Author.setText(null);
        txf_BookID.setText(null);
        txf_BookType.setText(null);
        txf_Publisher.setText(null);
        txf_Quantity.setText(null);
        txf_Title.setText(null);
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
            java.util.logging.Logger.getLogger(ManageBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_HomePage;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private rojeru_san.complementos.RSTableMetro tbl_bookdetails;
    private app.bolivia.swing.JCTextField txf_Author;
    private app.bolivia.swing.JCTextField txf_BookID;
    private app.bolivia.swing.JCTextField txf_BookType;
    private app.bolivia.swing.JCTextField txf_Publisher;
    private app.bolivia.swing.JCTextField txf_Quantity;
    private app.bolivia.swing.JCTextField txf_Title;
    // End of variables declaration//GEN-END:variables
}
