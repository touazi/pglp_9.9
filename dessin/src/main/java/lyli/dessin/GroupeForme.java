package lyli.dessin;

import java.util.ArrayList;
/**
 * <b>"L'implementation de la class  GroupeForme.</b>
 * un groupe de forme a :
 * <ul>
 * <li>IdGroupe</li>
 * <li>formes</li>
 * </ul>
 *appliquation du pattern `Composite`.
 * @author TOUAZI,Lylia
 */
public class GroupeForme extends Forme{
	/**
	 * idenfiant du groupe.
	 * */
	private int  IdGroupe;
	/**
     * la liste des formes.
     */
    private ArrayList<Forme> formes;
    /**
     * constructeur de la class GroupeFormes.
     * @param NameForme
     *  nom de la forme 
     */
    public GroupeForme(final String NameForme) {
        super(NameForme);
        formes = new ArrayList<Forme>();
        IdGroupe = 1 + (int)(Math.random() * ((1000 - 1) + 1));
    }
    /**
     * constructeur de la class GroupeFormes.
     * @param NameForme
     *  nom de la forme 
     *  @param formes
     *  la liste des formes.
     */
	public GroupeForme(final String NameForme, final ArrayList<Forme> formes) {
		super(NameForme);
		this.formes=formes; 
		}
    /**
     * constructeur de la class GroupeFormes.
     * @param NameForme
     *  nom de la forme 
     *  @param IdGroupe
     *   idenfiant du groupe
     */
	public GroupeForme(final String NameForme, final int IdGroupe) {
		super(NameForme);
		formes = new ArrayList<Forme>();
		this.IdGroupe=IdGroupe; 
		}
    /**
     * methode move.
     * @param x 
	 *le décalage des  coorrdonnees sur l'ax des X
     * @param y
     * le décalage des  coorrdonnees sur l'ax des Y
     */
    @Override
    public void move(final String NameForme, final int x, final int y) { 
        for (Forme f : formes) {
            f.move(NameForme,x, y);
        }
    }
    /**
     *methode affiche.
     *affiche les formes dans ce groupe.
     */
    @Override
    public void affiche() {
        System.out.println("Groupe ");
        for (Forme forme : formes) {
            forme.affiche();
        }
       
    }
    /**
     * methode ajouterForme.
     * @param forme
     *  forme à ajouter au groupe
     */
    public void ajouterForme(final Forme forme) {
            formes.add(forme);
    }
    /**
     * methode supprimerForme.
     * @param forme
     *  forme à supprimer dans le groupe
     */
    public void supprimerForme(final Forme forme) {
        formes.remove(forme);
    }

    /**
     * methode getListForm.
     * @return 
     * la liste des formes
     */
 
    public ArrayList<Forme> getListForm() {
        return this.formes;
    }
    /**
     * methode getId.
     * @return 
     * identifiant du groupe
     */
 
	public String getId() {
		return IdGroupe + " ";
	}
    
    
}
