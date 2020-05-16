package lyli.dessin;

import java.sql.SQLException;

import lyli.dessin.DAO.CeartionBDDREBY;
import lyli.dessin.DAO.DAO;
import lyli.dessin.DAO.DaoFactory;
import lyli.dessin.exeption.FormeDoncExistException;
import lyli.dessin.exeption.FormeExisteDeja;
import lyli.dessin.exeption.TableExisteDeja;
import lyli.dessin.command.CommandSuprimer;
import lyli.dessin.command.Command;
import lyli.dessin.command.CommandDeCreation;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FormeExisteDeja, FormeDoncExistException, SQLException, TableExisteDeja {
    	CeartionBDDREBY nn= new CeartionBDDREBY("mlnvd");
        nn.createTables();
      	 Cercle cerclee = new Cercle ("C1",new Coordonnee(0,0), 0);
         DaoFactory factoryy = new DaoFactory();
         DAO<Cercle> daoo = factoryy.getCercleDAO();
        
         cerclee = daoo.create(cerclee);
         cerclee = daoo.read(cerclee.getNameForme());
      //   Command cmd1 = new CommandDeCreation(cerclee);
       //  cmd1.execute();
        
         cerclee.affiche();
         
         
         Carre rec = new Carre ("Carrej",new Coordonnee(0,0),4);
         //Command cmd1 = new CommandDeCreation(cercle);
         //cmd1.execute();
         DAO<Carre> dao = factoryy.getCarreDAO();
         rec.affiche();
         rec = dao.create(rec);
         rec = dao.read("Carrej");
        // cerclee.move(cerclee.getNameForme(), 1, 1);
         rec.affiche();
         factoryy.disconnect();
        DrawingTUI b = new DrawingTUI();
    //     Command cmd = b.nextCommand("delete(C1)");
        String[] Token = "delete(Carrej)".split("delete");
         Forme f=b.delete(Token);//kkkkkkkkkkkkkkkkkkkkkk
     
   f.affiche();
Command cmd = new CommandSuprimer(f);
System.out.println("rrrrrrrrrrrrrr"+Token[1]);
  
b.afficheDessin();
System.out.println("rrrrrrrrrrrrrr"+Token[1]);
 cmd.execute();
    b.afficheDessin();
    }

	}
