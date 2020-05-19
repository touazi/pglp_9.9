package lyli.dessin;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRectangle {

	@Test
	public void test() {
		Rectangle c1 = new Rectangle("lylia", new Coordonnee(1, 4), 5, 2);
		c1.move("lylia", 3, 6);
		assertEquals(c1.getCoordonnee().getX(), 4);
		assertEquals(c1.getCoordonnee().getY(), 10);
		c1.move("lylia", 3, 6);
		assertEquals(c1.getCoordonnee().getX(), 7);
		assertEquals(c1.getCoordonnee().getY(), 16);
	}

}
