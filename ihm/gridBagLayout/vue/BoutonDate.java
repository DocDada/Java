package vue ;

import javax.swing.JButton;

import modele.Date;

public class BoutonDate extends JButton{

	private static final long serialVersionUID = 1L;
	private Date date ;
	
	public BoutonDate(String string) {
		super(string) ;
	}
	
	public void setDate(Date date) {
		this.date = date ;
	}
	
	public Date getDate() {
		return date ;
	}
}
