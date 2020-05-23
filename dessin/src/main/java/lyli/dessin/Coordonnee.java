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
 * @param x la possition dans l'ax des x
 * @param y la possition dans l'ax des Y
 */
public Coordonnee(final int x, final int y) {
	this.x = x;
	this.y = y;
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
 * @param x à modifier
 */
public final void setX(final int x) {
	this.x = x;
}
/**
 * methode qui modifie la coordonée y.
 * @param y a modifier
 */
public final void setY(final int y) {
	this.y = y;
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
