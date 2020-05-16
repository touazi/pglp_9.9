package lyli.dessin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lyli.dessin.Cercle;
import lyli.dessin.Coordonnee;
public class JdbsDaoCercleDerby implements DAO<Cercle> {
	Connection connect = null;
	public JdbsDaoCercleDerby(Connection connect ) 
	{
	this.connect = connect ;
	}

	@Override
	public Cercle create(Cercle obj) {
		this.delete(obj);
		PreparedStatement prepare = null;
		try  {
				 prepare = connect.prepareStatement(
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
		Cercle cercle = null;
		PreparedStatement prepare = null ;
		ResultSet result = null ;
		try {
			prepare = connect.prepareStatement(
					"SELECT * FROM cercle WHERE NameForme = ?  ");
			prepare.setString(1, id);
			result = prepare.executeQuery();
			if(result.next()) {
				cercle =   new Cercle (result.getString("NameForme"),
							new Coordonnee(result.getInt("centre_x"), result.getInt("centre_y")), 
							result.getInt("rayon"));
				}
			else { 
		       return null;}
			}
		catch (SQLException e) {
			e.getMessage();
		}
		return cercle;
		}

	@Override
	public Cercle update(Cercle obj) {
		try {
			PreparedStatement prepareFind = connect.prepareStatement(
					"SELECT * FROM cercle WHERE NameForme = ?  ");
			prepareFind.setString(1, obj.getNameForme());
			ResultSet res = prepareFind.executeQuery();
			if (res.next()) {  
			PreparedStatement prepare = connect.prepareStatement(
					"UPDATE cercle SET centre_x = ?, "
					+ "centre_y = ?, "
					+ "rayon = ? WHERE NameForme = ?");
			prepare.setInt(1, obj.getCoordonnee().getX());
			
			prepare.setInt(2, obj.getCoordonnee().getY());
			prepare.setInt(3, obj.getrayon());
			prepare.setString(4, obj.getNameForme());
			int result = prepare.executeUpdate();
			System.out.println(obj.getCoordonnee().getX());
			System.out.println(obj.getCoordonnee().getY());
			assert result == 1; }
			}
		catch (SQLException e) {
			e.getMessage();
		}
		return obj;	
	}
	@Override
	public void delete(Cercle obj) {
		// TODO Auto-generated method stub
		read(obj.getNameForme());
		try  {
			PreparedStatement prepareFind = connect.prepareStatement(
					"SELECT * FROM cercle WHERE NameForme = ?  ");
			prepareFind.setString(1, obj.getNameForme());
			ResultSet res = prepareFind.executeQuery();
			if (res.next()) {
				PreparedStatement prepare = connect.prepareStatement(
						"DELETE FROM cercle "
						+ "WHERE NameForme = ?");
				prepare.setString(1, obj.getNameForme());
				int result = prepare.executeUpdate();
				assert result == 1;
				}
			}
		catch (SQLException e) {
			e.getMessage();
		}
	}
}