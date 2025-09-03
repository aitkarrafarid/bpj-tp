package demo.singleton;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class SampleSingletonTest {

	@Test
	public void test() {
		// Interdire :
//		SampleSingleton monInstance = new SampleSingleton(); // Ne doit pas compiler
		
		SampleSingleton monInstance1 = SampleSingleton.getInstance();
      SampleSingleton monInstance2 = SampleSingleton.getInstance();
		monInstance1.methode1();
		// Vérifier qu'il y a une seule instance
		Assert.assertEquals(monInstance1, monInstance2);
	}

}
