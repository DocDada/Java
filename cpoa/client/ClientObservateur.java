package client;

import java.io.File;
import java.util.Set;

import outils.LectureFichierXML;

public class ClientObservateur {
	public static void main(String[] args) {
		File fileXML = new File("data_2018"+File.separator+"leaderboard-12.xml");
		Set setPosition = LectureFichierXML.lecture(fileXML);
		
		System.out.println(setPosition.size());
		System.out.println(setPosition);
	}
}
