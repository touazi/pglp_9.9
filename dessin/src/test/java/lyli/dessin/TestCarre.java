package lyli.dessin;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCarre {

	@Test
	public void test() {
		Carre c1 = new Carre("lylia", new Coordonnee(1, 4), 5);
		c1.move("lylia", 3, 6);
		assertEquals(c1.getCoordonnee().getX(), 4);
		assertEquals(c1.getCoordonnee().getY(), 10);
		c1.move("lylia", 3, 6);
		assertEquals(c1.getCoordonnee().getX(), 7);
		assertEquals(c1.getCoordonnee().getY(), 16);
	}

}
