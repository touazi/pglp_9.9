package lyli.dessin;
import java.sql.*;
import java.util.Iterator;
import java.util.List;

public class JdbsDaoGroupeDerby implements DAO<GroupeForme> {
	private static String dburl = CeartionBDDREBY.dburl;
	@Override
	public GroupeForme create(GroupeForme obj) {
		try (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = connect.prepareStatement(
					"INSERT INTO groupe (id)" +
					"VALUES (?)");
			prepare.setString(1, obj.getId());
			int result = prepare.executeUpdate();
			assert result == 1;
			List<Forme> lp = obj.getListForm();

	
			
			for(Iterator<Forme> it=lp.iterator(); it.hasNext();)
			{Forme n= it.next();
			
			prepare = connect.prepareStatement(
					"INSERT INTO APPARTENIR "
					+ "VALUES (?, ?)");
			prepare.setString(1, obj.getId());
			prepare.setString(2, n.getNameForme());
			prepare.addBatch();
       }
			prepare.executeBatch();
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	@Override
	public GroupeForme read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupeForme update(GroupeForme obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(GroupeForme obj) {
		// TODO Auto-generated method stub
		
	}

}
