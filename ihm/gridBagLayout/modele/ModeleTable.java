package modele;

import java.util.TreeSet;
import javax.swing.table.DefaultTableModel;

public class ModeleTable extends DefaultTableModel {

    private static final long serialVersionUID = 1L;
    static final int nbrEvts = 15;
    static final String labelJours[] = { "lu ", "ma ", "me ", "je ", "ve ", "sa ", "di " };
    private AgendaV2 agenda;

    public ModeleTable(Date parDate, AgendaV2 parAgenda) {
        agenda = parAgenda;

        this.setColumnCount(7);// nombre de colonnes (jours de la semaine)
        this.setRowCount(nbrEvts);// nombre de lignes (événements)

        Date date = parDate.datePremierJourSemaine();
        for (int jour = 0; jour < 7; jour++) {
            labelJours[jour] += date.getChJour();
            date = date.dateDuLendemain();
        } // lun 9 ma 10 me 11 ...
        this.setColumnIdentifiers(labelJours);

        // récupère les événements de la semaine entière
        TreeSet<Evenement> tableEvts = agenda.getEvenementsSemaine(parDate);

        // on ajoute les événements à la JTable
        if (tableEvts != null)
            for (Evenement evt : tableEvts)
                ajoutEvenement(evt);
    }// ModeleTable()

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

    public boolean isCellEditable(int indiceLig, int indiceCol) {
        return false;
    }// isCellEditable()

    public Class getColumnClass(int parNum) {
        return Evenement.class;
    }// getColumnClass()

    public AgendaV2 getAgenda() {
        return agenda;
    }

    public void setAgenda(AgendaV2 agenda) {
        this.agenda = agenda;
    }
}// ModeleTable