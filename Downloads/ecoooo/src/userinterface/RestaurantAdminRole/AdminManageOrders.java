/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.RestaurantAdminRole;

import Business.DeliveryMan.DeliveryMan;
import Business.Orders.Order;
import Business.Restaurant.Restaurant;
import java.awt.CardLayout;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author madhurimachatterjee
 */
public class AdminManageOrders extends javax.swing.JPanel {

    /**
     * Creates new form AdminManageOrders
     */
    JPanel userProcessContainer;
    Restaurant restaurant;
    public AdminManageOrders(JPanel userProcessContainer, Restaurant restaurant) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.restaurant = restaurant;
        btnAssignDeliveryMan.setEnabled(false);
        comboDeliveryMen.setEnabled(false);
        //comboDeliveryMen.setEnabled(true);
        btnDelete.setEnabled(false);
            //btnAssignDeliveryMan.setEnabled(true)
        valueLabel.setText(restaurant.getName());
        populateTable();
        comboDeliveryMen.addItem("");
        System.out.println(restaurant.getDeliveryManDirectory().getDeliveryManList().size());
        for(DeliveryMan dm : restaurant.getDeliveryManDirectory().getDeliveryManList())
        {
            System.out.println(dm.getName());
            comboDeliveryMen.addItem(dm.getName());
        }
    }
    
    public void populateTable()
    {
        DefaultTableModel dtm = (DefaultTableModel)tblOrders.getModel();
        dtm.setRowCount(0);
        if(restaurant.getOrderDirectory().getOrderList() != null)
        {
            for(Order order : restaurant.getOrderDirectory().getOrderList())
            {
                if(!order.isStatus())
                {
                    Object[] row = new Object[dtm.getColumnCount()];
                    row[0] = order;
                    row[1] = order.getCustomer().getName();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    row[2] = order.getOrderDate().format(formatter);
                    if(order.getDeliveryMan() == null)
                    {
                        row[3] = "";
                    }
                    else
                    {
                        row[3] = order.getDeliveryMan().getName();
                    }
                    dtm.addRow(row);
                }
            }
        }
        if(dtm.getRowCount() == 0)
            {
                comboDeliveryMen.setEnabled(false);
                btnAssignDeliveryMan.setEnabled(false);
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

        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrders = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAssignDeliveryMan = new javax.swing.JButton();
        comboDeliveryMen = new javax.swing.JComboBox<>();
        btnBack = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));

        enterpriseLabel.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        enterpriseLabel.setForeground(new java.awt.Color(0, 0, 204));
        enterpriseLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        enterpriseLabel.setText("Restaurant :");
        enterpriseLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        valueLabel.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        valueLabel.setForeground(new java.awt.Color(0, 0, 204));
        valueLabel.setText("<value>");
        valueLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order No.", "Customer Name", "Order Date", "Delivery Man"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrdersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblOrders);

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Current Orders");

        btnAssignDeliveryMan.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        btnAssignDeliveryMan.setForeground(new java.awt.Color(0, 0, 204));
        btnAssignDeliveryMan.setText("Assign Delivery Man");
        btnAssignDeliveryMan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAssignDeliveryMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignDeliveryManActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        btnBack.setForeground(new java.awt.Color(0, 0, 204));
        btnBack.setText("< Back");
        btnBack.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 0, 204));
        btnDelete.setText("Delete");
        btnDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(337, 337, 337))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(comboDeliveryMen, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(btnAssignDeliveryMan, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnDelete)))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAssignDeliveryMan)
                    .addComponent(comboDeliveryMen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(235, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblOrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrdersMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblOrders.getSelectedRow();
        if (selectedRow >= 0)
        {
            comboDeliveryMen.setEnabled(true);
            btnDelete.setEnabled(true);
            btnAssignDeliveryMan.setEnabled(true);
        }
    }//GEN-LAST:event_tblOrdersMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblOrders.getSelectedRow();
        if (selectedRow >= 0)
        {
            Order order = (Order) tblOrders.getValueAt(selectedRow, 0);
            restaurant.deleteOrder(order);
            JOptionPane.showMessageDialog(null, "Order deleted successfully!");
            populateTable();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Please select a row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAssignDeliveryManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignDeliveryManActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblOrders.getSelectedRow();
        if (selectedRow >= 0)
        {
            Order order = (Order) tblOrders.getValueAt(selectedRow, 0);
            if(comboDeliveryMen.getSelectedItem() != "")
            {
                String dmName = comboDeliveryMen.getSelectedItem().toString();
                DeliveryMan dm = restaurant.findDeliveryMan(dmName);
                order.setDeliveryMan(dm);
                JOptionPane.showMessageDialog(null, "Delivery man assigned successfully!");
                populateTable();
            }
            else
            {
               JOptionPane.showMessageDialog(null,"Please select a delivery man!", "Warning", JOptionPane.WARNING_MESSAGE);
                return; 
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Please select a row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnAssignDeliveryManActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignDeliveryMan;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JComboBox<String> comboDeliveryMen;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOrders;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
