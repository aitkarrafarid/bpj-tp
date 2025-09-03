package demo.stringpattern;

public class VerifString {

   public static void main (String[] args) {
      String s1 = "bonne pratique";
      String s2 = "bonne pratique";
      String s3 = new String("bonne pratique");
      String s4 = new String("bonne pratique");
      if (s1 == s2) {
         System.out.println("s1==s2");
      }
      if (s1 == s3) {
         System.out.println("s1==s3");
      }
      if (s3 == s4) {
         System.out.println("s3==s4");
      }
   }
}
