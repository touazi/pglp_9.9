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
 * <b>"la classe CommandDeCreation."</b>
 * <p>"implementation du patern Command"
 * @author TOUAZI,Lylia
 */
public class CommandDeCreation implements CommandS {
/**
* forme à créer.
*@see CommandDeCreation#CommandDeCreation(Forme)
* @see CommandDeCreation#execute()
*/
private Forme forme;
/**  DaoFactory de type DaoFactory.
    * @see CommandDeCreation#CommandDeCreation(Forme)
    * @see CommandDeCreation#execute()
    */
private DaoFactory factory;
/**
 * constructeur de la classe CommandDeCreation.
 * @param forme forme à créer
 *  @throws SQLException lever les Exceptions SQL
 */
public CommandDeCreation(final Forme forme) throws SQLException {
	this.forme = forme;
	this.factory = new DaoFactory();
}
/**
 * La methode getForme.
 * @return la forme cree
 */
public final Forme getForme() {
	return this.forme;
}
/**
 * execution de la commande create.
 */
public final void execute() {
	Forme formeCree = null;
	if (forme instanceof Cercle) {
		DAO<Cercle> dao = factory.getCercleDAO();
		formeCree = dao.create((Cercle) forme);
		if (formeCree != null) {
			System.out.println("Le cercle \""
+ forme.getNameForme()
+ "\" a bien été crée :) !");
	}
	factory.disconnect();
} else if (forme instanceof Carre) {
	DAO<Carre> dao = factory.getCarreDAO();
	formeCree = dao.create((Carre) forme);
	if (formeCree != null) {
		System.out.println("Le carre \""
+ forme.getNameForme()
+ "\" a bien été crée :) !");
	}
	factory.disconnect();
} else if (forme instanceof Rectangle) {
	DAO<Rectangle> dao = factory.getRectangleDAO();
	formeCree = dao.create((Rectangle) forme);
	if (formeCree != null) {
		System.out.println("Le retangle \""
+ forme.getNameForme()
+ "\" a bien été crée :) !");
	}
	factory.disconnect();
} else if (forme instanceof Triangle) {
	DAO<Triangle> dao = factory.getTriangleDAO();
	formeCree = dao.create((Triangle) forme);
	if (formeCree != null) {
		System.out.println("Le triangle \" "
+ forme.getNameForme()
+ "\" a bien été crée :) !");
	}
	factory.disconnect();
} else if (forme instanceof GroupeForme) {
	DAO<GroupeForme> dao = factory.getGroupeDAO();
	formeCree = dao.create((GroupeForme) forme);
	if (formeCree != null) {
		System.out.println("Le dessin \" "
+ forme.getNameForme()
+ "\" a bien été crée :) !");
			}
			factory.disconnect();
		} else {
			factory.disconnect();
			}
	}
}
