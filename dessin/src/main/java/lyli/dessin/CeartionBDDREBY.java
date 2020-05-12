package lyli.dessin;


import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import lyli.dessin.exeption.TableExisteDeja;

public class CeartionBDDREBY {
	private static final String userName = "";
	private static final String password = "";
	
	public static String dburl = "jdbc:derby:Derby;create=true";
	
	public CeartionBDDREBY() {
		Properties connectionProps = new Properties();
		connectionProps.put("user", userName);
		connectionProps.put("user", password);
	}
	
	public void createTables() throws TableExisteDeja {
		try (Connection connect = DriverManager.getConnection(dburl)) {
			  Statement state = connect.createStatement();
			    DatabaseMetaData databaseMetadata = connect.getMetaData();
			    ResultSet resultCARRE = databaseMetadata.getTables(null, null, "CARRE", null);
			    
			    if (resultCARRE.next()) {
			    	throw new TableExisteDeja("TABLE ALREADY EXISTS");
			    } else {
			
			state.addBatch(
					
					"CREATE TABLE carre("
					           + "NameForme varchar(30) PRIMARY KEY,"
				                + "topLeft_x int,"
				                + "topLeft_y int,"
				                + "side int"
					+ ")");
			
			    }
			    
			    
			    ResultSet resultRectangle = databaseMetadata.getTables(null, null, "RECTANGLE", null);
			    
			    if (resultRectangle.next()) {
			    	throw new TableExisteDeja("TABLE ALREADY EXISTS");
			    } else {
			
			state.addBatch(
					
					"CREATE TABLE rectangle("
							 + "NameForme varchar(30) PRIMARY KEY,"
				                + "topLeft_x int,"
				                + "topLeft_y int,"
				                + "sideTop int,"
				                + "sideLeft int"
				              + ")");
			
			    }
			    
			    
			    ResultSet resultTriangle = databaseMetadata.getTables(null, null, "TRIANGLE", null);
			    
			    if (resultTriangle.next()) {
			    	throw new TableExisteDeja("TABLE ALREADY EXISTS");
			    } else {
			
			state.addBatch(
					
					"CREATE TABLE triangle("
					           + "NameForme varchar(30) PRIMARY KEY,"
				                + "point1_x int,"
				                + "point1_y int,"
				                + "point2_x int,"
				                + "point2_y int,"
				                + "point3_x int,"
				                + "point3_y int"
				           	+ ")");
			
			    }
			    
			    
			    ResultSet resultCercle = databaseMetadata.getTables(null, null, "CERCLE", null);
			    
			    if (resultCercle.next()) {
			    	throw new TableExisteDeja("TABLE ALREADY EXISTS");
			    } else {
			
			state.addBatch(
					
					"CREATE TABLE cercle("
							 + "NameForme varchar(30) PRIMARY KEY,"
				                + "centre_x int,"
				                + "centre_y int,"
				                + "rayon int"
				           + ")");
			
			    }
			    
			    ResultSet result = databaseMetadata.getTables(null, null, "GROUPE", null);
			    if (result.next()) {
			    	throw new TableExisteDeja("TABLE ALREADY EXISTS");
			    } else {			
				state.addBatch("CREATE TABLE groupe ("
						+ "id VARCHAR(100) PRIMARY KEY"
						+ ")");}
			    ResultSet res = databaseMetadata.getTables(null, null, "APPARTENIR", null);
			    if (res.next()) {
			    	throw new TableExisteDeja("TABLE ALREADY EXISTS");
			    } else {
				state.addBatch( 
						"CREATE TABLE appartenir ("
						+ "id VARCHAR(100) ,"
						+ "nom VARCHAR(100) "
						+ ")");
			    }
			state.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
