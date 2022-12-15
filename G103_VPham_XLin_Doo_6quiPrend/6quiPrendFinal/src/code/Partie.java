package code;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;
import util.Console;



public class Partie {
	private static int nbSerie = 4;									//Nombre de serie sur dans la partie
	private static int maxCarteEnMain = 10;							//Max de carte qu'un joueur peut avoir dans sa main
	private static int maxCarte = 104;								//Max de carte dans la partie
	private ArrayList<Carte> deck = new ArrayList<Carte>();			//deck ou la pioche, liste de carte
	public ArrayList<Joueur> joueurArray = new ArrayList<Joueur>();	//liste des joueurs dans la partie
	private Serie[] serieArray = new Serie[nbSerie];				//liste de series
	
	/* Methode : lecture d'un fichier texte 
	 * recuperer les prenoms du fichier texte
	 */
	public void lire(String filename) throws FileNotFoundException, IOException {
		FileReader in = new FileReader(filename);
        BufferedReader bin = new BufferedReader(in);

		while (bin.ready()) {
            String line = bin.readLine();
            Joueur j = new Joueur(line);
            joueurArray.add(j);
		}
        bin.close();
	}
	
	
	//get nbSerie, permet de recuperer/retourner l'information nbSerie
	public static int getnbSerie() {
		return nbSerie;
	}
	
	/* Methode : chaine de caractere specifique
	 * annonce le nom des joueurs
	 */
	public String entreeJoueur() {
		String s = "";
		for (int i = 0; i < this.joueurArray.size() - 2 ; i++) {
			s+= this.joueurArray.get(i).toString()+", ";
		}
		s+= this.joueurArray.get(this.joueurArray.size()-2).toString() + " et " + this.joueurArray.get(this.joueurArray.size()-1).toString();
		return s;
	}
	
	// Methode : Creer un paquet de cartes
	public void creerDeck() {
		for (int i = 1 ; i <= maxCarte ; i++) {	
			Carte carte = new Carte(i);
			deck.add(carte);
		}
	}
	
	// Methode : melange le paquet de cartes
	public void melangerCarte() {
		Collections.shuffle(deck);
	}
	
	// Methode : distribuer des cartes aux joueurs
	public void distribuerCarte() {
		for (int i = 0; i < this.joueurArray.size(); i++) {
			for(int j = 0; j < maxCarteEnMain; j++) {
				Carte carte = deck.get(0);
				this.joueurArray.get(i).prendCarte(carte);
				deck.remove(0);
			}
		}
	}
	
	
	// Methode : initialise les series de la partie avec une carte 
	public void initialiserSerie() {
		
		List<Carte> cartes = new ArrayList<Carte>();
		for (int i = 0; i < nbSerie; i++) {
			Carte carte = deck.get(0);
			deck.remove(0);
			cartes.add(carte);
		}
		
		// Mélange dans l'ordre croissant les cartes
		function_sort(cartes);

		// Les 4 séries ont été créer et ont reçu une carte
		for (int i = 0; i < nbSerie; i++) {
			this.serieArray[i] = new Serie(i+1);
			this.serieArray[i].cartesDsSerie.add(cartes.get(i));
		}
	}
	
	/* fonction de tri, tri les cartes 
	 * @param[in] list<Carte> cartes
	 */
	private void function_sort(List<Carte> cartes) {

		for (int i = 0; i < cartes.size(); i++) {
			for (int j = 1; j < (cartes.size() - i); j++) {
				if (cartes.get(j - 1).getCarteId() > cartes.get(j).getCarteId()) {
					//swap elements
					Carte temp = cartes.get(j - 1);
					cartes.set(j - 1, cartes.get(j));
					cartes.set(j, temp);
				}
			}
		}
	}
	
	
	/* Methode : le joueur est appele
	 * Ses cartes lui sont presente
	 * Appelle de la methode "choisirCarte()" de la classe joueur
	 * le joueur
	 *  va pouvoir choisir une carte
	 */
	public void JoueurSelectionDesCartes(){
		for (int i = 0; i < this.joueurArray.size(); i++) {
			System.out.println("A " + this.joueurArray.get(i).toString() + " de jouer");
			Console.pause();
			
			for (int j = 0; j < Partie.getnbSerie(); j++) {
				System.out.println(this.serieArray[j].toString());
			}
			System.out.println("Vos cartes sont :" + this.joueurArray.get(i).hand);
			this.joueurArray.get(i).choisirCarte();
			Console.clearScreen();
		}
	}



}

