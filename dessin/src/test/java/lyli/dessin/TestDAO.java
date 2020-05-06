package lyli.dessin;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lyli.dessin.exeption.FormeExisteDeja;

public class TestDAO {

    Triangle triangle;
    Carre carre;
    Cercle cercle;
    Rectangle rectangle;
    GroupeForme  g;
    JdbsDaoCarreDerby ppp;
    JdbsDaoCercleDerby pppcercle;
    JdbsDaoTriangleDerby ppptriangle;
    JdbsDaoRectangleDerby Rectangleppp;
    JdbsDaoGroupeDerby groupeder;
	@Before()
	public void setUp() {
	     triangle = new Triangle( "lyliatriangle",new Coordonnee(1,1), new Coordonnee(0,0), new Coordonnee(0,2) );
         carre = new Carre ("lyliacarre",new Coordonnee(1,4), 2);
         cercle = new Cercle ("lyliacercle",new Coordonnee(4,5), 5);
         rectangle = new Rectangle ("lyliarectangle",new Coordonnee(1,4),5,2);
         g=new GroupeForme("premierGroupe");
          ppp=new JdbsDaoCarreDerby();
          pppcercle =new JdbsDaoCercleDerby();
          ppptriangle=new JdbsDaoTriangleDerby();
          Rectangleppp=new JdbsDaoRectangleDerby();
          groupeder = new JdbsDaoGroupeDerby();
    	
    	g= new GroupeForme("fff");
	}

	@Test
	public void testCreateCarre() throws FormeExisteDeja {
		Carre pCreate=ppp.create(carre);
		assertEquals(pCreate.getNameForme(), carre.getNameForme());
	}
	@Test
	public void testCreateRectangle() throws FormeExisteDeja {
		Rectangle pCreateRectangle= Rectangleppp.create(rectangle);
		assertEquals(pCreateRectangle.getNameForme(), rectangle.getNameForme());
    
	}
	@Test
	public void testCreateTriangle() throws FormeExisteDeja {
		 Triangle pCreateTriangle=ppptriangle.create(triangle);
		 assertEquals(pCreateTriangle.getNameForme(), triangle.getNameForme());
	    	
	}
	@Test
	public void testCeatecercle() throws FormeExisteDeja {
		Cercle pCreateCercle =pppcercle.create(cercle);
		assertEquals(pCreateCercle.getNameForme(), cercle.getNameForme());
	}
}
