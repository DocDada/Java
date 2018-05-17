package modele;

import java.util.TreeSet;
import javax.swing.table.DefaultTableModel;

public class ModeleTable extends DefaultTableModel {

    private static final long serialVersionUID = 1L;
    static final int nbrEvts = 15;
    private String labelJours[] = { "lu ", "ma ", "me ", "je ", "ve ", "sa ", "di " };
    private String labelJoursSemaine[];
    private Date date;
    private AgendaV2 agenda;

    ///////////////////////
    //                   //
    //   CONSTRUCTEURS   //
    //                   //
    ///////////////////////

    public ModeleTable(Date parDate, AgendaV2 parAgenda) {
        agenda = parAgenda;
        setDate(parDate);

        this.setColumnCount(7);// nombre de colonnes (jours de la semaine)
        this.setRowCount(nbrEvts);// nombre de lignes (événements)

        this.entete(parDate);

        // récupère les événements de la semaine entière
        TreeSet<Evenement> tableEvts = agenda.getEvenementsSemaine(parDate);

        // on ajoute les événements à la JTable
        if (tableEvts != null)
            for (Evenement evt : tableEvts)
                ajoutEvenement(evt);
    }// ModeleTable()

    //////////////////////
    //                  //
    //     METHODES     //
    //                  //
    //////////////////////

    // avant : private
    public void ajoutEvenement(Evenement evt) {
        // dimanche = 1 => colonne 6
        // lundi = 2 => colonne 0 (retranche 2)
        int indiceCol;
        if (evt.getChDate().getJourSemaine() == 1)
            indiceCol = 6;
        else
            indiceCol = evt.getChDate().getJourSemaine() - 2;

        int indiceLig = 0;
        for (; indiceLig < ModeleTable.nbrEvts && getValueAt(indiceLig, indiceCol) != null; indiceLig++);
        if (ModeleTable.nbrEvts <= indiceLig)// si la JTable ne peut afficher cette événement
            return;
        setValueAt(evt.getChTitre(), indiceLig, indiceCol);
    }// ajoutEvenement()

    public void entete(Date parDate) {
        labelJoursSemaine = labelJours;
        Date date = parDate.datePremierJourSemaine();
        for (int jour = 0; jour < 7; jour++) {
            labelJoursSemaine[jour] += date.getChJour();
            date = date.dateDuLendemain();
        } // lun 9 ma 10 me 11 ...
        this.setColumnIdentifiers(labelJoursSemaine);
    }

    public boolean isCellEditable(int indiceLig, int indiceCol) {
        return false;
    }// isCellEditable()

    //////////////////////
    //                  //
    //    ACCESSEURS    //
    //        ET        //
    //    MODIFIEURS    //
    //                  //
    //////////////////////

    public Class getColumnClass(int parNum) {
        return Evenement.class;
    }// getColumnClass()

    public AgendaV2 getAgenda() {
        return agenda;
    }

    public void setAgenda(AgendaV2 agenda) {
        this.agenda = agenda;
    }

    public String[] getLabelJours() {
        return labelJours;
    }

    public void setLabelJours(String[] labelJours) {
        this.labelJours = labelJours;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}// ModeleTable