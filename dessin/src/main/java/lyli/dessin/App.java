package lyli.dessin;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import lyli.dessin.exeption.FormeDoncExistException;
import lyli.dessin.exeption.FormeExisteDeja;
import lyli.dessin.exeption.TableExisteDeja;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, TableExisteDeja, FormeExisteDeja, FormeDoncExistException
    {
        System.out.println( "Hello World!" );
      
        Carre pm = new Carre ("lylia",new Coordonnee(1,4), 5);
    	JdbsDaoCarreDerby ppp=new JdbsDaoCarreDerby();
    	Carre pCreate=ppp.create(pm);
    	//System.out.println(pCreate.getNameForme()+  "   ccccccccccc  " + pm.getNameForme());
    	Carre c;
    	c=ppp.read("lylia");
    	c.affiche();
    	 Cercle cercle = new Cercle ("lyliacercle",new Coordonnee(4,5), 5);
    	JdbsDaoCercleDerby pppcercle =new JdbsDaoCercleDerby();
    	Cercle pCreateCercle =pppcercle.create(cercle);
    	//System.out.println(pCreateCercle.getNameForme()+  "   ccccccccccc  " + cercle.getNameForme());
    	
    	
    	
    	Triangle triangle = new Triangle( "lyliatriangle",new Coordonnee(1,1), new Coordonnee(0,0), new Coordonnee(0,2) );
	    JdbsDaoTriangleDerby ppptriangle=new JdbsDaoTriangleDerby();
	    Triangle pCreateTriangle=ppptriangle.create(triangle);
    	//System.out.println(pCreateTriangle.getNameForme()+  "   ccccccccccc  " + triangle.getNameForme());
    	
    	
    	
    	
    	 Rectangle rectangle = new Rectangle ("lyliarectangle",new Coordonnee(1,4),5,2);
     	JdbsDaoRectangleDerby Rectangleppp=new JdbsDaoRectangleDerby();
     	Rectangle pCreateRectangle= Rectangleppp.create(rectangle);
    	//System.out.println(pCreateRectangle.getNameForme()+  "   ccccccccccc  " + rectangle.getNameForme());
    
    	GroupeForme creategroupe;
    	JdbsDaoGroupeDerby groupeder = new JdbsDaoGroupeDerby();
    	
    	GroupeForme g= new GroupeForme("fff");
        g.ajouterForme(rectangle);
    	g.ajouterForme(cercle);
		creategroupe=groupeder.create(g);
 
    }

    
}
