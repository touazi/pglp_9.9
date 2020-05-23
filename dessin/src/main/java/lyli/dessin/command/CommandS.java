package lyli.dessin.command;
import java.sql.SQLException;
/**.
 * <b>"l'inteface CommandS."</b>
 * <p>"implementation du patern Command"
 * @author TOUAZI,Lylia
 */
public interface CommandS {
/**
* Methode execute.
* @throws SQLException lever les Exceptions SQL
* */
void execute() throws SQLException;
}
