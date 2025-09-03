package demo.likov.principe3_L.NePasFaire;

import demo.likov.Item;
import demo.likov.Order;

/**
 * Il s'agit d'une variante du principe ouvert ferm� que nous avons mentionn� pr�c�demment. Il peut �tre d�fini comme suit : 
 * les objets peuvent �tre remplac�s par des objets de sous-classes sans modifier les propri�t�s d'un programme.
 * 
 * Cela signifie qu'une classe cr��e en �tendant une classe de base doit remplacer ses m�thodes afin que la fonctionnalit� 
 * ne soit pas compromise du point de vue du client. Autrement dit, si un d�veloppeur �tend votre classe et l'utilise dans 
 * une application, il ne doit pas modifier le comportement attendu des m�thodes remplac�es.
 * 
 * Les sous-classes doivent remplacer les m�thodes de la classe de base afin que la fonctionnalit� ne soit pas interrompue 
 * du point de vue du client. Nous pouvons explorer cela en d�tail dans l'exemple suivant.
 * 
 * Supposons que nous ayons une classe charg�e de valider une commande et de v�rifier si toutes les marchandises de la commande 
 * sont en m�thode stock.isValid() qui retourne true ou false. 
 * Supposons �galement que certaines commandes doivent �tre valid�es diff�remment des autres, par exemple pour certaines commandes, 
 * nous devons v�rifier si toutes les marchandises de la commande sont en stock et si toutes les marchandises sont emball�es. 
 * 
 * Pour ce faire, nous �tendons la OrderStockValidatorclasse en cr�ant la classe OrderStockAndPackValidator 
 * 
 * {@link https://codegym.cc/fr/groups/posts/fr.232.solid-cinq-principes-de-base-de-la-conception-de-classes-en-java}
 */
public class OrderStockValidator {
   public boolean isValid (Order order) {
      for (Item item : order.getItems()) {
         // Nous devons v�rifier si toutes les marchandises de la commande :
         //    - sont en stock 
         //    - et si toutes les marchandises sont emball�es
         if (!item.isInStock() || !item.isPacked()) {
            throw new IllegalStateException(
                  String.format("Order %d is not valid!", order.getId()));
         }
      }

      return true;
   }
}
