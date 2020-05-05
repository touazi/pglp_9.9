/**
 * 
 */
package lyli.dessin;

/**
 * @author lylia
 *
 */
public class Cercle extends Forme {
	/**
	 * le centre du cercle.
	 */
	Coordonnee centre ;
	/**
	 * le rayon du cercle.
	 */
	final int rayon ;
	/**Constructeur de la class Cercle.
	 * @param NameForme
	 * le nom de la du Cercle.
	 * @param centre
	 *  la position du centre
	 * @param rayon
	 * le rayon du cercle
	 * */
	public Cercle(String NameForme,final Coordonnee centre, final int rayon) {
		super(NameForme);
		this.centre = centre.copy();
		this.rayon = rayon;
	}


	
	/**la methode move.
	 * <p>pour déplacer la Cercle</p>
	 * @param NameForme
	 * le nom de la du Cercle.
	 * @param x
	 *  le décalage de la coorrdonnee sur l'ax des X
	 * @param y
	 * le décalage de la coorrdonnee sur l'ax des Y
	 * */
	@Override
	public void move(String NameForme,int x, int y) {
		centre.setX(centre.getX()+ x);
		centre.setY(centre.getY()+ y);
		}
	/**la methode affiche.
	 * affiche les information du cercle*/
	@Override
	public void affiche() {
		System.out.println("Cercle("+ "centre = " + centre + ", rayon = " + rayon + ")");
	}
	/**La methode getCoordonnee.
	 * @return
	 * la position du point centre.
	 * */
	Coordonnee getCoordonnee() {
		return this.centre;
	}
	/**La methode getrayon.
	 * @return
	 * le rayon du cerle.
	 * */
	int getrayon() {
		return this.rayon;
	}	
}
