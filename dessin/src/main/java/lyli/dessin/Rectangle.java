package lyli.dessin;

public class Rectangle extends Forme {
    /**
     * point haut à gauche du rectangle.
     */
    private Coordonnee topLeft;
    /**
     * longueur du rectangle.
     */
    private int longueur;
    /**
     * largeur du rectangle.
     */
    private int largeur;
	public Rectangle(String NameForme,Coordonnee topLeft, int longueur, int largeur) {
		super(NameForme);
		this.topLeft = topLeft.copy();
		this.longueur = longueur;
		this.largeur = largeur;
	}

	@Override
	public void move(String NameForme,int x, int y) {
		this.topLeft.setX(this.topLeft.getX()+x);
		this.topLeft.setY(this.topLeft.getY()+y);
		
	}

	@Override
	public void affiche() {
        System.out.println("Rectangle(longueur = " + longueur + ", largeur = " + largeur
                + ", position point = " + topLeft + ")");
    
		
	}
	Coordonnee getCoordonnee() {
		return this.topLeft;
	}
	

}
