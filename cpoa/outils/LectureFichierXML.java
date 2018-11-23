package outils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import observateur.Position;

public class LectureFichierXML {

    public static Set lecture(File adresse) {

        Set arbrePositions = new HashSet();
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream(adresse));
            NodeList listeElementReleve = document
                    .getElementsByTagName("position");
            for (int i = 0; i < listeElementReleve.getLength(); i++) {
                Element courant = (Element) listeElementReleve.item(i);
                String nom = courant.getAttribute("nom");
                if (!nom.isEmpty()) {

                    String skipper = courant.getAttribute("skipper");
                    String chaineDistance = courant
                            .getAttribute("distance_arrivee");
                    double distance = 0;
                    GregorianCalendar dateEtHeure = null;
                    boolean boooleanAbd = false;
                    if (chaineDistance.isEmpty()) { // le skipper a abandonne
                        boooleanAbd = true;
                    } else if (chaineDistance.startsWith("Date")) { // le
                                                                    // skipper
                                                                    // est
                                                                    // arrive
                        dateEtHeure = new GregorianCalendar(
                                Integer.parseInt(chaineDistance.substring(21,
                                        25)), // annee
                                Integer.parseInt(chaineDistance.substring(18,
                                        20)) - 1, // mois janvier=0, fev=1 ...
                                Integer.parseInt(chaineDistance.substring(15,
                                        17)), // jour
                                Integer.parseInt(chaineDistance.substring(26,
                                        28)), // heure
                                Integer.parseInt(chaineDistance.substring(29,
                                        31)), // minute
                                Integer.parseInt(chaineDistance.substring(32,
                                        34)) // seconde
                        );
                    } else { // le skipper est en mer
                        distance = Double.parseDouble(chaineDistance.replace(
                                ',', '.'));
                    }
                    Position position = new Position(nom, skipper, distance,
                            dateEtHeure, boooleanAbd);
                    arbrePositions.add(position);

                }

            }
            // Affichage pour tester
            return arbrePositions;

        } // try
        catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        return null;
    }
}
