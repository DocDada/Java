package tp10JavaFX;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class IntegratingJavaFXintoSwingApplication {

    private static void initAndShowGUI() {
        JFrame frame = new JFrame("Swing and JavaFX");
        frame.setContentPane(new PanelContentPane());
        frame.setSize(900, 900);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initAndShowGUI();
            }
        });
    }
}