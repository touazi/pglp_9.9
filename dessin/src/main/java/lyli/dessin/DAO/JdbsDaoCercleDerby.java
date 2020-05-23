package lyli.dessin.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lyli.dessin.Cercle;
import lyli.dessin.Coordonnee;
/**.
 * <b>"la classe JdbsDaoCercleDerby."</b>
 * <p>"implementation du patern Dao"
 * @author TOUAZI,Lylia
 */
public class JdbsDaoCercleDerby implements DAO<Cercle> {
/**
 * attribut Connection pour se connecter à la base de donnée.
 * @see JdbsDaoCercleDerby#JdbsDaoCercleDerby(Cercle)
 * @see JdbsDaoCercleDerby#create(Cercle)
 * @see JdbsDaoCercleDerby#delete(Cercle)
 * @see JdbsDaoCercleDerby#read(Cercle)
 * @see JdbsDaoCercleDerby#update(Cercle)
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
 * constructeur de la classe JdbsDaoCercleDerby.
 * @param connect Connection à la base de donnée.
 */
public JdbsDaoCercleDerby(Connection connect) {
	this.connect = connect;
}
/**
 * methode create Cercle.
 * insertion d'un Cercle.
 * @param obj le Cercle à sauvgarder dans la base de donnée.
 * @return objet créee
 * */
@Override
public final Cercle create(final Cercle obj) {
	this.delete(obj);
	PreparedStatement prepare = null;
	try {
		prepare = connect.prepareStatement(
				"INSERT  INTO Cercle (NameForme, centre_x, "
+ "centre_y, rayon)"
+ "VALUES (?, ?, ?, ?)");
		prepare.setString(UN, obj.getNameForme());
		prepare.setInt(DEUX, obj.getCoordonnee().getX());
		prepare.setInt(TROIS, obj.getCoordonnee().getY());
		prepare.setInt(QUATRE, obj.getrayon());
		int result = prepare.executeUpdate();
		assert result == 1;
	} catch (SQLException e) {
		e.getMessage();
	}
	return obj;
}
/**
 * methode read Cercle.
 * recuperer d'un Cercle dans la bd.
 * @param id le nom du Cercle à lire dans la base de donnée.
 * @return objet lu
 * */
@Override
public final Cercle read(final String id) {
	// TODO Auto-generated method stub
Cercle cercle = null;
PreparedStatement prepare = null;
ResultSet result = null;
try {
	prepare = connect.prepareStatement("SELECT *"
+ " FROM cercle"
+ " WHERE NameForme = ?  ");
prepare.setString(1, id);
result = prepare.executeQuery();
if (result.next()) {
	cercle = new Cercle(result.getString("NameForme"),
new Coordonnee(result.getInt("centre_x"),
result.getInt("centre_y")),
result.getInt("rayon"));
		} else {
			return null;
		}
	} catch (SQLException e) {
		e.getMessage();
	}
	return cercle;
}
/**
 * methode update Cercle.
 * modification d'un Cercle dans la bd.
 * @param obj le Cercle à modifier dans la base de donnée.
 * @return objet modifier
 * */
@Override
public final Cercle update(final Cercle obj) {
	try {
		PreparedStatement prepareFind =
				connect.prepareStatement("SELECT * "
+ "FROM cercle WHERE NameForme = ?  ");
prepareFind.setString(1, obj.getNameForme());
ResultSet res = prepareFind.executeQuery();
if (res.next()) {
	PreparedStatement prepare = connect.prepareStatement(
			"UPDATE cercle SET centre_x = ?, "
+ "centre_y = ?, "
+ "rayon = ? WHERE NameForme = ?");
			prepare.setInt(UN, obj.getCoordonnee().getX());
			prepare.setInt(DEUX, obj.getCoordonnee().getY());
			prepare.setInt(TROIS, obj.getrayon());
			prepare.setString(QUATRE, obj.getNameForme());
			int result = prepare.executeUpdate();
			System.out.println(obj.getCoordonnee().getX());
			System.out.println(obj.getCoordonnee().getY());
			assert result == 1;
		}
	} catch (SQLException e) {
		e.getMessage();
	}
	return obj;
}
/**
 * methode delete Cercle.
 * supression d'un Cercle dans la bd.
 * @param obj le Cercle à suprimer dans la base de donnée.
 * */
@Override
public final void delete(final Cercle obj) {
// TODO Auto-generated method stub
read(obj.getNameForme());
try {
	PreparedStatement prepareFind =
			connect.prepareStatement("SELECT *"
+ " FROM cercle WHERE NameForme = ?  ");
prepareFind.setString(1, obj.getNameForme());
ResultSet res = prepareFind.executeQuery();
if (res.next()) {
	PreparedStatement prepare = connect
			.prepareStatement("DELETE "
+ "FROM cercle "
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
