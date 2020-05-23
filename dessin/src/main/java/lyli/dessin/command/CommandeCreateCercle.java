package lyli.dessin.command;
import lyli.dessin.Cercle;
import lyli.dessin.Coordonnee;
/**
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
   * @param nomCercle nom du Cercle.
   * @param centre le centre du cercle.
   * @param rayon du cercle.
   */
  public CommandeCreateCercle(final String nomCercle, final
		  Coordonnee centre, final int rayon) {
	    this.nomCercle = nomCercle;
	    this.centre = centre;
	    this.rayon = rayon;
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
