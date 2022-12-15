package code;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Gestion {
	
	public static void play(String filename) throws FileNotFoundException, IOException {
		
		Partie partie = new Partie();
		
		partie.lire(filename);
		
		System.out.println("Les " + partie.joueurArray.size() + " joueurs sont " + partie.entreeJoueur() + ". Merci de jouer à 6 qui prend !");
		
		partie.creerDeck();
		
		partie.melangerCarte();
		
		partie.distribuerCarte();
		
		partie.initialiserSerie();
		
		partie.JoueurSelectionDesCartes();
		
	}
}
