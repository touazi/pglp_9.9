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

public class CommandDeCreation implements Command {
   
	/**
	     * forme à créer.
	     */
	    private Forme forme;
	    /**
	     * constructeur de la classe.
	     * @param f forme à créer
	     */
	    public CommandDeCreation(final Forme f) {
	        this.forme = f;
	      /*  System.out.println("jjjjjjjjjjjjjjjjjj");
	        f.affiche();
	        forme.affiche();
	        System.out.println("jjjjjjjjjjjjjjjjjj");*/
	    }
	    public Forme getForme() {
	    	return this.forme;
	    }
	    /**
	     * execution de la commande.
	     * @throws SQLException 
	     * @throws FormeExisteDeja 
	     * @throws FormeDoncExistException 
	     */
	    public void execute() throws SQLException, FormeExisteDeja, FormeDoncExistException {
	       
	       // forme.affiche();
	        DaoFactory factory = new DaoFactory();
	        if (forme instanceof Cercle) {
	        	//System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmm");
	            DAO<Cercle> dao = factory.getCercleDAO();
	            dao.create((Cercle) forme);
	        } else if (forme instanceof Carre) {
	        	DAO<Carre> dao = factory.getCarreDAO();
	            dao.create((Carre) forme);
	        } else if (forme instanceof Rectangle) {
	        	DAO<Rectangle> dao = factory.getRectangleDAO();
	            dao.create((Rectangle) forme);
	            System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmm");
	            dao.read(forme.getNameForme()).affiche();
	            System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmm");
	        } else if (forme instanceof Triangle) {
	        	DAO<Triangle> dao = factory.getTriangleDAO();
	             dao.create((Triangle) forme);
	        } else {
	        	DAO<GroupeForme> dao = factory.getGroupeDAO();
	             dao.create((GroupeForme) forme);
	        }
	        factory.disconnect();
	     
	    }

}
