package controleur ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modele.AgendaV2;
import modele.Date;
import outil.LectureEcriture;
import vue.BoutonDate;
import vue.PanelAffichage;
import vue.PanelCalendrier;
import vue.PanelFormulaire;

public class Controleur implements ActionListener {

	AgendaV2 agenda ;
	PanelFormulaire panelForm ;
	PanelCalendrier panelCale ;
	PanelAffichage panelAffi ;
	

	public Controleur(AgendaV2 agd, PanelFormulaire panelF, PanelCalendrier panelC, PanelAffichage panelA) {
		agenda = agd ;
		panelForm = panelF ;
		panelCale = panelC ;
		panelAffi = panelA ;
		panelForm.enregistreEcouteur(this) ;//le panel de saisie se met a l'ecoute
		panelCale.enregistreEcouteur(this) ;
	}// Controleur()

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("+")) {
			agenda.ajout(panelForm.getEvenement());
			// ecriture de l'agenda dans le fichier
			File fichier = new File("FileAgenda"+File.separator+"agendas.ser");
			LectureEcriture.ecriture(fichier, agenda);
			//JOptionPane.showMessageDialog((JButton) e.getSource(), agenda.toString());
			panelForm.reset() ;
			panelAffi.setDate(panelForm.getDateFormulaire());
		}
		else if (e.getSource().getClass().getSimpleName().equals("BoutonDate")) {
			Date date = ((BoutonDate) e.getSource()).getDate();
			panelForm.setDate(date);
			panelAffi.setDate(date);
		}
	}// actionPerformed()
}// Controleur