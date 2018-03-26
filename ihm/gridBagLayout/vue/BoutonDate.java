package vue ;

import java.awt.Color;

import javax.swing.JButton;

import modele.Date;

public class BoutonDate extends JButton{

	private static final long serialVersionUID = 1L;
	private Date date ;
	private boolean estDateCourante ;
	
	public BoutonDate(Date parDate) {
		super(Integer.toString(parDate.getChJour())) ;
		Date today = new Date();
		estDateCourante = (today.getChJour()==parDate.getChJour() && today.getChMois()==parDate.getChMois());
		this.setCouleurs();
	}
	
	public void setDate(Date date) {
		this.date = date ;
	}
	
	public Date getDate() {
		return date ;
	}
	
	public void setCouleurs() {
		if(estDateCourante)
			this.setBackground(Color.RED);
		else
			this.setBackground(Color.WHITE);
	}
}
