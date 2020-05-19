package lyli.dessin;
/**
 * <b>"L'implementation de la class Forme.</b>
 * @author TOUAZI,Lylia
 */
public abstract class Forme {
	/**
	 * nom de Forme.
	 */
	private String nameForme;
	/**
	 * constructeur pour la class Forme.
	 * @param nameForme définir le nom de la forme
	 */
	public Forme(String nameForme) {
		this.nameForme = nameForme;
	}
	/**
	 * le nom de la forme.
	 * @return le nom de la forme
	 */
	public String getNameForme() {
		return nameForme;
	}
	/**
	 * deplacement d'une forme.
	 * @param nameForme le nom de la forme
	 * @param x         decalage d'ax des x
	 * @param y         decalage de l'ax des y
	 **/
	public abstract void move(String nameForme, int x, int y);
	/**
	 * affichage de la forme.
	 */
	public abstract void affiche();
	/**
	 * methode isGroupe.
	 * @return renvoie si la forme est un groupe ou non
	 */
	abstract public boolean isGroupe();
}