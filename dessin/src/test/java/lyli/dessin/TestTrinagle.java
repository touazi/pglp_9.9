package lyli.dessin;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestTrinagle {
	@Test
	public void test() {
		Triangle T = new Triangle("lylia", new Coordonnee(1, 1), new Coordonnee(0, 0), new Coordonnee(0, 2));
		T.move("lylia", 3, 0);
		assertEquals(T.getCoordonnee1().getX(), 4);
		assertEquals(T.getCoordonnee1().getY(), 1);

		assertEquals(T.getCoordonnee2().getX(), 3);
		assertEquals(T.getCoordonnee2().getY(), 0);

		assertEquals(T.getCoordonnee3().getX(), 3);
		assertEquals(T.getCoordonnee3().getY(), 2);
	}

}
