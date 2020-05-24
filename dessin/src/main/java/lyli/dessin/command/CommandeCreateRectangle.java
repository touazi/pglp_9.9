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
   * @param nameRactaglee nom du rectangle.
   * @param pp la Coordonnee d'un poind du rectangle.
   * @param sideLonn la longueur du rectangle.
   * @param sideLarr la largeur du rectangle.
   */
  public CommandeCreateRectangle(final String nameRactaglee, final
        Coordonnee pp, final int sideLonn, final int sideLarr) {
    this.nameRactagle = nameRactaglee;
    this.p = pp;
    this.sideLon = sideLonn;
    this.sideLar = sideLarr;
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
