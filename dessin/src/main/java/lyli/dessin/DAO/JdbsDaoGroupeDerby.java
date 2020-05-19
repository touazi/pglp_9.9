package lyli.dessin.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lyli.dessin.Carre;
import lyli.dessin.Cercle;
import lyli.dessin.Coordonnee;
import lyli.dessin.Forme;
import lyli.dessin.GroupeForme;
import lyli.dessin.Rectangle;
import lyli.dessin.Triangle;
public class JdbsDaoGroupeDerby implements DAO<GroupeForme> {
	/**
	 * attribut Connection pour se connecter à la base de donnée.
	 * @see JdbsDaoGroupeDerby#JdbsDaoGroupeDerby(Connection)
	 * @see JdbsDaoGroupeDerby#create(GroupeForme)
	 * @see JdbsDaoGroupeDerby#delete(GroupeForme)
	 * @see JdbsDaoGroupeDerby#read(String)
	 * @see JdbsDaoGroupeDerby#update(GroupeForme)
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
	 * constructeur de la classe JdbsDaoGroupeDerby.
	 * @param connect Connection à la base de donnée.
	 */
	public JdbsDaoGroupeDerby(Connection connect) {
		this.connect = connect;
	}
	/**
	 * methode create GroupeForme.
	 * insertion d'un GroupeForme.
	 * @param obj le GroupeForme à sauvgarder dans la base de donnée.
	 * @return objet créee
	 * */
	@Override
	public final GroupeForme create(final GroupeForme obj) {
		try {
			PreparedStatement prepare =
					connect.prepareStatement("INSERT"
							+ " INTO groupe (id) VALUES (?)");
			prepare.setString(1, obj.getNameForme());
			int result = prepare.executeUpdate();
			assert result == 1;
			List<Forme> lp = obj.getListForm();
			for (Iterator<Forme> it = lp.iterator(); it.hasNext();) {
				Forme n = it.next();
				prepare =
						connect.prepareStatement("INSERT INTO "
								+ "appartenir " + "VALUES (?, ?)");
				prepare.setString(1, obj.getNameForme());
				prepare.setString(2, n.getNameForme());
				prepare.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	/**
	 * methode read GroupeForme.
	 * recuperer d'un GroupeForme dans la bd.
	 * @param id le nom du GroupeForme à lire dans la base de donnée.
	 * @return objet lu
	 * */
	@Override
	public final GroupeForme read(final String id) {
		GroupeForme groupe = null;
		try {
			PreparedStatement prepares =
					connect.prepareStatement("SELECT * "
							+ "FROM appartenir WHERE id = ?");
			prepares.setString(1, id);
			ResultSet result = prepares.executeQuery();
			ArrayList<Cercle> cercles = new ArrayList<Cercle>();
			ArrayList<Rectangle> rectangles =
					new ArrayList<Rectangle>();
			ArrayList<Carre> carres = new ArrayList<Carre>();
			ArrayList<Triangle> triangles = new ArrayList<Triangle>();
			while (result.next()) {
				try {
					groupe = new GroupeForme(id);
					PreparedStatement prepare = connect
							.prepareStatement(""
					+ "SELECT * FROM cercle WHERE NameForme = ?  ");
					prepare.setString(1, result.getString("nom"));
					ResultSet resultt = prepare.executeQuery();
					if (resultt.next()) {
						Cercle cercle = new Cercle(
								resultt.getString("NameForme"),
								new Coordonnee(
										resultt.getInt("centre_x"),
										resultt.getInt("centre_y")),
										resultt.getInt("rayon"));
						resultt.close();
						cercles.add(cercle);
					}
				} catch (SQLException e) {
					e.getMessage();
				}
				try {
					PreparedStatement prepare = connect
							.prepareStatement(""
					+ "SELECT * FROM carre WHERE NameForme = ?  ");
					prepare.setString(1, result.getString("nom"));
					ResultSet resultt = prepare.executeQuery();
					if (resultt.next()) {
						Carre carre = new Carre(
								resultt.getString("NameForme"),
								new Coordonnee(
										resultt.getInt("topLeft_x"),
										resultt.getInt("topLeft_y")),
								resultt.getInt("side"));
						resultt.close();
						carres.add(carre);
					}
				} catch (SQLException e) {
					e.getMessage();
				}
				try {
					PreparedStatement prepare = connect
							.prepareStatement("SELECT * "
									+ "FROM triangle "
									+ "WHERE NameForme = ?  ");
					prepare.setString(1, result.getString("nom"));
					ResultSet resultt = prepare.executeQuery();
					if (resultt.next()) {
						Triangle triangle = new Triangle(
								resultt.getString("NameForme"),
								new Coordonnee(
										resultt.getInt("point1_x"),
										resultt.getInt("point1_y")),
								new Coordonnee(
										resultt.getInt("point2_x"),
										resultt.getInt("point2_y")),
								new Coordonnee(
										resultt.getInt("point3_x"),
										resultt.getInt("point3_y")));
						resultt.close();
						triangles.add(triangle);
					}
				} catch (SQLException e) {
					e.getMessage();
				}
				try {
					PreparedStatement prepare = connect
							.prepareStatement("SELECT * "
					+ "FROM rectangle WHERE NameForme = ?  ");
					prepare.setString(1, result.getString("nom"));
					ResultSet resultt = prepare.executeQuery();
					if (resultt.next()) {
						Rectangle rectangle = new Rectangle(
								resultt.getString("NameForme"),
								new Coordonnee(
										resultt.getInt("topLeft_x"),
										resultt.getInt("topLeft_y")),
								resultt.getInt("sideTop"),
								resultt.getInt("sideLeft"));
						resultt.close();
						rectangles.add(rectangle);
					}
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			for (Cercle cerclee : cercles) {
				groupe.ajouterForme(cerclee);
			}
			for (Carre carree : carres) {
				groupe.ajouterForme(carree);
			}
			for (Triangle rrianglee : triangles) {
				groupe.ajouterForme(rrianglee);
			}
			for (Rectangle rectanglee : rectangles) {
				groupe.ajouterForme(rectanglee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groupe;
	}
	/**
	 * methode update Rectangle.
	 * modification d'un Rectangle dans la bd.
	 * @param obj le Rectangle à modifier dans la base de donnée.
	 * @return objet modifier
	 * */
	@Override
	public final GroupeForme update(final GroupeForme obj) {
		try {
			PreparedStatement prepareFind;
			prepareFind = connect.prepareStatement("SELECT * "
			+ "FROM groupe WHERE id = ?  ");
			prepareFind.setString(1, obj.getNameForme());
			DaoFactory factory = new DaoFactory();
			DAO<Carre> daoCar = factory.getCarreDAO();
			DAO<Cercle> daoCercle = factory.getCercleDAO();
			DAO<Triangle> daoTriangle = factory.getTriangleDAO();
			DAO<Rectangle> daoRectangle = factory.getRectangleDAO();
			List<Forme> lp = obj.getListForm();
			for (Iterator<Forme> it = lp.iterator(); it.hasNext();) {
				Forme f = it.next();
				if (f instanceof Cercle) {
					daoCercle.update((Cercle) f);
				}
				if (f instanceof Rectangle) {
					daoRectangle.update((Rectangle) f);
				}
				if (f instanceof Triangle) {
					daoTriangle.update((Triangle) f);
				}
				if (f instanceof Carre) {
					daoCar.update((Carre) f);
				}
			}
			factory.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//obj.affiche();
		return obj;
	}
	/**
	 * methode delete GroupeForme.
	 * supression d'un GroupeForme dans la bd.
	 * @param obj le GroupeForme à suprimer dans la base de donnée.
	 * */
	@Override
	public final void delete(final GroupeForme obj) {
		// TODO Auto-generated method stub
		read(obj.getNameForme());
		try {
			PreparedStatement prepareFind =
					connect.prepareStatement("SELECT *"
			+ " FROM groupe WHERE id = ?  ");
			prepareFind.setString(1, obj.getNameForme());
			ResultSet res = prepareFind.executeQuery();
			if (res.next()) {
				String sql1 = "DELETE"
						+ " FROM groupe "
						+ "WHERE id = ?";
				PreparedStatement prepare =
						connect.prepareStatement(sql1);
				prepare.setString(1, obj.getNameForme());
				int result = prepare.executeUpdate();
				assert result == 1;
				for (Forme forme : obj.getListForm()) {
					String sql = "DELETE FROM"
							+ " appartenir "
							+ "WHERE id = ? "
							+ "and nom = ? ";
					prepare = connect.prepareStatement(sql);
					String nomObjet = obj.getNameForme();
					String nomForme = forme.getNameForme();		
					prepare.setString(1, nomObjet);
					prepare.setString(2, nomForme);
					int result1 = prepare.executeUpdate();
					assert result1 == 1;
				}
			}
		} catch (SQLException e) {
			e.getMessage();
		}
	}
}
