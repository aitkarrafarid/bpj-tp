package demo.stringpattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExemplePattern {
   public static void main (VerifString[] args) {
      Pattern p = Pattern.compile("[0-9]");
      Matcher m = p.matcher("j'ai 20 ans");
      while (m.find()) {
         System.out.println("trouvé");
      }
   }
}
