package demo.likov.principe2_O.NePasFaire;

import demo.likov.Order;
import demo.likov.principe1_S.NePasFaire.OrderProcessor;

/**
 * Ce principe est d�crit comme suit : les entit�s logicielles (classes, modules, fonctions, etc.) doivent �tre ouvertes � l'extension, mais ferm�es � la modification.
 * Cela signifie qu'il devrait �tre possible de modifier le comportement externe d'une classe sans apporter de modifications au code existant de la classe. 
 * Selon ce principe, les classes sont con�ues de sorte que modifier une classe pour l'adapter � des conditions sp�cifiques n�cessite simplement de l'�tendre 
 * et de remplacer certaines fonctions.
 * Cela signifie que le syst�me doit �tre flexible, capable de fonctionner dans des conditions changeantes sans changer le code source.
 * 
 * Poursuivant notre exemple impliquant le traitement des commandes, supposons que nous devions effectuer certaines actions avant le traitement d'une commande 
 * ainsi qu'apr�s l'envoi de l'e-mail de confirmation. Au lieu de changer le OrderProcessorclasse elle-m�me :
 *    - nous l'�tendrons pour atteindre notre objectif sans violer le principe ouvert ferm�. 
 *    - mettons priv� "beforeProcessing()" et "afterProcessing()" qui n'ont pas de raison d'�tre appel� en dehors de "process()".
 *  
 * {@link https://codegym.cc/fr/groups/posts/fr.232.solid-cinq-principes-de-base-de-la-conception-de-classes-en-java}
 */
public class OrderProcessorWithPreAndPostProcessing extends OrderProcessor {
   @Override
   public void process (Order order) {
      beforeProcessing();
      super.process(order);
      afterProcessing();
   }

   public void beforeProcessing () {
      // Take some action before processing the order
   }

   public void afterProcessing () {
      // Take some action after processing the order
   }
}
