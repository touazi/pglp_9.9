package lyli.dessin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lyli.dessin.Carre;
import lyli.dessin.Cercle;
import lyli.dessin.Coordonnee;
/**.
 * <b>"la classe JdbsDaoCarreDerby."</b>
 * <p>"implementation du patern Dao"
 * @author TOUAZI,Lylia
 */
public class JdbsDaoCarreDerby implements DAO<Carre> {
	/**
	 * attribut Connection pour se connecter à la base de donnée.
	 * @see JdbsDaoCarreDerby#JdbsDaoCarreDerby(Cercle)
	 * @see JdbsDaoCarreDerby#create(Cercle)
	 * @see JdbsDaoCarreDerby#delete(Cercle)
	 * @see JdbsDaoCarreDerby#read(Cercle)
	 * @see JdbsDaoCarreDerby#update(Cercle)
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
	 * constructeur de la classe JdbsDaoCarreDerby.
	 * @param connect Connection à la base de donnée.
	 */
	public JdbsDaoCarreDerby(Connection connect) {
		this.connect = connect;
	}
	/**
	 * methode create Carre.
	 * insertion d'un Carre.
	 * @param obj le Carre à sauvgarder dans la base de donnée.
	 * @return objet créee
	 * */
	@Override
	public final Carre create(Carre obj) {
		try {
			PreparedStatement prepare = connect.prepareStatement(
					"INSERT  INTO Carre (NameForme,"
					+ " topLeft_x, topLeft_y, side)"
							+ "VALUES (?, ?, ?, ?)");
			prepare.setString(1, obj.getNameForme());
			prepare.setInt(2, obj.getCoordonnee().getX());
			prepare.setInt(3, obj.getCoordonnee().getY());
			prepare.setInt(4, obj.getside());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.getMessage();
		}
		return obj;
	}
	/**
	 * methode read Carre.
	 * recuperer d'un Carre dans la bd.
	 * @param id le nom du Carre à lire dans la base de donnée.
	 * @return objet lu
	 * */
	@Override
	public final Carre read(String id) {
		// TODO Auto-generated method stub
		Carre carre = null;
		try {
			PreparedStatement prepare =
					connect.prepareStatement("SELECT *"
					+ " FROM carre WHERE NameForme = ?  ");
			prepare.setString(1, id);
			ResultSet result = prepare.executeQuery();
			if (result.next()) {
				carre = new Carre(result.getString("NameForme"),
						new Coordonnee(
								result.getInt("topLeft_x"),
								result.getInt("topLeft_y")),
								result.getInt("side"));
				result.close();
			} else {
				return null;
			}

		} catch (SQLException e) {
			e.getMessage();
		}
		return carre;
	}
	/**
	 * methode update Carre.
	 * modification d'un Carre dans la bd.
	 * @param obj le Carre à modifier dans la base de donnée.
	 * @return objet modifier
	 * */
	@Override
	public final Carre update(Carre obj) {
		try {
			PreparedStatement prepareFind =
					connect.prepareStatement("SELECT *"
					+ " FROM carre WHERE NameForme = ?  ");
			prepareFind.setString(1, obj.getNameForme());
			ResultSet res = prepareFind.executeQuery();
			if (res.next()) {
				String sql = "UPDATE carre SET topLeft_x = ?, "
						+ "topLeft_y = ?, "
						+ "side = ? WHERE NameForme = ?";
				PreparedStatement prepare = connect.prepareStatement(
						sql);
				prepare.setInt(1, obj.getCoordonnee().getX());
				prepare.setInt(2, obj.getCoordonnee().getY());
				prepare.setInt(3, obj.getside());
				prepare.setString(4, obj.getNameForme());
				int result = prepare.executeUpdate();
				assert result == 1;
				System.out.println(result);
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return obj;
	}
	/**
	 * methode delete Carre.
	 * supression d'un Carre dans la bd.
	 * @param obj le Carre à suprimer dans la base de donnée.
	 * */
	@Override
	public final void delete(Carre obj) {
		try {
			PreparedStatement prepare =
					connect.prepareStatement("DELETE FROM"
					+ " carre "
					+ "WHERE NameForme = ?");
			prepare.setString(1, obj.getNameForme());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		read(obj.getNameForme());
		try {
			PreparedStatement prepareFind =
					connect.prepareStatement("SELECT *"
					+ " FROM carre WHERE NameForme = ?  ");
			prepareFind.setString(1, obj.getNameForme());
			ResultSet res = prepareFind.executeQuery();
			if (res.next()) {
				PreparedStatement prepare =
						connect.prepareStatement("DELETE "
						+ "FROM carre "
						+ "WHERE NameForme = ?");
				prepare.setString(1, obj.getNameForme());
				int result = prepare.executeUpdate();
				assert result == 1;
			}
		} catch (SQLException e) {
			e.getMessage();
		}
	}
}
