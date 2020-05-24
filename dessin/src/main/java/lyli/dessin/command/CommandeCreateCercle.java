package lyli.dessin.command;
import lyli.dessin.Cercle;
import lyli.dessin.Coordonnee;
/**.
 * <b>"L'implementation de la class CommandeCreateCercle."</b>
 * @author TOUAZI,Lylia
 */
public class CommandeCreateCercle implements
CommandeCreateForme<Cercle> {
	/**.
   * nom d un cercle.
   */
  private String nomCercle;

  /**
   * point centre d'un cercle.
   */
  private Coordonnee centre;

  /**
   * le rayon d'un cercle.
   */
  private int rayon;

  /**
   * constructeur de la class CommandeCreateCercle.
   * @param nomCerclee nom du Cercle.
   * @param centree le centre du cercle.
   * @param rayonn du cercle.
   */
  public CommandeCreateCercle(final String nomCerclee, final
		  Coordonnee centree, final int rayonn) {
	    this.nomCercle = nomCerclee;
	    this.centre = centree;
	    this.rayon = rayonn;
	     }

  @Override
  /**
   * methode pour executer la commande de creation.
   *  du cercle.
   */
  public final Cercle execute() {
    return new Cercle(nomCercle, centre, rayon);
  }
}
