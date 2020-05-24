package lyli.dessin;
/**
 * @author lylia
 */
public class Coordonnee {
/**
 * coordonée x.
 */
private int x;
/**
 * coordonée y.
 */
private int y;
/**
 * constructeur de la class Coordonnee.
 * @param xx la possition dans l'ax des x
 * @param yy la possition dans l'ax des Y
 */
public Coordonnee(final int xx, final int yy) {
	this.x = xx;
	this.y = yy;
}
/**
 * méthode copy.
 * @return ue copie de la coordonnee
 */
public final Coordonnee copy() {
	return new Coordonnee(this.x, this.y);
}
/**
 * méthode equals.
 * @param coordonnee a tester l'égalité
 * @return vrai ou faux
 **/
public final boolean egale(final Coordonnee coordonnee) {
	return this.x == coordonnee.x && this.y == coordonnee.y;
}
/**
 * methode qui modifie la coordonée x.
 * @param xx à modifier
 */
public final void setX(final int xx) {
	this.x = xx;
}
/**
 * methode qui modifie la coordonée y.
 * @param yy a modifier
 */
public final void setY(final int yy) {
	this.y = yy;
}
/**
 * methode qui retourne la coordonée x.
 * @return coordonée x.
 */
public final int getX() {
	return x;
}
/**
 * methode qui retourne la coordonée y.
 * @return coordonée y
 */
public final int getY() {
	return y;
}
/**
 * methode qui renvoi décription d'une coordonnee.
 */
@Override
public final String toString() {
	return "(" + x + "," + y + ")";
	}
}
