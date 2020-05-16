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
public class CommandDeCreation implements Command {
   
	/**
	     * forme à créer.
	     */
	    private Forme forme;
	    /**
	     * constructeur de la classe.
	     * @param forme forme à créer
	     */
	    public CommandDeCreation(final Forme forme) {
	        this.forme = forme;
	    }
	    public Forme getForme() {
	    	return this.forme;
	    }
	    /**
	     * execution de la commande create.
	     * @throws SQLException lever les Exceptions SQL
	     */
	    public void execute() throws SQLException {
	        DaoFactory factory = new DaoFactory();
	        if (forme instanceof Cercle) {
	        	 DAO<Cercle> dao = factory.getCercleDAO();
	            dao.create((Cercle) forme);
	            factory.disconnect();
	        } else if (forme instanceof Carre) {
	        	DAO<Carre> dao = factory.getCarreDAO();
	            dao.create((Carre) forme);
	            factory.disconnect();
	        } else if (forme instanceof Rectangle) {
	        	DAO<Rectangle> dao = factory.getRectangleDAO();
	            dao.create((Rectangle) forme);
	            factory.disconnect();
	           } else if (forme instanceof Triangle) {
	        	DAO<Triangle> dao = factory.getTriangleDAO();
	             dao.create((Triangle) forme);
	             factory.disconnect();
	        } else  if(forme instanceof GroupeForme) {
	        	DAO<GroupeForme> dao = factory.getGroupeDAO();
	             dao.create((GroupeForme) forme);
	             factory.disconnect();
	        }else factory.disconnect();
	     
	    }

}
