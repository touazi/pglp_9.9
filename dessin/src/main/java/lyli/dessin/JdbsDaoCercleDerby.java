package lyli.dessin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lyli.dessin.exeption.FormeDoncExistException;
import lyli.dessin.exeption.FormeExisteDeja;

public class JdbsDaoCercleDerby implements DAO<Cercle> {
	private static String dburl = CeartionBDDREBY.dburl;
	@Override
	public Cercle create(Cercle obj) throws FormeExisteDeja {
			try (Connection connect = DriverManager.getConnection(dburl)) {
				PreparedStatement prepare = connect.prepareStatement(
						"INSERT  INTO Cercle (NameForme, centre_x, centre_y, rayon)" +
						"VALUES (?, ?, ?, ?)");
				prepare.setString(1, obj.getNameForme());
				prepare.setInt(2, obj.getCoordonnee().getX());
				prepare.setInt(3, obj.getCoordonnee().getY());
				prepare.setInt(4, obj.getrayon());
				int result = prepare.executeUpdate();
				assert result == 1;
			}
			catch (SQLException e) {
				e.getMessage();
				
			}
			return obj;	
	}


	@Override
	public Cercle read(String id) throws FormeDoncExistException {
		// TODO Auto-generated method stub
		Cercle cercle = null;
		try (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = connect.prepareStatement(
					"SELECT * FROM cercle WHERE NameForme = ?  ");
			prepare.setString(1, id);
			ResultSet result = prepare.executeQuery();
			
			if(result.next()) {
				cercle =   new Cercle (result.getString("NameForme"),
							new Coordonnee(result.getInt("centre_x"), result.getInt("centre_y")), 
							result.getInt("rayon"));
				result.close();
				}
			else { 
		        throw new FormeDoncExistException("Le Cercle que vous chercher n'Ã©xiste pas :( !");}
		
	}
		catch (SQLException e) {
			e.getMessage();
		}
		return cercle;
		}

	@Override
	public Cercle update(Cercle obj) throws FormeDoncExistException {
		try (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepareFind = connect.prepareStatement(
					"SELECT * FROM cercle WHERE NameForme = ?  ");
			prepareFind.setString(1, obj.getNameForme());
			ResultSet res = prepareFind.executeQuery();
			
			if(!res.next()) { throw new FormeDoncExistException(""
					+ "Le cercle que vous voulez modifier"
					+ " n'Ã©xiste pas :( !");}
			else {  
			PreparedStatement prepare = connect.prepareStatement(
					"UPDATE cercle SET centre_x = ?, "
					+ "centre_y = ?, "
					+ "rayon = ? WHERE NameForme = ?");
			prepare.setInt(1, obj.getCoordonnee().getX());
			prepare.setInt(2, obj.getCoordonnee().getY());
			prepare.setInt(3, obj.getrayon());
			prepare.setString(4, obj.getNameForme());
			int result = prepare.executeUpdate();
			assert result == 1;}
		}
		catch (SQLException e) {
			e.getMessage();
		}
		return obj;	
	}

	@Override
	public void delete(Cercle obj) throws FormeDoncExistException {
		// TODO Auto-generated method stub
		read(obj.getNameForme());
		try (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepareFind = connect.prepareStatement(
					"SELECT * FROM cercle WHERE NameForme = ?  ");
			prepareFind.setString(1, obj.getNameForme());
			ResultSet res = prepareFind.executeQuery();
			if(!res.next()) { throw new FormeDoncExistException(""
					+ "Le cercle , donc le nom " + obj.getNameForme() + ", que vous voulez suprimer"
					+ " n'Ã©xiste pas :( !");}
			else {
				PreparedStatement prepare = connect.prepareStatement(
						"DELETE FROM cercle "
						+ "WHERE NameForme = ?");
				prepare.setString(1, obj.getNameForme());
				int result = prepare.executeUpdate();
				assert result == 1;
		}}
		catch (SQLException e) {
			e.getMessage();
		}
	}

}
