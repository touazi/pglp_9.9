package lyli.dessin.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lyli.dessin.Carre;
import lyli.dessin.Coordonnee;
public class JdbsDaoCarreDerby implements DAO<Carre> {
	Connection connect = null;
	public JdbsDaoCarreDerby(Connection connect ) 
	{
	this.connect = connect ;
	}
	private static String dburl = CeartionBDDREBY.dburl;
	@Override
	public Carre create(Carre obj) {
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
	public Carre read(String id)  {
		// TODO Auto-generated method stub
		Carre carre = null;
		try (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = connect.prepareStatement(
					"SELECT * FROM carre WHERE NameForme = ?  ");
			prepare.setString(1, id);
			ResultSet result = prepare.executeQuery();
			if(result.next()) {
				carre = new Carre (result.getString("NameForme"),
							new Coordonnee(result.getInt("topLeft_x"), result.getInt("topLeft_y")), 
							result.getInt("side"));
				result.close();
				}
			else { 
		      return null;}
		
		}
		catch (SQLException e) {
			e.getMessage();
		}
		return carre;
		}



	@Override
	public Carre update(Carre obj) {
		try (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepareFind = connect.prepareStatement(
					"SELECT * FROM carre WHERE NameForme = ?  ");
			prepareFind.setString(1, obj.getNameForme());
			ResultSet res = prepareFind.executeQuery();
			if (res.next()) {  
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
		return obj;	
	}

	@Override
	public void delete(Carre obj) {
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
			if (res.next()) {
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
