# pglp_9.9 
# Logiciel de dessin

Le but de cet exercice est de r�aliser un logiciel de dessin. On se limitera ici � un affichage textuel, i.e. seule une description des figures sera affich�e. Par exemple, un cercle de centre (0, 0) et de rayon 50 sera "affich�" par la cha�ne de caract�res "Cercle(centre=(0,0),rayon=50)".

L'utilisateur interagira avec l'application par l'interm�diaire de la ligne de commandes. Chaque commande d�butera par une instruction suivie des arguments de cette instruction. Par exemple, pour cr�er un cercle, l'utilisateur pourra taper "c1 = Cercle((0, 0), 50)", puis pour le d�placer "move(c1, (10, 20))".

Le logiciel devra offrir les fonctionnalit�s suivantes:
* Chaque forme sera identifi�e par un nom ("c1", "unCercle", ...).
* L'application permettra de manipuler des cercles, des rectangles, des carr�s et des triangles.
* Chaque forme devra pouvoir �tre affich�e et d�plac�e.
* Les formes devront pouvoir �tre regroup�es et pourront subir des traitements globaux comme par exemple d�placer ensemble un cercle et un triangle.
* Un dessin (ensemble de formes) pourra �tre sauvegard�/charg� dans un SGBD embarqu� comme [HyperSQL](http://hsqldb.org/), [H2](http://www.h2database.com/html/main.html) ou [Derby](https://db.apache.org/derby/).

Dans cet exercice, vous appliquerez au mieux les principes de conception ainsi que les fonctionnalit�s du langage Java (exceptions, collections, ...).
Vous respecterez les m�mes modalit�s que pour les exercices pr�c�dents.
Le d�p�t _github_ sera nomm� `pglp_9.9`.

1. Proposer et impl�menter une hi�rarchie de classe repr�sentant les formes graphiques.
1. Repr�senter la notion de groupe de formes en appliquant le pattern `Composite`.
2. Render les formes et les groupes persistants en utilisant le pattern `DAO` et JDBC.
1. R�aliser la classe `DrawingTUI` qui se chargera des interactions avec l�utilisateur.
Cette classe fournira une m�thode `nextCommand` qui analysera le texte saisi par l�utilisateur et retournera un objet impl�mentant l�interface Commande (cf. question suivante).
Elle proposera �galement une m�thode permettant d'afficher un dessin.
1. Les commandes seront impl�ment�es � l�aide du mod�le de conception _Commande_.
   1. cr�er l�interface `Command` comportant la m�thode `execute`,
   1. cr�er une classe impl�mentant cette interface pour chaque action.
1. R�aliser la classe principale `DrawingApp`.
La m�thode `run` de cette classe interagira avec  `DrawingTUI` pour r�cup�rer la prochaine commande, l�ex�cutera puis affichera le r�sultat.