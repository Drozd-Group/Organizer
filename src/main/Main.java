/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import frame.OrganizerFrame;

/**
 *
 * @author Дмитрий Белоус
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrganizerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        new OrganizerFrame().setVisible(true);
    }
}
