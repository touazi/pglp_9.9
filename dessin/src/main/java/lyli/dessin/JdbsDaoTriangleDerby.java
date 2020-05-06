package lyli.dessin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import lyli.dessin.exeption.FormeExisteDeja;

public class JdbsDaoTriangleDerby implements DAO<Triangle> {
	private static String dburl = CeartionBDDREBY.dburl;
	@Override
	public Triangle create(Triangle obj) throws FormeExisteDeja {
		try (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = connect.prepareStatement(
					"INSERT  INTO Triangle (NameForme, point1_x, point1_y, point2_x, point2_y, point3_x, point3_y)" 
							+ "VALUES (?, ?, ?, ?, ?, ?, ?)");
			prepare.setString(1, obj.getNameForme());
			prepare.setInt(2, obj.getCoordonnee1().getX());
			prepare.setInt(3, obj.getCoordonnee1().getY());
			prepare.setInt(4, obj.getCoordonnee2().getX());
			prepare.setInt(5, obj.getCoordonnee2().getY());
			prepare.setInt(6, obj.getCoordonnee3().getX());
			prepare.setInt(7, obj.getCoordonnee3().getY()); 
			
			int result = prepare.executeUpdate();
			assert result == 1;
		}
		catch (SQLException e) {
			e.getMessage();
			
		}
		return obj;
	}

	@Override
	public Triangle read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Triangle update(Triangle obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Triangle obj) {
		// TODO Auto-generated method stub
		
	}

}
