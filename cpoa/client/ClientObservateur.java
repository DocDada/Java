package client;

import java.io.File;
import java.util.Set;

import observateur.Abandons;
import observateur.Arrivees;
import observateur.Classements;
import observateur.Position;
import outils.LectureFichierXML;

public class ClientObservateur {
    public static void main(String[] args) {

        Set<Position> setPosition;
        Classements classements = new Classements();
        Abandons abandons = new Abandons();
        Arrivees arrivees = new Arrivees();

        classements.enregistreObservateur(abandons);
        classements.enregistreObservateur(arrivees);

        // reading of all xml files; display
        File[] files = new File("data_2018").listFiles();
        for (File aFile : files) {
            setPosition = LectureFichierXML.lecture(aFile);
            classements.ajoutClassement(setPosition);
            //System.out.println(setPosition);
            //System.out.println(abandons.count());
            System.out.println(arrivees);
        }
        System.out.println(abandons);
    }
}
