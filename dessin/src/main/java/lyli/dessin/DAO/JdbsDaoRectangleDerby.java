package lyli.dessin.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lyli.dessin.Coordonnee;
import lyli.dessin.Rectangle;
/**.
 * <b>"la classe JdbsDaoRectangleDerby."</b>
 * <p>"implementation du patern Dao"
 * @author TOUAZI,Lylia
 */
public class JdbsDaoRectangleDerby implements DAO<Rectangle> {
	/**
	 * attribut Connection pour se connecter à la base de donnée.
	 * @see JdbsDaoRectangleDerby#JdbsDaoRectangleDerby(Connection)
	 * @see JdbsDaoRectangleDerby#create(Rectangle)
	 * @see JdbsDaoRectangleDerby#delete(Rectangle)
	 * @see JdbsDaoRectangleDerby#read(String)
	 * @see JdbsDaoRectangleDerby#update(Rectangle)
	 * */
	private Connection connect = null;
	/**constante un.*/
	static final int UN = 1;
	/**constante deux.*/
	static final int DEUX = 2;
	/**constante trois.*/
	static final int TROIS = 3;
	/**constante quatre.*/
	static final int QUATRE = 4;
	/**constante cinq.*/
	static final int CINQ = 5;
	/**constante six.*/
	static final int SIX = 6;
	/**constante sept.*/
	static final int SEPT = 7;
	/**
	 * constructeur de la classe JdbsDaoRectangleDerby.
	 * @param connect Connection à la base de donnée.
	 */
	public JdbsDaoRectangleDerby(Connection connect) {
		this.connect = connect;
	}
	/**
	 * methode create Rectangle.
	 * insertion d'un Rectangle.
	 * @param obj le Rectangle à sauvgarder dans la base de donnée.
	 * @return objet créee
	 * */
	@Override
	public final Rectangle create(final Rectangle obj) {
		try {
			PreparedStatement prepare =
					connect.prepareStatement("INSERT"
							+ "  INTO Rectangle (NameForme, "
					+ "topLeft_x, topLeft_y, sideTop, sideLeft)"
							+ "VALUES (?, ?, ?, ?, ?)");
			prepare.setString(1, obj.getNameForme());
			prepare.setInt(2, obj.getCoordonnee().getX());
			prepare.setInt(3, obj.getCoordonnee().getY());
			prepare.setInt(4, obj.getsideTop());
			prepare.setInt(5, obj.getsideLeft());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.getMessage();
		}
		return obj;
	}
	/**
	 * methode read Rectangle.
	 * recuperer d'un Rectangle dans la bd.
	 * @param id le nom du Rectangle à lire dans la base de donnée.
	 * @return objet lu
	 * */
	@Override
	public final Rectangle read(final String id) {
		// TODO Auto-generated method stub
		Rectangle rectangle = null;
		try {
			PreparedStatement prepare =
					connect.prepareStatement("SELECT * "
			+ "FROM rectangle WHERE NameForme = ?  ");
			prepare.setString(1, id);
			ResultSet result = prepare.executeQuery();
			if (result.next()) {
				rectangle = new Rectangle(
						result.getString("NameForme"),
						new Coordonnee(
								result.getInt("topLeft_x"),
								result.getInt("topLeft_y")),
						result.getInt("sideTop"),
						result.getInt("sideLeft"));
				result.close();
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return rectangle;
	}
	/**
	 * methode update Rectangle.
	 * modification d'un Rectangle dans la bd.
	 * @param obj le Rectangle à modifier dans la base de donnée.
	 * @return objet modifier
	 * */
	@Override
	public final Rectangle update(final Rectangle obj) {
		try {
			PreparedStatement prepareFind =
					connect.prepareStatement("SELECT *"
			+ " FROM rectangle WHERE NameForme = ?  ");
			prepareFind.setString(1, obj.getNameForme());
			ResultSet res = prepareFind.executeQuery();
			if (res.next()) {
				PreparedStatement prepare =
						connect.prepareStatement("UPDATE"
				+ " rectangle SET topLeft_x = ? , "
						+ "topLeft_y = ? , "
				+ "sideTop = ? , "
						+ "sideLeft = ?  "
				+ "WHERE NameForme = ?");
				prepare.setInt(1, obj.getCoordonnee().getX());
				prepare.setInt(2, obj.getCoordonnee().getY());
				prepare.setInt(3, obj.getsideTop());
				prepare.setInt(4, obj.getsideLeft());
				prepare.setString(5, obj.getNameForme());
				int result = prepare.executeUpdate();
				assert result == 1;
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return obj;
	}
	/**
	 * methode delete Rectangle.
	 * supression d'un Rectangle dans la bd.
	 * @param obj le Rectangle à suprimer dans la base de donnée.
	 * */
	@Override
	public final void delete(final Rectangle obj) {
		// TODO Auto-generated method stub
		read(obj.getNameForme());
		try {
			PreparedStatement prepareFind = connect
					.prepareStatement("SELECT *"
			+ "FROM rectangle WHERE NameForme = ?  ");
			prepareFind.setString(1, obj.getNameForme());
			ResultSet res = prepareFind.executeQuery();
			if (res.next()) {
				PreparedStatement prepare = connect
						.prepareStatement("DELETE"
				+ " FROM rectangle " + "WHERE NameForme = ?");
				prepare.setString(1, obj.getNameForme());
				int result = prepare.executeUpdate();
				assert result == 1;
			}
		} catch (SQLException e) {
			e.getMessage();
		}
	}
}
