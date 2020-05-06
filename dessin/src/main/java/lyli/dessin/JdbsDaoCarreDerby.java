package lyli.dessin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lyli.dessin.exeption.FormeExisteDeja;
import lyli.dessin.exeption.FormeDoncExistException;
public class JdbsDaoCarreDerby implements DAO<Carre> {
	private static String dburl = CeartionBDDREBY.dburl;
	@Override
	public Carre create(Carre obj) throws FormeExisteDeja {
		try (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = connect.prepareStatement(
					"INSERT  INTO Carre (NameForme, topLeft_x, topLeft_y, side)" +
					"VALUES (?, ?, ?, ?)");
			prepare.setString(1, obj.getNameForme());
			prepare.setInt(2, obj.getCoordonnee().getX());
			prepare.setInt(3, obj.getCoordonnee().getY());
			prepare.setInt(4, obj.getside());
			int result = prepare.executeUpdate();
			assert result == 1;
		}
		catch (SQLException e) {
			e.getMessage();
			
		}
		return obj;
	}

	@Override
	public Carre read(String id) throws FormeDoncExistException {
		// TODO Auto-generated method stub
		Carre carre = null;
		try (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = connect.prepareStatement(
					"SELECT * FROM carre WHERE NameForme = ?  ");
			prepare.setString(1, id);
			ResultSet result = prepare.executeQuery();
			
			if(result.next()) {
				carre =   new Carre (result.getString("NameForme"),
							new Coordonnee(result.getInt("topLeft_x"), result.getInt("topLeft_y")), 
							result.getInt("side"));
				result.close();
				}
			else { 
		        throw new FormeDoncExistException("Le carre que vous chercher n'Ã©xiste pas :( !");}
		}
		catch (SQLException e) {
			e.getMessage();
		}
		return carre;
		}



	@Override
	public Carre update(Carre obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Carre obj) {
		// TODO Auto-generated method stub
		
	}

}
