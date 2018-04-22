package vue;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import modele.AgendaV2;
import modele.Date;
import modele.Evenement;
import modele.ModeleTable;

public class PanelAffichage extends JPanel {

    private static final long serialVersionUID = 4566113147503848875L;
    private ModeleTable modele;
    private JTable tableSemaine;
    private AgendaV2 agenda;
    private Date date;
    private JScrollPane scrollPane;

    public PanelAffichage(AgendaV2 parAgenda) {
        agenda = parAgenda;
        date = new Date();
        setModele(new ModeleTable(date, agenda));
        tableSemaine = new JTable(getModele());// tableSemaine.setModel(modele)
        tableSemaine.setRowHeight(60);// hauteur des lignes
        // scrollpane nécessaire pour visualiser l'en-tête
        JScrollPane scrollPane = new JScrollPane(tableSemaine, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        this.add(scrollPane);
    }// PanelAffichage()

    public void setDate(Date parDate, AgendaV2 parAgenda) {
        date = parDate;
        /*
         * setModele(new ModeleTable(parDate, parAgenda)); tableSemaine = new
         * JTable(getModele()); tableSemaine.setRowHeight(60);// hauteur des lignes //
         * scrollpane nécessaire pour visualiser l'en-tête
         * 
         * this.remove(scrollPane);// ne marche pas scrollPane = new
         * JScrollPane(tableSemaine, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
         * ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); this.add(scrollPane);
         */
    }// setDate()

    public ModeleTable getModele() {
        return modele;
    }

    public void setModele(ModeleTable modele) {
        this.modele = modele;
    }

    public void ajoutEvenement(Evenement evenement) {
        modele.ajoutEvenement(evenement);
        tableSemaine = new JTable(getModele());// tableSemaine.setModel(modele)
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }
}// PanelAffichage