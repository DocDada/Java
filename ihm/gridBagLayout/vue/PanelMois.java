package vue;

import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.CalendrierDuMois;
import modele.Date;

public class PanelMois extends JPanel {

	private static final long serialVersionUID = 1L;
	private int mois ;
	private int lignes ;
	private CalendrierDuMois cal ;
	BoutonDate[] jours = new BoutonDate[42];
    String labelJours[] = {"lu", "ma", "me", "je", "ve", "sa", "di"} ;
    JLabel[] joursSemaine = new JLabel[7];

	public PanelMois(int mois) {
		this.mois = mois ;
		this.cal = new CalendrierDuMois(this.mois, new Date().getChAnnee()) ;

		for (int i = 0 ; i < labelJours.length ; i++) {
			joursSemaine[i] = new JLabel(labelJours[i]) ;
			joursSemaine[i].setHorizontalAlignment(JLabel.CENTER);
			this.add(joursSemaine[i]);
		}

		Iterator<Date> iter = cal.getDates().iterator() ;
		for (int i = 0 ; i<jours.length ; i++) {
			jours[i] = new BoutonDate(Integer.toString(iter.next().getChJour())) ;
			this.add(jours[i]) ;
		}
		this.setLayout(new GridLayout(lignes, 7, 20, 20)) ;
	}
	public int getMois() {
		return mois;
	}
	public void setMois(int mois) {
		this.mois = mois;
	}
}