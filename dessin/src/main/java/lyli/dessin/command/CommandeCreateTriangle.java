package lyli.dessin.command;
import lyli.dessin.Coordonnee;
import lyli.dessin.Triangle;
/**
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
   * @param nomTriangle du triangle.
   * @param p1 ponit reference1.
   * @param p2 ponit reference2.
   * @param p3 point reference3.
   */
  public CommandeCreateTriangle(final String nomTriangle,
		  final Coordonnee p1,
		  final Coordonnee p2,
		  final Coordonnee p3) {
    this.nomTriangle = nomTriangle;
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
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
