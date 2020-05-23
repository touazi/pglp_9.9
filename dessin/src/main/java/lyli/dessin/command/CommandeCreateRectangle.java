package lyli.dessin.command;
import lyli.dessin.Coordonnee;
import lyli.dessin.Rectangle;
/**.
 * <b>"L'implementation de la class CommandeCreateRectangle."</b>
 * @author TOUAZI,Lylia
 */
public class CommandeCreateRectangle implements
CommandeCreateForme<Rectangle> {
/**
 * nom d'un rectangle.
 */
	private String nameRactagle;
  /**
   * la Coordonnee d'un poind du rectangle.
   */
  private Coordonnee p;

  /**
   * la longueur du rectangle.
   */
  private int sideLon;

  /**
   * la largeur du rectangle.
   */
  private int sideLar;

  /**
   * costructeur de la class CommandCreateRectangle.
   * @param nameRactagle nom du rectangle.
   * @param p la Coordonnee d'un poind du rectangle.
   * @param sideLon la longueur du rectangle.
   * @param sideLar la largeur du rectangle.
   */
  public CommandeCreateRectangle(final String nameRactagle, final
		  Coordonnee p, final int sideLon, final int sideLar) {
    this.nameRactagle = nameRactagle;
    this.p = p;
    this.sideLon = sideLon;
    this.sideLar = sideLar;
  }

  @Override
  /**
   * methode pour executer la commande de creation.
   * d'un rectangle.
   */
  public final Rectangle execute() {
    return new Rectangle(nameRactagle, p, sideLon, sideLar);
  }
}
