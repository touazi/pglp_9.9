package lyli.dessin;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import lyli.dessin.exeption.FormeDoncExistException;

public class TestDrawingTui {
	Forme cercle = null, triangle = null, carre = null,
			rectangle = null, groupe = null;
	String name = null;
	String[] Token = null; 
	Forme f = null;
	  String[] SeparEgal1 = null, SeparEgal2 = null, SeparEgal4 = null, SeparEgal3 = null , Tokens = null;
	 String command1 = "Ce1=cercle((1,1),3)";
	 String command2 = "Tr1=triangle((1,1),(3,3),(4,4))";
	 String command3 = "Re1=rectangle((6,6),3,6)";
	 String command4 = "Ca1=carre((1,2),3)";
	@Before()
	public void setUp() throws FormeDoncExistException, SQLException {
		 SeparEgal1 = command1.split("=");
		 SeparEgal1[1] = SeparEgal1[1].replace(" ", "");
		 DrawingTUI n = new DrawingTUI();
	  	  Tokens = SeparEgal1[1].split("cercle");
	      	cercle = n.create(Tokens, "cer" ,SeparEgal1[0].trim());
	      	SeparEgal2 = command2.split("=");
	      	SeparEgal2[1] = SeparEgal2[1].replace(" ", "");
	      	Tokens = SeparEgal2[1].split("triangle");
	      	triangle = n.create(Tokens, "tri" ,SeparEgal2[0].trim());
	      	 SeparEgal3 = command3.split("=");
	      	 SeparEgal3[1] = SeparEgal3[1].replace(" ", "");
	     	Tokens = SeparEgal3[1].split("rectangle");
	      	rectangle = n.create(Tokens, "rec" ,SeparEgal3[0].trim());
	      	SeparEgal4 = command4.split("=");
	      	Tokens = SeparEgal4[1].split("carre");
	        SeparEgal4[1] = SeparEgal4[1].replace(" ", "");
	        	
	      	carre = n.create(Tokens, "car" ,SeparEgal4[0].trim());
	      
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
