package lyli.dessin.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lyli.dessin.Carre;
import lyli.dessin.Cercle;
import lyli.dessin.GroupeForme;
import lyli.dessin.Rectangle;
import lyli.dessin.Triangle;
/**.
 * <b>"la classe DaoFactory."</b>
 * <p>"implementation du patern Dao"
 * @author TOUAZI,Lylia
 */
public class DaoFactory {
/**
 * attribut Connection pour se connecter à la base de donnée.
 * @see JdbsDaoTriangleDerby#JdbsDaoTriangleDerby(Connection)
 * @see JdbsDaoTriangleDerby#create(Triangle)
 * @see JdbsDaoTriangleDerby#delete(Triangle)
 * @see JdbsDaoTriangleDerby#read(String)
 * @see JdbsDaoTriangleDerby#update(Triangle)
 * */
private Connection connect = null;
 /** constructeur de la classe DaoFactory.
 *  @throws SQLException lever les Exceptions SQL
 */
public DaoFactory() throws SQLException {
	String dburl = CeartionBDDREBY.getDburl();
	connect = DriverManager.getConnection(dburl);
}
/**
 * methode getConnection.
 *
 * @return  Un objet CercleDAO .
 *
 */
public final Connection getConnection() {
	return this.connect;
}
/**
 * methode getCarreDAO.
 *
 * @return  Un objet CercleDAO .
 *
 */
public final DAO<Carre> getCarreDAO() {
	return new JdbsDaoCarreDerby(connect);
}
/**
 * methode getRectangleDAO.
 *
 * @return  Un objet RectangleDAO .
 *
 */
public final DAO<Rectangle> getRectangleDAO() {
	return new JdbsDaoRectangleDerby(connect);
}
/**
 * methode getCercleDAO.
 *
 * @return  Un objet CercleDAO .
 *
 */
public final DAO<Cercle> getCercleDAO() {
	return new JdbsDaoCercleDerby(connect);
}
/**
 * methode getTriangleDAO.
 *
 * @return  Un objet TriangleDAO .
 *
 */
public final DAO<Triangle> getTriangleDAO() {
	return new JdbsDaoTriangleDerby(connect);
}
/**
 * methode getGroupeDAO.
 *
 * @return  Un objet GroupeDAO.
 *
 */
public final DAO<GroupeForme> getGroupeDAO() {
	return new JdbsDaoGroupeDerby(connect);
}
/**
 *
 */
public final void connect() {
	try {
		String dburl = CeartionBDDREBY.getDburl();
		connect = DriverManager.getConnection(dburl);
	} catch (SQLException e) {
		e.printStackTrace();
		try {
			connect.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}

/**
 * Disonnecter la database.
 */
	public final void disconnect() {

		try {
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
