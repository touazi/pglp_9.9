package lyli.dessin;

import java.io.File;
import java.sql.SQLException;
import java.util.Scanner;

import lyli.dessin.DAO.CeartionBDDREBY;
import lyli.dessin.command.Command;
import lyli.dessin.exeption.FormeDoncExistException;
import lyli.dessin.exeption.FormeExisteDeja;
import lyli.dessin.exeption.TableExisteDeja;
/**
 * <b>"L'implementation de la class DrawingApp.</b>
 * @author TOUAZI,Lylia
 */
public class DrawingApp {
	  /**lecture utilisateur.*/
    private Scanner saisie;
    /**interpreteur de commande.*/
    private DrawingTUI dt;
    /**constructeur de la class DrawingApp.*/
    public DrawingApp() {
       dt = new DrawingTUI();
        saisie = new Scanner(System.in);
    }
    /**la méthode menu qui permet d'afficher le menu pour l'utilisateur.*/
    public void menu() {
    	System.out.println("############################### Bienvenue au logiciel de dessin"
    			+ " ##################################");
    	System.out.println("################################### Exemple d'utilisation"
    			+ " ########################################");
    	System.out.println("\n***********************************"
    			+ "***************************************************************");
    	System.out.println("******* 1- Vous pouver créer une Forme "
    			+ "(Cercle,Carre,Rectangle,Triangle) ou un groupe de Forme ***");
    	System.out.println("*************************************"
    			+ "*************************************************************");
    	System.out.println("-------------------- pour un Cercle exp: "
    			+ "\"c1 = Cercle ((0, 0), 50) \" -----------------------------");
    	System.out.println("-------------------- pour un Carre exp"
    			+ ":\"ca1 = Carre((1, 2), 5) \" ---------------------------------");
    	System.out.println("-------------------- pour un Rectangle exp:"
    			+ "\"r1 = Rectangle((2, 8), 9, 4) \" -----------------------");
    	System.out.println("-------------------- pour un  Triangle exp:\"t1 = "
    			+ "Triangle((0, 0), (3, 1), (4, 6) \" ---------------");
    	System.out.println("-------------------- pour un Groupe exp: \"g1 ="
    			+ " Groupe (c1, ca1, r1, t1) \"-------------------------");
    	System.out.println("\n*****************************************"
    			+ "*********************************************************");
    	System.out.println("*************************** 2- Deplacer une "
    			+ "forme ou un groupe ***********************************");
    	System.out.println("*********************************************"
    			+ "*****************************************************");
    	System.out.println("-------------Syntaxe génerale : move(nom "
    			+ "de la forme a déplace, (decalage X, decalage Y)) --------");
    	System.out.println("-------------------- exemple d'un "
    			+ "Cercle : \"move(c1, (4, 5)) \" -----------------------------------");
    	System.out.println("-------------------- exemple d'un "
    			+ "Carre : \"move(ca1, (6, 2))\" ------------------------------------");
    	System.out.println("-------------------- exemple d'un"
    			+ " Rectangle : \"move(r1, (0, 14)) \"--------------------------------");
    	System.out.println("-------------------- exemple "
    			+ "d'un Triangle : \"move(t1, (5, 6)) \" ---------------------------------");
    	System.out.println("-------------------- exemple "
    			+ "d'un Groupe : \"move(g1, (7, 3)) \" -----------------------------------");
    	System.out.println("\n***************************************"
    			+ "***********************************************************");
    	System.out.println("*********************** 3- Supprimer une "
    			+ "forme ou un groupe **************************************");
    	System.out.println("******************************************"
    			+ "********************************************************");
    	System.out.println("--------------------- Syntaxe génerale :"
    			+ " delete(nom de la forme à suprimer)) ---------------------");
    	System.out.println("-------------------- exemple d'un Cercle "
    			+ "exp: \"delete(c1) \" --------------------------------------");
    	System.out.println("-------------------- exemple d'un Carre "
    			+ "exp:\"delete(ca1)\" ----------------------------------------");
    	System.out.println("-------------------- exemple d'un "
    			+ "Rectangle exp:\"delete(r1) \" ------------------------------------");
    	System.out.println("-------------------- exemple d'un  "
    			+ "Triangle exp:\"delete(t1) \" ------------------------------------");
    	System.out.println("-------------------- exemple d'un"
    			+ " Groupe exp: \"delete(g1) \" --------------------------------------");
    	System.out.println("\n********************************************"
    			+ "******************************************************");
    	System.out.println("******************************** 4- quiter: "
    			+ "taper exit *******************************************");
    	System.out.println("*****************************************"
    			+ "*********************************************************");
    	System.out.println(" Pour commencer veuillez saisir votre commande : ");
    	
    }
    /**
     * la méthode run qui permet d'executer les commandes de l'utilisateur.
     * @throws FormeDoncExistException lever les Exceptions forme exite pas
     * @throws SQLException lever les Exceptions SQL
     */
    public void run() throws FormeDoncExistException, SQLException {
    	this.menu();	
    	String cmd = saisie.nextLine();
    	cmd=cmd.replace(" ", "");
        Command c = null;
      
        while (!cmd.equalsIgnoreCase("exit")) {
        	if (!(cmd.equalsIgnoreCase(""))) {
          	c = dt.nextCommand(cmd);
            if (c != null) {
                 c.execute();
                 dt.afficheDessin();
            }
             }

        	 
            cmd = saisie.nextLine();
            cmd=cmd.replace(" ", "");
        }
        c = dt.nextCommand(cmd);
        if (c != null) {
            c.execute();
        } 
    }
    /**
     * le main du programme.
     * @param args arguments
     */
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
        System.out.println("veuillez saisir le nom de votre fichier ");
        Scanner s = new Scanner(System.in);
        String name = null;
        boolean b = false;
           name = s.nextLine();
           File f = new File (name);
           if (f.exists()){
                System.out.println("Le nom du fichier existe déja veuillez saisir un nouveau nom ");
                 b = false;
           }else{
               b = true;
           }
           while (!b) {
        	   name = s.nextLine();
               name = name.replace(" ", "");
               f = new File (name);
               if (f.exists()){
                    System.out.println("Le nom du fichier existe déja veuillez saisir un nouveau nom");
                     b = false;
               }else{
                    b = true;
               }

           }
          // s.close();
       CeartionBDDREBY nn= new CeartionBDDREBY(name);
        nn.createTables();
      	try {
            DrawingApp app = new DrawingApp();
            app.run();
        } catch (Exception e) {
            e.getMessage();
        }

	}

}
