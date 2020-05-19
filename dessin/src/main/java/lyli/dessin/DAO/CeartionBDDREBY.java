package lyli.dessin.DAO;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**.
 * <b>"la classe CeartionBDDREBY."</b>
 * <p>"implementation du patern Dao"
 * @author TOUAZI,Lylia
 */
public class CeartionBDDREBY {
	/**user name.*/
	private static final String USERNAME = "";
	/**pssword.*/
	private static final String PASSWORD = "";
	/**nom de la bd.*/
	private static String dburl = null;
	/**Constructeur de la classee CeartionBDDREBY.
	 * @param name nom de la bd*/
	public CeartionBDDREBY(final String name) {
		Properties connectionProps = new Properties();
		dburl = "jdbc:derby:" + name + ";create=true";
		connectionProps.put("user", USERNAME);
		connectionProps.put("user", PASSWORD);
	}
	/**mthode getDburl.
	 * @return name nom de la bd*/
	public static String getDburl() {
		return CeartionBDDREBY.dburl;
	}
	/**méthode createtebale.
	 * reation des tablde de la bd.*/
	public final void createTables() {
	try (Connection connect = DriverManager.getConnection(dburl)) {
			Statement state = connect.createStatement();
			DatabaseMetaData databaseMetadata = connect.getMetaData();
			ResultSet resultCARRE = databaseMetadata.getTables(null,
					null, "CARRE", null);
			if (!(resultCARRE.next())) {
				String sql = "CREATE TABLE carre("
						+ "NameForme varchar(30) PRIMARY KEY,"
								+ "topLeft_x int,"
								+ "topLeft_y int,"
								+ "side int" + ")";
				state.addBatch(sql);
			}
			ResultSet resultRectangle =
					databaseMetadata.getTables(null, null,
							"RECTANGLE", null);
			if (!(resultRectangle.next())) {
				String sql = "CREATE TABLE rectangle("
						+ "NameForme varchar(30) PRIMARY KEY,"
						+ "topLeft_x int,"
						+ "topLeft_y int,"
						+ "sideTop int,"
						+ "sideLeft int" + ")";
				state.addBatch(sql);
			}
			ResultSet resultTriangle =
					databaseMetadata.getTables(null,
							null, "TRIANGLE", null);

			if (!(resultTriangle.next())) {
				String sql = "CREATE TABLE triangle("
						+ "NameForme varchar(30) PRIMARY KEY,"
						+ "point1_x int,"
						+ "point1_y int,"
						+ "point2_x int,"
						+ "point2_y int,"
						+ "point3_x int,"
						+ "point3_y int"
						+ ")";
				state.addBatch(sql);
			}
			ResultSet resultCercle = databaseMetadata.getTables(null,
					null, "CERCLE", null);
			if (!(resultCercle.next())) {
				String sql = "CREATE TABLE cercle("
						+ "NameForme varchar(30) PRIMARY KEY,"
						+ "centre_x int,"
						+ "centre_y int,"
						+ "rayon int" + ")";
				state.addBatch(sql);
			}
			ResultSet result = databaseMetadata.getTables(null,
					null, "GROUPE", null);
			if (!(result.next())) {
				state.addBatch("CREATE TABLE groupe ("
			+ "id VARCHAR(100) PRIMARY KEY" + ")");
			}
			ResultSet res = databaseMetadata.getTables(null,
					null, "APPARTENIR", null);
			if (!(res.next())) {
				state.addBatch("CREATE TABLE appartenir ("
			+ "id VARCHAR(100) ," + "nom VARCHAR(100) " + ")");
			}
			state.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
