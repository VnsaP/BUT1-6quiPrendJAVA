package test;
import code.Carte;
import static org.junit.Assert.*;

import org.junit.Test;

public class CarteTest {
	/*
	 * On veut tester que creer une carte fonctionne bien
	 */
	@Test
	public void test() {
		Carte a=new Carte(5), b = new Carte(15);
		assertFalse(a.toString().equals(b.toString()));
	}
}

