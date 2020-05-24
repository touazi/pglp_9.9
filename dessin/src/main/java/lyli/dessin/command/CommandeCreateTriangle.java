package lyli.dessin.command;
import lyli.dessin.Coordonnee;
import lyli.dessin.Triangle;
/**.
 * <b>"L'implementation de la class CommandeCreateTriangle."</b>
 * @author TOUAZI,Lylia
 */
public class CommandeCreateTriangle  implements
CommandeCreateForme<Triangle> {
/**.
   * non du triangle.
   */
  private String nomTriangle;

  /**
   * La premiere Coordonnee d'un point du triangle.
   */
  private Coordonnee p1;

  /**
   * Le deuxième Coordonnee d'un point du triangle.
   */
  private Coordonnee p2;

  /**
   * La troisième Coordonnee d'un point du triangle.
   */
  private Coordonnee p3;

  /**
   * constructeur de la class CommandCreatTriangle.
   * @param nomTrianglee du triangle.
   * @param p11 ponit reference1.
   * @param p22 ponit reference2.
   * @param p33 point reference3.
   */
  public CommandeCreateTriangle(final String nomTrianglee,
       final Coordonnee p11,
       final Coordonnee p22,
       final Coordonnee p33) {
    this.nomTriangle = nomTrianglee;
    this.p1 = p11;
    this.p2 = p22;
    this.p3 = p33;
  }

  @Override
  /**
   * methode pour executer la commande de.
   * creation d'un triangle.
   */
  public final Triangle execute() {
    return new Triangle(nomTriangle, p1, p2, p3);
  }

}
