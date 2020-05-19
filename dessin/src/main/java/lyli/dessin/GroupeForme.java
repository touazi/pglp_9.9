package lyli.dessin;
import java.util.ArrayList;
/**
 * <b>"L'implementation de la class GroupeForme.</b> un groupe de forme a :
 * <ul>
 * <li>idGroupe</li>
 * <li>formes</li>
 * </ul>
 * appliquation du pattern `Composite`.
 * @author TOUAZI,Lylia
 */
public class GroupeForme extends Forme implements java.io.Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * idenfiant du groupe.
	 */
	private int idGroupe;
	/**
	 * la liste des formes.
	 */
	private ArrayList<Forme> formes;
	/**
	 * constructeur de la class GroupeFormes. 
	 * @param nameForme nom de la forme
	 */
	public GroupeForme(final String nameForme) {
		super(nameForme);
		formes = new ArrayList<Forme>();
		idGroupe = 1 + (int) (Math.random() * ((1000 - 1) + 1));
	}
	/**
	 * constructeur de la class GroupeFormes. 
	 * @param nameForme nom de la forme
	 * @param formes    la liste des formes.
	 */
	public GroupeForme(final String nameForme, final ArrayList<Forme> formes) {
		super(nameForme);
		this.formes = formes;
	}
	/**
	 * constructeur de la class GroupeFormes. 
	 * @param nameForme nom de la forme
	 * @param idGroupe  idenfiant du groupe
	 */
	public GroupeForme(final String nameForme, final int idGroupe) {
		super(nameForme);
		formes = new ArrayList<Forme>();
		this.idGroupe = idGroupe;
	}
	/**
	 * methode move. 
	 * @param x le décalage des coorrdonnees sur l'ax des X
	 * @param y le décalage des coorrdonnees sur l'ax des Y
	 */
	@Override
	public void move(final String nameForme, final int x,
			final int y) {
		for (Forme f : formes) {
			f.move(nameForme, x, y);
		}
	}
	/**
	 * methode affiche. affiche les formes dans ce groupe.
	 */
	@Override
	public void affiche() {
		System.out.println("Groupe {");
		for (Forme forme : formes) {
			forme.affiche();
		}
		System.out.println(" }");
	}
	/**
	 * methode ajouterForme.
	 * 
	 * @param forme forme à ajouter au groupe
	 */
	public void ajouterForme(final Forme forme) {
		formes.add(forme);
	}
	/**
	 * methode supprimerForme.
	 * 
	 * @param forme forme à supprimer dans le groupe
	 */
	public void supprimerForme(final Forme forme) {
		formes.remove(forme);
	}
	/**
	 * methode getListForm.
	 * @return la liste des formes
	 */
	public ArrayList<Forme> getListForm() {
		return this.formes;
	}
	/**
	 * methode getId.
	 * 
	 * @return identifiant du groupe
	 */
	public String getId() {
		return idGroupe + " ";
	}
	/**
	 * La methode isGroupe.
	 * @return oui si c'est un groupe ou non sinon.
	 */
	@Override
	public boolean isGroupe() {
		// TODO Auto-generated method stub
		return true;
	}
}