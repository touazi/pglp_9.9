package lyli.dessin.command;
import java.sql.SQLException;
import lyli.dessin.Carre;
import lyli.dessin.Cercle;
import lyli.dessin.Forme;
import lyli.dessin.GroupeForme;
import lyli.dessin.Rectangle;
import lyli.dessin.Triangle;
import lyli.dessin.DAO.DAO;
import lyli.dessin.DAO.DaoFactory;
/**.
 * <b>"L'implementation de la class CommandSuprimer.</b>
 * @author TOUAZI,Lylia
 */
public class CommandDeplacer implements Command {
/**
 * forme à deplacer.
 * @see CommandDeplacer#CommandDeplacer(Forme)
 * @see CommandDeplacer#execute()
*/
	private Forme forme;
	/**  DaoFactory de type DaoFactory.
	    *@see CommandDeplacer#CommandDeplacer(Forme)
	    * @see CommandDeplacer#execute()
	    */
	private DaoFactory factory;
	/**
	 * constructeur de la classe CommandDeplacer.
	 * @param forme forme à créer
	 *  @throws SQLException lever les Exceptions SQL
	 */
	public CommandDeplacer(final Forme forme) throws SQLException {
		this.forme = forme;
		this.factory = new DaoFactory();
	}
	/**
	 * execution de la commande de deplacement.
	 */
	public final void execute()  {
		if (forme instanceof Cercle) {
			DAO<Cercle> dao = factory.getCercleDAO();
			 dao.update((Cercle) forme);
			factory.disconnect();
		} else if (forme instanceof Carre) {
			DAO<Carre> dao = factory.getCarreDAO();
		     dao.update((Carre) forme);
			factory.disconnect();
		} else if (forme instanceof Rectangle) {
			DAO<Rectangle> dao = factory.getRectangleDAO();
			dao.update((Rectangle) forme);
			factory.disconnect();
		} else if (forme instanceof Triangle) {
			DAO<Triangle> dao = factory.getTriangleDAO();
			dao.update((Triangle) forme);
			factory.disconnect();
		} else if (forme instanceof GroupeForme) {
			DAO<GroupeForme> dao = factory.getGroupeDAO();
			dao.update((GroupeForme) forme);
			factory.disconnect();
		} else {
			factory.disconnect();
		}
	}
	/**
	 * méthode getForme.
	 * @return forme deplacer
	 */
	public final Forme getForme() {
		return this.forme;
	}
}
