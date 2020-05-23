package lyli.dessin.command;
import lyli.dessin.Carre;
import lyli.dessin.Coordonnee;
/**
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
	   * @param nomCarre nom du carre.
	   * @param p la Coordonnee d'un point du carre.
	   * @param side la taille d'un coté du carre.
	   */
	  public CommandeCreateCarre(final String nomCarre, final
			  Coordonnee p, final int side) {
	    this.nomCarre = nomCarre;
	    this.p = p;
	    this.side = side;
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
