package lyli.dessin.command;
import lyli.dessin.Carre;
import lyli.dessin.Coordonnee;
/**.
 * <b>"L'implementation de la class CommandeCreateCarre."</b>
 * @author TOUAZI,Lylia
 */
public class CommandeCreateCarre implements CommandeCreateForme<Carre> {
	  /**
	   * nom du carre.
	   */
	  private String nomCarre;

	  /**
	   * la Coordonnee d'un poind du carre.
	   */
	  private Coordonnee p;

	  /**
	   * la taille d'un cote du carre.
	   */
	  private int side;

	  /**
	   * constructeur de la class CommandeCreateCarre.
	   * @param nomCarree nom du carre.
	   * @param pp la Coordonnee d'un point du carre.
	   * @param sidee la taillee d'un coté du carre.
	   */
	  public CommandeCreateCarre(final String nomCarree, final
			  Coordonnee pp, final int sidee) {
	    this.nomCarre = nomCarree;
	    this.p = pp;
	    this.side = sidee;
	  }

	  @Override
	  /**
	   * methode pour executer la commande.
	   *  de creation du carre.
	   */
	  public final Carre execute() {
	    return new Carre(nomCarre, p, side);
	  }
}
