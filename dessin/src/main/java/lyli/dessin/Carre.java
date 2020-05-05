/**
 * 
 */
package lyli.dessin;
/**
 * <b>"L'implementation de la class Carre.</b>
 * un Carre a :
 * <ul>
 * <li>un point topLeft </li>
 * <li>side</li>
 * </ul> 
 * @author TOUAZI,Lylia
 */
public class Carre extends Forme{
	/**
	 * la Coordonnee d'un poind du carre.
	 *
	 * */
	Coordonnee topLeft ;
	/**
	 * la taille d'un coté du carre.
	 *
	 * */
	final int side ;
	/**La methode getCoordonnee.
	 * @return
	 * la position du point topleft.
	 * */
	Coordonnee getCoordonnee() {
		return this.topLeft;
	}
	/**La methode getside.
	 * @return
	 * la taille d'un coté du carre.
	 * */
	int getside() {
		return this.side;
	}
	/**Constructeur de la class Carre.
	 * @param NameForme
	 * le nom de la du carré.
	 * @param topLeft
	 *  la position du point topleft
	 * @param side
	 * la taille d'un coté du carre
	 * */
	public Carre(String NameForme,final Coordonnee topLeft, final int side) {
		super(NameForme);
		this.topLeft = topLeft.copy();
		this.side = side;
	}

	/**la methode affiche.
	 * affiche les information du carré*/
	@Override
	public void affiche() {
		   System.out.println("Carre(longueur = " + side + ", position = " + topLeft + ")");
		
	}

	/**la methode move.
	 * <p>pour déplacer la carré</p>
	 * @param NameForme
	 * le nom de la du carré.
	 * @param x
	 *  le décalage de la corrdonnee sur l'ax des X
	 * @param y
	 * le décalage de la corrdonnee sur l'ax des Y
	 * */
	@Override
	public void move(String NameForme, int x, int y) {
		this.topLeft.setX(this.topLeft.getX()+x);
		this.topLeft.setY(this.topLeft.getY()+y);
		
	}

}
