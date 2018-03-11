package vue;
import javax.swing.JComboBox;
import javax.swing.JLabel ;
import javax.swing.JPanel ;
import javax.swing.JButton ;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.util.GregorianCalendar ;
import java.util.Calendar ;
import modele.Date;
import modele.Agenda ;
import modele.Evenement;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout ;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelFormulaire extends JPanel implements ActionListener {
	JButton ajoutDate = new JButton("+");
	JTextField textTitre = new JTextField();
	JTextField textLieu = new JTextField();
    JTextArea textDescription = new JTextArea(10,20);
    Date dateFormulaire = new Date() ;// la date courante
    GregorianCalendar calendrier = new GregorianCalendar() ;
	//JTextField textDescription ;
	Agenda agd ;
    JLabel afficheDate ;

	public PanelFormulaire(Agenda parAgenda) {
        agd = parAgenda ;
		GridBagLayout gestionnaire = new GridBagLayout();
		this.setLayout(gestionnaire);
		GridBagConstraints contraintes = new GridBagConstraints();
		contraintes.fill = GridBagConstraints.BOTH ;
		contraintes.gridwidth = 5 ;
		contraintes.insets = new Insets(10, 10, 10, 10) ;
		
		//contraintes.anchor = GridBagConstraints.WEST ;
		//contraintes.gridheight = 2 ;
		afficheDate = new JLabel(dateFormulaire+"\n"+agd.toString());// on affiche l'Agenda
		this.add(afficheDate, contraintes) ;

        // ajout d'une Date à l'Agenda
		//contraintes.anchor = GridBagConstraints.EAST ;
		//contraintes.gridwidth = 1 ;
		//contraintes.fill = GridBagConstraints.NONE ;// à modif
		//contraintes.anchor = GridBagConstraints.EAST ;// à modif
		contraintes.gridx = 7 ;// on place le boutton plus loin à droite
		this.add(ajoutDate, contraintes) ;
        ajoutDate.addActionListener(this) ;// le bouton se met à l'écoute


		// étiquette "Titre"
		contraintes.fill = GridBagConstraints.BOTH ;
		contraintes.gridx = 0 ;
		contraintes.gridy = 2 ;
		contraintes.gridheight = 1 ;
		contraintes.gridwidth = 1 ;
		contraintes.fill = GridBagConstraints.BOTH ;
		JLabel labelTitre = new JLabel("Titre", JLabel.LEFT);
		labelTitre.setDisplayedMnemonic('T');
		this.add(labelTitre, contraintes);

        // saisie du Titre
		contraintes.gridx = 6 ;
		this.add(textTitre, contraintes) ;
        textTitre.grabFocus() ;
		
		
		// étiquette "Lieu"
		contraintes.gridx = 0 ;
		contraintes.gridy = 3 ;
		JLabel labelLieu = new JLabel("Lieu", JLabel.LEFT);
		labelLieu.setDisplayedMnemonic('L');
		this.add(labelLieu, contraintes);

        // saisie du Lieu
		contraintes.gridx = 6 ;
		this.add(textLieu, contraintes) ;
		
		
		// étiquette "Début"
		contraintes.gridx = 0 ;
		contraintes.gridy = 4 ;
		JLabel labelDebut = new JLabel("Début", JLabel.LEFT);
		labelDebut.setDisplayedMnemonic('D');
		this.add(labelDebut, contraintes);

		// JComboBox
		contraintes.insets = new Insets(0,10,0,10);
		contraintes.fill = GridBagConstraints.NONE ;
		//contraintes.anchor = GridBagConstraints.WEST ;
		contraintes.gridx = 6 ;
		//contraintes.fill = GridBagConstraints.NONE ;
		String heures[] = new String[24];
		for(int i = 0 ; i < 24 ; i++) {
			if(i < 10)
				heures[i] = "0"+i ;
			else
				heures[i] = ""+i ;
		}
        JComboBox boxHeures = new JComboBox(heures) ;
        boxHeures.setSelectedItem(String.valueOf(calendrier.get(Calendar.HOUR_OF_DAY))) ;
        // l'heure actuelle sera affichée/sélectionnée
		this.add(boxHeures, contraintes);// ajout des heures

		// ":"
		contraintes.gridx = 7 ;
		this.add(new JLabel(":"), contraintes);

		contraintes.gridx = 8 ;
		String minutes[] = new String[60];
		for(int i = 0 ; i < 60 ; i++) {
			if(i < 10)
				minutes[i] = "0"+i ;
			else
				minutes[i] = ""+i ;
		}
        JComboBox boxMinutes = new JComboBox(minutes) ;
        boxMinutes.setSelectedItem(String.valueOf(calendrier.get(Calendar.MINUTE))) ;
        // la minute actuelle sera affichée/sélectionnée
		this.add(boxMinutes, contraintes);// ajout des minutes


		// étiquette "Fin"
		contraintes.insets = new Insets(10,10,10,10);
		contraintes.gridx = 0 ;
		contraintes.gridy = 5 ;
		JLabel labelFin = new JLabel("Fin", JLabel.LEFT);
		labelFin.setDisplayedMnemonic('F');
		this.add(labelFin, contraintes);

        // saisie des heures (Fin)
		contraintes.insets = new Insets(0,10,0,10);
		contraintes.gridx = 6 ;
		this.add(new JComboBox(heures), contraintes);

        // ":"
		contraintes.gridx = 7 ;
		this.add(new JLabel(":"), contraintes);

        // saisie des minutes (Fin)
		contraintes.gridx = 8 ;
		this.add(new JComboBox(minutes), contraintes);
		// Fin JComboBox
		
		
        // étiquette "Description"
		contraintes.insets = new Insets(10,10,10,10);
		contraintes.fill = GridBagConstraints.BOTH ;
		contraintes.gridx = 0 ;
		contraintes.gridy = 6 ;
		JLabel labelDescription = new JLabel("Description");
		labelDescription.setDisplayedMnemonic('e');
		this.add(labelDescription, contraintes);

        // zone de saisie (Dexcription)
		contraintes.gridx = 6 ;
		this.add(textDescription, contraintes) ;
	}// PanelFormuaire()

    public void setDate(Date parDate) {
        this.dateFormulaire = parDate ;
    }// setDate

    public void actionPerformed(ActionEvent parEvt) {
        if(parEvt.getSource()==this.ajoutDate) {
            agd.ajout(new Evenement(new Date(), this.textTitre.getText(), this.textLieu.getText()));
            afficheDate.setText(agd.toString()) ;
            this.textTitre.setText("") ;
            this.textLieu.setText("") ;
            this.textDescription.setText("") ;
            this.textTitre.requestFocus() ;// le champ "Titre" est sélectionné
        }
        // le nouvel événement date du jour même
        // on prend le titre et le lieu entrés dans les cases par l'utilisateur
    }// actionPerformed


}
