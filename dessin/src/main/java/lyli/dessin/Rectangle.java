package lyli.dessin;

public class Rectangle extends Forme {
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
	/**Constructeur de la class Rectangle.
	 * @param NameForme
	 * le nom de la du Rectangle.
	 * @param topLeft
	 *  la position du point topleft
	 * @param sideTop
	 * la taille d'un coté  haut du carre
	 * @param sideLeft
	 * la taille d'un coté  left du carre
	 * */
	public Rectangle(String NameForme,Coordonnee topLeft, int sideTop, int sideLeft) {
		super(NameForme);
		this.topLeft = topLeft.copy();
		this.sideTop = sideTop;
		this.sideLeft = sideLeft;
	}
	/**la methode move.
	 * <p>pour déplacer la rectange</p>
	 * @param NameForme
	 * le nom de la du rectange.
	 * @param x
	 *  le décalage de la coorrdonnee sur l'ax des X
	 * @param y
	 * le décalage de la coorrdonnee sur l'ax des Y
	 * */
	@Override
	public void move(String NameForme,int x, int y) {
		this.topLeft.setX(this.topLeft.getX()+x);
		this.topLeft.setY(this.topLeft.getY()+y);
		
	}
	/**la methode affiche.
	 * affiche les information du rectange*/

	@Override
	public void affiche() {
        System.out.println("Rectangle(longueur = " + sideTop + ", largeur = " + sideLeft
                + ", position point = " + topLeft + ")");
    
		
	}
	/**La methode getCoordonnee.
	 * @return
	 * la position du point topLeft.
	 * */
	public Coordonnee getCoordonnee() {
		return this.topLeft;
	}
	/**La methode getsideTop.
	 * @return
	 * taille du coté haut du rectangle.
	 * */
	public int getsideTop() {
		return this.sideTop;
	}
	/**La methode getsideLeft.
	 * @return
	 * taille du coté left du rectangle.
	 * */
	public int getsideLeft() {
		return this.sideLeft;
	}

}
