package view;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.MaterialLiteTheme;
import org.kordamp.ikonli.materialdesign2.MaterialDesignC;
import org.kordamp.ikonli.swing.FontIcon;

/**
 * Combined and Corrected ReservationForm
 * @author orian
 */
public class ReservationForm extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ReservationForm.class.getName());

    /**
     * Creates new form Reservation
     */
    public ReservationForm() {
        // 1. Initialize all NetBeans visual components
        initComponents();

        // 2. Safely integrate the NavBar without destroying the visual form
        NavBar bar = new NavBar();

        // We capture the NetBeans components into a wrapper or assign NavBar to NORTH
        // so the generated layout isn't wiped clean.
        this.add(bar, BorderLayout.NORTH);

        // 3. Set up the DocumentListeners properly ONCE during initialization
        setupDocumentListeners();

        // 4. Force the JFrame to recalculate its layout and display components
        this.revalidate();
        this.repaint();
    }

    /**
     * Centralized setup for text fields to track real-time typing events safely
     */
    private void setupDocumentListeners() {
        txt_customer.getDocument().addDocumentListener(new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) { validateCustomer(); }
            @Override public void removeUpdate(DocumentEvent e) { validateCustomer(); }
            @Override public void changedUpdate(DocumentEvent e) { validateCustomer(); }
        });

        txt_room.getDocument().addDocumentListener(new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) { validateRoom(); }
            @Override public void removeUpdate(DocumentEvent e) { validateRoom(); }
            @Override public void changedUpdate(DocumentEvent e) { validateRoom(); }
        });
    }

    private void validateCustomer() {
        String cusId = txt_customer.getText();
        FontIcon materialIconCheck = FontIcon.of(MaterialDesignC.CHECK);
        FontIcon materialIconClose = FontIcon.of(MaterialDesignC.CLOSE);

        materialIconCheck.setIconSize(24);
        materialIconCheck.setIconColor(Color.GREEN);
        materialIconClose.setIconSize(24);
        materialIconClose.setIconColor(Color.RED);

        if (cusId == null || cusId.trim().isEmpty()) {
            lbl_customer_valid.setIcon(null);
            lbl_customer_valid.setText("");
            return;
        }

        if (new controller.CustomerController().customerExist(cusId)) {
            lbl_customer_valid.setIcon(materialIconCheck);
        } else {
            lbl_customer_valid.setIcon(materialIconClose);
        }
    }

    private void validateRoom() {
        String roomId = txt_room.getText();
        FontIcon materialIconCheck = FontIcon.of(MaterialDesignC.CHECK);
        FontIcon materialIconClose = FontIcon.of(MaterialDesignC.CLOSE);

        materialIconCheck.setIconSize(24);
        materialIconCheck.setIconColor(Color.GREEN);
        materialIconClose.setIconSize(24);
        materialIconClose.setIconColor(Color.RED);

        if (roomId == null || roomId.trim().isEmpty()) {
            lbl_room_valid.setIcon(null);
            lbl_room_valid.setText("");
            return;
        }

        if (new controller.RoomController().roomExist(roomId)) {
            lbl_room_valid.setIcon(materialIconCheck);
            lbl_amount.setText(new controller.RoomController().roomPrice(txt_room.getText()));
        } else {
            lbl_room_valid.setIcon(materialIconClose);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_customer = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lbl_customer_valid = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_room = new javax.swing.JTextField();
        lbl_room_valid = new javax.swing.JLabel();
        cmb_payment_type = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_amount = new javax.swing.JLabel();
        btn_clear = new javax.swing.JButton();
        btn_make_reservation = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lbl_message = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 600));

        jLabel1.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 14)); // NOI18N
        jLabel1.setText("Reservation");

        jLabel2.setText("Customer Id ");

        jLabel3.setText("Room Id");

        cmb_payment_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Card" }));

        jLabel5.setText("Payment Method");

        jLabel6.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        jLabel6.setText("Amount");

        lbl_amount.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        lbl_amount.setText("0000.00");

        btn_clear.setText("Clear");
        btn_clear.addActionListener(this::btn_clearActionPerformed);

        btn_make_reservation.setText("Reserve");
        btn_make_reservation.addActionListener(this::btn_make_reservationActionPerformed);

        jButton3.setText("Check-in");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(343, 343, 343)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(cmb_payment_type, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(jLabel6)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                                        .addComponent(lbl_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(txt_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel1))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lbl_customer_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(txt_room, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lbl_room_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel3)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(lbl_message, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(btn_make_reservation, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(276, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_room, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_room_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_customer_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmb_payment_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbl_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                .addGap(34, 34, 34)
                                .addComponent(lbl_message, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn_make_reservation)
                                        .addComponent(jButton3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_clear)
                                .addContainerGap(139, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_make_reservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_make_reservationActionPerformed
        String room_id = txt_room.getText();
        String cus_id = txt_customer.getText();
        String amount = lbl_amount.getText();

        if(room_id.isEmpty() || cus_id.isEmpty() || amount.isEmpty()) {
            lbl_message.setText("Please fill all fields");
            lbl_message.setForeground(Color.RED);
        } else {
            if(new controller.ReservationController().addReservation(cus_id, room_id, amount)){
                System.out.println("Reservation Saved");
                lbl_message.setText("Reserved Successfully!");
                lbl_message.setForeground(Color.GREEN);
            }
        }
    }//GEN-LAST:event_btn_make_reservationActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        lbl_amount.setText("0000.00");
        lbl_customer_valid.setIcon(null);
        lbl_room_valid.setIcon(null);
        txt_room.setText("");
        txt_customer.setText("");
        lbl_message.setText("Cleared");
        lbl_message.setForeground(Color.BLUE);
    }//GEN-LAST:event_btn_clearActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel(new MaterialLiteTheme()));
        } catch (Exception ex) {
            System.out.println("Could not load Look and Feel theme.");
        }

        java.awt.EventQueue.invokeLater(() -> new ReservationForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_make_reservation;
    private javax.swing.JComboBox<String> cmb_payment_type;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbl_amount;
    private javax.swing.JLabel lbl_customer_valid;
    private javax.swing.JLabel lbl_message;
    private javax.swing.JLabel lbl_room_valid;
    private javax.swing.JTextField txt_customer;
    private javax.swing.JTextField txt_room;
    // End of variables declaration//GEN-END:variables
}