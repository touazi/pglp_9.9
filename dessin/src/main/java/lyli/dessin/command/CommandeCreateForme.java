package lyli.dessin.command;
/**
 * interface CommandCreate pour c.
 * @author Touazi Lylia.
 *
 * @param <T> la forme a crée.
 */

public interface CommandeCreateForme<T> extends Commande {
/**.
* Methode execute.
*@return un commande a executer.
* */
T execute();
}
