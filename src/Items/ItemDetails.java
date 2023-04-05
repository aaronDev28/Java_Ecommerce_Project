/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items;

import AdminPage.AdminPanelHomePage;
import Cart.Cart;
import LoginPage.DBConnection;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Aaron
 */
public class ItemDetails extends javax.swing.JFrame {

    DBConnection conn;
    int itemId;
    private Cart CartInstance;
    /**
     * Creates new form ItemDetails
     */
    public ItemDetails(int itemId, Cart CartInstance) {
        initComponents();
        conn = new DBConnection();
        this.itemId = itemId;
        this.CartInstance = CartInstance;
        populateTextFields();
    }

    public void populateTextFields() {
        java.sql.Connection dbconn = conn.connectDB();
        
        try {
                PreparedStatement st = dbconn.prepareStatement("SELECT * FROM products WHERE id = ?");
            
                st.setInt(1, itemId);

                ResultSet res = st.executeQuery();

                if(res.next()) {
                    ID_NameTextField.setText(res.getString("name"));
                    ID_PriceTextField.setText(String.valueOf(res.getDouble("price")));
                    ID_DescriptionTextField.setText(res.getString("description"));
                    
                    byte[] img = res.getBytes("image");
                    ImageIcon image = new ImageIcon(img);
                    Image im = image.getImage();
                    Image myimg = im.getScaledInstance(img1.getWidth(), img1.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon newImage = new ImageIcon(myimg);
                    img1.setIcon(newImage);
                    
                    
                } else {                   
                    JOptionPane.showMessageDialog(this, "Item not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            
                res.close();
                st.close();
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AdminPanelHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        ID_AddToCart = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        CancelButton = new javax.swing.JButton();
        ID_NameLabel = new javax.swing.JLabel();
        ID_NameTextField = new javax.swing.JTextField();
        ID_DescriptionLabel = new javax.swing.JLabel();
        ID_DescriptionTextField = new javax.swing.JTextField();
        ID_PriceLabel = new javax.swing.JLabel();
        ID_PriceTextField = new javax.swing.JTextField();
        img1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ID_AddToCart.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ID_AddToCart.setText("Add Item To Cart");
        ID_AddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_AddToCartActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(72, 202, 228));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Item Details");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        CancelButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CancelButton.setText("Close");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        ID_NameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ID_NameLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        ID_NameLabel.setText("Name");

        ID_NameTextField.setEditable(false);
        ID_NameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        ID_DescriptionLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ID_DescriptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        ID_DescriptionLabel.setText("Description");

        ID_DescriptionTextField.setEditable(false);
        ID_DescriptionTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ID_DescriptionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_DescriptionTextFieldActionPerformed(evt);
            }
        });

        ID_PriceLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ID_PriceLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        ID_PriceLabel.setText("Price");

        ID_PriceTextField.setEditable(false);
        ID_PriceTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ID_PriceTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        ID_PriceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_PriceTextFieldActionPerformed(evt);
            }
        });

        img1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ID_AddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ID_NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ID_PriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ID_DescriptionLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ID_DescriptionTextField)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ID_NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ID_PriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(img1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(74, 74, 74)))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID_NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ID_NameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID_PriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ID_PriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(img1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ID_DescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ID_DescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID_AddToCart)
                    .addComponent(CancelButton))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ID_AddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_AddToCartActionPerformed

            this.CartInstance.AddToCart(itemId, ID_NameTextField.getText(), Double.parseDouble(ID_PriceTextField.getText()), 1);
            JOptionPane.showMessageDialog(this, "Item added to cart.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_ID_AddToCartActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        dispose();
        this.setVisible(false);
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void ID_DescriptionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_DescriptionTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_DescriptionTextFieldActionPerformed

    private void ID_PriceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_PriceTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_PriceTextFieldActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton ID_AddToCart;
    private javax.swing.JLabel ID_DescriptionLabel;
    private javax.swing.JTextField ID_DescriptionTextField;
    private javax.swing.JLabel ID_NameLabel;
    private javax.swing.JTextField ID_NameTextField;
    private javax.swing.JLabel ID_PriceLabel;
    private javax.swing.JTextField ID_PriceTextField;
    private javax.swing.JLabel img1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
