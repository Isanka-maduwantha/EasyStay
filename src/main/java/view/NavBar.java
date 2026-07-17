package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class NavBar extends JPanel {

    // Theme Slate Palette
    private final Color SIDEBAR_BG = new Color(30, 41, 59);      // Slate 800
    private final Color BUTTON_BG = new Color(51, 65, 85);        // Slate 700 (Subtle highlight)
    private final Color TEXT_LIGHT = new Color(248, 250, 252);    // Slate 50
    private final Color SUBTITLE_GRAY = new Color(148, 163, 184); // Slate 400
    private final Color COLOR_ERROR = new Color(239, 68, 68);     // Accent Red for logout

    // UI Components
    private JButton btn_cusRegister;
    private JButton btn_dashboard;
    private JButton btn_logout;
    private JButton btn_reservation;
    private JButton btn_rooms;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel4;

    public NavBar() {
        initComponents();
    }

    private void initComponents() {
        jLabel4 = new JLabel();
        btn_reservation = new JButton();
        btn_dashboard = new JButton();
        btn_rooms = new JButton();
        jLabel2 = new JLabel();
        jButton5 = new JButton();
        jButton6 = new JButton();
        btn_cusRegister = new JButton();
        btn_logout = new JButton();
        jButton7 = new JButton();
        jLabel1 = new JLabel();

        // Panel Base Properties
        setBackground(SIDEBAR_BG);
        setPreferredSize(new Dimension(240, 720)); // Match desktop height nicely with extra breathing room
        setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(71, 85, 105)));

        // Category Sub-Headers
        setupCategoryHeader(jLabel2, "PAGES");
        setupCategoryHeader(jLabel4, "ACTIONS");
        setupCategoryHeader(jLabel1, "REPORTS");

        // Menu Navigation Buttons
        setupNavButton(btn_dashboard, "Dashboard");
        btn_dashboard.addActionListener(this::btn_dashboardActionPerformed);

        setupNavButton(btn_rooms, "Rooms Available");
        btn_rooms.addActionListener(this::btn_roomsActionPerformed);

        setupNavButton(jButton5, "Customers List");

        setupNavButton(btn_cusRegister, "Register Customer");
        btn_cusRegister.addActionListener(this::btn_cusRegisterActionPerformed);

        setupNavButton(btn_reservation, "New Reservation");
        btn_reservation.addActionListener(this::btn_reservationActionPerformed);

        setupNavButton(jButton6, "Reservation Report");
        setupNavButton(jButton7, "Financial Report");

        // Logout CTA Button
        btn_logout.setBackground(COLOR_ERROR);
        btn_logout.setForeground(Color.WHITE);
        btn_logout.setFont(new Font("SansSerif", Font.BOLD, 12));
        btn_logout.setText("Log Out");
        btn_logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_logout.setFocusPainted(false);
        btn_logout.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
        btn_logout.addActionListener(this::btn_logoutActionPerformed);

        // Layout alignment block
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_dashboard, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                        .addComponent(btn_rooms, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                        .addComponent(jButton5, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                        .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_cusRegister, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                        .addComponent(btn_reservation, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton6, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                        .addComponent(jButton7, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                        .addComponent(btn_logout, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_dashboard, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_rooms, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_cusRegister, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_reservation, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE) // Expands bottom gap flexibly
                                .addComponent(btn_logout, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
        );
    }

    private void setupNavButton(JButton button, String text) {
        button.setBackground(BUTTON_BG);
        button.setForeground(TEXT_LIGHT);
        button.setFont(new Font("SansSerif", Font.PLAIN, 13));
        button.setText("  " + text); // Add spacing to imitate an icon gap
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }

    private void setupCategoryHeader(JLabel label, String text) {
        label.setFont(new Font("SansSerif", Font.BOLD, 10));
        label.setForeground(SUBTITLE_GRAY);
        label.setText(text);
    }

    private void btn_cusRegisterActionPerformed(java.awt.event.ActionEvent evt) {
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window != null) {
            window.dispose();
            new CustomerRegister().setVisible(true);
        }
    }

    private void btn_dashboardActionPerformed(java.awt.event.ActionEvent evt) {
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window != null) {
            window.dispose();
            new Dashboard().setVisible(true);
        }
    }

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window != null) {
            window.dispose();
            new LoginForm().setVisible(true);
        }
    }

    private void btn_roomsActionPerformed(java.awt.event.ActionEvent evt) {
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window != null) {
            window.dispose();
            new Rooms().setVisible(true);
        }
    }

    private void btn_reservationActionPerformed(java.awt.event.ActionEvent evt) {
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window != null) {
            window.dispose();
            new ReservationForm().setVisible(true);
        }
    }

    // Event Listener bindings
    public void addDashboardListener(java.awt.event.ActionListener listener) {
        btn_dashboard.addActionListener(listener);
    }

    public void addRoomsListener(java.awt.event.ActionListener listener) {
        btn_rooms.addActionListener(listener);
    }

    public void addCustomersListener(java.awt.event.ActionListener listener) {
        jButton5.addActionListener(listener);
    }

    public void addCustomerRegisterListener(java.awt.event.ActionListener listener) {
        btn_cusRegister.addActionListener(listener);
    }

    public void addReservationListener(java.awt.event.ActionListener listener) {
        btn_reservation.addActionListener(listener);
    }

    public void addReportListener(java.awt.event.ActionListener listener) {
        jButton6.addActionListener(listener);
    }
}