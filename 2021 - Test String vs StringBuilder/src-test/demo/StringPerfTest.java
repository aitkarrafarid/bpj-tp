package demo;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringPerfTest {

   private static final int NB_ITER = 100000;

   @Test
   public void testString() {
      long startMem = Runtime.getRuntime().freeMemory();
      long startTime = System.currentTimeMillis();

      String s1 = "";
      for (int i = 0 ; i < NB_ITER ; i++) {
         s1 = s1 + "toto" + i;
      }
      
      long stopMem = Runtime.getRuntime().freeMemory();
      long stopTime = System.currentTimeMillis();
      long deltaTime = stopTime - startTime;
      long deltaMem = stopMem - startMem;
      System.out.println("durée=" + deltaTime + "ms - occupation=" + deltaMem + "bytes");
   }

   @Test
   public void testStringBuilder() {
      long startMem = Runtime.getRuntime().freeMemory();
      long startTime = System.currentTimeMillis();
      
      StringBuilder sb1 = new StringBuilder("");
      for (int i = 0 ; i < NB_ITER ; i++) {
         sb1.append("toto" + i);
      }
      
      long stopMem = Runtime.getRuntime().freeMemory();
      long stopTime = System.currentTimeMillis();
      long deltaTime = stopTime - startTime;
      long deltaMem = stopMem - startMem;
      System.out.println("durée=" + deltaTime + "ms - occupation=" + deltaMem + "bytes");
   }
   
}
