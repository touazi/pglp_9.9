package lyli.dessin.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lyli.dessin.Coordonnee;
import lyli.dessin.Triangle;
/**.
 * <b>"la classe JdbsDaoTriangleDerby."</b>
 * <p>"implementation du patern Dao"
 * @author TOUAZI,Lylia
 */
public class JdbsDaoTriangleDerby implements DAO<Triangle> {
/**
 * attribut Connection pour se connecter à la base de donnée.
 * @see JdbsDaoTriangleDerby#JdbsDaoTriangleDerby(Connection)
 * @see JdbsDaoTriangleDerby#create(Triangle)
 * @see JdbsDaoTriangleDerby#delete(Triangle)
 * @see JdbsDaoTriangleDerby#read(String)
 * @see JdbsDaoTriangleDerby#update(Triangle)
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
 * constructeur de la classe JdbsDaoTriangleDerby.
 * @param connectt Connection à la base de donnée.
 */
public JdbsDaoTriangleDerby(final Connection connectt) {
	this.connect = connectt;
}
/**
 * methode create triangle.
 * insertion d'un Triangle.
 * @param obj le Triangle à sauvgarder dans la base de donnée.
 * @return objet créee
 * */
@Override
public final Triangle create(final Triangle obj) {
	this.delete(obj);
	try {
		PreparedStatement prepare = connect
				.prepareStatement("INSERT  INTO Triangle "
+ "(NameForme, point1_x, point1_y, "
+ "point2_x, point2_y, point3_x, point3_y)"
+ "VALUES (?, ?, ?, ?, ?, ?, ?)");
		prepare.setString(1, obj.getNameForme());
		prepare.setInt(2, obj.getCoordonnee1().getX());
		prepare.setInt(TROIS, obj.getCoordonnee1().getY());
		prepare.setInt(QUATRE, obj.getCoordonnee2().getX());
		prepare.setInt(CINQ, obj.getCoordonnee2().getY());
		prepare.setInt(SIX, obj.getCoordonnee3().getX());
		prepare.setInt(SEPT, obj.getCoordonnee3().getY());
		int result = prepare.executeUpdate();
		assert result == 1;
	} catch (SQLException e) {
		e.getMessage();
	}
	return obj;
}
/**
 * methode read triangle.
 * recuperer d'un Triangle dans la bd.
 * @param id le nom du Triangle à lire dans la base de donnée.
 * @return objet lu
 * */
@Override
public final Triangle read(final String id) {
	// TODO Auto-generated method stub
Triangle triangle = null;
try {
	PreparedStatement prepare =
			connect.prepareStatement("SELECT * "
+ "FROM triangle WHERE NameForme = ?  ");
prepare.setString(1, id);
ResultSet result = prepare.executeQuery();

if (result.next()) {
	Coordonnee coordonnee1 = new Coordonnee(
			result.getInt("point1_x"),
result.getInt("point1_y"));
Coordonnee coordonnee2 = new Coordonnee(
		result.getInt("point2_x"),
result.getInt("point2_y"));
Coordonnee coordonnee3 = new Coordonnee(
		result.getInt("point3_x"),
result.getInt("point3_y"));
triangle = new Triangle(result.getString("NameForme"),
					coordonnee1,
					coordonnee2,
					coordonnee3);
			result.close();
		} else {
			return null;
		}
	} catch (SQLException e) {
		e.getMessage();
	}
	return triangle;
}
/**
 * methode update triangle.
 * modification d'un Triangle dans la bd.
 * @param obj le Triangle à modifier dans la base de donnée.
 * @return objet modifier
 * */
@Override
public final Triangle update(final Triangle obj) {
	try {
		PreparedStatement prepareFind;
		prepareFind = connect
				.prepareStatement("SELECT *"
+ " FROM triangle WHERE NameForme = ?  ");
prepareFind.setString(1, obj.getNameForme());
ResultSet res = prepareFind.executeQuery();
if (res.next()) {
	PreparedStatement prepare;
	prepare = connect.prepareStatement(
					"UPDATE triangle "
+ "SET point1_x = ?, "
+ "point1_y = ?, "
+ "point2_x = ?, "
+ "point2_y = ?, "
+ "point3_x = ?, "
+ "point3_y = ? WHERE "
+ "NameForme = ?");
			prepare.setInt(1, obj.getCoordonnee1().getX());
			prepare.setInt(2, obj.getCoordonnee1().getY());
			prepare.setInt(TROIS, obj.getCoordonnee2().getX());
			prepare.setInt(QUATRE, obj.getCoordonnee2().getY());
			prepare.setInt(CINQ, obj.getCoordonnee3().getX());
			prepare.setInt(SIX, obj.getCoordonnee3().getY());
			prepare.setString(SEPT, obj.getNameForme());
			int result = prepare.executeUpdate();
			assert result == 1;
		}
	} catch (SQLException e) {
		e.getMessage();
	}
	return obj;
}
/**
 * methode delete triangle.
 * supression d'un Triangle dans la bd.
 * @param obj le Triangle à suprimer dans la base de donnée.
 * */
@Override
public final void delete(final Triangle obj) {
	// TODO Auto-generated method stub
read(obj.getNameForme());
try {
	PreparedStatement prepareFind;
	prepareFind = connect.prepareStatement("SELECT *"
+ " FROM triangle WHERE NameForme = ?  ");
prepareFind.setString(1, obj.getNameForme());
ResultSet res = prepareFind.executeQuery();
if (res.next()) {
	PreparedStatement prepare;
	prepare = connect.prepareStatement("DELETE "
+ "FROM triangle "
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
