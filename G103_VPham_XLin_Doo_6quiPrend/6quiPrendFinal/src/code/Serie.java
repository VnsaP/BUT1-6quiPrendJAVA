package code;

import java.util.ArrayList;



public class Serie {
	public int serieID;								//l'indice de la serie
	public ArrayList<Carte> cartesDsSerie;			//liste des cartes de la serie
	public int MAXCarteDsSerie = 6;					//Max de carte que peut contenir une serie
	
	
	//Constructeur de Serie
	public Serie(int serieID) {
		this.serieID = serieID;
		this.cartesDsSerie = new ArrayList<Carte>();
	}
	
	//get SerieId, permet de recuperer/retourner l'information "SerieId"
	public int getSerieId() {
		return serieID;
	}
	
	/* Permet d'avoir une chaine de caractère specifique pour la serie
	 * exemple : 
	 * - Série n° 1 : 23
	 */
	public String toString() {
		String s = "";
		s+= "- Série n° " + getSerieId() + " : ";
		for (int i = 0; i< cartesDsSerie.size()-1; i++) {
			s+= cartesDsSerie.get(i).toString() + ",";
		}
		s+= cartesDsSerie.get(cartesDsSerie.size()-1).toString();
		return s;
	}
}
