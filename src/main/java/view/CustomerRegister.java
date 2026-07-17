package view;

import controller.CustomerController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Cursor;
import java.sql.Date;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.LayoutStyle;
import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.MaterialLiteTheme;

public class CustomerRegister extends JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CustomerRegister.class.getName());

    // UI Components
    private JButton btn_reg;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JTextField txt_c_dob;
    private JTextField txt_c_email;
    private JTextField txt_c_nic;
    private JTextField txt_c_num;
    private JTextField txt_cname;
    private JLabel txt_message;
    private JPanel mainContainer;
    private JPanel formCard;

    // Palette Matchers
    private final Color PRIMARY_DARK = new Color(30, 41, 59);
    private final Color ACCENT_GRAY = new Color(100, 116, 139);
    private final Color BG_LIGHT = new Color(241, 245, 249);
    private final Color CARD_BG = new Color(255, 255, 255);
    private final Color COLOR_ERROR = new Color(239, 68, 68);
    private final Color COLOR_SUCCESS = new Color(34, 197, 94);

    public CustomerRegister() {
        initComponents();

        NavBar bar = new NavBar();
        this.setLayout(new BorderLayout());
        this.getContentPane().add(bar, BorderLayout.WEST);
        this.getContentPane().add(mainContainer, BorderLayout.CENTER);

        this.revalidate();
        this.repaint();
    }

    private void initComponents() {
        mainContainer = new JPanel();
        formCard = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        txt_cname = new JTextField();
        jLabel5 = new JLabel();
        txt_c_dob = new JTextField();
        jLabel6 = new JLabel();
        txt_c_email = new JTextField();
        txt_c_num = new JTextField();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        txt_c_nic = new JTextField();
        btn_reg = new JButton();
        txt_message = new JLabel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1280, 720));
        setSize(new Dimension(1280, 720));

        mainContainer.setBackground(BG_LIGHT);
        formCard.setBackground(CARD_BG);
        formCard.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                BorderFactory.createEmptyBorder(20, 30, 20, 30)
        ));

        jLabel2.setFont(new Font("SansSerif", Font.BOLD, 24));
        jLabel2.setForeground(PRIMARY_DARK);
        jLabel2.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel2.setText("Customer Registration");

        txt_message.setFont(new Font("SansSerif", Font.BOLD, 13));
        txt_message.setHorizontalAlignment(SwingConstants.CENTER);

        // Styling Form Field Methods helpers
        setupFieldLabel(jLabel1, "Full Name");
        setupTextField(txt_cname);

        setupFieldLabel(jLabel5, "Date of Birth (YYYY-MM-DD)");
        setupTextField(txt_c_dob);

        setupFieldLabel(jLabel6, "Email Address");
        setupTextField(txt_c_email);

        setupFieldLabel(jLabel7, "Phone Number");
        setupTextField(txt_c_num);

        setupFieldLabel(jLabel8, "NIC Number");
        setupTextField(txt_c_nic);

        btn_reg.setBackground(PRIMARY_DARK);
        btn_reg.setForeground(Color.WHITE);
        btn_reg.setFont(new Font("SansSerif", Font.BOLD, 14));
        btn_reg.setText("Register Customer");
        btn_reg.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_reg.setFocusPainted(false);
        btn_reg.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        btn_reg.addActionListener(this::btn_regActionPerformed);

        // Form alignment logic inside the white card
        GroupLayout formCardLayout = new GroupLayout(formCard);
        formCard.setLayout(formCardLayout);
        formCardLayout.setHorizontalGroup(
                formCardLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(formCardLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(formCardLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_message, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_cname)
                                        .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_c_dob)
                                        .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_c_email)
                                        .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_c_num)
                                        .addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_c_nic)
                                        .addComponent(btn_reg, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
                                .addContainerGap())
        );
        formCardLayout.setVerticalGroup(
                formCardLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(formCardLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_message, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cname, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_c_dob, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_c_email, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_c_num, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_c_nic, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(btn_reg, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        // Main Background Panel
        GroupLayout mainContainerLayout = new GroupLayout(mainContainer);
        mainContainer.setLayout(mainContainerLayout);
        mainContainerLayout.setHorizontalGroup(
                mainContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainContainerLayout.createSequentialGroup()
                                .addContainerGap(315, Short.MAX_VALUE)
                                .addComponent(formCard, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(315, Short.MAX_VALUE))
        );
        mainContainerLayout.setVerticalGroup(
                mainContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainContainerLayout.createSequentialGroup()
                                .addContainerGap(50, Short.MAX_VALUE)
                                .addComponent(formCard, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(50, Short.MAX_VALUE))
        );
    }

    private void setupTextField(JTextField field) {
        field.setFont(new Font("SansSerif", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(203, 213, 225), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
    }

    private void setupFieldLabel(JLabel label, String text) {
        label.setFont(new Font("SansSerif", Font.BOLD, 12));
        label.setForeground(PRIMARY_DARK);
        label.setText(text);
    }

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {
        String Name = txt_cname.getText().trim();
        String dob = txt_c_dob.getText().trim();
        String email = txt_c_email.getText().trim();
        String nic = txt_c_nic.getText().trim();
        String phone = txt_c_num.getText().trim();

        if (Name.isEmpty() || dob.isEmpty() || email.isEmpty() || nic.isEmpty() || phone.isEmpty()) {
            txt_message.setForeground(COLOR_ERROR);
            txt_message.setText("Fields cannot be left blank.");
        } else if (phone.length() != 10 || !phone.matches("\\d+")) {
            txt_message.setForeground(COLOR_ERROR);
            txt_message.setText("Invalid phone number sequence (must be 10 digits).");
        } else if (nic.length() != 12 || !nic.matches("\\d+")) {
            txt_message.setForeground(COLOR_ERROR);
            txt_message.setText("Invalid NIC Number (must be 12 digits).");
        } else if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            txt_message.setForeground(COLOR_ERROR);
            txt_message.setText("Invalid email address formatting.");
        } else {
            try {
                Date sqlDate = Date.valueOf(dob);
                if (new CustomerController().customerRegister(Name, email, phone, sqlDate, nic)) {
                    txt_message.setForeground(COLOR_SUCCESS);
                    txt_message.setText("Registration Successful!");

                    // Clear fields upon success
                    txt_cname.setText("");
                    txt_c_dob.setText("");
                    txt_c_email.setText("");
                    txt_c_num.setText("");
                    txt_c_nic.setText("");
                } else {
                    txt_message.setForeground(COLOR_ERROR);
                    txt_message.setText("Database registration was unsuccessful.");
                }
            } catch (IllegalArgumentException e) {
                txt_message.setForeground(COLOR_ERROR);
                txt_message.setText("Format mismatch. Use: YYYY-MM-DD");
            }
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel(new MaterialLiteTheme()));
        } catch (Exception ex) {
            System.out.println("Error setting look and feel in view.CustomerRegister.main()");
        }
        java.awt.EventQueue.invokeLater(() -> new CustomerRegister().setVisible(true));
    }
}