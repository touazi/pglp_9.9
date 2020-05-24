package lyli.dessin;
/**.
 * <b>"L'implementation de la class DrawingTUI."</b>
 * @author TOUAZI,Lylia
 */
public class Cercle extends Forme implements java.io.Serializable {
/**
 *
 */
private static final long serialVersionUID = 1L;
/**
 * nom du cercle.
 * */
private String nameForme;
/**
 * le centre du cercle.
 */
private Coordonnee centre;
/**
 * le rayon du cercle.
 */
private int rayon;
/**
 * Constructeur de la class Cercle.
 * @param nameFormee le nom de la du Cercle.
 * @param centree    la position du centre
 * @param rayonn     le rayon du cercle
 */
public Cercle(final String nameFormee, final
		Coordonnee centree, final int rayonn) {
	super(nameFormee);
	this.centre = centree.copy();
	this.rayon = rayonn;
	this.nameForme = nameFormee;
}
/**
 * la methode move.
 * <p>
 * pour déplacer la Cercle
 * </p>
 * @param nameFormee le nom de la du Cercle.
 * @param xx         le décalage de la coorrdonnee sur l'ax des X
 * @param yy         le décalage de la coorrdonnee sur l'ax des Y
 */
@Override
public final void move(final String nameFormee, final
		int xx, final int yy) {
	centre.setX(centre.getX() + xx);
	centre.setY(centre.getY() + yy);
}
/**
 * la methode affiche. affiche les information du cercle
 */
@Override
public final void affiche() {
	System.out.println("  Cercle(nom = \"" + nameForme
			+ "\", centre = "
			+ centre
			+ ", rayon = " + rayon + ")");
}
/**
 * La methode getCoordonnee.
 * @return la position du point centre.
 */
public final Coordonnee getCoordonnee() {
	return this.centre;
}
/**
 * La methode getrayon.
 *
 * @return le rayon du cerle.
 */
public final int getrayon() {
	return this.rayon;
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
