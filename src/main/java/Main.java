
import javax.swing.UIManager;
import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.MaterialLiteTheme;
import view.LoginForm;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author orian
 */
public class Main {
    
    public static void main(String [] args){
        System.setProperty("java.awt.headless", "false");
                try 
       {
             UIManager.setLookAndFeel(new MaterialLookAndFeel(new MaterialLiteTheme()));
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
        } catch (Exception ex) {
            System.out.println("view.Dashboard.main()");
        }
        java.awt.EventQueue.invokeLater(() -> new LoginForm().setVisible(true));

    }
}
