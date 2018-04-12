package modele;

import java.util.TreeSet;

import javax.swing.table.DefaultTableModel;

public class ModeleTable extends DefaultTableModel {

	private static final long serialVersionUID = 1L;
	static final int nbrEvts = 15 ;
    static final String labelJours[] = {"lu ", "ma ", "me ", "je ", "ve ", "sa ", "di "} ;
    AgendaV2 agenda;

	public ModeleTable(Date parDate, AgendaV2 parAgenda) {
		agenda = parAgenda;
		this.setColumnCount(7);
		this.setRowCount(nbrEvts);
		Date date = parDate.datePremierJourSemaine() ;
		for(int jour=0 ; jour<7 ; jour++) {
			labelJours[jour] += date.getChJour();
			date = date.dateDuLendemain();
		}// lun 9  ma 10  me 11 ...
		this.setColumnIdentifiers(labelJours);
		TreeSet <Evenement> evts = agenda.getEvenementsSemaine(parDate);
		if(evts != null) {
			System.out.println("A");
			for(Evenement evt : evts) {
				ajoutEvenement(evt);
				System.out.println("B");
			}
		}
	}// ModeleTable()

	private void ajoutEvenement(Evenement evt) {
		int indiceCol = evt.getChDate().getJourSemaine()-2 ;
		int indiceLig = 0 ;
		for( ; indiceLig<ModeleTable.nbrEvts && getValueAt(indiceLig, indiceCol) != null ; indiceLig++);
		setValueAt(evt.getChTitre(), indiceLig, indiceCol);
	}// ajoutEvenement()

	public boolean isCellEditable(int indiceLig, int indiceCol) {
		return false ;
	}// isCellEditable()

	public Class getColumnClass(int parNum) {
		return Evenement.class ;
	}// getColumnClass()
}// ModeleTable