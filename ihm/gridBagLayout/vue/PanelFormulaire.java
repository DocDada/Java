package vue;
import javax.swing.JComboBox;
import javax.swing.JLabel ;
import javax.swing.JPanel ;
import javax.swing.JButton ;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controleur.Controleur;

import java.util.GregorianCalendar ;
import java.util.Calendar ;

import modele.Date;
import modele.AgendaV2 ;
import modele.Evenement;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout ;
import java.awt.Insets;

public class PanelFormulaire extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton ajoutDate = new JButton("+");
	JTextField textTitre = new JTextField();
	JTextField textLieu = new JTextField();
    JTextArea textDescription = new JTextArea(10,20);
    Date dateFormulaire = new Date() ;// la date courante
    GregorianCalendar calendrier = new GregorianCalendar() ;
	//JTextField textDescription ;
	AgendaV2 agd ;
    JLabel afficheDate ;
    
    JComboBox<String> boxHeures ;
    JComboBox<String> boxMinutes ;
    JComboBox<String> boxHeuresF ;
    JComboBox<String> boxMinutesF ;

	public PanelFormulaire() {
		GridBagLayout gestionnaire = new GridBagLayout();
		this.setLayout(gestionnaire);
		GridBagConstraints contraintes = new GridBagConstraints();
		contraintes.fill = GridBagConstraints.BOTH ;
		contraintes.insets = new Insets(10, 10, 10, 10) ;
		
		// 0 : texte
		// 6 : objet (JTextField, JComboBox)
		// 7 : ":" ou JButton "+"
		// 8 : Autre JComboBox
		
		
		//contraintes.anchor = GridBagConstraints.WEST ;
		//contraintes.gridheight = 2 ;
		afficheDate = new JLabel(dateFormulaire.toString());// on affiche l'Agenda
		this.add(afficheDate, contraintes) ;

        // ajout d'une Date � l'Agenda
		//contraintes.anchor = GridBagConstraints.EAST ;
		//contraintes.gridwidth = 1 ;
		//contraintes.fill = GridBagConstraints.NONE ;// � modif
		//contraintes.anchor = GridBagConstraints.EAST ;// � modif
		contraintes.gridx = 7 ;// on place le boutton plus loin � droite
		this.add(ajoutDate, contraintes) ;
        //ajoutDate.addActionListener(this) ;// le bouton se met � l'�coute
        ajoutDate.setActionCommand("+");

		// �tiquette "Titre"
		//contraintes.fill = GridBagConstraints.BOTH ;
		contraintes.gridx = 0 ;
		contraintes.gridy = 2 ;
		/*contraintes.gridheight = 1 ;
		contraintes.gridwidth = 1 ;*/
		contraintes.fill = GridBagConstraints.BOTH ;
		JLabel labelTitre = new JLabel("Titre", JLabel.LEFT);
		labelTitre.setDisplayedMnemonic('T');
		labelTitre.setLabelFor(textTitre);
		this.add(labelTitre, contraintes);

        // saisie du Titre
		contraintes.gridx = 6 ;
		this.add(textTitre, contraintes) ;
        textTitre.grabFocus() ;
		
		
		// �tiquette "Lieu"
		contraintes.gridx = 0 ;
		contraintes.gridy = 3 ;
		JLabel labelLieu = new JLabel("Lieu", JLabel.LEFT);
		labelLieu.setDisplayedMnemonic('L');
		labelLieu.setLabelFor(textLieu);
		this.add(labelLieu, contraintes);

        // saisie du Lieu
		contraintes.gridx = 6 ;
		this.add(textLieu, contraintes) ;
		
		
		// �tiquette "D�but"
		contraintes.gridx = 0 ;
		contraintes.gridy = 4 ;
		JLabel labelDebut = new JLabel("D�but", JLabel.LEFT);
		labelDebut.setDisplayedMnemonic('D');
		
		this.add(labelDebut, contraintes);

		// JComboBox
		//contraintes.insets = new Insets(0,10,0,10);
		//contraintes.fill = GridBagConstraints.NONE ;
		//contraintes.anchor = GridBagConstraints.WEST ;
		contraintes.gridx = 6 ;
		//contraintes.fill = GridBagConstraints.NONE ;
		String heures[] = new String[24];
		for(int i = 0 ; i < 24 ; i++) {
				heures[i] = ""+i ;
		}
        boxHeures = new JComboBox<String>(heures) ;
        boxHeures.setSelectedItem(String.valueOf(calendrier.get(Calendar.HOUR_OF_DAY))) ;
        // l'heure actuelle sera affich�e/s�lectionn�e
		this.add(boxHeures, contraintes);// ajout des heures

		// ":"
		contraintes.gridx = 7 ;
		this.add(new JLabel(":"), contraintes);

		contraintes.gridx = 8 ;
		String[] minutes = new String[60];
		for(int i = 0 ; i < 60 ; i++)
			minutes[i] = ""+i ;
        boxMinutes = new JComboBox<String>(minutes) ;
        boxMinutes.setSelectedItem(String.valueOf(calendrier.get(Calendar.MINUTE))) ;
        // la minute actuelle sera affich�e/s�lectionn�e
		this.add(boxMinutes, contraintes);// ajout des minutes


		// �tiquette "Fin"
		//contraintes.insets = new Insets(10,10,10,10);
		contraintes.gridx = 0 ;
		contraintes.gridy = 5 ;
		JLabel labelFin = new JLabel("Fin", JLabel.LEFT);
		labelFin.setDisplayedMnemonic('F');
		this.add(labelFin, contraintes);

        // saisie des heures (Fin)
		//contraintes.insets = new Insets(0,10,0,10);
		contraintes.gridx = 6 ;
		boxHeuresF = new JComboBox<String>(heures) ;
		this.add(boxHeuresF, contraintes);

        // ":"
		contraintes.gridx = 7 ;
		this.add(new JLabel(":"), contraintes);

        // saisie des minutes (Fin)
		contraintes.gridx = 8 ;
		boxMinutesF = new JComboBox<String>(minutes) ;
		this.add(boxMinutesF, contraintes);
		// Fin JComboBox
		
		
        // �tiquette "Description"
		//contraintes.insets = new Insets(10,10,10,10);
		contraintes.fill = GridBagConstraints.BOTH ;
		contraintes.gridx = 0 ;
		contraintes.gridy = 6 ;
		JLabel labelDescription = new JLabel("Description");
		labelDescription.setDisplayedMnemonic('e');
		labelDescription.setLabelFor(labelDescription);
		this.add(labelDescription, contraintes);

        // zone de saisie (Dexcription)
		contraintes.gridx = 6 ;
		this.add(textDescription, contraintes) ;
	}// PanelFormuaire()

    public void setDate(Date parDate) {
        this.dateFormulaire = parDate ;
    }// setDate

    /*
    public void actionPerformed(ActionEvent parEvt) {
        if(parEvt.getSource()==this.ajoutDate) {
            //agd.ajout(new Evenement(new Date(), this.textTitre.getText(), this.textLieu.getText()));
        	int un = Integer.parseInt((String) boxHeures.getSelectedItem());
        	int deux = Integer.parseInt((String) boxMinutes.getSelectedItem());
        	int trois = Integer.parseInt((String) boxHeuresF.getSelectedItem());
        	int quatre = Integer.parseInt((String) boxMinutesF.getSelectedItem());
        	agd.ajout(new Evenement(new Date(), this.textTitre.getText(), this.textLieu.getText(), un, deux, trois, quatre));
            System.out.println(agd);
            
            this.textTitre.setText("") ;
            this.textLieu.setText("") ;
            this.textDescription.setText("") ;
            this.textTitre.requestFocus() ;// le champ "Titre" est s�lectionn�
        }
     // le nouvel �v�nement date du jour m�me
     // on prend le titre et le lieu entr�s dans les cases par l'utilisateur
    }// actionPerformed
    */
    
    public JTextField getTextTitre() {
    	return this.textTitre ;
    }



	public Evenement getEvenement() {
		return new Evenement(this.getDateFormulaire(), textTitre.getText(), textLieu.getText());
	}

	public Date getDateFormulaire() {
		return dateFormulaire;
	}

	public void setAfficheDate(Date parD) {
		this.afficheDate.setText(parD.toString());
	}

	public void reset() {
		// TODO Auto-generated method stub
		this.textTitre.setText(new String()) ;
        this.textLieu.setText(new String()) ;
        this.textDescription.setText(new String()) ;
        
        boxMinutes.setSelectedItem(String.valueOf(calendrier.get(Calendar.MINUTE))) ;
        boxHeures.setSelectedItem(String.valueOf(calendrier.get(Calendar.HOUR_OF_DAY))) ;
        this.textTitre.requestFocus() ;// le champ "Titre" est s�lectionn�
	}

	public void enregistreEcouteur(Controleur parC) {
		ajoutDate.addActionListener(parC) ;
	}

}