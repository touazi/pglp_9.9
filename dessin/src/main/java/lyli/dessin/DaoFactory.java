package lyli.dessin;

public class DaoFactory {
		public static DAO<Carre> getCarreDAO ( ) {
			return new JdbsDaoCarreDerby ( ) ;
			}
		public static DAO<Rectangle> getRectangleDAO ( ) {
			return new JdbsDaoRectangleDerby ( ) ;
			}
		public static DAO<Cercle> getCercleDAO ( ) {
			return new JdbsDaoCercleDerby ( ) ;
			}
		public static DAO<Triangle> getTriangleDAO ( ) {
			return new JdbsDaoTriangleDerby ( ) ;
			}
		public static DAO<GroupeForme> getGroupeDAO ( ) {
			return new JdbsDaoGroupeDerby ( ) ;
			}

	}


