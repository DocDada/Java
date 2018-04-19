package vue;

import java.awt.Color;

import javax.swing.JButton;

import modele.Date;

public class BoutonDate extends JButton {

    private static final long serialVersionUID = 1L;
    private Date date;
    private boolean estDateCourante;

    public BoutonDate(Date parDate) {
        super(Integer.toString(parDate.getChJour()));
        Date today = new Date();
        date = parDate;
        estDateCourante = (today.getChJour() == parDate.getChJour() && today.getChMois() == parDate.getChMois());
        this.setCouleurs();
    }// BoutonDate()

    ////////////////
    // ACCESSEURS //
    // ET         //
    // MODIFIEURS //
    ////////////////

    public void setDate(Date date) {
        this.date = date;
    }// setDate()

    public Date getDate() {
        return date;
    }// getDate()

    public void setCouleurs() {
        if (estDateCourante)
            this.setForeground(Color.RED);

        this.setBackground(Color.WHITE);
    }// setCouleurs()
}// BoutonDate