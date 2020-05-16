package lyli.dessin;

/**
 * @author lylia
 *
 */
public class Coordonnee {

    /**
     * coordonée x.
     */
	 int x;
    
	
	/**
     * coordonée y.
     */
	int y;

    /**
     * constructeur de la class Coordonnee.
     * @param x la possition dans l'ax des x
     * @param y la possition dans l'ax des Y
     */
	public Coordonnee(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * méthode copy.
	 * @return ue copie de la coordonnee
	 *
	 * */
	public Coordonnee copy () {
        return new Coordonnee(this.x, this.y);
    }
	
	/**
	 * méthode equals.
	 * @param coordonnee a tester l'égalité
	 * @return vrai ou faux
     **/
	public boolean equals (Coordonnee coordonnee) {
	        return this.x == coordonnee.x && this.y == coordonnee.y;
	    }
	 /**
     * methode qui modifie la coordonée x.
     *@param x à modifier
     *  */
	  public void setX(int x) {
			this.x = x;
		}
		 /**
	     * methode qui modifie la coordonée y.
	     * @param y a modifier
	     *  */
		public void setY(int y) {
			this.y = y;
		}
	 /**
     * methode qui retourne la coordonée x.
     * @return coordonée x.
     *  */
	public int getX() {
    	return x;
     }
    /**
     * methode qui retourne la coordonée y.
     * @return coordonée y
     */
    public int getY() {
    	return y;
       }
    /**
     * methode qui renvoi décription d'une coordonnee.
     */
    @Override
    public String toString() {
    	return "(" + x + "," + y + ")";
        }
}
