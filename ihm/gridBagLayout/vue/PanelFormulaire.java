package vue;
import javax.swing.JComboBox;
import javax.swing.JLabel ;
import javax.swing.JPanel ;
import javax.swing.JButton ;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import modele.Date;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout ;
import java.awt.Insets;
import java.awt.event.ActionEvent;

public class PanelFormulaire extends JPanel {
	JButton ajoutDate = new JButton("+");
	JTextField textTitre = new JTextField();
	JTextField textLieu = new JTextField();
	//JTextField textDescription ;
	
	public PanelFormulaire() {
		GridBagLayout gestionnaire = new GridBagLayout();
		this.setLayout(gestionnaire);
		GridBagConstraints contraintes = new GridBagConstraints();
		contraintes.fill = GridBagConstraints.BOTH ;
		contraintes.insets = new Insets(10, 10, 10, 10) ;
		
		//contraintes.anchor = GridBagConstraints.WEST ;
		//contraintes.gridheight = 2 ;
		JLabel afficheDate = new JLabel(new Date().toString());// on affiche la date courante
		this.add(afficheDate, contraintes) ;
		
		//contraintes.anchor = GridBagConstraints.EAST ;
		//contraintes.gridwidth = 1 ;
		//contraintes.fill = GridBagConstraints.NONE ;// à modif
		//contraintes.anchor = GridBagConstraints.EAST ;// à modif
		contraintes.gridx = 7 ;// on place le boutton plus loin à droite
		
		this.add(ajoutDate, contraintes) ;
		
		contraintes.fill = GridBagConstraints.BOTH ;
		contraintes.gridx = 0 ;
		contraintes.gridy = 2 ;
		contraintes.gridheight = 1 ;
		contraintes.fill = GridBagConstraints.BOTH ;
		JLabel labelTitre = new JLabel("Titre", JLabel.LEFT);// étiquette "Titre"
		labelTitre.setDisplayedMnemonic('T');
		this.add(labelTitre, contraintes);
		
		contraintes.gridx = 6 ;
		this.add(textTitre, contraintes) ;
		
		
		contraintes.gridx = 0 ;
		contraintes.gridy = 3 ;
		JLabel labelLieu = new JLabel("Lieu", JLabel.LEFT);// étiquette "Lieu"
		labelLieu.setDisplayedMnemonic('L');
		this.add(labelLieu, contraintes);
		
		contraintes.gridx = 6 ;
		this.add(textLieu, contraintes) ;
		
		
		contraintes.gridx = 0 ;
		contraintes.gridy = 4 ;
		JLabel labelDebut = new JLabel("Début", JLabel.LEFT);// étiquette "Début"
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
		this.add(new JComboBox(heures), contraintes);// ajout des heures
		
		contraintes.gridx = 7 ;
		this.add(new JLabel(":"), contraintes);// ajout ":"
		
		contraintes.gridx = 8 ;
		String minutes[] = new String[60];
		for(int i = 0 ; i < 60 ; i++) {
			if(i < 10)
				minutes[i] = "0"+i ;
			else
				minutes[i] = ""+i ;
		}
		this.add(new JComboBox(minutes), contraintes);// ajout des minutes
		
		
		contraintes.insets = new Insets(10,10,10,10);
		contraintes.gridx = 0 ;
		contraintes.gridy = 5 ;
		JLabel labelFin = new JLabel("Fin", JLabel.LEFT);// étiquette "Fin"
		labelFin.setDisplayedMnemonic('F');
		this.add(labelFin, contraintes);
		
		contraintes.insets = new Insets(0,10,0,10);
		contraintes.gridx = 6 ;
		this.add(new JComboBox(heures), contraintes);
		
		contraintes.gridx = 7 ;
		this.add(new JLabel(":"), contraintes);
		
		contraintes.gridx = 8 ;
		this.add(new JComboBox(minutes), contraintes);
		// Fin JComboBox
		
		
		contraintes.insets = new Insets(10,10,10,10);
		contraintes.fill = GridBagConstraints.BOTH ;
		contraintes.gridx = 0 ;
		contraintes.gridy = 6 ;
		JLabel labelDescription = new JLabel("Description");
		labelDescription.setDisplayedMnemonic('e');
		this.add(labelDescription, contraintes);
		
		contraintes.gridx = 6 ;
		JTextArea textDescription = new JTextArea(10,20);
		this.add(textDescription, contraintes) ;
	}
	

}
