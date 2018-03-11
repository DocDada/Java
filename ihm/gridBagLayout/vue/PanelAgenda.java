package vue;

import javax.swing.JLabel ;
import javax.swing.JPanel ;
import javax.swing.JButton ;
import javax.swing.ImageIcon ;

import modele.Agenda;
import modele.Date;
import modele.Evenement;

import java.awt.CardLayout ;
import java.awt.BorderLayout ;
import java.awt.event.ActionListener ;
import java.awt.event.ActionEvent ;


public class PanelAgenda extends JPanel {
	private static final long serialVersionUID = 1L;
	Agenda aged = new Agenda(3);
    PanelFormulaire panelF = new PanelFormulaire(aged) ;
    public PanelAgenda() {
        //boolean truc = aged.ajout(new Evenement(new Date(1,1,1999), "controle", "g26"));
        //boolean toto = aged.ajout(new Evenement(new Date(1,2,1999), "controle", "g26"));
        this.add(panelF) ;
    }



}
