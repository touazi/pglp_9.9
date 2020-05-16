package lyli.dessin;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import lyli.dessin.DAO.DAO;
import lyli.dessin.DAO.DaoFactory;
import lyli.dessin.exeption.FormeDoncExistException;
import lyli.dessin.exeption.FormeExisteDeja;

public class TestDAO {

    Triangle triangle;
    Carre carre;
    Cercle cercle;
    Rectangle rectangle;
    GroupeForme  g;
    DAO<Carre> ppp;
    DAO<Cercle> pppcercle;
    DAO<Triangle> ppptriangle;
    DAO<Rectangle> Rectangleppp;
    DAO<GroupeForme> groupeder;
	DaoFactory factory ;
	@Before()
	public void setUp() throws SQLException {
	     triangle = new Triangle( "lyliatriangle",new Coordonnee(1,1), new Coordonnee(0,0), new Coordonnee(0,2) );
         carre = new Carre ("lyliacarre",new Coordonnee(1,4), 2);
         cercle = new Cercle ("lyliacercle",new Coordonnee(4,5), 5);
         rectangle = new Rectangle ("lyliarectangle",new Coordonnee(1,4),5,2);
         g=new GroupeForme("premierGroupe");
         factory = new DaoFactory();
         pppcercle = factory.getCercleDAO();
         ppp = factory.getCarreDAO();
         Rectangleppp = factory.getRectangleDAO();
         ppptriangle = factory.getTriangleDAO();
         groupeder = factory.getGroupeDAO();
          //ppp=new JdbsDaoCarreDerby();
         
          
    	g= new GroupeForme("fff");
	}

	@Test
	public void testCreateCarre() throws FormeExisteDeja, FormeDoncExistException {
		Carre pCreate=ppp.create(carre);
		assertEquals(pCreate.getNameForme(), carre.getNameForme());
	}
	@Test
	public void testCreateRectangle() throws FormeExisteDeja, FormeDoncExistException {
		Rectangle pCreateRectangle= Rectangleppp.create(rectangle);
		assertEquals(pCreateRectangle.getNameForme(), rectangle.getNameForme());
    
	}
	@Test
	public void testCreateTriangle() throws FormeExisteDeja, FormeDoncExistException {
		 Triangle pCreateTriangle=ppptriangle.create(triangle);
		 assertEquals(pCreateTriangle.getNameForme(), triangle.getNameForme());
	    	
	}
	
	@Test
	public void testCreateGroupe() throws FormeExisteDeja, FormeDoncExistException {
		 g.ajouterForme(rectangle);
		 	g.ajouterForme(cercle);
				GroupeForme creategroupe = groupeder.create(g);
		 assertEquals(creategroupe.getListForm().size(), 2);
	    	
	}
	
	@Test
	public void testreadcercle() throws FormeExisteDeja, FormeDoncExistException {
		Cercle pCreateCercle =pppcercle.create(cercle);
		assertEquals(pCreateCercle.getNameForme(), cercle.getNameForme());
	}
	@Test
	public void testreadCarre() throws FormeExisteDeja, FormeDoncExistException {
		Carre pCreate=ppp.create(carre);
		assertEquals(pCreate.getNameForme(), carre.getNameForme());
		Carre c=ppp.read("lyliacarre");
		assertEquals(c.getside(), carre.getside());
		assertEquals(c.getCoordonnee().getX(), carre.getCoordonnee().getX());
		assertEquals(c.getCoordonnee().getY(), carre.getCoordonnee().getY());
		assertEquals(c.getNameForme(), carre.getNameForme());
	}
	@Test
	public void testreadRectangle() throws FormeExisteDeja, FormeDoncExistException {
		Rectangle pCreateRectangle= Rectangleppp.create(rectangle);
		assertEquals(pCreateRectangle.getNameForme(), rectangle.getNameForme());
		Rectangle c=Rectangleppp.read("lyliarectangle");
		assertEquals(c.getsideLeft(), rectangle.getsideLeft());
		assertEquals(c.getCoordonnee().getX(), rectangle.getCoordonnee().getX());
		assertEquals(c.getCoordonnee().getY(), rectangle.getCoordonnee().getY());
		assertEquals(c.getNameForme(), rectangle.getNameForme());
    
	}
	@Test
	public void testreadTriangle() throws FormeExisteDeja, FormeDoncExistException {
		 Triangle pCreateTriangle=ppptriangle.create(triangle);
		 assertEquals(pCreateTriangle.getNameForme(), triangle.getNameForme());
		 
		 Triangle c=ppptriangle.read("lyliatriangle");
			assertEquals(c.getCoordonnee1().getX(), triangle.getCoordonnee1().getX());
			assertEquals(c.getCoordonnee1().getY(), triangle.getCoordonnee1().getY());
			assertEquals(c.getCoordonnee2().getX(), triangle.getCoordonnee2().getX());
			assertEquals(c.getCoordonnee2().getY(), triangle.getCoordonnee2().getY());
			assertEquals(c.getCoordonnee3().getX(), triangle.getCoordonnee3().getX());
			assertEquals(c.getCoordonnee3().getY(), triangle.getCoordonnee3().getY());
			assertEquals(c.getNameForme(), triangle.getNameForme());
	    	
	}
	@Test
	public void testCeatecercle() throws FormeExisteDeja, FormeDoncExistException {
		Cercle pCreateCercle =pppcercle.create(cercle);
		assertEquals(pCreateCercle.getNameForme(), cercle.getNameForme());
		Cercle c=pppcercle.read("lyliacercle");
		assertEquals(c.getrayon(), cercle.getrayon());
		assertEquals(c.getCoordonnee().getX(), cercle.getCoordonnee().getX());
		assertEquals(c.getCoordonnee().getY(), cercle.getCoordonnee().getY());
		assertEquals(c.getNameForme(), cercle.getNameForme());
	}
	@After
	public void tearDown() throws Exception {
		factory.disconnect();
	}
}
