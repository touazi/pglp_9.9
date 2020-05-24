package lyli.dessin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lyli.dessin.DAO.DAO;
import lyli.dessin.DAO.DaoFactory;
import lyli.dessin.command.CommandS;
import lyli.dessin.command.CommandDeCreation;
import lyli.dessin.command.CommandDeplacer;
import lyli.dessin.command.CommandSuprimer;
import lyli.dessin.command.CommandeCreateCarre;
import lyli.dessin.command.CommandeCreateCercle;
import lyli.dessin.command.CommandeCreateForme;
import lyli.dessin.command.CommandeCreateRectangle;
import lyli.dessin.command.CommandeCreateTriangle;
import lyli.dessin.command.Commandexit;
import lyli.dessin.exeption.FormeDoncExistException;
/**.
 * <b>"L'implementation de la class DrawingTUI."</b>
 * @author TOUAZI,Lylia
 */
public class DrawingTUI {
	/**constante un.*/
	static final int UN = 1;
	/**constante deux.*/
	static final int DEUX = 2;
	/**constante trois.*/
	static final int TROIS = 3;
	/**constante quatre.*/
	static final int QUATRE = 4;
	/**constante cinq.*/
	static final int CINQ = 5;
	/**constante six.*/
	static final int SIX = 6;
	/**constante sept.*/
	static final int SEPT = 7;
	/**constante huit.*/
	static final int HUIT = 8;
	/**constante neuf.*/
	static final int NEUF = 9;
	/**constante dix.*/
	static final int DIX = 10;
	/**constante onze.*/
	static final int ONZE = 11;
	/**constante DOUZE.*/
	static final int DOUZE = 12;
	/** connection a la base de donnée. */
	private Connection connect = null;
	/** constructeur de la class DrawingApp. */
	public DrawingTUI() {
		// this.connect = connect;
	}

/**
 * La Fonction createForme. <b>"elle permet de créer une Forme
 * selon le type de
 * de la chaine"</b> <b>"de caractaire donnée."</b>
 * @param token    les Tokens de la commande
 * @param typeForme le type de la forme à créer
 * @param name      le nome de la forme
 * @return la forme générer
 * @throws SQLException lever les Exceptions SQL
 */
public final Forme createForme(final String[] token,
		final String typeForme,
		final String name) throws SQLException {
	Forme forme = null;
	if (typeForme.equalsIgnoreCase("cer")) {

String[] tokens = token[1].split(",|\\(|\\)");
if (tokens.length == SIX) {
	try {
		int centrex = Integer.parseInt(tokens[DEUX]);
		int centrey = Integer.parseInt(tokens[TROIS]);
		int rayon = Integer.parseInt(tokens[CINQ]);
		CommandeCreateForme<Cercle> cmd = null;
		cmd = new CommandeCreateCercle(name,
				new Coordonnee(
						centrex,
						centrey),
				rayon);
        forme = (Forme) cmd.execute();
		return forme;
	} catch (Exception e) {
		System.out.println("impossible de "
	+ "crée le cercle car"
	+ " : " + e.getLocalizedMessage());
	}
} else {
	if (tokens.length > SIX) {
		System.err.println("arguments en plus");
	return null;
} else {
	System.err.println("arguments en moins");
			return null;
		}
	}
} else if (typeForme.equalsIgnoreCase("car")) {
String[] tokens = token[UN].split(",|\\(|\\)");
if (tokens.length == SIX) {
	try {
		int pointx = Integer.parseInt(tokens[DEUX]);
		int pointy = Integer.parseInt(tokens[TROIS]);
		int side = Integer.parseInt(tokens[CINQ]);
		CommandeCreateForme<Carre> cmd = null;
		cmd = new CommandeCreateCarre(name,
				new Coordonnee(pointx, pointy),
				side);
        forme = (Forme) cmd.execute();
		return forme;
	} catch (Exception e) {
		System.out.println("impossible de crée le "
	+ "carre car : "
				+ e.getLocalizedMessage());
	}
} else {
	if (tokens.length > SIX) {
		System.err.println("arguments en plus");
	return null;
} else {
	System.err.println("arguments en moins");
				return null;
				}
		}
} else if (typeForme.equalsIgnoreCase("rec")) {
String[] tokens = token[UN].split(",|\\(|\\)");
if (tokens.length == SEPT) {
	try {
		int pointx = Integer.parseInt(tokens[DEUX]);
		int pointy = Integer.parseInt(tokens[TROIS]);
		int sidetof = Integer.parseInt(tokens[CINQ]);
		int sideleft = Integer.parseInt(tokens[SIX]);
		CommandeCreateForme<Rectangle> cmd = null;
		cmd = new CommandeCreateRectangle(name,
				new Coordonnee(pointx, pointy),
				sidetof, sideleft);
        forme = (Forme) cmd.execute();
		return forme;
	} catch (Exception e) {
		System.out.println("impossible de crée "
	+ "le rectangle car : " + e.getLocalizedMessage());
	}
} else {
	if (tokens.length > SEPT) {
		System.err.println("arguments en plus");
	return null;
} else {
	System.err.println("arguments en moins");
				return null;
				}
		}
} else if (typeForme.equalsIgnoreCase("tri")) {
String[] tokens = token[UN].split(",|\\(|\\)");
if (tokens.length == DOUZE) {
	try {
		int point1x = Integer.parseInt(tokens[DEUX]);
		int point1y = Integer.parseInt(tokens[TROIS]);
		int point2x = Integer.parseInt(tokens[SIX]);
		int point2y = Integer.parseInt(tokens[SEPT]);
		int point3x = Integer.parseInt(tokens[DIX]);
		int point3y = Integer.parseInt(tokens[ONZE]);
		CommandeCreateForme<Triangle> cmd = null;
		cmd = new CommandeCreateTriangle(name,
				new Coordonnee(point1x, point1y),
				new Coordonnee(point2x, point2y),
				new Coordonnee(point3x, point3y));
        forme = (Forme) cmd.execute();
		return forme;
	} catch (Exception e) {
		System.out.println("impossible de"
	+ " crée le triangle "
	+ "car : " + e.getLocalizedMessage());
	}
} else {
	if (tokens.length > DOUZE) {
		System.err.println("arguments en plus");
	return null;
} else {
	System.err.println("arguments en moins");
					return null;
					}
			}
	}
	return null;
}

/**
 * La Fonction createGroupe. <b>"elle permet de créer
 *  une Groupe selon le type
 * de de la chaine"</b> <b>"de caractaire donnée."</b>
 * @param tokens les Tokens de la commande
 * @param name   le nome de la forme
 * @return la forme générer
 * @throws SQLException            lever les Exceptions SQL
 * @throws FormeDoncExistException lever les Exceptions de
 *  la forme qui n'existe pas
 */
public final Forme createGroupe(final String[] tokens,
		final String name)
		throws SQLException, FormeDoncExistException {
	ArrayList<Forme> formes = new ArrayList<Forme>();
	if ((tokens[1].startsWith("(") && tokens[1].endsWith(")"))) {
GroupeForme groupe = new GroupeForme(name);
DaoFactory factory = new DaoFactory();
for (String s : tokens[1].substring(1,
		tokens[1].length() - 1).split(",")) {
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
	System.err.println("La forme:  " + s
			+ " n'existe pas ");
			return null;
		}
	}
	factory.disconnect();
	for (Forme s : formes) {
		groupe.ajouterForme(s);
	}
	return groupe;
} else {
	System.err.println("parenteses manquantes");
	    return null;
	    }
}
/**
 * La Fonction move. <b>"elle permet de deplacer
 *  une Groupe ou une forme "</b>
 *
 * @param token les Tokens de la commande
 * @return la forme deplacer
 */
public final Forme move(final String[] token) {
	String[] tokens = token[1].split(",|\\(|\\)");
if (tokens.length != CINQ) {
	if (tokens.length < CINQ) {
		System.err.println(
			"Arguments en moins."
+ " Exmple move : \" move(nom_fig,(1,1))\"");
} else {
	System.err.println("Arguments en plus. "
		+ "Exmple move :"
		+ "\" move(nom_fig,(1,1))\"");
	}
} else {
	try {
		System.out.println(tokens[1]);
		Forme f = null;
		DaoFactory factory = new DaoFactory();
		Forme forme = null;
		if (f == null) {
			DAO<Carre> daoCa = factory.getCarreDAO();
			forme = daoCa.read(tokens[1]);
			if (forme != null) {
				f = forme;
			}
			DAO<Rectangle> daoR = factory.getRectangleDAO();
			forme = daoR.read(tokens[1]);
			if (forme != null) {
				f = forme;
			}
			DAO<Triangle> daoT = factory.getTriangleDAO();
			forme = daoT.read(tokens[1]);
			if (forme != null) {
				f = forme;
			}
			DAO<GroupeForme> daoG = factory.getGroupeDAO();
			forme = daoG.read(tokens[1]);
			if (forme != null) {
				f = forme;
			}
			DAO<Cercle> daoCe = factory.getCercleDAO();
			forme = daoCe.read(tokens[1]);
			factory.disconnect();
			if (forme != null) {
				f = forme;
			}
		}
		if (f == null) {
			System.err.println("La forme:  "
+ tokens[0] + " n'existe pas ");
	}
	if (f != null) {
		f.move(tokens[1], Integer.parseInt(tokens[TROIS]),
				Integer.parseInt(tokens[QUATRE]));
		return f;
	}
} catch (Exception e) {
	System.err.println("Commande invalide");
		e.printStackTrace();
	}
}
	return null;
}
/**
 * La Fonction delete. <b>"elle permet de suprimer
 *  une Groupe ou une forme "</b>
 * @param token les Tokens de la commande
 * @return la forme à surpimer
 * @throws FormeDoncExistException lever les Exceptions
 *  de la forme qui n'existe pas
 * @throws SQLException pour lever les Exceptions SQL
 */
public final Forme delete(final String[] token)
		throws SQLException, FormeDoncExistException {
	String[] tokens = null;
	if ((token[1].startsWith("(") && token[1].endsWith(")"))) {
token[1] = token[1].substring(1, token[1].length() - 1);
tokens = token[1].split(",");
DaoFactory factory = new DaoFactory();
Forme forme = null;
if (forme == null) {
	DAO<Carre> daoCa = factory.getCarreDAO();
	forme = daoCa.read(tokens[0]);
}
if (forme == null) {
	DAO<Rectangle> daoR = factory.getRectangleDAO();
	forme = daoR.read(tokens[0]);
}
if (forme == null) {
	DAO<Triangle> daoT = factory.getTriangleDAO();
	forme = daoT.read(tokens[0]);
}
if (forme == null) {
	DAO<GroupeForme> daoG = factory.getGroupeDAO();
	forme = daoG.read(tokens[0]);
}
if (forme == null) {
	DAO<Cercle> daoCe = factory.getCercleDAO();
	forme = daoCe.read(tokens[0]);
}
factory.disconnect();
if (forme != null) {
	return forme;
} else {
	System.err.println("La forme:  " + tokens[0] + " n'existe pas ");
		return null;
	}
} else {
	System.err.println("parenthèses manquantes");
		return null;
	}
}

/**
 * la fonction nextCommand recupere les commande
 *  le l'utilisateur en chaine de
 * carractere et les transforme en commande.
 * @param command commande de l'utilisateur.
 * @return une commande à exectuer ou null s'il n'y en a pas.
 * @throws FormeDoncExistException lever les Exceptions
 *  de la forme qui n'existe pas
 * @throws SQLException            lever les Exceptions SQL
 */
public final CommandS nextCommand(final String command)
		throws FormeDoncExistException, SQLException {
	String[] token = null;
	if (command.indexOf("=") > -1) {
Forme f = null;
String[] separEgal = null, tokens = null;
separEgal = command.split("=");
if (separEgal.length != 2) {
	System.err.println("la commande "
+ command + "n'est pas reconnu, vérifier "
+ "que la syntaxe de la commande"
+ " est correcte");
	return null;
}
if ((separEgal[1].indexOf("Cercle") > -1)
|| (separEgal[1].indexOf("CERCLE") > -1)
|| (separEgal[1].indexOf("cercle") > -1)) {
if (separEgal[1].indexOf("Cercle") > -1) {
tokens = separEgal[1].split("Cercle");
} else if (separEgal[1].indexOf("cercle") > -1) {
tokens = separEgal[1].split("cercle");
} else {
	tokens = separEgal[1].split("CERCLE");
}
if (tokens.length > 1) {
	f = this.createForme(tokens, "cer",
			separEgal[0].trim());
} else {
	System.err.println("la commande "
+ command + "n'est pas reconnu, vérifier "
+ "que la syntaxe de la commande"
+ " est correcte");
		return null;
	}
} else if ((separEgal[1].indexOf("Triangle") > -1)
|| (separEgal[1].indexOf("TRIANGLE") > -1)
|| (separEgal[1].indexOf("triangle") > -1)) {
if (separEgal[1].indexOf("Triangle") > -1) {
tokens = separEgal[1].split("Triangle");
} else if (separEgal[1].indexOf("triangle") > -1) {
tokens = separEgal[1].split("triangle");
} else {
	tokens = separEgal[1].split("TRIANGLE");
}
if (tokens.length > 1) {
	f = this.createForme(tokens, "tri",
			separEgal[0].trim());
} else {
	System.err.println("la commande "
+ command + "n'est pas reconnu, vérifier "
+ "que la syntaxe de la commande"
+ " est correcte");
		return null;
	}
} else if (separEgal[1].contains("Rectangle")
|| separEgal[1].contains("rectangle")
|| separEgal[1].contains("RECTANGLE")) {
if (separEgal[1].contains("Rectangle")) {
tokens = separEgal[1].split("Rectangle");
} else if (separEgal[1].contains("rectangle")) {
tokens = separEgal[1].split("rectangle");
} else {
	tokens = separEgal[1].split("RECTANGLE");
}
if (tokens.length > 1) {
	f = this.createForme(tokens, "rec",
			separEgal[0].trim());
} else {
	System.err.println("la commande "
+ command + "n'est pas reconnu, vérifier "
+ "que la syntaxe de la commande"
+ " est correcte");
		return null;
	}
} else if (separEgal[1].contains("Carre")
|| separEgal[1].contains("carre")
|| separEgal[1].contains("CARRE")) {
if (separEgal[1].contains("Carre")) {
tokens = separEgal[1].split("Carre");
} else if (separEgal[1].contains("carre")) {
tokens = separEgal[1].split("carre");
} else {
	tokens = separEgal[1].split("CARRE");
}
if (tokens.length > 1) {
	f = this.createForme(tokens, "car",
			separEgal[0].trim());
} else {
	System.err.println("la commande "
+ command + "n'est pas reconnu, vérifier "
+ "que la syntaxe de la commande "
+ "est correcte");
		return null;
	}
} else if ((separEgal[1].indexOf("Groupe") > -1)
|| (separEgal[1].indexOf("groupe") > -1)
|| (separEgal[1].indexOf("GROUPE") > -1)) {
if (separEgal[1].indexOf("Groupe") > -1) {
tokens = separEgal[1].split("Groupe");
} else if (separEgal[1].indexOf("groupe") > -1) {
tokens = separEgal[1].split("groupe");
} else {
	tokens = separEgal[1].split("GROUPE");
}
if (tokens.length > 1) {
	f = this.createGroupe(tokens,
			separEgal[0].trim());
} else {
	System.err.println("la commande "
+ command + "n'est pas reconnu, vérifier "
+ "que la syntaxe de la commande"
+ " est correcte");
		return null;
	}
} else {
	System.err.println("la commande "
+ command + "n'est pas reconnu, vérifier "
+ "que la syntaxe de la commande"
+ " est correcte");
	return null;
}
if (f != null) {
	return new CommandDeCreation(f);
} else {
	System.err.println("crée d'abord la forme "
+ "pour la mettre dans un groupe");
		return null;
	}
} else if ((command.indexOf("move") > -1)
|| (command.indexOf("Move") > -1)
|| (command.indexOf("MOVE") > -1)) {
if ((command.indexOf("Move") > -1)) {
token = command.split("Move");
} else if ((command.indexOf("move") > -1)) {
token = command.split("move");
} else {
	token = command.split("MOVE");
}
if (token.length != 2) {
	System.err.println("la commande "
+ command + "n'est pas reconnu, vérifier "
+ "que la syntaxe de la commande "
+ "est correcte");
	return null;
}
Forme f = null;
f = this.move(token);
if (f != null) {
	return new CommandDeplacer(f);
} else {
	System.err.println("crée d'abord la "
+ "forme pour la deplacer");
		return null;
	}
} else if ((command.indexOf("delete") > -1)
|| (command.indexOf("Delete") > -1)
|| (command.indexOf("DELETE") > -1)) {
if ((command.indexOf("Delete") > -1)) {
token = command.split("Delete");
} else if ((command.indexOf("delete") > -1)) {
token = command.split("delete");
} else {
	token = command.split("DELETE");
}
if (token.length != 2) {
	System.err.println("la commande "
+ command + "n'est pas"
+ " reconnu, vérifier "
+ "que la syntaxe de"
+ " la commande "
+ "est correcte");
	return null;
}
Forme f = null;
f = this.delete(token);
if (f != null) {
	return new CommandSuprimer(f);
} else {
	System.err.println("crée d'abord la forme "
+ "pour la mettre "
+ "dans un groupe");
		return null;
	}
} else if (command.equalsIgnoreCase("exit")) {
	return new Commandexit();
}
System.err.println("la commande "
+ command + "n'est pas reconnu, vérifier "
+ "que la syntaxe de la commande est correcte");
	return null;
}

/**
 * la methode afficheDessin. affiche toutes les formes du dessin .
 *
 * @throws SQLException lever les Exceptions SQL
 */

public final void afficheDessin() throws SQLException {
	DaoFactory factory = new DaoFactory();
	Forme readf = null;
	this.connect = factory.getConnection();
	ArrayList<Forme> formes = new ArrayList<Forme>();
	try {
		PreparedStatement prepare = null;
		prepare = connect.prepareStatement("SELECT "
+ "NameForme FROM cercle");
ResultSet result = prepare.executeQuery();
while (result.next()) {
	DAO<Cercle> daoCe = factory.getCercleDAO();
	String t = result.getString("NameForme");
		readf = daoCe.read(t);
		formes.add(readf);
	}
} catch (SQLException e) {
	e.printStackTrace();
	formes = new ArrayList<Forme>();
}
try {
	PreparedStatement prepare = null;
	prepare = connect.prepareStatement("SELECT "
+ "NameForme FROM carre");
ResultSet result = prepare.executeQuery();
while (result.next()) {
	DAO<Carre> daoCa = factory.getCarreDAO();
	String t = result.getString("NameForme");
		readf = daoCa.read(t);
		formes.add(readf);
	}
} catch (SQLException e) {
	e.printStackTrace();
	formes = new ArrayList<Forme>();
}
try {
	PreparedStatement prepare = null;
	prepare = connect.prepareStatement("SELECT "
+ "NameForme FROM rectangle");
ResultSet result = prepare.executeQuery();
while (result.next()) {
	DAO<Rectangle> daoR = factory.getRectangleDAO();
	String t = result.getString("NameForme");
		readf = daoR.read(t);
		formes.add(readf);
	}
} catch (SQLException e) {
	e.printStackTrace();
	formes = new ArrayList<Forme>();
}
try {
	PreparedStatement prepare = null;
	prepare = connect.prepareStatement("SELECT "
+ "NameForme FROM triangle");
ResultSet result = prepare.executeQuery();
while (result.next()) {
	DAO<Triangle> daoT = factory.getTriangleDAO();
	String t = result.getString("NameForme");
		readf = daoT.read(t);
		formes.add(readf);
	}
} catch (SQLException e) {
	e.printStackTrace();
	formes = new ArrayList<Forme>();
}
try {
	PreparedStatement prepare = null;
	prepare = connect.prepareStatement("SELECT "
+ "id FROM groupe");
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
			//if (f.isGroupe()) {
				f.affiche();
			//}
		}
	}
}
