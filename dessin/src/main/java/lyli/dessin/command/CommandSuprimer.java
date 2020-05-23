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
public class CommandSuprimer implements CommandS {
/**
	 * forme à suprimer.
	 *@see CommandSuprimer#CommandSuprimer(Forme)
     * @see CommandSuprimer#execute()
	 */
	private Forme forme;
	/**  DaoFactory de type DaoFactory.
	    *@see CommandSuprimer#CommandSuprimer(Forme)
	    * @see CommandSuprimer#execute()
	    */
	private DaoFactory factory;
	/**
	 * constructeur de la classe CommandSuprimer.
	 * @param forme forme à suprimer
	 *  @throws SQLException lever les Exceptions SQL
	 */
	public CommandSuprimer(final Forme forme) throws SQLException {
		this.forme = forme;
		this.factory = new DaoFactory();
	}
	/**
	 * execution de la commande de suprimer.
	 */
	@Override
	public final void execute() {
		if (forme instanceof Cercle) {
			DAO<Cercle> dao = factory.getCercleDAO();
			dao.delete((Cercle) forme);
			factory.disconnect();
		} else if (forme instanceof Carre) {
			DAO<Carre> dao = factory.getCarreDAO();
			dao.delete((Carre) forme);
			factory.disconnect();
		} else if (forme instanceof Rectangle) {
			DAO<Rectangle> dao = factory.getRectangleDAO();
			dao.delete((Rectangle) forme);
			factory.disconnect();
		} else if (forme instanceof Triangle) {
			DAO<Triangle> dao = factory.getTriangleDAO();
			dao.delete((Triangle) forme);
			factory.disconnect();
		} else if (forme instanceof GroupeForme) {
			DAO<GroupeForme> dao = factory.getGroupeDAO();
			dao.delete((GroupeForme) forme);
			factory.disconnect();
		} else {
			factory.disconnect();
		}
	}
}
