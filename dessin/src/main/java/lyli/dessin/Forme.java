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
	 * @param nameFormee définir le nom de la forme
	 */
	public Forme(final String nameFormee) {
		this.nameForme = nameFormee;
	}
	/**
	 * le nom de la forme.
	 * @return le nom de la forme
	 */
	public final String getNameForme() {
		return nameForme;
	}
	/**
	 * deplacement d'une forme.
	 * @param nameFormee le nom de la forme
	 * @param x         decalage d'ax des x
	 * @param y         decalage de l'ax des y
	 **/
	 abstract void move(String nameFormee, int x, int y);
	/**
	 * affichage de la forme.
	 */
	 abstract void affiche();
	/**
	 * methode isGroupe.
	 * @return renvoie si la forme est un groupe ou non
	 */
	abstract boolean isGroupe();
}
