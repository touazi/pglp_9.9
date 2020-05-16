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
import lyli.dessin.exeption.FormeDoncExistException;
import lyli.dessin.exeption.FormeExisteDeja;
/**
 * <b>"L'implementation de la class CommandSuprimer.</b>
 * @author TOUAZI,Lylia
 */
public class CommandSuprimer implements Command {
	Forme f = null;
public CommandSuprimer(Forme f) {
	this.f = f;
}
	@Override
	public void execute() throws SQLException, FormeExisteDeja, FormeDoncExistException {
		System.out.println("eeeeeeeeeeeeeeeee");
		 DaoFactory factory = new DaoFactory();
	        if (f instanceof Cercle) {
	        	//System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmm");
	            DAO<Cercle> dao = factory.getCercleDAO();
	             dao.delete((Cercle) f);
	        } else if (f instanceof Carre) {
	        	DAO<Carre> dao = factory.getCarreDAO();
	             dao.delete((Carre) f);
	        } else if (f instanceof Rectangle) {
	        	DAO<Rectangle> dao = factory.getRectangleDAO();
	            dao.delete((Rectangle) f);
	        } else if (f instanceof Triangle) {
	        	DAO<Triangle> dao = factory.getTriangleDAO();
	             dao.delete((Triangle) f);
	        } else {
	        	DAO<GroupeForme> dao = factory.getGroupeDAO();
	             dao.delete((GroupeForme) f);
	        }
	        factory.disconnect();
	     
		
	}

}
