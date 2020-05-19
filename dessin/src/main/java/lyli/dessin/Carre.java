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
	 * @param nameForme le nom de la du carré.
	 * @param topLeft   la position du point topleft
	 * @param side      la taille d'un coté du carre
	 */
	public Carre(final String nameForme, final Coordonnee topLeft,
			final int side) {
		super(nameForme);
		this.topLeft = topLeft.copy();
		this.side = side;
	}
	/**
	 * la methode affiche. affiche les information du carré
	 */
	@Override
	public final void affiche() {
		System.out.println("  Carre(longueur = " + side + "," 
	+ " position = " + topLeft + ")");
	}
	/**
	 * la methode move.
	 * <p>
	 * pour déplacer la carré
	 * </p>
	 * @param nameForme le nom de la du carré.
	 * @param x         le décalage de la corrdonnee sur l'ax des X
	 * @param y         le décalage de la corrdonnee sur l'ax des Y
	 */
	@Override
	public final void move(final String nameForme, final int x,
			final int y) {
		this.topLeft.setX(this.topLeft.getX() + x);
		this.topLeft.setY(this.topLeft.getY() + y);
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