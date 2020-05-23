package lyli.dessin.command;
/**.
 * <b>"la classe Commandexit."</b>
 * <p>"implementation du patern Command"
 * @author TOUAZI,Lylia
 */
public class Commandexit implements CommandS {
/**.
* execution de la commande de exit.
*/
@Override
public final void execute() {
// TODO Auto-generated method stub
	System.exit(0);
	}
}
