package lyli.dessin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import lyli.dessin.exeption.FormeExisteDeja;

public class JdbsDaoRectangleDerby implements DAO<Rectangle>{
	private static String dburl = CeartionBDDREBY.dburl;
	@Override
	public Rectangle create(Rectangle obj) throws FormeExisteDeja {
		try (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = connect.prepareStatement(
					"INSERT  INTO Rectangle (NameForme, topLeft_x, topLeft_y, sideTop, sideLeft)" +
					"VALUES (?, ?, ?, ?, ?)");
			prepare.setString(1, obj.getNameForme());
			prepare.setInt(2, obj.getCoordonnee().getX());
			prepare.setInt(3, obj.getCoordonnee().getY());
			prepare.setInt(4, obj.getsideTop());
			prepare.setInt(5, obj.getsideLeft());
			int result = prepare.executeUpdate();
			assert result == 1;
		}
		catch (SQLException e) {
			e.getMessage();
			
		}
		return obj;
	}

	@Override
	public Rectangle read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle update(Rectangle obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Rectangle obj) {
		// TODO Auto-generated method stub
		
	}

}
