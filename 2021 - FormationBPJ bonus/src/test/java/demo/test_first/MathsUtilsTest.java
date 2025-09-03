package demo.test_first;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class MathsUtilsTest {

	/**
	 * Tester la divisation de 2 valeurs enti�res (diff�rentes de 0).
	 */
	@Test
	public void diviserParCasNominal() {
		// Given
		int a = 6;
		int b = 3;
		
		// When
		double result = MathsUtils.diviserPar(a, b);
		
		// Then
		Assert.assertTrue(result == 2);
	}
	
	/**
	 * Tester le soul�vement de l'erreur lors d'un diviseur �gal � 0.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void diviserParCasException() {
		MathsUtils.diviserPar(6, 0);
	}

}
