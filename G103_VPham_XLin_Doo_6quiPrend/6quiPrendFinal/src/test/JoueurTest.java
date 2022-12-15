package test;
import code.Joueur;
import static org.junit.Assert.*;

import org.junit.Test;


public class JoueurTest {
	/*
	 * on veut tester que lire est le prenom d'un joueur fonctionne bien
	 */
	@Test
	public void test() {
		String k = "Karl";
		String s = "Suzi";
		Joueur j = new Joueur(k), b = new Joueur(s);
		assertFalse(j.toString().equals(b.toString()));
	}

}
