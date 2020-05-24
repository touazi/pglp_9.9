package lyli.dessin;
/**
 * <b>"L'implementation de la class Carre.</b> un Carre a :
 * <ul>
 * <li>un point topLeft</li>
 * <li>side</li>
 * </ul>
 * @author TOUAZI,Lylia
 */
public class Carre extends Forme implements java.io.Serializable {
/**
 *
 */

private static final long serialVersionUID = 1L;
/**
 * nom du carre.
 * */
private String nameForme;
/**
 * la Coordonnee d'un poind du carre.
 */
private Coordonnee topLeft;
/**
 * la taille d'un coté du carre.
 */
private int side;
/**
 * La methode getCoordonnee.
 * @return la position du point topleft.
 */
public final Coordonnee getCoordonnee() {
	return this.topLeft;
}
/**
 * La methode getside.
 * @return la taille d'un coté du carre.
 */
public final int getside() {
	return this.side;
}
/**
 * Constructeur de la class Carre.
 * @param nameFormee le nom de la du carré.
 * @param topLeftt   la position du point topleft
 * @param sidee      la taille d'un coté du carre
 */
public Carre(final String nameFormee, final Coordonnee topLeftt,
		final int sidee) {
	super(nameFormee);
	this.topLeft = topLeftt.copy();
	this.side = sidee;
	this.nameForme = nameFormee;
}
/**
 * la methode affiche. affiche les information du carré.
 */
@Override
public final void affiche() {
	System.out.println("  Carre(nom = \"" + nameForme
		+ "\", longueur = " + side + ","
+ " position = " + topLeft + ")");
}
/**
 * la methode move.
 * <p>
 * pour déplacer la carré
 * </p>
 * @param nameFormee le nom de la du carré.
 * @param xx         le décalage de la corrdonnee sur l'ax des X
 * @param yy         le décalage de la corrdonnee sur l'ax des Y
 */
@Override
public final void move(final String nameFormee, final int xx,
		final int yy) {
	this.topLeft.setX(this.topLeft.getX() + xx);
	this.topLeft.setY(this.topLeft.getY() + yy);
}
/**
 * La methode isGroupe.
 * @return oui si c'est un groupe ou non sinon.
 */
@Override
public final boolean isGroupe() {
	// TODO Auto-generated method stub
		return false;
	}
}
