package lyli.dessin;
/**
 * class Triangle.
 * @author TOUAZI,Lylia
 */
public class Triangle extends Forme implements java.io.Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * nom du triangle.
	 * */
	private String nameForme;
	/**
	 * le point1 du Triangle.
	 */
	private Coordonnee point1;
	/**
	 * le point2 du Triangle.
	 */
	private Coordonnee point2;
	/**
	 * le point3 du Triangle.
	 */
	private Coordonnee point3;
	/**
	 * Constructeur de la class Triangle.
	 * @param nameFormee le nom de la du Triangle.
	 * @param point11    le point1 du Triangle.
	 * @param point22    le point2 du Triangle.
	 * @param point33    le point3 du Triangle.
	 */
	public Triangle(final String nameFormee,
			final Coordonnee point11,
			final Coordonnee point22,
			final Coordonnee point33) {
		super(nameFormee);
		this.nameForme = nameFormee;
		this.point1 = point11.copy();
		this.point2 = point22.copy();
		this.point3 = point33.copy();
	}
	/**
	 * la methode move.
	 * <p>
	 * pour déplacer la Triangle
	 * </p>
	 * @param nameFormee le nom de la du Triangle.
	 * @param x         le décalage des coorrdonnees sur l'ax des X
	 * @param y         le décalage des coorrdonnees sur l'ax des Y
	 */
	@Override
	public final void move(final String nameFormee, final int x,
			 final int y) {
		this.point1.setX(this.point1.getX() + x);
		this.point1.setY(this.point1.getY() + y);
		this.point2.setX(this.point2.getX() + x);
		this.point2.setY(this.point2.getY() + y);
		this.point3.setX(this.point3.getX() + x);
		this.point3.setY(this.point3.getY() + y);
	}
	/**
	 * la methode affiche. affiche les information du trinagle
	 */
	@Override
	public final void affiche() {
		System.out.println("  Triangle(nom = \"" + nameForme
				+ "\", position point1 = " + point1
				+ ",position point2 = " + point2
				+ ", position point3 = " + point3
				+ ")");
	}
	/**
	 * La methode getCoordonnee.
	 * @return la position du point1.
	 */
	public final Coordonnee getCoordonnee1() {
		return this.point1;
	}
	/**
	 * La methode getCoordonnee.
	 * @return la position du point2.
	 */
	public final Coordonnee getCoordonnee2() {
		return this.point2;
	}
	/**
	 * La methode getCoordonnee.
	 * @return la position du point3.
	 */
	public final Coordonnee getCoordonnee3() {
		return this.point3;
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
