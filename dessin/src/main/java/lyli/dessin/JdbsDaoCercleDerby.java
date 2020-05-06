package lyli.dessin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	public Cercle read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cercle update(Cercle obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Cercle obj) {
		// TODO Auto-generated method stub
		
	}

}
