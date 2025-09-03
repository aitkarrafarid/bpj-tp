package demo.likov.principe2_O.NePasFaire;

import demo.likov.Order;
import demo.likov.principe1_S.NePasFaire.OrderProcessor;

/**
 * Ce principe est décrit comme suit : les entités logicielles (classes, modules, fonctions, etc.) doivent être ouvertes à l'extension, mais fermées à la modification.
 * Cela signifie qu'il devrait être possible de modifier le comportement externe d'une classe sans apporter de modifications au code existant de la classe. 
 * Selon ce principe, les classes sont conçues de sorte que modifier une classe pour l'adapter à des conditions spécifiques nécessite simplement de l'étendre 
 * et de remplacer certaines fonctions.
 * Cela signifie que le système doit être flexible, capable de fonctionner dans des conditions changeantes sans changer le code source.
 * 
 * Poursuivant notre exemple impliquant le traitement des commandes, supposons que nous devions effectuer certaines actions avant le traitement d'une commande 
 * ainsi qu'après l'envoi de l'e-mail de confirmation. Au lieu de changer le OrderProcessorclasse elle-même :
 *    - nous l'étendrons pour atteindre notre objectif sans violer le principe ouvert fermé. 
 *    - mettons privé "beforeProcessing()" et "afterProcessing()" qui n'ont pas de raison d'être appelé en dehors de "process()".
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
