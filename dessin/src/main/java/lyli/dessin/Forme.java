package lyli.dessin;

/**
 * <b>"L'implementation de la class Forme.</b>
 * @author TOUAZI,Lylia
 */
public abstract class Forme {
    /**
     * nom de Forme.
     */
    private String NameForme;
    /**
     * constructeur pour la class Forme.
     * @param NameForme
     * définir le nom de la forme
     */
	public Forme(String NameForme) {
		this.NameForme = NameForme;
	}
    /**
     *le nom de la forme.
     * @return le nom de la forme
     */
    public String getNameForme() {
        return NameForme;
    }
    /**
     * deplacement d'une forme.
     * @param NameForme le nom de la forme
     * @param x decalage d'ax des x
     * @param y decalage de l'ax des y
     **/
    public abstract void move(String NameForme, int x, int y);
    /**
     * affichage de la forme.
     */
    public abstract void affiche();
}
