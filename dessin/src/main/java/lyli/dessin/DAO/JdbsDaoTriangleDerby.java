package lyli.dessin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lyli.dessin.Coordonnee;
import lyli.dessin.Triangle;

public class JdbsDaoTriangleDerby implements DAO<Triangle> {

	Connection connect = null;
	public JdbsDaoTriangleDerby(Connection connect) {
		this.connect = connect ;
	}

	@Override
	public Triangle create(Triangle obj)  {
		this.delete(obj);
		try {
			PreparedStatement prepare = connect.prepareStatement(
					"INSERT  INTO Triangle (NameForme, point1_x, point1_y, "
					+ "point2_x, point2_y, point3_x, point3_y)" 
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
		Triangle triangle = null;
		try {
			PreparedStatement prepare = connect.prepareStatement(
					"SELECT * FROM triangle WHERE NameForme = ?  ");
			prepare.setString(1, id);
			ResultSet result = prepare.executeQuery();
			
			if(result.next()) {
				triangle =   new Triangle (result.getString("NameForme"),
							new Coordonnee(result.getInt("point1_x"), result.getInt("point1_y")), 
							new Coordonnee(result.getInt("point2_x"), result.getInt("point2_y")),
							new Coordonnee(result.getInt("point3_x"), result.getInt("point3_y")));
				result.close();
				}
			else { 
		     	return null;}
			}
		catch (SQLException e) {
			e.getMessage();
		}
		return triangle;
		}

	@Override
	public Triangle update(Triangle obj) {
		try {
			PreparedStatement prepareFind = connect.prepareStatement(
					"SELECT * FROM triangle WHERE NameForme = ?  ");
			prepareFind.setString(1, obj.getNameForme());
			ResultSet res = prepareFind.executeQuery();
			
			if (res.next()) {  
			PreparedStatement prepare = connect.prepareStatement(
					"UPDATE triangle SET point1_x = ?, "
					+ "point1_y = ?, "
					+ "point2_x = ?, "
					+ "point2_y = ?, "
					+ "point3_x = ?, "
					+ "point3_y = ? WHERE NameForme = ?");
			prepare.setInt(1, obj.getCoordonnee1().getX());
			prepare.setInt(2, obj.getCoordonnee1().getY());
			prepare.setInt(3, obj.getCoordonnee2().getX());
			prepare.setInt(4, obj.getCoordonnee2().getY());
			prepare.setInt(5, obj.getCoordonnee3().getX());
			prepare.setInt(6, obj.getCoordonnee3().getY());
			prepare.setString(7, obj.getNameForme());
			int result = prepare.executeUpdate();
			assert result == 1;}
		}
		catch (SQLException e) {
			e.getMessage();
		}
		return obj;	
	}

	@Override
	public void delete(Triangle obj) {
		// TODO Auto-generated method stub
		read(obj.getNameForme());
		try  {
			PreparedStatement prepareFind = connect.prepareStatement(
					"SELECT * FROM triangle WHERE NameForme = ?  ");
			prepareFind.setString(1, obj.getNameForme());
			ResultSet res = prepareFind.executeQuery();
			if (res.next()) {
				PreparedStatement prepare = connect.prepareStatement(
						"DELETE FROM triangle "
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
