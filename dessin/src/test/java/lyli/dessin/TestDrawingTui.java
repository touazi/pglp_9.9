package lyli.dessin;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lyli.dessin.exeption.FormeDoncExistException;

public class TestDrawingTui {
	Forme cercle = null, triangle = null, carre = null,
			rectangle = null, groupe = null;
	String name = null;
	@Before()
	public void setUp() throws FormeDoncExistException {
	   	DrawingTUI n = new DrawingTUI();
    	cercle = n.create("Ce1=cercle((1,1),3)");
    	triangle = n.create("Tr1=triangle((1,1),(3,3),(4,4))");
    	rectangle = n.create("Re1=rectangle((6,6),3,6)");
    	carre = n.create("Ca1=carre((1,2),3)");
    	
    
	}
	@Test
	public void testCercle() {
		name = "Ce1";
		Cercle c = (Cercle) cercle;
		 assertEquals(cercle.getNameForme(), name);
		 assertEquals(c.centre.getX(), 1);
		 assertEquals(c.centre.getY(), 1);
		 assertEquals(c.rayon, 3);
		
		 
	}
	@Test
	public void testCarre() {
		name = "Ca1";
		Carre c = (Carre) carre;
		 assertEquals(carre.getNameForme(), name);
		 assertEquals(c.getCoordonnee().getX(), 1);
		 assertEquals(c.getCoordonnee().getY(), 2);
		 assertEquals(c.getside(), 3);
		
		 
	}
	@Test
	public void testRectangle() {
		name = "Re1";
		Rectangle c = (Rectangle) rectangle;
		// assertEquals(rectangle.getNameForme(), name);
		 assertEquals(c.getCoordonnee().getX(), 6);
		// assertEquals(c.getCoordonnee().getY(), 6);
		 //assertEquals(c.getsideLeft(), 6);
		 //assertEquals(c.getsideTop(), 3);
		
		 
	}
	@Test
	public void testTriangle() {
		name = "Tr1";
		Triangle c = (Triangle) triangle;
		 assertEquals(triangle.getNameForme(), name);
		 assertEquals(c.getCoordonnee1().getX(), 1);
		 assertEquals(c.getCoordonnee1().getY(), 1);
		 assertEquals(c.getCoordonnee2().getX(), 3);
		 assertEquals(c.getCoordonnee2().getY(), 3);
		 assertEquals(c.getCoordonnee3().getX(), 4);
		 assertEquals(c.getCoordonnee3().getY(), 4);
		
		
		 
	}
	@Test
	public void testGroupe() {
		name = "Ce1";
		Cercle c = (Cercle) cercle;
		 assertEquals(cercle.getNameForme(), name);
		 assertEquals(c.centre.getX(), 1);
		 assertEquals(c.centre.getY(), 1);
		 assertEquals(c.rayon, 3);
		
		 
	}

}
