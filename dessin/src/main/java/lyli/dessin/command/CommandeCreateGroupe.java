package lyli.dessin.command;
import lyli.dessin.GroupeForme;
/**.
 * <b>"L'implementation de la class CommandeCreateGroupe."</b>
 * @author TOUAZI,Lylia
 */
public class CommandeCreateGroupe implements
CommandeCreateForme<GroupeForme> {

  /**.
   * nom du groupe.
   */
  private String nomGroupe;

  /**
   * constructeur de la class CommandeCreateGroupe.
   * @param nomGroupee nom du groupe.
   */
  public CommandeCreateGroupe(final String nomGroupee) {
    this.nomGroupe = nomGroupee;
  }

  /**
   * methode execute pour executer la commande.
   * de creation du groupe.
   * @return new groupe
   */
  public final GroupeForme execute() {
    return new GroupeForme(nomGroupe);
  }
}
