/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ivanderlibrary;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author mfarr
 */
public class BorrowBook extends javax.swing.JFrame {

    /**
     * Creates new form Homepage
     */
    public BorrowBook() {
        initComponents();
    }
        private void clearTextField(){
        txf_BookID.setText(null);
        txf_CustomerID.setText(null);
        DateC_IssueDate.setDatoFecha(null);
        DateC_DueDate.setDatoFecha(null);
    }
    public void getBookDetails(int BookID){
        try{
            Connection cn = ConnectionDB.getConnection();
            String sql = "select * from book_details where BookID = ?";
            PreparedStatement prp = cn.prepareStatement(sql);
            prp.setInt(1, BookID);
            ResultSet rs = prp.executeQuery();
            
            if(rs.next()){
                emp_BookID.setText(Integer.toString(rs.getInt("BookID")));
                emp_Title.setText(rs.getString("Title"));
                emp_Author.setText(rs.getString("Author"));
                emp_Publisher.setText(rs.getString("Publisher"));
                emp_BookType.setText(rs.getString("BookType"));
                emp_Quantity.setText(Integer.toString(rs.getInt("Quantity")));
            } else {
                lbl_invalidBookID.setText("INVALID BOOK ID");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void getCustomerDetails(int CustomerID){
        
        try{
            Connection cn = ConnectionDB.getConnection();
            String sql = "select * from customer where CustomerID = ?";
            PreparedStatement prp = cn.prepareStatement(sql);
            prp.setInt(1, CustomerID);
            ResultSet rs = prp.executeQuery();
            
            if(rs.next()){
                emp_CustID.setText(Integer.toString(rs.getInt("CustomerID")));
                emp_Name.setText(rs.getString("Name"));
                emp_PhoneNum.setText(Integer.toString(rs.getInt("PhoneNumber")));
                emp_Gender.setText(rs.getString("Gender"));               
            }else {
                lbl_invalidCustID.setText("INVALID CUSTOMER ID");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public boolean issueBook(int BookID, int CustomerID){
        boolean isIssued = false;
        Date IssueDate = DateC_IssueDate.getDatoFecha();
        Date DueDate = DateC_DueDate.getDatoFecha();
        
        Long L1 = IssueDate.getTime();
        Long L2 = DueDate.getTime();
        
        java.sql.Date LIssueDate = new java.sql.Date(L1);
        java.sql.Date LDueDate = new java.sql.Date(L2);
        
        int UserID = 1;
        try{
            Connection cn = ConnectionDB.getConnection();
            String sql = "INSERT INTO issue_book( UserID, BookID, CustomerID, IssueDate, DueDate, Status) VALUES (?,?,?,?,?,?);";
            PreparedStatement prp = cn.prepareStatement(sql);
            
            prp.setInt(1, 1);
            prp.setInt(2, BookID);
            prp.setInt(3, CustomerID);
            prp.setDate(4, LIssueDate);
            prp.setDate(5, LDueDate);
            prp.setString(6, "Issued");
            
            int rowCount = prp.executeUpdate();
            if(rowCount > 0){
                isIssued = true;
            }else {
                isIssued = false;
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
        return isIssued;
    }

    public void updateQuantity(int BookID){
        try{
            Connection cn = ConnectionDB.getConnection();
            String sql = "update book_details set Quantity = Quantity - 1 where BookID = ?";
            PreparedStatement prp = cn.prepareStatement(sql);
            prp.setInt(1, BookID);
            
            int rowCount = prp.executeUpdate();
            
            if(rowCount > 0 ){
                JOptionPane.showMessageDialog(this, "Updated");
                int QuantityBBook = Integer.parseInt(emp_Quantity.getText());
                emp_Quantity.setText(Integer.toString(QuantityBBook - 1));
            }else {
                JOptionPane.showMessageDialog(this, "Failed");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
   public boolean Issued(int BookID, int CustomerID){
       boolean Issued = false;
       
       try{
           Connection cn = ConnectionDB.getConnection();
           String sql = "select * from issue_book where BookID = ? and CustomerID = ? and status = ?";
           PreparedStatement prp = cn.prepareStatement(sql);
           prp.setInt(1, BookID);
           prp.setInt(2, CustomerID);
           prp.setString(3, "Issued");
           
           ResultSet rs = prp.executeQuery();
           
           if(rs.next()) {
               Issued = true;
           }else {
               Issued = false;
           }
       }catch (Exception e){
           e.printStackTrace();
       }
       return Issued;
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
        txf_BookID = new app.bolivia.swing.JCTextField();
        btn_IssueDate = new javax.swing.JButton();
        txf_CustomerID = new app.bolivia.swing.JCTextField();
        DateC_IssueDate = new rojeru_san.componentes.RSDateChooser();
        DateC_DueDate = new rojeru_san.componentes.RSDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        emp_Author = new javax.swing.JLabel();
        emp_Title = new javax.swing.JLabel();
        emp_Publisher = new javax.swing.JLabel();
        emp_BookType = new javax.swing.JLabel();
        emp_Quantity = new javax.swing.JLabel();
        emp_BookID = new javax.swing.JLabel();
        lbl_invalidBookID = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        emp_CustID = new javax.swing.JLabel();
        emp_Name = new javax.swing.JLabel();
        emp_PhoneNum = new javax.swing.JLabel();
        emp_Gender = new javax.swing.JLabel();
        lbl_invalidCustID = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
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
        jLabel15.setText("Book ID");

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Customer ID");

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Issue Date");

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Due Date");

        txf_BookID.setBackground(new java.awt.Color(229, 178, 153));
        txf_BookID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 132, 108)));
        txf_BookID.setForeground(new java.awt.Color(0, 0, 0));
        txf_BookID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txf_BookID.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txf_BookID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txf_BookIDFocusLost(evt);
            }
        });
        txf_BookID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_BookIDActionPerformed(evt);
            }
        });

        btn_IssueDate.setBackground(new java.awt.Color(180, 132, 108));
        btn_IssueDate.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_IssueDate.setForeground(new java.awt.Color(255, 255, 255));
        btn_IssueDate.setText("Issue Book");
        btn_IssueDate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_IssueDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_IssueDateActionPerformed(evt);
            }
        });

        txf_CustomerID.setBackground(new java.awt.Color(229, 178, 153));
        txf_CustomerID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 132, 108)));
        txf_CustomerID.setForeground(new java.awt.Color(0, 0, 0));
        txf_CustomerID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txf_CustomerID.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txf_CustomerID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txf_CustomerIDFocusLost(evt);
            }
        });

        DateC_IssueDate.setBackground(new java.awt.Color(252, 222, 192));
        DateC_IssueDate.setForeground(new java.awt.Color(0, 0, 0));
        DateC_IssueDate.setColorBackground(new java.awt.Color(229, 178, 153));
        DateC_IssueDate.setColorButtonHover(new java.awt.Color(180, 132, 108));
        DateC_IssueDate.setColorDiaActual(new java.awt.Color(180, 132, 108));
        DateC_IssueDate.setColorForeground(new java.awt.Color(0, 0, 0));
        DateC_IssueDate.setColorSelForeground(new java.awt.Color(252, 222, 192));
        DateC_IssueDate.setColorTextDiaActual(new java.awt.Color(252, 222, 192));
        DateC_IssueDate.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        DateC_IssueDate.setFormatoFecha("yyyy-MM-dd");
        DateC_IssueDate.setFuente(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        DateC_IssueDate.setPlaceholder("Input Date");

        DateC_DueDate.setBackground(new java.awt.Color(252, 222, 192));
        DateC_DueDate.setForeground(new java.awt.Color(0, 0, 0));
        DateC_DueDate.setColorBackground(new java.awt.Color(229, 178, 153));
        DateC_DueDate.setColorButtonHover(new java.awt.Color(180, 132, 108));
        DateC_DueDate.setColorDiaActual(new java.awt.Color(180, 132, 108));
        DateC_DueDate.setColorForeground(new java.awt.Color(0, 0, 0));
        DateC_DueDate.setColorSelForeground(new java.awt.Color(252, 222, 192));
        DateC_DueDate.setColorTextDiaActual(new java.awt.Color(252, 222, 192));
        DateC_DueDate.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        DateC_DueDate.setFormatoFecha("yyyy-MM-dd");
        DateC_DueDate.setFuente(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        DateC_DueDate.setPlaceholder("Input Date");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txf_BookID, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                    .addComponent(txf_CustomerID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_IssueDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DateC_IssueDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DateC_DueDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txf_BookID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txf_CustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DateC_IssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DateC_DueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btn_IssueDate)
                .addGap(158, 158, 158))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 690));

        jPanel5.setBackground(new java.awt.Color(252, 222, 192));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(229, 178, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Book ID    :");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 27, -1, 30));

        jLabel27.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Quantity   :");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 369, -1, 30));

        jLabel29.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Author      :");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 157, -1, 30));

        jLabel30.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Publisher :");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 229, -1, 30));

        jLabel31.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("BookType:");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 297, 96, 30));

        jLabel33.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Title          :");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 92, 95, 30));

        emp_Author.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        emp_Author.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(emp_Author, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 157, 249, 30));

        emp_Title.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        emp_Title.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(emp_Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 92, 249, 30));

        emp_Publisher.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        emp_Publisher.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(emp_Publisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 229, 249, 30));

        emp_BookType.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        emp_BookType.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(emp_BookType, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 297, 249, 30));

        emp_Quantity.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        emp_Quantity.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(emp_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 369, 249, 30));

        emp_BookID.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        emp_BookID.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(emp_BookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 27, 252, 30));

        lbl_invalidBookID.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_invalidBookID.setForeground(new java.awt.Color(255, 0, 0));
        lbl_invalidBookID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbl_invalidBookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 424, 330, 30));

        jPanel5.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 360, 460));

        jPanel2.setBackground(new java.awt.Color(229, 178, 153));

        jLabel32.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Customer ID     :");

        jLabel28.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Gender              :");

        jLabel34.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Name                 :");

        jLabel35.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Phone Number :");

        emp_CustID.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        emp_CustID.setForeground(new java.awt.Color(0, 0, 0));

        emp_Name.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        emp_Name.setForeground(new java.awt.Color(0, 0, 0));

        emp_PhoneNum.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        emp_PhoneNum.setForeground(new java.awt.Color(0, 0, 0));

        emp_Gender.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        emp_Gender.setForeground(new java.awt.Color(0, 0, 0));

        lbl_invalidCustID.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_invalidCustID.setForeground(new java.awt.Color(255, 0, 0));
        lbl_invalidCustID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_invalidCustID, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emp_CustID, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emp_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emp_PhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emp_Gender, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emp_CustID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(emp_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(emp_PhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emp_Gender, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addComponent(lbl_invalidCustID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 360, -1));

        jLabel25.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("Borrow Book");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 170, 30));

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
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 63, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 780, 690));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_IssueDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_IssueDateActionPerformed

       if(emp_Quantity.getText().equals("0")){
           JOptionPane.showMessageDialog(this, "Book is not available");
       }else{
       if(Issued(Integer.parseInt(txf_BookID.getText()), Integer.parseInt(txf_CustomerID.getText())) == false){
           
        if(issueBook(Integer.parseInt(txf_BookID.getText()), Integer.parseInt(txf_CustomerID.getText()) ) == true){
            JOptionPane.showMessageDialog(this, "Succes");
            updateQuantity(Integer.parseInt(txf_BookID.getText()));
            clearTextField();
        }else{
            JOptionPane.showMessageDialog(this, "Failed");
        }
       }else{
           JOptionPane.showMessageDialog(this, "Customer Already has this book");
       }
       }
    }//GEN-LAST:event_btn_IssueDateActionPerformed

    private void txf_BookIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_BookIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_BookIDActionPerformed

    private void txf_BookIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txf_BookIDFocusLost
        if(!txf_BookID.getText().equals("")){
            getBookDetails(Integer.parseInt(txf_BookID.getText()));
        }
    }//GEN-LAST:event_txf_BookIDFocusLost

    private void txf_CustomerIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txf_CustomerIDFocusLost
            if(!txf_CustomerID.getText().equals("")){
            getCustomerDetails(Integer.parseInt(txf_CustomerID.getText()));
        }
    }//GEN-LAST:event_txf_CustomerIDFocusLost

    private void btn_HomePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HomePageActionPerformed
        Homepage HPage = new Homepage();
        HPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_HomePageActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BorrowBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser DateC_DueDate;
    private rojeru_san.componentes.RSDateChooser DateC_IssueDate;
    private javax.swing.JButton btn_HomePage;
    private javax.swing.JButton btn_IssueDate;
    private javax.swing.JLabel emp_Author;
    private javax.swing.JLabel emp_BookID;
    private javax.swing.JLabel emp_BookType;
    private javax.swing.JLabel emp_CustID;
    private javax.swing.JLabel emp_Gender;
    private javax.swing.JLabel emp_Name;
    private javax.swing.JLabel emp_PhoneNum;
    private javax.swing.JLabel emp_Publisher;
    private javax.swing.JLabel emp_Quantity;
    private javax.swing.JLabel emp_Title;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbl_invalidBookID;
    private javax.swing.JLabel lbl_invalidCustID;
    private app.bolivia.swing.JCTextField txf_BookID;
    private app.bolivia.swing.JCTextField txf_CustomerID;
    // End of variables declaration//GEN-END:variables
}
