package vue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class FenetreAgenda extends JFrame implements Serializable, ActionListener {
    private static final long serialVersionUID = 1L;
    PanelAgendaV2 contentPane;
    public FenetreAgenda(String parTitre) {
        super(parTitre);
        contentPane = new PanelAgendaV2();
        // Calendrier, Evenement, Semaine, Fermer
        final String[] items = {"Calendrier", "Evenement", "Semaine", "Fermer"};
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        JMenu menu = new JMenu("IHM");
        menu.setMnemonic('M');
        for(String item:items) {
            JMenuItem itemMenu = new JMenuItem(item, item.charAt(0));
            itemMenu.setAccelerator(KeyStroke.getKeyStroke(item.charAt(0), java.awt.Event.CTRL_MASK));
            itemMenu.addActionListener(contentPane);
            itemMenu.setActionCommand(item);
            menu.add(itemMenu);
        }
        menuBar.add(menu);

        JScrollPane scroll = new JScrollPane(contentPane);
        setContentPane(scroll);
        contentPane.setBackground(new Color(33, 63, 59));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(new Color(62, 58, 59));
        setSize(900, 490);
        setVisible(true);
        contentPane.getPanelF().getTextTitre().requestFocus();
    }

    public static void main(String[] args) {
        new FenetreAgenda("IHM - TP4 - TP5 - TP6 - TP7 - TP8");
    }// main()

    public void actionPerformed(ActionEvent e) {
    }

}// FenetreAgenda