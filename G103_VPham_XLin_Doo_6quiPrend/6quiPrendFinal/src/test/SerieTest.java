package test;
import code.Serie;
import static org.junit.Assert.*;

import org.junit.Test;

public class SerieTest {
	
	//on veut tester qu'on attribue bien un indice a une serie
	@Test
	public void test() {
		Serie a = new Serie(1), b = new Serie(3);
		assertFalse(a.toString().equals(b.toString()));
	}

}
