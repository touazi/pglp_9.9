package lyli.dessin.command;
import java.sql.SQLException;
/**.
 * <b>"l'inteface Command."</b>
 * <p>"implementation du patern Command"
 * @author TOUAZI,Lylia
 */
public interface Command {
/**
* Methode execute.
* @throws SQLException lever les Exceptions SQL
* */
public void execute() throws SQLException;
}
