package vue;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
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

    ///////////////////////
    //                   //
    //   CONSTRUCTEURS   //
    //                   //
    ///////////////////////

    public PanelAffichage(AgendaV2 parAgenda) {
        agenda = parAgenda;
        date = new Date();
        setModele(new ModeleTable(date, agenda));
        tableSemaine = new JTable(getModele());// tableSemaine.setModel(modele)
        tableSemaine.setRowHeight(60);// hauteur des lignes
        
        // un objet se met à l'écoute des actions de la souris sur la table
        // affiche dans une boîte de dialogue l'événement d'un jour
        tableSemaine.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JTable table = (JTable) evt.getSource();
                ModeleTable model = (ModeleTable) table.getModel();
                Point point = evt.getPoint();
                int ligIndex = table.rowAtPoint(point);
                int colIndex= table.columnAtPoint(point);
                JOptionPane.showMessageDialog(table, model.getValueAt(ligIndex, colIndex));
            }
        });
        
        // association du renderer à la table
        tableSemaine.setDefaultRenderer(modele.getColumnClass(0), new CelluleRenderer());
        
        // scrollpane nécessaire pour visualiser l'en-tête
        JScrollPane scrollPane = new JScrollPane(tableSemaine, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        this.add(scrollPane);
    }// PanelAffichage()

    //////////////////////
    //                  //
    //     METHODES     //
    //                  //
    //////////////////////

    public void ajoutEvenement(Evenement evenement) {
        modele.ajoutEvenement(evenement);
        tableSemaine = new JTable(getModele());// tableSemaine.setModel(modele)
    }

    //////////////////////
    //                  //
    //    ACCESSEURS    //
    //        ET        //
    //    MODIFIEURS    //
    //                  //
    //////////////////////

    public void setDate(ModeleTable model) {
        setModele(model);
        tableSemaine.setModel(this.modele);
    }// setDate()

    public ModeleTable getModele() {
        return modele;
    }

    public void setModele(ModeleTable model) {
        this.modele = model;
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