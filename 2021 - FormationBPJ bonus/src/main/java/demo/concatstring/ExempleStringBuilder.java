package demo.concatstring;

/**
 * Exemple permettant d'illustrer qu'une concaténation de 'String' est convertit en 'StringBuilder'.
 * Montrer le "Ne pas faire" car 2 instances de StringBuilder() (cf. code décompilé "java/lang/StringBuilder."<init>":(")
 * --> Rechercher dans le code source puis dans le code décompilé pour :
 *    - "sampleUseStringBuilderNOk ()" 
 *    - "sampleUseStringBuilderInutile ()" 
 *    - "sampleUseStringBuilderOk ()" 
 * 
 * Remarque : pour lancer la décompilation cf. "external tools \ javap ExempleString"
 */
public class ExempleStringBuilder {

   public static void main (String[] args) {
      sampleUseStringBuilderNOk();
      sampleUseStringBuilderInutile();
      sampleUseStringBuilderOk();
   }

   /**
   * Exemple d'usage de 'StringBuilder' à ne pas faire (car 2 instances de 'StringBuilder').
   * 
   * Voici un extrait du code décompilé pour "sampleUseStringBuilderNOk()".
   *    Classfile /T:/1_Formations_en_cours/2017_04_26_Cours_Java_Bonnes_pratiques/WS_FormationBPJ/FormationBPJ/target/demo/concatstring/ExempleStringBuilder.class
   *      Last modified 9 avr. 2017; size 1188 bytes
   *      MD5 checksum 89cffb8fcf6b7bf533f6af3a77897d3c
   *      Compiled from "ExempleStringBuilder.java"
   *    public class demo.concatstring.ExempleStringBuilder
   *      minor version: 0
   *      major version: 50
   *      flags: ACC_PUBLIC, ACC_SUPER
   *    Constant pool:
   *       #1 = Class              #2             // demo/concatstring/ExempleStringBuilder
   *       #2 = Utf8               demo/concatstring/ExempleStringBuilder
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
   *      #13 = Utf8               Ldemo/concatstring/ExempleStringBuilder;
   *      #14 = Utf8               main
   *      #15 = Utf8               ([Ljava/lang/String;)V
   *      #16 = Methodref          #1.#17         // demo/concatstring/ExempleStringBuilder.sampleUseStringBuilderNOk:()V
   *      #17 = NameAndType        #18:#6         // sampleUseStringBuilderNOk:()V
   *      #18 = Utf8               sampleUseStringBuilderNOk
   *      #19 = Utf8               args
   *      #20 = Utf8               [Ljava/lang/String;
   *      #21 = Class              #22            // java/lang/StringBuilder
   *      #22 = Utf8               java/lang/StringBuilder
   *      #23 = Methodref          #21.#9         // java/lang/StringBuilder."<init>":()V
   *      #24 = String             #25            // sampleUseStringBuilderNOk
   *      #25 = Utf8               sampleUseStringBuilderNOk ()
   *      #26 = Methodref          #21.#27        // java/lang/StringBuilder."<init>":(Ljava/lang/String;)V
   *      #27 = NameAndType        #5:#28         // "<init>":(Ljava/lang/String;)V
   *      #28 = Utf8               (Ljava/lang/String;)V
   *      #29 = Methodref          #21.#30        // java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
   *      #30 = NameAndType        #31:#32        // append:(I)Ljava/lang/StringBuilder;
   *      #31 = Utf8               append
   *      #32 = Utf8               (I)Ljava/lang/StringBuilder;
   *      #33 = String             #34            // \n
   *      #34 = Utf8               \n
   *      #35 = Methodref          #21.#36        // java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   *      #36 = NameAndType        #31:#37        // append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   *      #37 = Utf8               (Ljava/lang/String;)Ljava/lang/StringBuilder;
   *      #38 = Methodref          #21.#39        // java/lang/StringBuilder.toString:()Ljava/lang/String;
   *      #39 = NameAndType        #40:#41        // toString:()Ljava/lang/String;
   *      #40 = Utf8               toString
   *      #41 = Utf8               ()Ljava/lang/String;
   *      #42 = Fieldref           #43.#45        // java/lang/System.out:Ljava/io/PrintStream;
   *      #43 = Class              #44            // java/lang/System
   *      #44 = Utf8               java/lang/System
   *      #45 = NameAndType        #46:#47        // out:Ljava/io/PrintStream;
   *      #46 = Utf8               out
   *      #47 = Utf8               Ljava/io/PrintStream;
   *      #48 = String             #49            // sampleUseStringBuilderNOk : \n
   *      #49 = Utf8               sampleUseStringBuilderNOk : \n
   *      #50 = Methodref          #21.#51        // java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   *      #51 = NameAndType        #31:#52        // append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   *      #52 = Utf8               (Ljava/lang/Object;)Ljava/lang/StringBuilder;
   *      #53 = Methodref          #54.#56        // java/io/PrintStream.println:(Ljava/lang/String;)V
   *      #54 = Class              #55            // java/io/PrintStream
   *      #55 = Utf8               java/io/PrintStream
   *      #56 = NameAndType        #57:#28        // println:(Ljava/lang/String;)V
   *      #57 = Utf8               println
   *      #58 = Utf8               sbStringBuilderNOk
   *      #59 = Utf8               Ljava/lang/StringBuilder;
   *      #60 = Utf8               i
   *      #61 = Utf8               I
   *      #62 = Utf8               StackMapTable
   *      #63 = Utf8               SourceFile
   *      #64 = Utf8               ExempleStringBuilder.java
   *    {
   *      public demo.concatstring.ExempleStringBuilder();
   *        descriptor: ()V
   *        flags: ACC_PUBLIC
   *        Code:
   *          stack=1, locals=1, args_size=1
   *             0: aload_0
   *             1: invokespecial #8                  // Method java/lang/Object."<init>":()V
   *             4: return
   *          LineNumberTable:
   *            line 10: 0
   *          LocalVariableTable:
   *            Start  Length  Slot  Name   Signature
   *                0       5     0  this   Ldemo/concatstring/ExempleStringBuilder;
   *    
   *      public static void main(java.lang.String[]);
   *        descriptor: ([Ljava/lang/String;)V
   *        flags: ACC_PUBLIC, ACC_STATIC
   *        Code:
   *          stack=0, locals=1, args_size=1
   *             0: invokestatic  #16                 // Method sampleUseStringBuilderNOk:()V
   *             3: return
   *          LineNumberTable:
   *            line 13: 0
   *            line 16: 3
   *          LocalVariableTable:
   *            Start  Length  Slot  Name   Signature
   *                0       4     0  args   [Ljava/lang/String;
   *    }
   *    SourceFile: "ExempleStringBuilder.java"
   */
   private static void sampleUseStringBuilderNOk () {
      StringBuilder sbStringBuilderNOk = new StringBuilder();
      for (int i = 0; i < 5; i++) {
         // Ne pas faire
         sbStringBuilderNOk.append("sampleUseStringBuilderNOk " + i + "\n"); // Car sinon concat de String sans optim possible : le JIT créé 2 instances de 'StringBuilder'
      }
      System.out.println("sampleUseStringBuilderNOk : \n" + sbStringBuilderNOk);
   }

   /**
   * Exemple d'usage de 'StringBuilder' à faire (car 1 seule instance de 'StringBuilder') mais inutile car moins lisible qu'un opérateur "+".
   * 
   * Voici un extrait du code décompilé pour "sampleUseStringBuilderInutile()".
   *    Classfile /T:/1_Formations_en_cours/2017_04_26_Cours_Java_Bonnes_pratiques/WS_FormationBPJ/FormationBPJ/target/demo/concatstring/ExempleStringBuilder.class
   *      Last modified 9 avr. 2017; size 1206 bytes
   *      MD5 checksum 3b0d84b2a275c734a3fe8a12c7f4f847
   *      Compiled from "ExempleStringBuilder.java"
   *    public class demo.concatstring.ExempleStringBuilder
   *      minor version: 0
   *      major version: 50
   *      flags: ACC_PUBLIC, ACC_SUPER
   *    Constant pool:
   *       #1 = Class              #2             // demo/concatstring/ExempleStringBuilder
   *       #2 = Utf8               demo/concatstring/ExempleStringBuilder
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
   *      #13 = Utf8               Ldemo/concatstring/ExempleStringBuilder;
   *      #14 = Utf8               main
   *      #15 = Utf8               ([Ljava/lang/String;)V
   *      #16 = Methodref          #1.#17         // demo/concatstring/ExempleStringBuilder.sampleUseStringBuilderInutile:()V
   *      #17 = NameAndType        #18:#6         // sampleUseStringBuilderInutile:()V
   *      #18 = Utf8               sampleUseStringBuilderInutile
   *      #19 = Utf8               args
   *      #20 = Utf8               [Ljava/lang/String;
   *      #21 = Class              #22            // java/lang/StringBuilder
   *      #22 = Utf8               java/lang/StringBuilder
   *      #23 = Methodref          #21.#9         // java/lang/StringBuilder."<init>":()V
   *      #24 = String             #25            // sampleUseStringBuilderInutile
   *      #25 = Utf8               sampleUseStringBuilderInutile ()
   *      #26 = Methodref          #21.#27        // java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   *      #27 = NameAndType        #28:#29        // append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   *      #28 = Utf8               append
   *      #29 = Utf8               (Ljava/lang/String;)Ljava/lang/StringBuilder;
   *      #30 = Methodref          #21.#31        // java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
   *      #31 = NameAndType        #28:#32        // append:(I)Ljava/lang/StringBuilder;
   *      #32 = Utf8               (I)Ljava/lang/StringBuilder;
   *      #33 = String             #34            // \n
   *      #34 = Utf8               \n
   *      #35 = Fieldref           #36.#38        // java/lang/System.out:Ljava/io/PrintStream;
   *      #36 = Class              #37            // java/lang/System
   *      #37 = Utf8               java/lang/System
   *      #38 = NameAndType        #39:#40        // out:Ljava/io/PrintStream;
   *      #39 = Utf8               out
   *      #40 = Utf8               Ljava/io/PrintStream;
   *      #41 = String             #42            // sampleUseStringBuilderInutile : \n
   *      #42 = Utf8               sampleUseStringBuilderInutile : \n
   *      #43 = Methodref          #21.#44        // java/lang/StringBuilder."<init>":(Ljava/lang/String;)V
   *      #44 = NameAndType        #5:#45         // "<init>":(Ljava/lang/String;)V
   *      #45 = Utf8               (Ljava/lang/String;)V
   *      #46 = Methodref          #21.#47        // java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   *      #47 = NameAndType        #28:#48        // append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   *      #48 = Utf8               (Ljava/lang/Object;)Ljava/lang/StringBuilder;
   *      #49 = Methodref          #21.#50        // java/lang/StringBuilder.toString:()Ljava/lang/String;
   *      #50 = NameAndType        #51:#52        // toString:()Ljava/lang/String;
   *      #51 = Utf8               toString
   *      #52 = Utf8               ()Ljava/lang/String;
   *      #53 = Methodref          #54.#56        // java/io/PrintStream.println:(Ljava/lang/String;)V
   *      #54 = Class              #55            // java/io/PrintStream
   *      #55 = Utf8               java/io/PrintStream
   *      #56 = NameAndType        #57:#45        // println:(Ljava/lang/String;)V
   *      #57 = Utf8               println
   *      #58 = Utf8               sbStringBuilderInutile
   *      #59 = Utf8               Ljava/lang/StringBuilder;
   *      #60 = Utf8               i
   *      #61 = Utf8               I
   *      #62 = Utf8               StackMapTable
   *      #63 = Utf8               SourceFile
   *      #64 = Utf8               ExempleStringBuilder.java
   *    {
   *      public demo.concatstring.ExempleStringBuilder();
   *        descriptor: ()V
   *        flags: ACC_PUBLIC
   *        Code:
   *          stack=1, locals=1, args_size=1
   *             0: aload_0
   *             1: invokespecial #8                  // Method java/lang/Object."<init>":()V
   *             4: return
   *          LineNumberTable:
   *            line 10: 0
   *          LocalVariableTable:
   *            Start  Length  Slot  Name   Signature
   *                0       5     0  this   Ldemo/concatstring/ExempleStringBuilder;
   *    
   *      public static void main(java.lang.String[]);
   *        descriptor: ([Ljava/lang/String;)V
   *        flags: ACC_PUBLIC, ACC_STATIC
   *        Code:
   *          stack=0, locals=1, args_size=1
   *             0: invokestatic  #16                 // Method sampleUseStringBuilderInutile:()V
   *             3: return
   *          LineNumberTable:
   *            line 14: 0
   *            line 16: 3
   *          LocalVariableTable:
   *            Start  Length  Slot  Name   Signature
   *                0       4     0  args   [Ljava/lang/String;
   *    }
   *    SourceFile: "ExempleStringBuilder.java"
   */
   private static void sampleUseStringBuilderInutile () {
      StringBuilder sbStringBuilderInutile = new StringBuilder();
      for (int i = 0; i < 5; i++) {
         // Il faut faire
         sbStringBuilderInutile.append("sampleUseStringBuilderInutile ");
         sbStringBuilderInutile.append(i);
         sbStringBuilderInutile.append("\n");
      }
      System.out.println("sampleUseStringBuilderInutile : \n" + sbStringBuilderInutile);
   }

   /**
   * Exemple d'usage d'un opérateur "+" pour concaténer des 'String'.
   * 
   * Voici un extrait du code décompilé pour "sampleUseStringBuilderOk()".
   *    Classfile /T:/1_Formations_en_cours/2017_04_26_Cours_Java_Bonnes_pratiques/WS_FormationBPJ/FormationBPJ/target/demo/concatstring/ExempleStringBuilder.class
   *      Last modified 9 avr. 2017; size 1202 bytes
   *      MD5 checksum 726af3af2fdf8923612f9d4cc5860fee
   *      Compiled from "ExempleStringBuilder.java"
   *    public class demo.concatstring.ExempleStringBuilder
   *      minor version: 0
   *      major version: 50
   *      flags: ACC_PUBLIC, ACC_SUPER
   *    Constant pool:
   *       #1 = Class              #2             // demo/concatstring/ExempleStringBuilder
   *       #2 = Utf8               demo/concatstring/ExempleStringBuilder
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
   *      #13 = Utf8               Ldemo/concatstring/ExempleStringBuilder;
   *      #14 = Utf8               main
   *      #15 = Utf8               ([Ljava/lang/String;)V
   *      #16 = Methodref          #1.#17         // demo/concatstring/ExempleStringBuilder.sampleUseStringBuilderOk:()V
   *      #17 = NameAndType        #18:#6         // sampleUseStringBuilderOk:()V
   *      #18 = Utf8               sampleUseStringBuilderOk
   *      #19 = Utf8               args
   *      #20 = Utf8               [Ljava/lang/String;
   *      #21 = Class              #22            // java/lang/String
   *      #22 = Utf8               java/lang/String
   *      #23 = Methodref          #21.#9         // java/lang/String."<init>":()V
   *      #24 = Class              #25            // java/lang/StringBuilder
   *      #25 = Utf8               java/lang/StringBuilder
   *      #26 = Methodref          #21.#27        // java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
   *      #27 = NameAndType        #28:#29        // valueOf:(Ljava/lang/Object;)Ljava/lang/String;
   *      #28 = Utf8               valueOf
   *      #29 = Utf8               (Ljava/lang/Object;)Ljava/lang/String;
   *      #30 = Methodref          #24.#31        // java/lang/StringBuilder."<init>":(Ljava/lang/String;)V
   *      #31 = NameAndType        #5:#32         // "<init>":(Ljava/lang/String;)V
   *      #32 = Utf8               (Ljava/lang/String;)V
   *      #33 = String             #34            // sampleUseStringBuilderOk
   *      #34 = Utf8               sampleUseStringBuilderOk ()
   *      #35 = Methodref          #24.#36        // java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   *      #36 = NameAndType        #37:#38        // append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   *      #37 = Utf8               append
   *      #38 = Utf8               (Ljava/lang/String;)Ljava/lang/StringBuilder;
   *      #39 = Methodref          #24.#40        // java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
   *      #40 = NameAndType        #37:#41        // append:(I)Ljava/lang/StringBuilder;
   *      #41 = Utf8               (I)Ljava/lang/StringBuilder;
   *      #42 = String             #43            // \n
   *      #43 = Utf8               \n
   *      #44 = Methodref          #24.#45        // java/lang/StringBuilder.toString:()Ljava/lang/String;
   *      #45 = NameAndType        #46:#47        // toString:()Ljava/lang/String;
   *      #46 = Utf8               toString
   *      #47 = Utf8               ()Ljava/lang/String;
   *      #48 = Fieldref           #49.#51        // java/lang/System.out:Ljava/io/PrintStream;
   *      #49 = Class              #50            // java/lang/System
   *      #50 = Utf8               java/lang/System
   *      #51 = NameAndType        #52:#53        // out:Ljava/io/PrintStream;
   *      #52 = Utf8               out
   *      #53 = Utf8               Ljava/io/PrintStream;
   *      #54 = String             #55            // sampleUseStringBuilderOk : \n
   *      #55 = Utf8               sampleUseStringBuilderOk : \n
   *      #56 = Methodref          #57.#59        // java/io/PrintStream.println:(Ljava/lang/String;)V
   *      #57 = Class              #58            // java/io/PrintStream
   *      #58 = Utf8               java/io/PrintStream
   *      #59 = NameAndType        #60:#32        // println:(Ljava/lang/String;)V
   *      #60 = Utf8               println
   *      #61 = Utf8               sbStringConcat
   *      #62 = Utf8               Ljava/lang/String;
   *      #63 = Utf8               i
   *      #64 = Utf8               I
   *      #65 = Utf8               StackMapTable
   *      #66 = Utf8               SourceFile
   *      #67 = Utf8               ExempleStringBuilder.java
   *    {
   *      public demo.concatstring.ExempleStringBuilder();
   *        descriptor: ()V
   *        flags: ACC_PUBLIC
   *        Code:
   *          stack=1, locals=1, args_size=1
   *             0: aload_0
   *             1: invokespecial #8                  // Method java/lang/Object."<init>":()V
   *             4: return
   *          LineNumberTable:
   *            line 10: 0
   *          LocalVariableTable:
   *            Start  Length  Slot  Name   Signature
   *                0       5     0  this   Ldemo/concatstring/ExempleStringBuilder;
   *    
   *      public static void main(java.lang.String[]);
   *        descriptor: ([Ljava/lang/String;)V
   *        flags: ACC_PUBLIC, ACC_STATIC
   *        Code:
   *          stack=0, locals=1, args_size=1
   *             0: invokestatic  #16                 // Method sampleUseStringBuilderOk:()V
   *             3: return
   *          LineNumberTable:
   *            line 15: 0
   *            line 16: 3
   *          LocalVariableTable:
   *            Start  Length  Slot  Name   Signature
   *                0       4     0  args   [Ljava/lang/String;
   *    }
   *    SourceFile: "ExempleStringBuilder.java"
   */
   private static void sampleUseStringBuilderOk () {
      String sbStringConcat = new String();
      for (int i = 0; i < 5; i++) {
         // Il faut faire
         sbStringConcat = sbStringConcat + "sampleUseStringBuilderOk " + i + "\n";
      }
      System.out.println("sampleUseStringBuilderOk : \n" + sbStringConcat);
   }
}
