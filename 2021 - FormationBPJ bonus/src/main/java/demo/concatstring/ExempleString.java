package demo.concatstring;

/**
 * Exemple permettant d'illustrer qu'une concaténation de 'String' est convertit en 'StringBuilder'.
 * Montrer le principe :
 * --> Rechercher "sampleUseConcatString ()" dans le code source puis dans le code décompilé.
 * 
 * Remarque : pour lancer la décompilation cf. "external tools \ javap ExempleString"
 */
public class ExempleString {

   public static void main (String[] args) {
      sampleUseConcatString();
   }

   /**
   * Exemple de concaténation de 'String' --> JIT traduit en 'StringBuilder'. 
   * Voivi un extrait du code décompilé pour "sampleUseConcatString()".
   *    Classfile /T:/1_Formations_en_cours/2017_04_26_Cours_Java_Bonnes_pratiques/WS_FormationBPJ/FormationBPJ/target/demo/string/ExempleString.class
   *      Last modified 9 avr. 2017; size 947 bytes
   *      MD5 checksum e878de8b40496a1770ae84381b3a403f
   *      Compiled from "ExempleString.java"
   *    public class demo.string.ExempleString
   *      minor version: 0
   *      major version: 50
   *      flags: ACC_PUBLIC, ACC_SUPER
   *    Constant pool:
   *       #1 = Class              #2             // demo/string/ExempleString
   *       #2 = Utf8               demo/string/ExempleString
   *       #3 = Class              #4             // java/lang/Object
   *       #4 = Utf8               java/lang/Object
   *       #5 = Utf8               <init>
   *       #6 = Utf8               ()V
   *       #7 = Utf8               Code
   *       #8 = Methodref          #3.#9          // java/lang/Object."<init>":()V
   *       #9 = NameAndType        #5:#6          // "<init>":()V
   *      #10 = Utf8               LineNumberTable
   *      #11 = Utf8               LocalVariableTable
   *      #12 = Utf8               this
   *      #13 = Utf8               Ldemo/string/ExempleString;
   *      #14 = Utf8               main
   *      #15 = Utf8               ([Ljava/lang/String;)V
   *      #16 = Methodref          #1.#17         // demo/string/ExempleString.sampleUseConcatString:()V
   *      #17 = NameAndType        #18:#6         // sampleUseConcatString:()V
   *      #18 = Utf8               sampleUseConcatString ()
   *      #19 = Utf8               args
   *      #20 = Utf8               [Ljava/lang/String;
   *      #21 = Class              #22            // java/lang/StringBuilder
   *      #22 = Utf8               java/lang/StringBuilder
   *      #23 = String             #24            // chaine1
   *      #24 = Utf8               chaine1
   *      #25 = Methodref          #21.#26        // java/lang/StringBuilder."<init>":(Ljava/lang/String;)V
   *      #26 = NameAndType        #5:#27         // "<init>":(Ljava/lang/String;)V
   *      #27 = Utf8               (Ljava/lang/String;)V
   *      #28 = Methodref          #21.#29        // java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
   *      #29 = NameAndType        #30:#31        // append:(I)Ljava/lang/StringBuilder;
   *      #30 = Utf8               append
   *      #31 = Utf8               (I)Ljava/lang/StringBuilder;
   *      #32 = String             #33            //  chaine2
   *      #33 = Utf8                chaine2
   *      #34 = Methodref          #21.#35        // java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   *      #35 = NameAndType        #30:#36        // append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   *      #36 = Utf8               (Ljava/lang/String;)Ljava/lang/StringBuilder;
   *      #37 = Methodref          #21.#38        // java/lang/StringBuilder.toString:()Ljava/lang/String;
   *      #38 = NameAndType        #39:#40        // toString:()Ljava/lang/String;
   *      #39 = Utf8               toString
   *      #40 = Utf8               ()Ljava/lang/String;
   *      #41 = Fieldref           #42.#44        // java/lang/System.out:Ljava/io/PrintStream;
   *      #42 = Class              #43            // java/lang/System
   *      #43 = Utf8               java/lang/System
   *      #44 = NameAndType        #45:#46        // out:Ljava/io/PrintStream;
   *      #45 = Utf8               out
   *      #46 = Utf8               Ljava/io/PrintStream;
   *      #47 = Methodref          #48.#50        // java/io/PrintStream.println:(Ljava/lang/String;)V
   *      #48 = Class              #49            // java/io/PrintStream
   *      #49 = Utf8               java/io/PrintStream
   *      #50 = NameAndType        #51:#27        // println:(Ljava/lang/String;)V
   *      #51 = Utf8               println
   *      #52 = Utf8               val
   *      #53 = Utf8               I
   *      #54 = Utf8               result
   *      #55 = Utf8               Ljava/lang/String;
   *      #56 = Utf8               SourceFile
   *      #57 = Utf8               ExempleString.java
   *    {
   *      public demo.string.ExempleString();
   *        descriptor: ()V
   *        flags: ACC_PUBLIC
   *        Code:
   *          stack=1, locals=1, args_size=1
   *             0: aload_0
   *             1: invokespecial #8                  // Method java/lang/Object."<init>":()V
   *             4: return
   *          LineNumberTable:
   *            line 116: 0
   *          LocalVariableTable:
   *            Start  Length  Slot  Name   Signature
   *                0       5     0  this   Ldemo/string/ExempleString;
   *    
   *      public static void main(java.lang.String[]);
   *        descriptor: ([Ljava/lang/String;)V
   *        flags: ACC_PUBLIC, ACC_STATIC
   *        Code:
   *          stack=0, locals=1, args_size=1
   *             0: invokestatic  #16                 // Method sampleUseConcatString:()V
   *             3: return
   *          LineNumberTable:
   *            line 119: 0
   *            line 121: 3
   *          LocalVariableTable:
   *            Start  Length  Slot  Name   Signature
   *                0       4     0  args   [Ljava/lang/String;
   *    }
   *    SourceFile: "ExempleString.java"
    */
   private static void sampleUseConcatString () {
      int val = 3;
      String result = "chaine1 " + val + " chaine2";
      System.out.println(result);
      // Affiche : chaine1 3 chaine2
   }

}
