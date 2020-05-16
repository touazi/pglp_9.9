package lyli.dessin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lyli.dessin.DAO.DAO;
import lyli.dessin.DAO.DaoFactory;
import lyli.dessin.command.Command;
import lyli.dessin.command.CommandDeCreation;
import lyli.dessin.command.CommandDeplacer;
import lyli.dessin.command.CommandSuprimer;
import lyli.dessin.command.Commandexit;
import lyli.dessin.exeption.FormeDoncExistException;
/**
 * <b>"L'implementation de la class DrawingTUI."</b>
 * @author TOUAZI,Lylia
 */
public class DrawingTUI {
    /** connection a la base de donnée.*/
    Connection connect = null;
    /**constructeur de la class DrawingApp.*/
    public DrawingTUI() {
    //	this.connect = connect;
    }

		/**
	     * La Fonction createForme.
	     * <b>"elle permet de créer une Forme selon le type de de la chaine"</b>
	     * <b>"de caractaire donnée."</b>
	     * @param Tokens les Tokens de la commande
	     * @param typeForme le type de la forme à créer
	     * @param name le nome de la forme
	     * @return la forme générer 
		 * @throws SQLException lever les Exceptions SQL
	     */
	public Forme createForme(String[] Tokens, String typeForme, String name) throws  SQLException {
	    	 if (typeForme.equalsIgnoreCase("cer")) { 
	    		    if ( (Tokens[1].startsWith("(") && Tokens[1].endsWith(")"))) {
						 Tokens[1] = Tokens[1].substring(1, Tokens[1].length() - 1);
						 Tokens = Tokens[1].split(",|\\(|\\)");
							 if (Tokens.length == 5) {
								 try {
									 return new Cercle(name,  
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
								 {System.err.println("arguments en plus");
								 return null;}
								 else {  System.err.println("arguments en moins");
								 	return null;}
							 }
						} else {
							System.err.println("parenteses manquantes");
							return null;}
		            
	            } else if (typeForme.equalsIgnoreCase("car")){   
			      	     if ( (Tokens[1].startsWith("(") && Tokens[1].endsWith(")"))) {
							 Tokens[1] = Tokens[1].substring(1, Tokens[1].length() - 1);
							 Tokens = Tokens[1].split(",|\\(|\\)");
								 if (Tokens.length == 5) {
									 try {
										 return new Carre(name,  
												 new Coordonnee(Integer.parseInt(Tokens[1]) , 
														 Integer.parseInt(Tokens[2])),
												 Integer.parseInt(Tokens[4]));
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
			            
	            } else if(typeForme.equalsIgnoreCase("rec")) {
	                 	     if ( (Tokens[1].startsWith("(") && Tokens[1].endsWith(")"))) {
	            				 Tokens[1] = Tokens[1].substring(1, Tokens[1].length() - 1);
	            				 Tokens = Tokens[1].split(",|\\(|\\)");
	            					 if (Tokens.length == 6) {
	            						 try {
	            							 return new Rectangle(name,  
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
	                
	            } else  if (typeForme.equalsIgnoreCase("tri")) {
	                 	     if ( (Tokens[1].startsWith("(") && Tokens[1].endsWith(")"))) {
	            				 Tokens[1] = Tokens[1].substring(1, Tokens[1].length() - 1);
	            				 Tokens = Tokens[1].split(",|\\(|\\)");
	            					 if (Tokens.length == 11) {
	            						 try {
	            							 return  new Triangle(name,  
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
	                
	            } 
	            
	        
	        return null;
	    }

	/**
     * La Fonction createGroupe.
     * <b>"elle permet de créer une Groupe selon le type de de la chaine"</b>
     * <b>"de caractaire donnée."</b>
     * @param Tokens les Tokens de la commande
     * @param name le nome de la forme
     * @return la forme générer  
	 * @throws SQLException lever les Exceptions SQL
	 * @throws FormeDoncExistException lever les Exceptions de la forme qui n'existe pas
     */
public Forme createGroupe(String[] Tokens, String name) throws SQLException, FormeDoncExistException {
	
    	  ArrayList<Forme> formes = new ArrayList<Forme>();
         if((Tokens[1].startsWith("(") && Tokens[1].endsWith(")")))  {
        	 GroupeForme Groupe = new GroupeForme(name);
        	 DaoFactory factory = new DaoFactory();
    	        for (String s : Tokens[1].substring(1, Tokens[1].length() - 1).split(",")) {
               
    	        Forme forme = null;
    	        if (forme == null) {
    	        	 DAO<Carre> daoCa = factory.getCarreDAO();
    	        	 forme = daoCa.read(s);
    	           if (forme != null) {
    	            	formes.add(forme);
    	            	continue;
    	            	}

    	            DAO<Rectangle> daoR = factory.getRectangleDAO();
    	            forme = daoR.read(s);
    	            if (forme != null) {
    	            	formes.add(forme);
    	            	continue;
    	            	}
    	            DAO<Triangle> daoT = factory.getTriangleDAO();
    	        	forme = daoT.read(s);
    	        	   if (forme != null) {
    		            	formes.add(forme);
    		            	continue;
    		            	}
    	        	 DAO<GroupeForme> daoG = factory.getGroupeDAO();
    	        	 forme = daoG.read(s);
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
    	            throw new FormeDoncExistException ("La forme:  "+ s + " n'existe pas ");
    	            }    
    	       }
    	        factory.disconnect();
    	        for (Forme s : formes)  {
                	Groupe.ajouterForme(s);
                    }
    	        return Groupe;
     }
         else  System.err.println("parenteses manquantes");
return null;
      
}

/**
 * La Fonction move.
 * <b>"elle permet de deplacer une Groupe ou une forme "</b>
 * @param Token les Tokens de la commande
 * @return la forme deplacer
 */
public Forme move(final String[]  Token) {

        if (!Token[0].equals("")
                || !(Token[1].startsWith("(") && Token[1].endsWith(")"))) {
            System.err.println(" parenthèses manquantes");
        } else {
        	Token[1] = Token[1].substring(1, Token[1].length() - 1);
        	String [] Tokens = Token[1].split(",|\\(|\\)");;
            if (Tokens.length != 4) {
                System.err.println(" "
                        + Tokens.length + "/" + 4 + " arguments");
            } else {
                try {
                    System.out.println(Tokens[3]);
                  //  deplacement = new Coordonnee( , );
                    Forme f = null;//this.getForme(variableName);
                    
	                      DaoFactory factory = new DaoFactory();
	          	        Forme forme = null;
	          	        if (f == null) {
	          	        	 DAO<Carre> daoCa = factory.getCarreDAO();
	          	        	 forme = daoCa.read(Tokens[0]);
	          	            System.out.println("carre");
	          	            if (forme != null) {
	          	            	f=forme;
	          	            	}

	          	            DAO<Rectangle> daoR = factory.getRectangleDAO();
	          	            forme = daoR.read(Tokens[0]);
	          	            System.out.println("rectangle");
	          	            if (forme != null) {
	          	            	f=forme;
	          	            	}
	          	            DAO<Triangle> daoT = factory.getTriangleDAO();
	          	        	forme = daoT.read(Tokens[0]);
	          	        	 System.out.println("triangle");
	          	        	   if (forme != null) {
	          	        		 f=forme;
	          		            	}
	          	        	 DAO<GroupeForme> daoG = factory.getGroupeDAO();
	          	        	 forme = daoG.read(Tokens[0]);
	          		        	 System.out.println("groupe");
	          		        	   if (forme != null) {
	          			            	
	          		        		 f=forme;
	          			            	}
	          	            DAO<Cercle> daoCe = factory.getCercleDAO();
	          	            forme = daoCe.read(Tokens[0]);
	          	            factory.disconnect();
	          	    	
	          	            if (forme != null) {
	          	            	
	          	            	f=forme;
	          	            	}
	          	            }    if (f == null)  System.err.println("La forme:  "+ Tokens[0] + " n'existe pas "); 
	          	       
                    if (f != null) {
                    //  System.out.println("ayouhhhhhhhhhhhhhhhhhhhhhhh");
                  //  f.affiche();
                      f.move(Tokens[0], Integer.parseInt(Tokens[2]), Integer.parseInt(Tokens[3]));
                    	//Command cfff =  new CommandDeplacer(f);
                    //	cfff.execute();
                     // f.affiche();
                      return f;
                    }
                } catch (Exception e) {
                    System.err.println("Commande invalide");
                    e.printStackTrace();
                }
            }
        }
		return null;
		
	}
/**
 * La Fonction delete.
 * <b>"elle permet de suprimer une Groupe ou une forme "</b>
 * @param Token les Tokens de la commande
 * @return la forme à surpimer
 * @throws FormeDoncExistException  ever les Exceptions de la forme qui n'existe pas
 * @throws SQLException ever les Exceptions SQL
 */
    public Forme delete(final String[]  Token) throws SQLException, FormeDoncExistException {
    	String[] Tokens = null ;
    	if ( !(Token[1].startsWith("(") && Token[1].endsWith(")"))) {
            System.err.println("Commande invalide, parenthèses manquantes");
        } else {
        	Token[1] = Token[1].substring(1, Token[1].length() - 1);
            Tokens = Token[1].split(",");
            System.out.println(Tokens[0]);
           DaoFactory factory = new DaoFactory();
	        Forme forme = null;
	        if (forme == null) {
	        	 DAO<Carre> daoCa = factory.getCarreDAO();
	        	 forme = daoCa.read(Tokens[0]);}
	        if (forme == null) {
	            DAO<Rectangle> daoR = factory.getRectangleDAO();
	            forme = daoR.read(Tokens[0]);}
	        if (forme == null) {
	            DAO<Triangle> daoT = factory.getTriangleDAO();
	        	forme = daoT.read(Tokens[0]); 
	        	}
	        if (forme == null) {
	        	  DAO<GroupeForme> daoG = factory.getGroupeDAO();
	        	 forme = daoG.read(Tokens[0]);}
	        if (forme == null) {
		         DAO<Cercle> daoCe = factory.getCercleDAO();
	            forme = daoCe.read(Tokens[0]);
	           
	            } 
	        factory.disconnect();
	            if (forme != null) {
                    return forme;
                } else {
                	 throw new FormeDoncExistException ("La forme:  "+ Tokens[0] + " n'existe pas ");
                }
        
        }
		return null;
    } 
	    /**
	     * la fonction nextCommand recupere les commande le l'utilisateur 
	     * en chaine de carractere et les transforme en commande.
	     * @param command commande de l'utilisateur.
	     * @return une commande à exectuer ou null s'il n'y en a pas.
	     * @throws FormeDoncExistException lever les Exceptions de la forme qui n'existe pas
	     * @throws SQLException lever les Exceptions SQL
	     */
	public Command nextCommand(final String command) throws FormeDoncExistException, SQLException {
		 
		String[] Token = null;
	    	if (command.indexOf("=") > -1) {
	    		 Forme f = null;
		    	  String[] SeparEgal = null , Tokens = null;
		    	  SeparEgal = command.split("=");
		    		if(SeparEgal.length != 2) {
		    			System.err.println("la commande "+command+
		    					"n'est pas reconnu, vérifier "
		    					+ "que la syntaxe de la commande est correcte");
		    			return null;}
		    	      if ( (SeparEgal[1].indexOf("Cercle") > -1) || 
		                    	(SeparEgal[1].indexOf("CERCLE") > -1) ||
		                    	(SeparEgal[1].indexOf("cercle") > -1)) {
		                   	 if(SeparEgal[1].indexOf("Cercle") > -1) {
		                   	  Tokens = SeparEgal[1].split("Cercle");
		                     }else if (SeparEgal[1].indexOf("cercle") > -1) {
		                    	 Tokens = SeparEgal[1].split("cercle");
		                     }else { Tokens = SeparEgal[1].split("CERCLE");   }
			        	 f = this.createForme(Tokens, "cer" ,SeparEgal[0].trim());
			         }
			         else if ((SeparEgal[1].indexOf("Triangle") > -1) || 
		                    	(SeparEgal[1].indexOf("TRIANGLE") > -1) ||
		                    	(SeparEgal[1].indexOf("triangle") > -1)) {
		                   	 if(SeparEgal[1].indexOf("Triangle") > -1) {
		                   	  Tokens = SeparEgal[1].split("Triangle");
		                     }else if (SeparEgal[1].indexOf("triangle") > -1) {
		                    	 Tokens = SeparEgal[1].split("triangle");
		                     }else { Tokens = SeparEgal[1].split("TRIANGLE");   }
		                   	f = this.createForme(Tokens, "tri" ,SeparEgal[0].trim());
		               
			         }
			         else if  (SeparEgal[1].contains("Rectangle") || 
		                    	SeparEgal[1].contains("rectangle") ||
		                    	SeparEgal[1].contains("RECTANGLE") ) {
		                   	 if(SeparEgal[1].contains("Rectangle")) {
		                   	  Tokens = SeparEgal[1].split("Rectangle");
		                     }else if (SeparEgal[1].contains("rectangle")) {
		                    	 Tokens = SeparEgal[1].split("rectangle");
		                     }else { Tokens = SeparEgal[1].split("RECTANGLE"); }
		                  	f = this.createForme(Tokens, "rec" ,SeparEgal[0].trim());
			         }
			         else if (SeparEgal[1].contains("Carre") || 
		                    	SeparEgal[1].contains("carre") ||
		                    	SeparEgal[1].contains("CARRE") ) {
		                   	 if(SeparEgal[1].contains("Carre")) {
		                   	  Tokens = SeparEgal[1].split("Carre");
		                     }else if (SeparEgal[1].contains("carre")) {
		                    	 Tokens = SeparEgal[1].split("carre");
		                     }else { Tokens = SeparEgal[1].split("CARRE"); }
			        	 f = this.createForme(Tokens, "car" ,SeparEgal[0].trim());
			         }
			         else if ((SeparEgal[1].indexOf("Groupe") > -1) || 
		                    	(SeparEgal[1].indexOf("groupe") > -1) ||
		                    	(SeparEgal[1].indexOf("GROUPE") > -1)) {
		                   	 if(SeparEgal[1].indexOf("Groupe") > -1) {
		                   	  Tokens = SeparEgal[1].split("Groupe");
		                     }else if (SeparEgal[1].indexOf("groupe") > -1) {
		                    	 Tokens = SeparEgal[1].split("groupe");
		                     }else { Tokens = SeparEgal[1].split("GROUPE"); }
			        	 f = this.createGroupe(Tokens ,SeparEgal[0].trim());
			         }else return null;
	           
	            if (f != null) {
	            	return new CommandDeCreation (f);
	              
	   	            	 }
	            } else if ((command.indexOf("move") > -1) || 
	        		(command.indexOf("Move") > -1) || 
	        		(command.indexOf("MOVE") > -1)) {
	    		String  cmd = null;
	    		if((command.indexOf("Move") > -1)) {Token = command.split("Move");}
	    		else if ((command.indexOf("move") > -1)) {Token = command.split("move");}
	    		else {Token = command.split("MOVE");}
	    		if(Token.length != 2) {
	    			System.err.println("la commande "+command+
	    					"n'est pas reconnu, vérifier "
	    					+ "que la syntaxe de la commande est correcte");
	    			return null;}
	    		Forme f = null;
	    		f = this.move(Token);
	    		//f.affiche();
	    		 if (f != null) {
	    			 return new CommandDeplacer (f);
		              }
	        }
	    	else if ((command.indexOf("delete") > -1) || 
	        		(command.indexOf("Delete") > -1) || 
	        		(command.indexOf("DELETE") > -1)) {
	    		String  cmd = null ;
	    		if((command.indexOf("Delete") > -1)) {Token = command.split("Delete");}
	    		else if ((command.indexOf("delete") > -1)) {Token = command.split("delete");}
	    		else {Token = command.split("DELETE");}
	    		if(Token.length != 2) {
	    			System.err.println("la commande "+ command +
	    					"n'est pas reconnu, vérifier "
	    					+ "que la syntaxe de la commande est correcte");
	    			return null;}
	    		Forme f = null;
	    		f = this.delete(Token);
	    		f.affiche();
	    		 if (f != null) {
	    			 return new CommandSuprimer (f);
		            	 }
	    		 }
	         else if (command.equalsIgnoreCase("exit")) {
	        	return new Commandexit ();
	        }
	    	System.err.println("la commande "+ command +
					"n'est pas reconnu, vérifier "
					+ "que la syntaxe de la commande est correcte");
			return null;
	      
	    }
	
	    /**
	     * la methode afficheDessin.
	     * affiche toutes les formes du dessin .
	     * @throws SQLException lever les Exceptions SQL
	     */

	     public void afficheDessin() throws  SQLException {
	    	  DaoFactory factory = new DaoFactory();
	    	  this.connect = factory.getConnection();
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
	            formes = new ArrayList<Forme>();
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
	            formes = new ArrayList<Forme>();
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
	            formes = new ArrayList<Forme>();
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
	            formes = new ArrayList<Forme>();
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
	            formes = new ArrayList<Forme>();
	        }
	        for (Forme f : formes) {
	                f.affiche();
	             }
	        
	    }
	      
}
