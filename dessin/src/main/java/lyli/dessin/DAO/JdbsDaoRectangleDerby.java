package lyli.dessin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lyli.dessin.Coordonnee;
import lyli.dessin.Rectangle;
import lyli.dessin.exeption.FormeDoncExistException;
import lyli.dessin.exeption.FormeExisteDeja;

public class JdbsDaoRectangleDerby implements DAO<Rectangle>{
	Connection connect = null;
	public JdbsDaoRectangleDerby(Connection connect) 
	{
	this.connect = connect ;
	}
	@Override
	public Rectangle create(Rectangle obj) throws FormeExisteDeja {
		try {
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
	public Rectangle read(String id) throws FormeDoncExistException {
		// TODO Auto-generated method stub
		Rectangle rectangle = null;
		try {
			PreparedStatement prepare = connect.prepareStatement(
					"SELECT * FROM rectangle WHERE NameForme = ?  ");
			prepare.setString(1, id);
			ResultSet result = prepare.executeQuery();
			
			if(result.next()) {
				rectangle =   new Rectangle (result.getString("NameForme"),
							new Coordonnee(result.getInt("topLeft_x"), result.getInt("topLeft_y")), 
							result.getInt("sideTop"),
							result.getInt("sideLeft"));
				result.close();
				}
			else { 
		      //  throw new FormeDoncExistException("Le Rectangle que vous chercher n'Ã©xiste pas :( !");
		        return null;    
			}
		}
		catch (SQLException e) {
			e.getMessage();
		}
		return rectangle;
		}

	@Override   
	public Rectangle update(Rectangle obj) throws FormeDoncExistException {
		try {
			PreparedStatement prepareFind = connect.prepareStatement(
					"SELECT * FROM rectangle WHERE NameForme = ?  ");
			prepareFind.setString(1, obj.getNameForme());
			ResultSet res = prepareFind.executeQuery();
			
			if(!res.next()) { throw new FormeDoncExistException(""
					+ "Le rectangle que vous voulez modifier"
					+ " n'Ã©xiste pas :( !");}
			else { 
				
			PreparedStatement prepare = connect.prepareStatement(
					"UPDATE rectangle SET topLeft_x = ? , "
					+ "topLeft_y = ? , "
					+ "sideTop = ? , "
					+ "sideLeft = ?  "
					+ "WHERE NameForme = ?");
			
			prepare.setInt(1, obj.getCoordonnee().getX());
			prepare.setInt(2, obj.getCoordonnee().getY());
			prepare.setInt(3, obj.getsideTop());
			prepare.setInt(4, obj.getsideLeft());
			prepare.setString(5, obj.getNameForme());
			int result = prepare.executeUpdate();
			assert result == 1;}
		}
		catch (SQLException e) {
			e.getMessage();
		}
		return obj;	
	}

	@Override
	public void delete(Rectangle obj) throws FormeDoncExistException {
		// TODO Auto-generated method stub
		read(obj.getNameForme());
		try {
			PreparedStatement prepareFind = connect.prepareStatement(
					"SELECT * FROM rectangle WHERE NameForme = ?  ");
			prepareFind.setString(1, obj.getNameForme());
			ResultSet res = prepareFind.executeQuery();
			if(!res.next()) { throw new FormeDoncExistException(""
					+ "Le rectangle, donc le nom " + obj.getNameForme() + ",  que vous voulez suprimer"
					+ " n'Ã©xiste pas :( !");}
			else {
				PreparedStatement prepare = connect.prepareStatement(
						"DELETE FROM rectangle "
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
