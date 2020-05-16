package lyli.dessin.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lyli.dessin.Carre;
import lyli.dessin.Cercle;
import lyli.dessin.GroupeForme;
import lyli.dessin.Rectangle;
import lyli.dessin.Triangle;

public class DaoFactory {
	 Connection connect = null;
	public DaoFactory() throws SQLException {
	    
		String dburl = CeartionBDDREBY.dburl;
    	connect = DriverManager.getConnection(dburl);
	}
	public Connection getConnection() {
		return this.connect;
	}
	public DAO<Carre> getCarreDAO ( ) {
			return new JdbsDaoCarreDerby (connect) ;
			}
		public  DAO<Rectangle> getRectangleDAO ( ) {
			return new JdbsDaoRectangleDerby (connect) ;
			}
		public  DAO<Cercle> getCercleDAO ( ) {
			return new JdbsDaoCercleDerby (connect) ;
			}
		public  DAO<Triangle> getTriangleDAO ( ) {
			return new JdbsDaoTriangleDerby (connect) ;
			}
		public  DAO<GroupeForme> getGroupeDAO ( ) {
			return new JdbsDaoGroupeDerby (connect) ;
			}
		
		  public void connect() {

			    try {
			    	String dburl = CeartionBDDREBY.dburl;
			    	connect = DriverManager.getConnection(dburl);
			    } catch (SQLException e) {
			      e.printStackTrace();
			      try {
			        connect.close();
			      } catch (SQLException ex) {
			        ex.printStackTrace();
			      }
			    }

			  }

			  /**
			  * Disonnects from database.
			  */
			  public void disconnect() {

			    try {
			      connect.close();
			    } catch (SQLException e) {
			      e.printStackTrace();
			    }
			  }


	}


