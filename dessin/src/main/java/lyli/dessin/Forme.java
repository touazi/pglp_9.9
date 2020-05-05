package lyli.dessin;

/**
 * @author lylia
 *
 */
public abstract class Forme {
    /**
     * nom de Forme.
     */
    private String NameForme;
    /**
     * constructeur pour la class Forme.
     * @param NomForme
     * définir le nom de la forme
     */
	public Forme(String NameForme) {
		this.NameForme = NameForme;
	}
    /**
     *le nom de la forme.
     * @return NomForme
     *  le nom de la forme
     */
    public String getNameForme() {
        return NameForme;
    }
    /**
     * deplacement d'une forme.
     * @param coor déplacement de la coordonnee
     **/
    public abstract void move(String NameForme, int x, int y);
    /**
     * affichage de la forme.
     */
    public abstract void affiche();
}
