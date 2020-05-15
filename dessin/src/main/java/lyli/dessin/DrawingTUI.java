package lyli.dessin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lyli.dessin.exeption.FormeDoncExistException;

public class DrawingTUI {
		/**
	     * interprÃ¨te la commande de crÃ©ation de forme.
	     * @param cmd2 la commande
	     * @return la forme gÃ©nÃ©rÃ©e
	     * @throws FormeDoncExistException 
	     * @throws SQLException 
	     */
	public Forme create(final String command) throws FormeDoncExistException {
	    	 Forme f = null;
	    	  String[] SeparEgal = null , Tokens = null;
	    	  SeparEgal = command.split("=");
	    	  SeparEgal[1] = SeparEgal[1].replace(" ", "");
		         if (SeparEgal[1].contains("Cercle") || SeparEgal[1].contains("cercle") ) {
		        	 if(SeparEgal[1].contains("Cercle")) {
		        	  Tokens = SeparEgal[1].split("Cercle");
		             }else {Tokens = SeparEgal[1].split("cercle");}    
		      	     if ( (Tokens[1].startsWith("(") && Tokens[1].endsWith(")"))) {
						 Tokens[1] = Tokens[1].substring(1, Tokens[1].length() - 1);
						 Tokens = Tokens[1].split(",|\\(|\\)");
							 if (Tokens.length == 5) {
								 try {
									 return new Cercle(SeparEgal[0].trim(),  
											 new Coordonnee(Integer.parseInt(Tokens[1]) , 
													 Integer.parseInt(Tokens[2])),
											 Integer.parseInt(Tokens[4]));
								} catch (Exception e) {
									System.out.println("impossible de crée le cercle car : "
														+ e.getLocalizedMessage());
								}
				         	  }
							 else{
								 if(Tokens.length > 5)
								 System.err.println("arguments en plus");
								 else  System.err.println("arguments en moins");
							 }
						} else
							System.err.println("parenteses manquantes");
		            
	            } else if (SeparEgal[1].contains("Carre") || SeparEgal[1].contains("carre")) {
			        	 if(SeparEgal[1].contains("Carre")) {
			        	  Tokens = SeparEgal[1].split("Carre");
			             }else {Tokens = SeparEgal[1].split("carre");}    
			      	     if ( (Tokens[1].startsWith("(") && Tokens[1].endsWith(")"))) {
							 Tokens[1] = Tokens[1].substring(1, Tokens[1].length() - 1);
							 Tokens = Tokens[1].split(",|\\(|\\)");
								 if (Tokens.length == 5) {
									 try {
										 return new Carre(SeparEgal[0].trim(),  
												 new Coordonnee(Integer.parseInt(Tokens[1]) , 
														 Integer.parseInt(Tokens[2])),
												 Integer.parseInt(Tokens[4]));
										 //f.affiche();
									} catch (Exception e) {
										System.out.println("impossible de crée le carre car : "
															+ e.getLocalizedMessage());
									}
					         	  }
								 else{
									 if(Tokens.length > 5)
									 System.err.println("arguments en plus");
									 else  System.err.println("arguments en moins");
								 }
							} else
								System.err.println("parenteses manquantes");
			            
	            } else if  (SeparEgal[1].contains("Rectangle") || 
	                    	SeparEgal[1].contains("rectangle") ||
	                    	SeparEgal[1].contains("RECTANGLE") ) {
	                   	 if(SeparEgal[1].contains("Rectangle")) {
	                   	  Tokens = SeparEgal[1].split("Rectangle");
	                     }else if (SeparEgal[1].contains("rectangle")) {
	                    	 Tokens = SeparEgal[1].split("rectangle");
	                     }else { Tokens = SeparEgal[1].split("RECTANGLE"); }
	                 	     if ( (Tokens[1].startsWith("(") && Tokens[1].endsWith(")"))) {
	            				 Tokens[1] = Tokens[1].substring(1, Tokens[1].length() - 1);
	            				 Tokens = Tokens[1].split(",|\\(|\\)");
	            					 if (Tokens.length == 6) {
	            						 try {
	            							 return new Rectangle(SeparEgal[0].trim(),  
	            									 new Coordonnee(Integer.parseInt(Tokens[1]) , 
	            											 Integer.parseInt(Tokens[2])),
	            									 Integer.parseInt(Tokens[4]),
	            									 Integer.parseInt(Tokens[5]));
	            						} catch (Exception e) {
	            							System.out.println("impossible de crée le rectangle car : "
	            												+ e.getLocalizedMessage());
	            						}
	            		         	  }
	            					 else{
	            						 if(Tokens.length > 6)
	            						 System.err.println("arguments en plus");
	            						 else  System.err.println("arguments en moins");
	            					 }
	            				} else
	            					System.err.println("parenteses manquantes");
	                
	            } else if  (SeparEgal[1].contains("Triangle") || 
	                    	SeparEgal[1].contains("TRIANGLE") ||
	                    	SeparEgal[1].contains("triangle") ) {
	                   	 if(SeparEgal[1].contains("Triangle")) {
	                   	  Tokens = SeparEgal[1].split("Triangle");
	                     }else if (SeparEgal[1].contains("triangle")) {
	                    	 Tokens = SeparEgal[1].split("triangle");
	                     }else { Tokens = SeparEgal[1].split("TRIANGLE");   }
	                 	     if ( (Tokens[1].startsWith("(") && Tokens[1].endsWith(")"))) {
	            				 Tokens[1] = Tokens[1].substring(1, Tokens[1].length() - 1);
	            				 Tokens = Tokens[1].split(",|\\(|\\)");
	            					 if (Tokens.length == 11) {
	            						 try {
	            							 return  new Triangle(SeparEgal[0].trim(),  
	            									 new Coordonnee(Integer.parseInt(Tokens[1]) , 
	            											Integer.parseInt(Tokens[2])),
	            									 new Coordonnee(Integer.parseInt(Tokens[5]) , 
	            											Integer.parseInt(Tokens[6])),
	            									 new Coordonnee(Integer.parseInt(Tokens[9]) , 
	            											Integer.parseInt(Tokens[10])));
	            						} catch (Exception e) {
	            							System.out.println("impossible de crée le triangle car : "
	            												+ e.getLocalizedMessage());
	            						}
	            		         	  }
	            					 else{
	            						 if(Tokens.length > 11)
	            						 System.err.println("arguments en plus");
	            						 else  System.err.println("arguments en moins");
	            					 }
	            				} else
	            					System.err.println("parenteses manquantes");
	                
	            } else if (SeparEgal[1].contains("Groupe") ||
	            		SeparEgal[1].contains("groupe") ||
	            		SeparEgal[1].contains("GROUPE")) {
                  	 if(SeparEgal[1].contains("Groupe")) {
	                   	  Tokens = SeparEgal[1].split("Groupe");
	                     }else if (SeparEgal[1].contains("groupe")) {
	                    	 Tokens = SeparEgal[1].split("groupe");
	                     }else { Tokens = SeparEgal[1].split("GROUPE"); }
	          	  ArrayList<Forme> formes = new ArrayList<Forme>();
	               if((Tokens[1].startsWith("(") && Tokens[1].endsWith(")")))  {
	              	 GroupeForme Groupe = new GroupeForme(SeparEgal[0].trim());
	          	        for (String s : Tokens[1].substring(1, Tokens[1].length() - 1).split(",")) {
	                      DaoFactory factory = new DaoFactory();
	          	        Forme forme = null;
	          	        if (f == null) {
	          	        	 DAO<Carre> daoCa = factory.getCarreDAO();
	          	        	 forme = daoCa.read(s);
	          	            System.out.println("carre");
	          	            if (forme != null) {
	          	            	formes.add(forme);
	          	            	continue;
	          	            	}

	          	            DAO<Rectangle> daoR = factory.getRectangleDAO();
	          	            forme = daoR.read(s);
	          	            System.out.println("rectangle");
	          	            if (forme != null) {
	          	            	formes.add(forme);
	          	            	continue;
	          	            	}
	          	            DAO<Triangle> daoT = factory.getTriangleDAO();
	          	        	forme = daoT.read(s);
	          	        	 System.out.println("triangle");
	          	        	   if (forme != null) {
	          		            	formes.add(forme);
	          		            	continue;
	          		            	}
	          	        	 DAO<GroupeForme> daoG = factory.getGroupeDAO();
	          	        	 forme = daoG.read(s);
	          		        	 System.out.println("groupe");
	          		        	   if (forme != null) {
	          			            	formes.add(forme);
	          			            	continue;
	          			            	}
	          	            DAO<Cercle> daoCe = factory.getCercleDAO();
	          	            forme = daoCe.read(s);
	          	            if (forme != null) {
	          	            	formes.add(forme);
	          	            	continue;
	          	            	}
	          			    System.err.println("La forme:  "+ s + " n'existe pas ");
	          	            }    
	          	       }
	          	        for (Forme s : formes)  {
	                      	Groupe.ajouterForme(s);
	                          }
	          	        return Groupe;
	           }
	               else  System.err.println("parenteses manquantes");
	            }
	            
	        
	        return null;
	    }



	    /**
	     * interprÃ¨te une commande.
	     * @param cmd commande Ã  interprÃ©ter.
	     * @return une commande Ã  exÃ©cuter ou null s'il n'y en a pas.
	     * @throws FormeDoncExistException 
	     * @throws FormeExisteDeja 
	     * @throws SQLException 
	     */
	    public Command nextCommand(final String cmd) throws FormeDoncExistException, SQLException {
	       
	    	if (cmd.contains("=")) {
	            Forme f = this.create(cmd);
	            if (f != null) {
	              
	               f.affiche();
	               Command lylia = new CommandDeCreation ();
	               lylia.execute();
	               this.afficheDessin();
	            	 return lylia;
	            }
	      
	        } else if (!cmd.equalsIgnoreCase("exit")) {
	        	return new Commandexit ();
	        }
	        return null;
	    }
	
	    /**
	     * affiche toutes les formes du dessin (sauf les groupes).
	     * @throws SQLException 
	     * @throws FormeDoncExistException 
	     */

	     public void afficheDessin() throws FormeDoncExistException, SQLException {
	    	  DaoFactory factory = new DaoFactory();
	    	  String dburl = CeartionBDDREBY.dburl;
	      Connection connect = DriverManager.getConnection(dburl);
	        ArrayList<Forme> formes = new ArrayList<Forme>();
	        try {
	            PreparedStatement prepare = connect.prepareStatement(
	                    "SELECT NameForme FROM cercle");
	            ResultSet result = prepare.executeQuery();
	            while (result.next()) {
	            	DAO<Cercle> daoCe = factory.getCercleDAO();
	            	formes.add(daoCe.read(result.getString("NameForme")));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            formes= new ArrayList<Forme>();
	        }
	        try {
	            PreparedStatement prepare = connect.prepareStatement(
	                    "SELECT NameForme FROM carre");
	            ResultSet result = prepare.executeQuery();
	            while (result.next()) {
	            	 DAO<Carre> daoCa = factory.getCarreDAO();
	            	formes.add(daoCa.read(result.getString("NameForme")));
	             }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            formes= new ArrayList<Forme>();
	        }
	        try {
	            PreparedStatement prepare = connect.prepareStatement(
	                    "SELECT NameForme FROM rectangle");
	            ResultSet result = prepare.executeQuery();
	            while (result.next()) {
	            	 DAO<Rectangle> daoR = factory.getRectangleDAO();
	            	formes.add(daoR.read(result.getString("NameForme")));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            formes= new ArrayList<Forme>();
	        }
	        
	        
	        
	        try {
	            PreparedStatement prepare = connect.prepareStatement(
	                    "SELECT NameForme FROM triangle");
	            ResultSet result = prepare.executeQuery();
	            while (result.next()) {
	            	  DAO<Triangle> daoT = factory.getTriangleDAO();
	            	formes.add(daoT.read(result.getString("NameForme")));
	            	
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            formes= new ArrayList<Forme>();
	        }
	        
	        try {
	            PreparedStatement prepare = connect.prepareStatement(
	                    "SELECT id FROM groupe");
	            ResultSet result = prepare.executeQuery();
	            while (result.next()) {
	            	 DAO<GroupeForme> daoG = factory.getGroupeDAO();
	            	formes.add(daoG.read(result.getString("id")));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            formes= new ArrayList<Forme>();
	        }
	        for (Forme f : formes) {
	                f.affiche();
	             }
	        
	    }
	      
}
