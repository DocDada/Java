package controleur ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modele.AgendaV2;
import modele.Date;
import vue.BoutonDate;
import vue.PanelCalendrier;
import vue.PanelFormulaire;

public class Controleur implements ActionListener {
	AgendaV2 agenda ;
	PanelFormulaire panelForm ;
	PanelCalendrier panelCale ;
	
	public Controleur(AgendaV2 agd, PanelFormulaire panelF, PanelCalendrier panelC) {
		agenda = agd ;
		panelForm = panelF ;
		panelCale = panelC ;
		panelForm.enregistreEcouteur(this) ;//le panel de saisie se met a l'ecoute
		panelCale.enregistreEcouteur(this) ;
	}// Controleur()

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("+")) {
			agenda.ajout(panelForm.getEvenement());
			JOptionPane.showMessageDialog((JButton) e.getSource(), agenda.toString());
			panelForm.reset() ;
		}
		else if (e.getSource().getClass().getSimpleName().equals("BoutonDate")) {
			Date date = ((BoutonDate) e.getSource()).getDate();
			panelForm.setDate(date);
		}
	}// actionPerformed()
}// Controleur