package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;

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

		for (int i = 0 ; i < labelJours.length ; i++) {
			joursSemaine[i] = new JLabel(labelJours[i]) ;
			joursSemaine[i].setHorizontalAlignment(JLabel.CENTER);
			this.add(joursSemaine[i]);
		}
		Date pourBouton =new Date();
		Iterator<Date> iter = cal.getDates().iterator() ;
		for (int i = 0 ; i<jours.length && iter.hasNext() ; i++) {
			pourBouton = iter.next();
			jours[i] = new BoutonDate(pourBouton) ;
			if(pourBouton.getChMois()!=new Date().getChMois())
				jours[i].setForeground(Color.CYAN);
			jours[i].addActionListener(this);
			this.add(jours[i]) ;
		}
		boutonSelect = jours[0];
		this.setLayout(new GridLayout(lignes, 7, 20, 20)) ;
	}
	public int getMois() {
		return mois;
	}
	public void setMois(int mois) {
		this.mois = mois;
	}
	public BoutonDate getJoursIndice(int indice) {
	    return this.jours[indice] ;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		boutonSelect.setBackground(Color.WHITE);// les dates non selectionnees sont en blanc
		boutonSelect = (BoutonDate)e.getSource();
		if (!boutonSelect.isSelected())// si le bouton n'a pas ete selectionne
			boutonSelect.setBackground(Color.LIGHT_GRAY);// la date est en grise
	}
}