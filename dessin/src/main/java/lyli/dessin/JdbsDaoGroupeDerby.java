package lyli.dessin;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lyli.dessin.exeption.FormeDoncExistException;
import lyli.dessin.exeption.FormeExisteDeja;

public class JdbsDaoGroupeDerby implements DAO<GroupeForme> {
	private static String dburl = CeartionBDDREBY.dburl;
	@Override
	public GroupeForme create(GroupeForme obj) {
		try (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = connect.prepareStatement(
					"INSERT INTO groupe (id)" +
					"VALUES (?)");
			prepare.setString(1, obj.getNameForme());
			int result = prepare.executeUpdate();
			assert result == 1;
			List<Forme> lp = obj.getListForm();
			for(Iterator<Forme> it=lp.iterator(); it.hasNext();) {
				Forme n= it.next();
			prepare = connect.prepareStatement(
					"INSERT INTO appartenir "
					+ "VALUES (?, ?)");
			prepare.setString(1, obj.getNameForme());
			prepare.setString(2, n.getNameForme());
			prepare.executeUpdate();
		}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	
	@Override
	public GroupeForme read(String id) throws FormeDoncExistException {
		GroupeForme groupe = new GroupeForme(id);
		try (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepares = connect.prepareStatement(
					"SELECT * FROM appartenir WHERE id = ?");
			prepares.setString(1,id);
			ResultSet result = prepares.executeQuery();
			ArrayList<Cercle> Cercles = new ArrayList<Cercle>();
			ArrayList<Rectangle> Rectangles = new ArrayList<Rectangle>();
			ArrayList<Carre> Carres = new ArrayList<Carre>();
			ArrayList<Triangle> Triangles = new ArrayList<Triangle>();
			while (result.next()){
					try {
						PreparedStatement prepare = connect.prepareStatement(
						"SELECT * FROM cercle WHERE NameForme = ?  ");
						prepare.setString(1, result.getString("nom"));
						ResultSet resultt = prepare.executeQuery();
						if(resultt.next()) {
							Cercle cercle =   new Cercle (resultt.getString("NameForme"),
										new Coordonnee(resultt.getInt("centre_x"),
										resultt.getInt("centre_y")), 
										resultt.getInt("rayon"));
							resultt.close();
							Cercles.add(cercle);
							}
						}  catch (SQLException e) { e.getMessage(); }
					try {
						PreparedStatement prepare = connect.prepareStatement(
						"SELECT * FROM carre WHERE NameForme = ?  ");
						prepare.setString(1, result.getString("nom"));
						ResultSet resultt = prepare.executeQuery();
						
						if(resultt.next()) {
							Carre carre =   new Carre (resultt.getString("NameForme"),
										new Coordonnee(resultt.getInt("topLeft_x"), 
										resultt.getInt("topLeft_y")), 
										resultt.getInt("side"));
							resultt.close();
							Carres.add(carre);
							}
						}  catch (SQLException e) { e.getMessage(); }
					try {
						PreparedStatement prepare = connect.prepareStatement(
						"SELECT * FROM triangle WHERE NameForme = ?  ");
						prepare.setString(1, result.getString("nom"));
						ResultSet resultt = prepare.executeQuery();
						if(resultt.next()) {
							Triangle triangle = new Triangle (resultt.getString("NameForme"),
										new Coordonnee(resultt.getInt("point1_x"),
										resultt.getInt("point1_y")), 
										new Coordonnee(resultt.getInt("point2_x"),
										resultt.getInt("point2_y")),
										new Coordonnee(resultt.getInt("point3_x"),
										resultt.getInt("point3_y")));
							resultt.close();
							Triangles.add(triangle);
							}
						}  catch (SQLException e) { e.getMessage(); }
					try {
						PreparedStatement prepare = connect.prepareStatement(
						"SELECT * FROM rectangle WHERE NameForme = ?  ");
						prepare.setString(1, result.getString("nom"));
						ResultSet resultt = prepare.executeQuery();	
						if(resultt.next()) {
							Rectangle rectangle = new Rectangle (resultt.getString("NameForme"),
										new Coordonnee(resultt.getInt("topLeft_x"), 
										resultt.getInt("topLeft_y")), 
										resultt.getInt("sideTop"), 
										resultt.getInt("sideLeft"));
							resultt.close();
							Rectangles.add(rectangle);
							}
						} catch (SQLException e) { e.getMessage(); }					
					}
		         for (Cercle Cerclee: Cercles) { groupe.ajouterForme(Cerclee); }
		         for (Carre carree: Carres) { groupe.ajouterForme(carree); }
		         for (Triangle Trianglee: Triangles) { groupe.ajouterForme(Trianglee); }
		         for (Rectangle Rectanglee: Rectangles) { groupe.ajouterForme(Rectanglee); }	
		
		}catch (SQLException e) { e.printStackTrace(); }
		return groupe;
	}
	

	@Override
	public GroupeForme update(GroupeForme obj) throws FormeDoncExistException, FormeExisteDeja {
		GroupeForme groupe = new GroupeForme(obj.getNameForme());
		try (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepareFind = connect.prepareStatement(
					"SELECT * FROM groupe WHERE id = ?  ");
			prepareFind.setString(1, obj.getNameForme());
		      DAO<Carre> daoCar = DaoFactory.getCarreDAO();
		      DAO<Cercle> daoCercle = DaoFactory.getCercleDAO();
		      DAO<Triangle> daoTriangle = DaoFactory.getTriangleDAO();
		      DAO<Rectangle> daoRectangle = DaoFactory.getRectangleDAO();
		      List<Forme> lp = obj.getListForm();
				for(Iterator<Forme> it=lp.iterator(); it.hasNext();) {
		    	Forme f = it.next();
		    	System.out.println("===================================");
		    	f.affiche();
		    	System.out.println("===================================");
		    	if (f instanceof Cercle) {
		    		groupe.ajouterForme(daoCercle.update((Cercle) f));}
		    	
		    	if (f instanceof Rectangle) {
		    			daoRectangle.update((Rectangle) f);}
		    	if (f instanceof Triangle) {
		    		    	daoTriangle.update((Triangle) f);}
		    	if (f instanceof Carre) {
		    			groupe.ajouterForme(daoCar.update((Carre) f));}
		      }

		    } catch (SQLException e) {
		      e.printStackTrace();
		    } 
		obj.affiche();
		    return obj;
	}

	
	@Override
	public void delete(GroupeForme obj) throws FormeDoncExistException {
		// TODO Auto-generated method stub
		read(obj.getNameForme());
		try (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepareFind = connect.prepareStatement(
					"SELECT * FROM groupe WHERE id = ?  ");
			prepareFind.setString(1, obj.getNameForme());
			ResultSet res = prepareFind.executeQuery();
			if(!res.next()) { throw new FormeDoncExistException(""
					+ "Le groupe , donc le nom " + obj.getNameForme() + ", que vous voulez suprimer"
					+ " n'Ã©xiste pas :( !");}
			else {
				PreparedStatement prepare = connect.prepareStatement(
						"DELETE FROM groupe "
						+ "WHERE id = ?");
				prepare.setString(1, obj.getNameForme());
				int result = prepare.executeUpdate();
				assert result == 1;
				for (Forme forme : obj.getListForm()) {
					 prepare = connect.prepareStatement(
								"DELETE FROM appartenir "
								+ "WHERE id = ? "
							 	+ "and nom = ? ");
					 prepare.setString(1, obj.getNameForme());
					 prepare.setString(2, forme.getNameForme());
					 int result1 = prepare.executeUpdate();
						assert result1 == 1 ;
						}
				}
			}
		catch (SQLException e) {
			e.getMessage();
		}
	}
}