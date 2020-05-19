package lyli.dessin;
/**
 * @author lylia
 */
public class Cercle extends Forme implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * le centre du cercle.
	 */
	Coordonnee centre;
	/**
	 * le rayon du cercle.
	 */
	final int rayon;
	/**
	 * Constructeur de la class Cercle.
	 * @param nameForme le nom de la du Cercle.
	 * @param centre    la position du centre
	 * @param rayon     le rayon du cercle
	 */
	public Cercle(final String nameForme, final 
			Coordonnee centre, final int rayon) {
		super(nameForme);
		this.centre = centre.copy();
		this.rayon = rayon;
	}
	/**
	 * la methode move.
	 * <p>
	 * pour déplacer la Cercle
	 * </p>
	 * @param nameForme le nom de la du Cercle.
	 * @param x         le décalage de la coorrdonnee sur l'ax des X
	 * @param y         le décalage de la coorrdonnee sur l'ax des Y
	 */
	@Override
	public final void move(final String nameForme, final 
			int x, final int y) {
		centre.setX(centre.getX() + x);
		centre.setY(centre.getY() + y);
	}
	/**
	 * la methode affiche. affiche les information du cercle
	 */
	@Override
	public final void affiche() {
		System.out.println("  Cercle(" + "centre = " + centre 
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