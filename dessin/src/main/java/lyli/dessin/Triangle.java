package lyli.dessin;
/**
 *class Triangle
 * @author TOUAZI,Lylia
 */
public class Triangle extends Forme implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	/**Constructeur de la class Triangle.
	 * @param NameForme
	 * le nom de la du Triangle.
	 * @param point1
	 *  le point1 du Triangle. 
	 * @param point2
	 * le point2	 du Triangle.
	 * @param point3
	 * le point3 du Triangle.
	 * */
	public Triangle(final String NameForme, final Coordonnee point1,
			final Coordonnee point2, final Coordonnee point3) {
		super(NameForme);
		this.point1 = point1.copy();
		this.point2 = point2.copy();
		this.point3 = point3.copy();
	}

	/**la methode move.
	 * <p>pour déplacer la Triangle</p>
	 * @param NameForme
	 * le nom de la du Triangle.
	 * @param x
	 *  le décalage des  coorrdonnees sur l'ax des X
	 * @param y
	 * le décalage des coorrdonnees sur l'ax des Y
	 * */
	@Override
	public void move(final String NameForme, final int x, final int y) {
		this.point1.setX(this.point1.getX() + x);
		this.point1.setY(this.point1.getY() + y);
		this.point2.setX(this.point2.getX() + x);
		this.point2.setY(this.point2.getY() + y);
		this.point3.setX(this.point3.getX() + x);
		this.point3.setY(this.point3.getY() + y);
		
	}
	/**la methode affiche.
	 * affiche les information du trinagle*/
	@Override
	public void affiche() {
	    System.out.println("Triangle(position point1 = " +  point1 + ",position point2 = " + point2
                + ", position point3 = " + point3 + ")");
	    }
	/**La methode getCoordonnee.
	 * @return
	 * la position du point1.
	 * */
	public Coordonnee getCoordonnee1() {
		return this.point1;
	}
	/**La methode getCoordonnee.
	 * @return
	 * la position du point2.
	 * */
	public Coordonnee getCoordonnee2() {
		return this.point2;
	}
	/**La methode getCoordonnee.
	 * @return
	 * la position du point3.
	 * */
	public Coordonnee getCoordonnee3() {
		return this.point3;
	}
}