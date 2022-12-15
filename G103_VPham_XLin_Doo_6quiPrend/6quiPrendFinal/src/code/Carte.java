package code;

public class Carte {
	private int carteId;			//numero de la carte
	private int teteDeBoeuf;		//teteDeBoeuf
	
	/*Constructeur de carte
	  Initialise le nombre de tete de boeuf
	  @param[in] Int carteId 
	 */ 
	public Carte(int carteId) {
		assert ((carteId >= 1) && (carteId <= 104));
		this.carteId = carteId;
		
		this.teteDeBoeuf = 0;
		if ( carteId % 5 == 0) {	//les cartes terminant par un 5 valent 2 TeteDeBoeuf
			this.teteDeBoeuf += 2;
		} if ( carteId % 10 == 0) {	//les cartes terminant par un 0 en valent 3 TeteDeBoeuf
			this.teteDeBoeuf += 3;
		} if ( carteId % 11 == 0) {	//les cartes formés par deux chiffres égaux valent 5 TeteDeBoeuf
			this.teteDeBoeuf += 5;
		} if (teteDeBoeuf == 0)		//les autres cartes valent 1 TeteDeBoeuf
			this.teteDeBoeuf = 1;
	}
 
	//get CarteId, permet de recuperer/retourner l'information "CarteId"
	public int getCarteId() {
		return carteId;	
	}

	//get teteDeBoeuf, permet de recuperer/retourner l'information "teteDeBoeuf"
	public int getTeteDeBoeuf() {
		return teteDeBoeuf;
	}
	
	/* Permet d'avoir une chaine de caractère specifique pour une carte
	 * exemple de format carte 15 avec 2 tetes de boeuf : 
	 * 15 (2)
	*/
	public String toString() {
		String s = "";
		if (getTeteDeBoeuf()==1)
			s+= getCarteId();
		else
			s+= getCarteId() + " (" + getTeteDeBoeuf() + ")";
		return s;
	}
}
