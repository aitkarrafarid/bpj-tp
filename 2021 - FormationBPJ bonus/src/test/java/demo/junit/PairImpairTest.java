// Fichier : PairImpairTest.java
package demo.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PairImpairTest {

	@Test
	public void testSimple() {
		// Given
		List<Integer> petiteListe = new ArrayList<Integer>();
		petiteListe.add(2);
		petiteListe.add(3);
		petiteListe.add(45);
		PairImpair pi = new PairImpair(petiteListe);		
		// When
		int nbPairs=pi.donneNbEntiersPairs();
		int nbImpairs=pi.donneNbEntiersImpairs();
		// Then
		assertEquals(1, nbPairs);
		assertEquals(2, nbImpairs);
	}

}
