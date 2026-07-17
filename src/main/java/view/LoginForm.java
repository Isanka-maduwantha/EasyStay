package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.MaterialLiteTheme;

public class LoginForm extends JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginForm.class.getName());

    // UI Components
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel5;
    private JTextField txt_uname;
    private JPasswordField txt_psswd;
    private JCheckBox chb_remember;
    private JLabel lbl_message_uname;
    private JLabel lbl_message_psswd;
    private JLabel lbl_message;
    private JButton btn_login;

    // Modern Color Palette
    private final Color PRIMARY_DARK = new Color(30, 41, 59);    // Slate 800
    private final Color ACCENT_GRAY = new Color(100, 116, 139);   // Slate 500
    private final Color BG_LIGHT = new Color(241, 245, 249);      // Slate 100
    private final Color CARD_BG = new Color(255, 255, 255);       // Solid White
    private final Color COLOR_ERROR = new Color(239, 68, 68);     // Soft Red
    private final Color COLOR_SUCCESS = new Color(34, 197, 94);   // Soft Green

    public LoginForm() {
        initComponents();
    }

    private void initComponents() {
        // Instantiate components
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        txt_uname = new JTextField();
        jLabel3 = new JLabel();
        txt_psswd = new JPasswordField();
        chb_remember = new JCheckBox();
        lbl_message_uname = new JLabel();
        jLabel5 = new JLabel();
        lbl_message_psswd = new JLabel();
        lbl_message = new JLabel();
        btn_login = new JButton();

        // Base Window Config
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1280, 720));
        setResizable(false);

        // Base backgrounds
        jPanel1.setBackground(BG_LIGHT);
        jPanel2.setBackground(CARD_BG);
        jPanel2.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        // Typography Hierarchy
        jLabel1.setFont(new Font("SansSerif", Font.BOLD, 36));
        jLabel1.setForeground(PRIMARY_DARK);
        jLabel1.setText("EasyStay Login");

        jLabel5.setFont(new Font("SansSerif", Font.ITALIC, 14));
        jLabel5.setForeground(ACCENT_GRAY);
        jLabel5.setText("Your dream stay awaits!");

        jLabel2.setFont(new Font("SansSerif", Font.BOLD, 12));
        jLabel2.setForeground(PRIMARY_DARK);
        jLabel2.setText("Username");

        txt_uname.setFont(new Font("SansSerif", Font.PLAIN, 14));
        txt_uname.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(203, 213, 225), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        jLabel3.setFont(new Font("SansSerif", Font.BOLD, 12));
        jLabel3.setForeground(PRIMARY_DARK);
        jLabel3.setText("Password");

        txt_psswd.setFont(new Font("SansSerif", Font.PLAIN, 14));
        txt_psswd.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(203, 213, 225), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        chb_remember.setFont(new Font("SansSerif", Font.PLAIN, 12));
        chb_remember.setForeground(ACCENT_GRAY);
        chb_remember.setBackground(CARD_BG);
        chb_remember.setSelected(true);
        chb_remember.setText("Remember me on this device");

        lbl_message_uname.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lbl_message_uname.setForeground(COLOR_ERROR);

        lbl_message_psswd.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lbl_message_psswd.setForeground(COLOR_ERROR);

        lbl_message.setFont(new Font("SansSerif", Font.BOLD, 13));
        lbl_message.setHorizontalAlignment(SwingConstants.CENTER);

        btn_login.setBackground(PRIMARY_DARK);
        btn_login.setForeground(Color.WHITE);
        btn_login.setFont(new Font("SansSerif", Font.BOLD, 14));
        btn_login.setText("Log In");
        btn_login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_login.setFocusPainted(false);
        btn_login.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Action binding
        btn_login.addActionListener(this::btn_loginActionPerformed);

        // inner container setup
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbl_message, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_uname)
                                        .addComponent(lbl_message_uname, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_psswd)
                                        .addComponent(lbl_message_psswd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(chb_remember, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_login, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addGap(24, 24, 24)
                                .addComponent(lbl_message, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_uname, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_message_uname, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_psswd, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_message_psswd, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(chb_remember)
                                .addGap(24, 24, 24)
                                .addComponent(btn_login, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(40, Short.MAX_VALUE))
        );

        // Outer Wrapper layout
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(410, Short.MAX_VALUE)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(410, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(110, Short.MAX_VALUE)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(110, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {
        String username = txt_uname.getText().trim();
        String password = new String(txt_psswd.getPassword()).trim();

        lbl_message_uname.setText("");
        lbl_message_psswd.setText("");
        lbl_message.setText("");

        boolean hasError = false;

        if (username.isEmpty()) {
            lbl_message_uname.setText("Username cannot be empty");
            hasError = true;
        }

        if (password.isEmpty()) {
            lbl_message_psswd.setText("Password cannot be empty");
            hasError = true;
        }

        if (hasError) {
            return;
        }

        if (new controller.LoginController().validateLogin(username, password)) {
            lbl_message.setForeground(COLOR_SUCCESS);
            lbl_message.setText("Login Successful! Redirecting...");

            javax.swing.Timer timer = new javax.swing.Timer(1500, e -> {
                this.dispose();
                new Dashboard().setVisible(true);
            });
            timer.setRepeats(false);
            timer.start();
        } else {
            lbl_message.setForeground(COLOR_ERROR);
            lbl_message.setText("Invalid Username or Password");
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel(new MaterialLiteTheme()));
        } catch (Exception ex) {
            System.out.println("Error setting LookAndFeel in view.LoginForm.main()");
        }
        java.awt.EventQueue.invokeLater(() -> new LoginForm().setVisible(true));
    }
}