package vue;
import javax.swing.JComboBox;
import javax.swing.JLabel ;
import javax.swing.JPanel ;
import javax.swing.JScrollPane;
import javax.swing.JButton ;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout ;
import java.awt.Insets;
import java.util.GregorianCalendar ;
import java.util.Calendar ;
import controleur.Controleur;
import modele.Date;
import modele.AgendaV2 ;
import modele.Evenement;



public class PanelFormulaire extends JPanel {

	// CONSTANTE
	static final long serialVersionUID = 1L;
	static final String INTITULE_BOUTON = "+" ;
	final static Font FONT_DATE = new Font("Verdana", Font.BOLD, 14);
	final static Font FONT_LABEL = new Font("Verdana", Font.BOLD, 11);
	// DECLENCHEUR
	JButton ajoutDate = new JButton(INTITULE_BOUTON);
	// SAISIE
	JTextField textTitre = new JTextField(4);
	JTextField textLieu = new JTextField(4);
    JTextArea textDescription = new JTextArea(8,8);
    // AFFICHAGE
    Date dateFormulaire = new Date() ;// la date courante
    JLabel afficheDate ;
    GregorianCalendar calendrier = new GregorianCalendar() ;
    AgendaV2 agd ;
    // HEURES + MINUTES (DEBUT + FIN)
    JComboBox<String> boxHeures ;
    JComboBox<String> boxMinutes ;
    JComboBox<String> boxHeuresF ;
    JComboBox<String> boxMinutesF ;

    public PanelFormulaire() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints contraintes = new GridBagConstraints();
		contraintes.anchor = GridBagConstraints.WEST ;
		contraintes.insets = new Insets(6, 6, 6, 6) ;
		//LABEL
		afficheDate = new JLabel(dateFormulaire.toString(), JLabel.LEFT);// date courante
		JLabel labelTitre = new JLabel("Titre", JLabel.LEFT);
		JLabel labelLieu = new JLabel("Lieu", JLabel.LEFT);
		JLabel labelDebut = new JLabel("Début", JLabel.LEFT);
		JLabel labelFin = new JLabel("Fin", JLabel.LEFT);
		JLabel labelDescription = new JLabel("Description", JLabel.LEFT);
		
		// date d'aujourd'hui
		contraintes.gridx = 0 ;
		contraintes.gridy = 0 ;
		contraintes.gridwidth = 4 ;
		this.add(afficheDate, contraintes) ;
		
		// Bouton d'ajout des evenements
		contraintes.gridx = 4 ;
		contraintes.gridwidth = 1 ;
		ajoutDate.setActionCommand(INTITULE_BOUTON);
		this.add(ajoutDate, contraintes) ;
		
		// labelTitre + textTitre
		contraintes.gridy++ ;
		contraintes.gridx = 0 ;
		this.add(labelTitre, contraintes);
        contraintes.gridwidth = 4 ;
        contraintes.gridx++ ;
        contraintes.fill = GridBagConstraints.HORIZONTAL ;
        this.add(textTitre, contraintes) ;
		contraintes.fill = GridBagConstraints.NONE ;
		
		// labelLieu + textLieu
		contraintes.gridy++ ;
		contraintes.gridx = 0 ;
		contraintes.gridwidth = 1 ;
		this.add(labelLieu, contraintes);
		contraintes.gridx++ ;
		contraintes.gridwidth = 4 ;
		contraintes.fill = GridBagConstraints.HORIZONTAL ;
		this.add(textLieu, contraintes) ;
		contraintes.fill = GridBagConstraints.NONE ;
		
		// heure de debut
		contraintes.gridy++ ;
		contraintes.gridx = 0 ;
		contraintes.gridwidth = 1 ;
		this.add(labelDebut, contraintes);
		contraintes.gridx++ ;
		String heures[] = new String[24];
		for(int i = 0 ; i < 24 ; i++) {
				heures[i] = ""+i ;
		}
        boxHeures = new JComboBox<String>(heures) ;
        boxHeures.setSelectedItem(String.valueOf(calendrier.get(Calendar.HOUR_OF_DAY))) ;
        // l'heure actuelle sera affichée/sélectionnée
		this.add(boxHeures, contraintes);// ajout des heures
		contraintes.gridx++ ;
		this.add(new JLabel(":"), contraintes);
		contraintes.gridx++ ;
		String[] minutes = new String[60];
		// saisie de sminutes
		for(int i = 0 ; i < 60 ; i++)
			minutes[i] = ""+i ;
        boxMinutes = new JComboBox<String>(minutes) ;
        boxMinutes.setSelectedItem(String.valueOf(calendrier.get(Calendar.MINUTE))) ;
        // la minute actuelle sera affichee/selectionnee
		this.add(boxMinutes, contraintes);// ajout des minutes
		
		// heure de fin
		contraintes.gridy++ ;
		contraintes.gridx = 0 ;
		this.add(labelFin, contraintes);
		contraintes.gridx++ ;
		boxHeuresF = new JComboBox<String>(heures) ;
		this.add(boxHeuresF, contraintes);
		contraintes.gridx++ ;		
		this.add(new JLabel(":"), contraintes);
		contraintes.gridx++ ;
        // saisie des minutes
		boxMinutesF = new JComboBox<String>(minutes) ;
		this.add(boxMinutesF, contraintes);
		
		// labelDescription + textDescription
		contraintes.gridy++ ;
		contraintes.gridx = 0 ;
		contraintes.anchor = GridBagConstraints.NORTHWEST ;
		this.add(labelDescription, contraintes);
		contraintes.gridx++ ;
		contraintes.gridwidth = 4 ;
		contraintes.fill = GridBagConstraints.BOTH ;
		this.add(new JScrollPane(textDescription), contraintes) ;
		
		afficheDate.setFont(FONT_DATE) ;
		ajoutDate.setFont(FONT_DATE);
		ajoutDate.setFocusPainted(false);
		
		labelTitre.setFont(FONT_LABEL);
		labelTitre.setDisplayedMnemonic('T');
		labelTitre.setLabelFor(textTitre);
		
		labelLieu.setFont(FONT_LABEL);
		labelLieu.setDisplayedMnemonic('L');
		labelLieu.setLabelFor(textLieu);
		
		labelDebut.setFont(FONT_LABEL);
		labelDebut.setDisplayedMnemonic('D');
		labelDebut.setLabelFor(boxHeures);
		
		labelFin.setFont(FONT_LABEL);
		labelFin.setDisplayedMnemonic('F');

		labelDescription.setFont(FONT_LABEL);
		labelDescription.setDisplayedMnemonic('e');
		labelDescription.setLabelFor(labelDescription);
		

		reset() ;
	}// PanelFormuaire()

    public void setDate(Date parDate) {
        this.dateFormulaire = parDate ;
    }// setDate
    
    public JTextField getTextTitre() {
    	return this.textTitre ;
    }

	public Evenement getEvenement() {
		/*
		int h1 = Integer.parseInt((String) boxHeures.getSelectedItem());
    	int m1 = Integer.parseInt((String) boxMinutes.getSelectedItem());
    	int h2 = Integer.parseInt((String) boxHeuresF.getSelectedItem());
    	int m2 = Integer.parseInt((String) boxMinutesF.getSelectedItem());
    	return new Evenement(getDateFormulaire(), textTitre.getText(), textLieu.getText(), h1, m1, h2, m2) ;
    	*/
		return new Evenement(getDateFormulaire(), textTitre.getText(), textLieu.getText());
	}

	public Date getDateFormulaire() {
		return dateFormulaire;
	}

	public void setAfficheDate(Date parD) {
		this.afficheDate.setText(parD.toString());
	}

	public void reset() {
		this.textTitre.setText(new String()) ;
        this.textLieu.setText(new String()) ;
        this.textDescription.setText(new String()) ;
        
        boxMinutes.setSelectedItem(String.valueOf(calendrier.get(Calendar.MINUTE))) ;
        boxHeures.setSelectedItem(String.valueOf(calendrier.get(Calendar.HOUR_OF_DAY))) ;
        this.textTitre.requestFocus() ;// le champ "Titre" est sélectionné
	}

	public void enregistreEcouteur(Controleur parC) {
		ajoutDate.addActionListener(parC) ;
	}

}