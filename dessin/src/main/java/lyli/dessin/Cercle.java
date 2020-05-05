/**
 * 
 */
package lyli.dessin;

/**
 * @author lylia
 *
 */
public class Cercle extends Forme {
	Coordonnee centre ;
	final int rayon ;
	/**
	 * 
	 */
	public Cercle(String NameForme,final Coordonnee centre, final int rayon) {
		super(NameForme);
		this.centre = centre.copy();
		this.rayon = rayon;
	}


	

	@Override
	public void move(String NameForme,int x, int y) {
		centre.setX(centre.getX()+ x);
		centre.setY(centre.getY()+ y);
		}

	@Override
	public void affiche() {
		System.out.println("Cercle("+ "centre = " + centre + ", rayon = " + rayon + ")");
	}

	Coordonnee getCoordonnee() {
		return this.centre;
	}
	int getrayon() {
		return this.rayon;
	}	
}
