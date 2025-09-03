package demo.exception;

import org.junit.Assert;
import org.junit.Test;

/**
 * Exemple de "test-fist" : on part de cette classe pour faire l'implémentation.
 */
public class MathsUtilsTest {

	/**
	 * Tester une division simple de 2 nombres entiers.
	 * @throws DividedException 
	 */
	@Test
	public void dividedByCN() throws DividedException {
		double actual;
		actual = MathsUtils.dividedBy(6, 3);
		Assert.assertTrue(2 == actual);
	}

	/**
	 * Tester une division par zéro.
	 * @throws DividedException 
	 */
	@Test(expected=DividedException.class)
//	@Test
	public void dividedByCE() throws DividedException {
		MathsUtils.dividedBy(6, 0);
	}

}
