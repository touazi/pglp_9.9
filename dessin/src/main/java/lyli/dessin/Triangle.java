package lyli.dessin;

public class Triangle extends Forme{
	private Coordonnee point1;
	private Coordonnee point2;
	private Coordonnee point3;


	public Triangle(String NameForme, Coordonnee point1, Coordonnee point2, Coordonnee point3) {
		super(NameForme);
		this.point1 = point1.copy();
		this.point2 = point2.copy();
		this.point3 = point3.copy();
	}

	@Override
	public void move(String NameForme, int x, int y) {
		this.point1.setX(this.point1.getX()+x);
		this.point1.setY(this.point1.getY()+y);
		
		this.point2.setX(this.point2.getX()+x);
		this.point2.setY(this.point2.getY()+y);
		
		this.point3.setX(this.point3.getX()+x);
		this.point3.setY(this.point3.getY()+y);
		
	}

	@Override
	public void affiche() {
	    System.out.println("Triangle(position point1 = " +  point1 + ",position point2 = " + point2
                + ", position point3 = " + point3 + ")");
		
	}
	Coordonnee getCoordonnee1() {
		return this.point1;
	}
	Coordonnee getCoordonnee2() {
		return this.point2;
	}
	Coordonnee getCoordonnee3() {
		return this.point3;
	}

}
