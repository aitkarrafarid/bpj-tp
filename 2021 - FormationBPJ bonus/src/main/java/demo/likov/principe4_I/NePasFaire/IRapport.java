package demo.likov.principe4_I.NePasFaire;

/**
 * Ce principe est caract�ris� par la d�claration suivante : le client ne doit pas �tre contraint d'impl�menter des m�thodes qu'il n'utilisera pas.
 * Le principe de s�gr�gation des interfaces signifie que les interfaces trop "�paisses" doivent �tre divis�es en interfaces plus petites et plus sp�cifiques, afin que les clients utilisant de petites interfaces ne connaissent que les m�thodes dont ils ont besoin pour leur travail. Par cons�quent, lorsqu'une m�thode d'interface change, les clients qui n'utilisent pas cette m�thode ne doivent pas changer.
 * Prenons cet exemple : Alex, un d�veloppeur, a cr�� une interface "IRapport" et ajout� deux m�thodes : 
 *    - generateExcel()
 *    - et generatedPdf(). 
 *    
 * Maintenant, un client souhaite utiliser cette interface, mais n'a l'intention d'utiliser que des rapports au format PDF, et non dans Excel. 
 * Cette fonctionnalit� satisfera-t-elle ce client ?
 * --> Non. Le client devra impl�menter deux m�thodes, dont l'une est largement inutile et n'existe que gr�ce � Alex, celui qui a con�u le logiciel. Le client utilisera une interface diff�rente ou ne fera rien avec la m�thode pour les rapports Excel.
 * Alors, quelle est la solution? Il s'agit de diviser l'interface existante en deux plus petites. 
 * L'un pour les rapports PDF, l'autre pour les rapports Excel. 
 * Cela permet aux clients d'utiliser uniquement les fonctionnalit�s dont ils ont besoin.
 * 
 * {@link https://codegym.cc/fr/groups/posts/fr.232.solid-cinq-principes-de-base-de-la-conception-de-classes-en-java}
 */
public interface IRapport {

   abstract public void generateExcel ();

   abstract public void generatePdf ();
}
