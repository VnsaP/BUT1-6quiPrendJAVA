/* Projet DOO 
 * Auteur : Vanessa Pham
 * Auteur : Xingtong Lin
 * Groupe : 103
 * "6 qui prend"
 * IUT Paris Rives de Seine, 13/03/2022
 */

package appli;
import java.io.FileNotFoundException;
import java.io.IOException;
import code.Gestion;

//import java.util.ArrayList;
//import code.Carte;
//import code.Partie;
//import code.Joueur;
//import code.Serie;

public class Application {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Gestion.play("./config.txt");
		
	}

}
