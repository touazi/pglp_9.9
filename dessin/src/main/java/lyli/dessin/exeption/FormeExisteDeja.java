package lyli.dessin.exeption;
/**.
 * <b>"l'exeption FormeExisteDeja."</b>
 * @author TOUAZI,Lylia
 */
public class FormeExisteDeja extends Exception {
/**.
*
*/
private static final long serialVersionUID = 1L;
/**
 * * @param message message d'erreur.
 */
public FormeExisteDeja(final String message) {
super(message);
}
}
