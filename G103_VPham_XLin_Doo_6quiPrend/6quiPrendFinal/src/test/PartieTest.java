package test;
import code.Partie;
import static org.junit.Assert.*;

import org.junit.Test;

import code.Joueur;
public class PartieTest {
	
	/*
	 * on veut tester les methodes de parties
	 */
	@Test
	public void test() {
		Partie partie = new Partie();
		partie.creerDeck();
		partie.entreeJoueur();
		fail("Not yet implemented");
	}

}
