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

public class CommandDeplacer implements Command  {   
	/**
	     * forme à deplacer.
	     */
	    private Forme forme;
	    /**
	     * constructeur de la classe CommandDeplacer.
	     * @param f forme à deplacer
	     */
	    public CommandDeplacer(final Forme f) {
	        this.forme = f;
	        }

	    /**
	     * execution de la commande de deplacement.
	     * @throws SQLException  lever les Exceptions SQL
	     */
	    public void execute() throws SQLException {
	        Forme f;
	        DaoFactory factory = new DaoFactory();
	        if (forme instanceof Cercle) {
	        	 DAO<Cercle> dao = factory.getCercleDAO();
	            f = dao.update((Cercle) forme);
	            factory.disconnect();
	        } else if (forme instanceof Carre) {
	        	DAO<Carre> dao = factory.getCarreDAO();
	            f = dao.update((Carre) forme);
	            factory.disconnect();
	        } else if (forme instanceof Rectangle) {
	        	DAO<Rectangle> dao = factory.getRectangleDAO();
	            f = dao.update((Rectangle) forme);
	            factory.disconnect();
	        } else if (forme instanceof Triangle) {
	        	DAO<Triangle> dao = factory.getTriangleDAO();
	            f = dao.update((Triangle) forme);
	            factory.disconnect();
	        } else if(forme instanceof GroupeForme) {
	        	DAO<GroupeForme> dao = factory.getGroupeDAO();
	            f = dao.update((GroupeForme) forme);
	            factory.disconnect();
	        } else factory.disconnect();
	        
	     
	    }
	    /**
	     * méthode getForme.
	     * @return  forme deplacer
	     */
	    public Forme getForme() {
	    	return this.forme;
	    }
}
