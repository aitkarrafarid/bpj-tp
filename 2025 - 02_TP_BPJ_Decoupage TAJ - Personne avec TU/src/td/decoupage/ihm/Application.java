package td.decoupage.ihm;

import java.util.List;
import java.util.Scanner;

import td.decoupage.metier.Personne;
import td.decoupage.service.PersonneService;

public class Application implements IPersonneIhm {

   private static Application application = new Application();
   private static PersonneService personneService = new PersonneService();
   private static Scanner scanner = new Scanner(System.in);

   @Override
   public Personne obtenirPersonneSaisie() {
      System.out.println("--- Saisie d'une nouvelle personne ---");
      System.out.println("Entrer le nom (ou \"FIN\" pour sortir) : ");
      String nom = scanner.next();
      if ("FIN".equalsIgnoreCase(nom)) {
         return null;
      }
      else {
         System.out.println("Entrer le prenom : ");
         String prenom = scanner.next();
         System.out.println("Entrer l'age : ");
         int age = scanner.nextInt();
         return new Personne(nom, prenom, age);
      }
   }

   public static int choixMenu() {
      System.out.println("--- Menu General ---");
      System.out.println("1. Afficher l'annuaire complet");
      System.out.println("2. Saisie d'une nouvelle personne");
      System.out.println("3. Rechercher les personnes de prenom...");
      System.out.println("4. Quitter");
      int retour = scanner.nextInt();
      if (retour < 0 || retour > 4) {
         System.out.println("Erreur de saisie");
         return -1;
      }
      return retour;
   }

   public static String saisieChaine() {
      return scanner.next();
   }

   public static void main(String[] args) throws Exception {
      int choix = 0;
      // init BDD
      System.out.println("initialisation de la structure de la BDD :  code retour = " + application.initBdD());

      do {
         choix = choixMenu();
         switch (choix) {
            case 1:
               System.out.println("Afficher TOUS !");
               System.out.println(getListeComplete());
               break;
            case 2:
               // Obtenir la personne saisie dans l'IHM
               Personne p = application.obtenirPersonneSaisie();
               // Ajouter la personne en BdD
               application.enregistrerPersonneEnBdD(p);
               System.out.println(p + "  est enregistree !");
               break;
            case 3:
               System.out.println("recherche de personnes :");
               System.out.println("Saisir le prenom voulu :");
               String prenom = saisieChaine();
               int nbPersonneDuPrenom = application.nbPersonnesNommees(prenom);
               System.out.println(nbPersonneDuPrenom + " personnes trouvees dont le prenom est " + prenom);

               break;
            case 4:
               // Nothing to do
               break;
            default:
               System.out.println("Vous devez saisir 1, 2, 3 ou 4 !!!");
               break;
         }
      } while (choix != 4);
      application.closeIhm();
   }

   // partie base de données
   @Override
   public int initBdD() throws Exception {
      return personneService.initBdD();
   }

   @Override
   public void closeIhm() throws Exception {
      scanner.close();
      personneService.closeService();
   }

   @Override
   public void enregistrerPersonneEnBdD(Personne p) throws Exception {
      personneService.enregistrerPersonneEnBdD(p);
   }

   @Override
   public int getNbPersonnesEnBdD() throws Exception {
      return personneService.getNbPersonnesEnBdD();
   }

   private static List<Personne> getListeComplete() throws Exception {
      return personneService.getListeComplete();
   }

   public List<Personne> recherchePersonneSelonPrenom(String prenom) throws Exception {
      return personneService.recherchePersonneSelonPrenom(prenom);
   }

   public int nbPersonnesNommees(String prenom) throws Exception {
      return personneService.nbPersonnesNommees(prenom);
   }

   @Override
   public List<Personne> getListComplete() throws Exception {
      return personneService.getListeComplete();
   }

}
