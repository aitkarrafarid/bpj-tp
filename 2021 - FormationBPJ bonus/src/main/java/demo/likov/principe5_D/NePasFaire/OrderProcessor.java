package demo.likov.principe5_D.NePasFaire;

import demo.likov.Order;
import demo.likov.principe1_S.AFaire.ConfirmationEmailSender;
import demo.likov.principe1_S.AFaire.MySQLOrderRepository;

/**
 * En Java, ce principe SOLID est d�crit comme suit : les d�pendances au sein du syst�me sont construites sur la base d'abstractions.
 * Les modules de niveau sup�rieur ne d�pendent pas des modules de niveau inf�rieur. Les abstractions ne doivent pas d�pendre des d�tails.
 * Les d�tails doivent d�pendre des abstractions. Le logiciel doit �tre con�u de mani�re � ce que les diff�rents modules 
 * soient autonomes et connect�s les uns aux autres par abstraction.
 * 
 * Une application classique de ce principe est le Spring Framework. Dans Spring Framework, tous les modules sont impl�ment�s en tant que composants distincts pouvant fonctionner ensemble. 
 * Ils sont si autonomes qu'ils peuvent �tre utilis�s tout aussi facilement dans des modules de programme autres que Spring Framework.
 * 
 * Ceci est r�alis� gr�ce � la d�pendance des principes ferm� et ouvert. Tous les modules donnent acc�s uniquement � l'abstraction, qui peut �tre utilis�e dans un autre module. Essayons d'illustrer cela � l'aide d'un exemple. 
 * Parlant du principe de responsabilit� unique, nous avons consid�r� le classe OrderProcessor avec l'instanciation de 'MySQLOrderRepository' et 'ConfirmationEmailSender'.
 * Mais nous violons le "L" du SOLID car ces 2 classes se trouvent dans le niveau inf�rieur (couche persistance/technique).
 * 
 * Ces classes sont loin de ce que nous appellerions des abstractions. 
 * Et du point de vue du principe d'inversion des d�pendances, il serait pr�f�rable de commencer par cr�er des abstractions 
 * avec lesquelles nous pourrons travailler � l'avenir, plut�t que des impl�mentations sp�cifiques. 
 * Cr�ons deux interfaces : MailSenderet OrderRepository. Ce seront nos abstractions.
 *  
 * {@link https://codegym.cc/fr/groups/posts/fr.232.solid-cinq-principes-de-base-de-la-conception-de-classes-en-java}
 */
public class OrderProcessor {
   public void process (Order order) {

      MySQLOrderRepository repository = new MySQLOrderRepository();
      ConfirmationEmailSender mailSender = new ConfirmationEmailSender();

      if (order.isValid() && repository.save(order)) {
         mailSender.sendConfirmationEmail(order);
      }
   }
}
