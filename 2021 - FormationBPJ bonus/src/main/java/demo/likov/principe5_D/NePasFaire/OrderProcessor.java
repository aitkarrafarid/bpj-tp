package demo.likov.principe5_D.NePasFaire;

import demo.likov.Order;
import demo.likov.principe1_S.AFaire.ConfirmationEmailSender;
import demo.likov.principe1_S.AFaire.MySQLOrderRepository;

/**
 * En Java, ce principe SOLID est décrit comme suit : les dépendances au sein du système sont construites sur la base d'abstractions.
 * Les modules de niveau supérieur ne dépendent pas des modules de niveau inférieur. Les abstractions ne doivent pas dépendre des détails.
 * Les détails doivent dépendre des abstractions. Le logiciel doit être conçu de manière à ce que les différents modules 
 * soient autonomes et connectés les uns aux autres par abstraction.
 * 
 * Une application classique de ce principe est le Spring Framework. Dans Spring Framework, tous les modules sont implémentés en tant que composants distincts pouvant fonctionner ensemble. 
 * Ils sont si autonomes qu'ils peuvent être utilisés tout aussi facilement dans des modules de programme autres que Spring Framework.
 * 
 * Ceci est réalisé grâce à la dépendance des principes fermé et ouvert. Tous les modules donnent accès uniquement à l'abstraction, qui peut être utilisée dans un autre module. Essayons d'illustrer cela à l'aide d'un exemple. 
 * Parlant du principe de responsabilité unique, nous avons considéré le classe OrderProcessor avec l'instanciation de 'MySQLOrderRepository' et 'ConfirmationEmailSender'.
 * Mais nous violons le "L" du SOLID car ces 2 classes se trouvent dans le niveau inférieur (couche persistance/technique).
 * 
 * Ces classes sont loin de ce que nous appellerions des abstractions. 
 * Et du point de vue du principe d'inversion des dépendances, il serait préférable de commencer par créer des abstractions 
 * avec lesquelles nous pourrons travailler à l'avenir, plutôt que des implémentations spécifiques. 
 * Créons deux interfaces : MailSenderet OrderRepository. Ce seront nos abstractions.
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
