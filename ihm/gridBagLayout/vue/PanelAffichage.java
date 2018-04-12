package vue;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import modele.AgendaV2;
import modele.Date;
import modele.ModeleTable;



public class PanelAffichage extends JPanel {

	private static final long serialVersionUID = 4566113147503848875L;
	ModeleTable modele ;
	JTable tableSemaine ;
	AgendaV2 agenda ;

	public PanelAffichage(AgendaV2 parAgenda) {
		agenda = parAgenda ;
		modele = new ModeleTable(new Date(), agenda);
		tableSemaine = new JTable(modele);// tableSemaine.setModel(modele)
		tableSemaine.setRowHeight(60);// hauteur des lignes
		JScrollPane scrollPane = new JScrollPane(tableSemaine, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(600, 400));
		this.add(scrollPane);
	}// PanelAffichage()

	public void setDate(Date parDate) {
		modele = new ModeleTable(parDate, agenda);
		tableSemaine = new JTable(modele);
	}// setDate()
}// PanelAffichage