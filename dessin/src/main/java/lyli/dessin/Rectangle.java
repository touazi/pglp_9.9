package lyli.dessin;
/**
 * class Rectangle.
 * @author TOUAZI,Lylia
 */
public class Rectangle extends Forme implements java.io.Serializable {
/**
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * nom du rectangle.
	 * */
	private String nameForme;
	/**
	 * point haut à gauche du rectangle.
	 */
	private Coordonnee topLeft;
	/**
	 * taille du coté haut du rectangle.
	 */
	private int sideTop;
	/**
	 * taille du coté left du rectangle.
	 */
	private int sideLeft;
	/**
	 * Constructeur de la class Rectangle.
	 * @param nameFormee le nom de la du Rectangle.
	 * @param topLeftt   la position du point topleft
	 * @param sideTopp   la taille d'un coté haut du carre
	 * @param sideLeftt  la taille d'un coté left du carre
	 */
	public Rectangle(final String nameFormee,
			final Coordonnee topLeftt,
			final int sideTopp,
			final int sideLeftt) {
		super(nameFormee);
		this.nameForme = nameFormee;
		this.topLeft = topLeftt.copy();
		this.sideTop = sideTopp;
		this.sideLeft = sideLeftt;
	}
	/**
	 * la methode move.
	 * <p>
	 * pour déplacer la rectange
	 * </p>
	 * @param nameForme le nom de la du rectange.
	 * @param x         le décalage de la coorrdonnee sur l'ax des X
	 * @param y         le décalage de la coorrdonnee sur l'ax des Y
	 */
	@Override
	public final void move(final String nameForme,
			final int x, final int y) {
		this.topLeft.setX(this.topLeft.getX() + x);
		this.topLeft.setY(this.topLeft.getY() + y);
	}
	/**
	 * la methode affiche. affiche les information du rectange
	 */
	@Override
	public final void affiche() {
		System.out.println(
				"  Rectangle(nom = \"" + nameForme
				+ "\", longueur = " + sideTop
				+ ", largeur = " + sideLeft
				+ ", position point = " + topLeft
				+ ")");
	}
	/**
	 * La methode getCoordonnee.
	 * @return la position du point topLeft.
	 */
	public final Coordonnee getCoordonnee() {
		return this.topLeft;
	}
	/**
	 * La methode getsideTop.
	 * @return taille du coté haut du rectangle.
	 */
	public final int getsideTop() {
		return this.sideTop;
	}
	/**
	 * La methode getsideLeft.
	 * @return taille du coté left du rectangle.
	 */
	public final int getsideLeft() {
		return this.sideLeft;
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
