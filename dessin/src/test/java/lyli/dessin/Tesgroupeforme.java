package lyli.dessin;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Tesgroupeforme {
    Triangle triangle;
    Carre carre;
    Cercle cercle;
    Rectangle rectangle;
    GroupeForme  g;
	@Before()
	public void setUp() {
	     triangle = new Triangle( "lyliatriangle",new Coordonnee(1,1), new Coordonnee(0,0), new Coordonnee(0,2) );
         carre = new Carre ("lyliacarre",new Coordonnee(1,4), 2);
         cercle = new Cercle ("lyliacercle",new Coordonnee(4,5), 5);
         rectangle = new Rectangle ("lyliarectangle",new Coordonnee(1,4),5,2);
         g=new GroupeForme("premierGroupe");
	}

	@Test
	public void testajouter() {
		g.ajouterForme(triangle);
        g.ajouterForme(cercle);
        assertEquals(g.getListForm().size(), 2);
        g.ajouterForme(carre);
        g.ajouterForme(rectangle);
        assertEquals(g.getListForm().size(), 4);
	}
	@Test
	public void testsuprimer() {
		g.ajouterForme(triangle);
        g.ajouterForme(cercle);
        g.ajouterForme(carre);
        g.ajouterForme(rectangle);
        g.supprimerForme(carre);
        assertEquals(g.getListForm().size(), 3);
        
	}
	@Test
	public void testMove() {
		g.ajouterForme(carre);
        g.ajouterForme(cercle);
        assertEquals(g.getListForm().size(), 2);
        assertEquals(carre.getCoordonnee().getX(),1);
        assertEquals(carre.getCoordonnee().getY(),4);
        assertEquals(cercle.getCoordonnee().getX(),4);
        assertEquals(cercle.getCoordonnee().getY(),5);
        
        g.move("premierGroupe", 1, 1);
        assertEquals(carre.getCoordonnee().getX(),2);
        assertEquals(carre.getCoordonnee().getY(),5);
        
        assertEquals(cercle.getCoordonnee().getX(),5);
        assertEquals(cercle.getCoordonnee().getY(),6);
	}
	@Test
	public void test() {
		g.ajouterForme(rectangle);
		assertTrue(g.getListForm().contains(rectangle));
	
	}

}
