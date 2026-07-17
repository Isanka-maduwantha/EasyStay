package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.MaterialLiteTheme;

public class Dashboard extends JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Dashboard.class.getName());

    // UI Components
    private ButtonGroup buttonGroupNavActions;
    private ButtonGroup buttonGroupNavPages;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JPanel jPanel2;
    private JPanel jPanel1;

    // Styling constants
    private final Color PRIMARY_DARK = new Color(30, 41, 59);
    private final Color BG_LIGHT = new Color(241, 245, 249);
    private final Color CARD_BG = new Color(255, 255, 255);

    public Dashboard() {
        initComponents();

        NavBar bar = new NavBar();
        this.setLayout(new BorderLayout());
        this.getContentPane().add(bar, BorderLayout.WEST); // Better layout side-docking for Navbar
        this.getContentPane().add(jPanel1, BorderLayout.CENTER);

        this.revalidate();
        this.repaint();
    }

    private void initComponents() {
        buttonGroupNavActions = new ButtonGroup();
        buttonGroupNavPages = new ButtonGroup();
        jLabel1 = new JLabel();
        jPanel2 = new JPanel();
        jLabel3 = new JLabel();
        jPanel1 = new JPanel(); // Plain backing panel to handle main view logic

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1280, 720));
        setSize(new Dimension(1280, 720));

        jPanel1.setBackground(BG_LIGHT);
        jPanel2.setBackground(CARD_BG);
        jPanel2.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        jLabel1.setFont(new Font("SansSerif", Font.BOLD, 24));
        jLabel1.setForeground(PRIMARY_DARK);
        jLabel1.setText("Dashboard Overview");

        jLabel3.setFont(new Font("SansSerif", Font.BOLD, 14));
        jLabel3.setForeground(PRIMARY_DARK);
        jLabel3.setText("Available Rooms");

        // Layout inner stats card (jPanel2)
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(150, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addContainerGap(60, Short.MAX_VALUE))
        );

        // Layout main container workspace (jPanel1)
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(700, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1)
                                .addGap(30, 30, 30)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(500, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel(new MaterialLiteTheme()));
        } catch (Exception ex) {
            System.out.println("Error initializing LookAndFeel in view.Dashboard.main()");
        }
        java.awt.EventQueue.invokeLater(() -> new Dashboard().setVisible(true));
    }
}