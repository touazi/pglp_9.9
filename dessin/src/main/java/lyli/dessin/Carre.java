/**
 * 
 */
package lyli.dessin;

/**
 * @author Touazi lylia
 *
 */
public class Carre extends Forme{


	Coordonnee topLeft ;
	Coordonnee getCoordonnee() {
		return this.topLeft;
	}
	final int side ;
	int getside() {
		return this.side;
	}
	public Carre(String NameForme,final Coordonnee topLeft, final int side) {
		super(NameForme);
		this.topLeft = topLeft.copy();
		this.side = side;
	}


	@Override
	public void affiche() {
		   System.out.println("Carre(longueur = " + side + ", position = " + topLeft + ")");
		
	}


	@Override
	public void move(String NameForme, int x, int y) {
		this.topLeft.setX(this.topLeft.getX()+x);
		this.topLeft.setY(this.topLeft.getY()+y);
		
	}

}
