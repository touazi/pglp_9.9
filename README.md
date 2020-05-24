# pglp_9.9 
# Logiciel de dessin
Une fois avoir executer le programme vous tappez le nom du fichier ou vous allez suavgarder votre dessin.

Apres vous pouvez commencer à crée vos dessin (cercle, carre rectangle, et triangle), pour cela il faut tappez une des commande suivante:
* nomCercle = cercle((coordonneeY, coordonneeY), rayon)  ==> vous pouvez ecrire sois (cercle, Cercle ou CERCLE) et les espace sont pas obligatoire.
* nomCarre = carre((coordonneeY, coordonneeY), valeurCote)  ==> vous pouvez ecrire sois (carre,Carre ou CARRE) et les espace sont pas obligatoire.
* nomTriangle = triangle((coordonnee1Y, coordonnee1Y), (coordonnee2Y, coordonnee2Y), (coordonnee3Y, coordonnee3Y))  ==> vous pouvez ecrire sois (triangle,Triangle ou TRIANGLE) et les espace sont pas obligatoire.
* nomRecatange = rectangle((coordonneeY, coordonneeY), valeurCotehaut, valeurCotegauche)  ==> vous pouvez ecrire sois (rectangle, Rectangle ou RECTANGLE) et les espace sont pas obligatoire.


Vous pouver aussi crée une groupe de forme et pour cela vous tappez la commande suivante:
* nomGroupe=groupe(nomTriangle, nomCercle,........) 
==> la liste des forme déja crée que vous voulez ajouter dans le groupe, si il n'est pas crée il ajoute pas dans le groupe.
==> vous pouvez ecrire sois (groupe,Groupe ou GROUPE) et les espace sont pas obligatoire.



vous pouvez aussi déplacer une forme comme suite :
* move(monFormeADeplacer,(dacalageX,decalageY)) 
==> vous pouvez sois déplacer une forme ou un groupe de formes, si vous déplacer une forme qui se trouve dans un groupe elle sera déplacer dans le groupe.
==> si vous voulez déplacer un ensemble de forme vous pouvez les regrouper dans un groupe puis les deplcer ensemble en tappant la commande suivante:
==>move(nomGroupe,(decapalageX,decalageY))

Pour ce qui est de l'affichage des formes ou du groupe formes il sont afficher des leur création et c'est le cas aussi pour la sauvgarde; à chaque fois qu'une forme est crée elle sauvgarder dans Derby et à chaque fois qu'une forme est déplacer elle est sauvgarder aussi.

Vous pouvez aussi suprimez une fomre ou un groupe de forme et pour cella vous tappez la commande suivate:
* delete(nomForme) pour une seul forme.
* ou delete(nomGroupe) pour un groupe de forme.




Le project :
Le but de cet exercice est de réaliser un logiciel de dessin. On se limitera ici à un affichage textuel, i.e. seule une description des figures sera affichée. Par exemple, un cercle de centre (0, 0) et de rayon 50 sera "affiché" par la chaîne de caractères "Cercle(centre=(0,0),rayon=50)".

L'utilisateur interagira avec l'application par l'intermédiaire de la ligne de commandes. Chaque commande débutera par une instruction suivie des arguments de cette instruction. Par exemple, pour créer un cercle, l'utilisateur pourra taper "c1 = Cercle((0, 0), 50)", puis pour le déplacer "move(c1, (10, 20))".

Le logiciel devra offrir les fonctionnalités suivantes:
* Chaque forme sera identifiée par un nom ("c1", "unCercle", ...).
* L'application permettra de manipuler des cercles, des rectangles, des carrés et des triangles.
* Chaque forme devra pouvoir être affichée et déplacée.
* Les formes devront pouvoir être regroupées et pourront subir des traitements globaux comme par exemple déplacer ensemble un cercle et un triangle.
* Un dessin (ensemble de formes) pourra être sauvegardé/chargé dans un SGBD embarqué comme [HyperSQL](http://hsqldb.org/), [H2](http://www.h2database.com/html/main.html) ou [Derby](https://db.apache.org/derby/).

Dans cet exercice, vous appliquerez au mieux les principes de conception ainsi que les fonctionnalités du langage Java (exceptions, collections, ...).
Vous respecterez les mêmes modalités que pour les exercices précédents.
Le dépôt _github_ sera nommé `pglp_9.9`.

1. Proposer et implémenter une hiérarchie de classe représentant les formes graphiques.
1. Représenter la notion de groupe de formes en appliquant le pattern `Composite`.
2. Render les formes et les groupes persistants en utilisant le pattern `DAO` et JDBC.
1. Réaliser la classe `DrawingTUI` qui se chargera des interactions avec l’utilisateur.
Cette classe fournira une méthode `nextCommand` qui analysera le texte saisi par l’utilisateur et retournera un objet implémentant l’interface Commande (cf. question suivante).
Elle proposera également une méthode permettant d'afficher un dessin.
1. Les commandes seront implémentées à l’aide du modèle de conception _Commande_.
   1. créer l’interface `Command` comportant la méthode `execute`,
   1. créer une classe implémentant cette interface pour chaque action.
1. Réaliser la classe principale `DrawingApp`.
La méthode `run` de cette classe interagira avec  `DrawingTUI` pour récupérer la prochaine commande, l’exécutera puis affichera le résultat.