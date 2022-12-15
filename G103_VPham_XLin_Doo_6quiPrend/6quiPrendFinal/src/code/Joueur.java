package code;

import java.util.*;
import java.util.Scanner;


public class Joueur {
	private String prenom; 						//le prenom du joueur
	private ArrayList<Carte> cartesRamassees; 	//les cartes ramassees du joueur
	public ArrayList<Carte> hand;				//les cartes que le joueur possède
	private int points;							//points/tetes de boeuf ramassees 

	
	/* Constructeur de joueur
	 * @param[in] String prenom
	 */
	public Joueur(String prenom) {
		this.prenom = prenom;
		this.hand = new ArrayList<Carte>(); 
		this.cartesRamassees = new ArrayList<Carte>();
		this.points = 0;
	}
	
	
	/* Methode : le joueur prend une carte distribue, 
	 * le joueur la garde dans sa "main"
	 * @param[in] Carte carte
	 */
	public void prendCarte(Carte carte) {
		hand.add(carte);
	}
	
	/* Methode : le joueur choisi une carte de sa "main"
	 * il ne peut saisir qu'un carte qu'il possede
	 */
	public void choisirCarte() {//throws java.lang.NumberFormatException
		System.out.println("Saisissez une carte :");
		Scanner sc = new Scanner(System.in);
	
		try {
			String s = sc.next();
			boolean isInt = checkInt(s);
			int i = Integer.valueOf(s);
			boolean isCartInDeck = checkInDeckCart(i);// Check dans le deck si la carte existe
			
			// Sinon reboucler sur la lecture d'entrée
			while(!isCartInDeck||!isInt){//
				System.out.print("Vous n'avez pas cette carte, saisissez votre choix : ");
	           	sc = new Scanner(System.in);
	           	String re = sc.next();
				int reJouer = Integer.valueOf(re);
				isCartInDeck = checkInDeckCart(reJouer);
				isInt = checkInt(re);
			}
		
			// Si oui alors enlever du deck la carte
			for(int j = 0; j < this.hand.size(); j++) {
				if (this.hand.get(j).getCarteId() == i)
					this.hand.remove(j);
			}
			
		}catch(java.lang.NumberFormatException e) {
			System.out.println("Vous n'avez pas cette carte, saisissez votre choix : ");
			
		}
	}

	/* Fonction boolean qui indique si une carte est dans la main du joueur 
	 * @param[in] int carteACheck
	 */
	private boolean checkInDeckCart(int carteACheck) {
		for(Carte c: this.hand) {
			if (carteACheck == c.getCarteId())
				return true;
		}
		return false;
	}
	
	/* Fonction boolean qui indique si la valeur saisi est un entier
	 * @param[in] String i
	 */
	private boolean checkInt(String i) {
		for(char c : i.toCharArray()) {
			if (Character.isDigit(c))
				return true;
		}
		return false;
	}

	/* Permet d'avoir une chaine de caractère specifique pour le joueur
	 * retourne le prenom
	 */
	public String toString() {
		return prenom;
	}

}

