package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.Controleur;
import modele.CalendrierDuMois;
import modele.Date;

public class PanelMois extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private int mois ;
	private int lignes ;
	private CalendrierDuMois cal ;
	private BoutonDate[] jours = new BoutonDate[42];
    private static final String labelJours[] = {"lu", "ma", "me", "je", "ve", "sa", "di"} ;
    private JLabel[] joursSemaine = new JLabel[7];
    private BoutonDate boutonSelect ;


	public PanelMois(int mois) {
		this.mois = mois ;
		this.cal = new CalendrierDuMois(this.mois, new Date().getChAnnee()) ;

		// lu ma me je ve sa di
		for (int i = 0 ; i < labelJours.length ; i++) {
			joursSemaine[i] = new JLabel(labelJours[i]) ;
			joursSemaine[i].setHorizontalAlignment(JLabel.CENTER);
			this.add(joursSemaine[i]);
		}

		Date pourBouton = new Date();// pour stocker la valeur retournee par l'iterateur
		Iterator<Date> iter = cal.getDates().iterator() ;
		for (int i = 0 ; i<jours.length && iter.hasNext() ; i++) {
			pourBouton = iter.next();// stockage de la valeur retournee
			jours[i] = new BoutonDate(pourBouton) ;// assigne cette valeur au tableau
			if(pourBouton.getChMois()!=new Date().getChMois())
				jours[i].setForeground(Color.CYAN);
			jours[i].addActionListener(this);
			this.add(jours[i]) ;
		}
		boutonSelect = jours[0];
		this.setLayout(new GridLayout(lignes, 7, 20, 20)) ;
	}// PanelMois()


	////////////////
	// ACCESSEURS //
	//     ET     //
	// MODIFIEURS //
	////////////////

	public int getMois() {
		return mois;
	}// getMois()

	public void setMois(int mois) {
		this.mois = mois;
	}// setMois()

	public BoutonDate getJoursIndice(int indice) {
	    return this.jours[indice] ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boutonSelect.setBackground(Color.WHITE);// les dates non selectionnees sont en blanc
		boutonSelect = (BoutonDate)e.getSource();
		if (!boutonSelect.isSelected())// si le bouton n'a pas ete selectionne
			boutonSelect.setBackground(Color.LIGHT_GRAY);// la date est en grise
	}// actionPerformed()

	public void enregistreEcouteur(Controleur parC) {
		for(int i = 0 ; jours[i] != null && i<jours.length ; i++)
			jours[i].addActionListener(parC);
	}// enregistreEcouteur()
}// PanelMois