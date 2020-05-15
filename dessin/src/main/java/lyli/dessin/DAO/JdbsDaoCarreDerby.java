package lyli.dessin.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lyli.dessin.exeption.FormeExisteDeja;
import lyli.dessin.Carre;
import lyli.dessin.CeartionBDDREBY;
import lyli.dessin.Coordonnee;
import lyli.dessin.exeption.FormeDoncExistException;
public class JdbsDaoCarreDerby implements DAO<Carre> {
	Connection connect = null;
	public JdbsDaoCarreDerby(Connection connect ) 
	{
	this.connect = connect ;
	}
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
	public Carre read(String id) throws FormeDoncExistException  {
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
		       // throw new FormeDoncExistException("Le Carre "+ result.getString("NameForme") + "que vous chercher n'Ã©xiste pas :( !");
				return null;}
		
		}
		catch (SQLException e) {
			e.getMessage();
		}
		return carre;
		}



	@Override
	public Carre update(Carre obj) throws FormeDoncExistException {
		try (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepareFind = connect.prepareStatement(
					"SELECT * FROM carre WHERE NameForme = ?  ");
			prepareFind.setString(1, obj.getNameForme());
			ResultSet res = prepareFind.executeQuery();
			
			if(!res.next()) { throw new FormeDoncExistException(""
					+ "Le carre que vous voulez modifier"
					+ " n'Ã©xiste pas :( !");}
			else {  
			PreparedStatement prepare = connect.prepareStatement(
					"UPDATE carre SET topLeft_x = ?, "
					+ "topLeft_y = ?, "
					+ "side = ? WHERE NameForme = ?");
			prepare.setInt(1, obj.getCoordonnee().getX());
			prepare.setInt(2, obj.getCoordonnee().getY());
			prepare.setInt(3, obj.getside());
			prepare.setString(4, obj.getNameForme());
			int result = prepare.executeUpdate();
			 assert result == 1;
			System.out.println(result);}
		}
		catch (SQLException e) {
			e.getMessage();
		} 
		System.out.println("lllllllllllllllllllllllllllllllllllllllllll");
		obj.affiche();
		System.out.println("llllllllllllllllllllllllllllllllllllllllllll");
		return obj;	
	}

	@Override
	public void delete(Carre obj) throws FormeDoncExistException {
		try (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = connect.prepareStatement(
					"DELETE FROM carre "
					+ "WHERE NameForme = ?");
			prepare.setString(1, obj.getNameForme());
			int result = prepare.executeUpdate();
			assert result == 1;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		read(obj.getNameForme());
		try (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepareFind = connect.prepareStatement(
					"SELECT * FROM carre WHERE NameForme = ?  ");
			prepareFind.setString(1, obj.getNameForme());
			ResultSet res = prepareFind.executeQuery();
			
			if(!res.next()) { throw new FormeDoncExistException(""
					+ "Le carre, donc le nom " + obj.getNameForme() + ", que vous voulez suprimer"
					+ " n'Ã©xiste pas :( !");}
			else {
				PreparedStatement prepare = connect.prepareStatement(
						"DELETE FROM carre "
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
