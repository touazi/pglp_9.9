package lyli.dessin;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Triangle triangle = new Triangle( "lyliatriangle",new Coordonnee(1,1), new Coordonnee(0,0), new Coordonnee(0,2) );
        Carre carre = new Carre ("lylia",new Coordonnee(1,4), 5);
        Cercle cercle = new Cercle ("lylia",new Coordonnee(1,4), 5);
        Rectangle rectangle = new Rectangle ("lylia",new Coordonnee(1,4),5,2);
        
        GroupeForme  g=new GroupeForme("premierGroupe");
        GroupeForme  g2=new GroupeForme("premierGroupe");
        g.ajouterForme(triangle);
        //g.affiche();
        g.ajouterForme(cercle);
        //g.affiche();
        g.move("lyliatriangle", 1, 1);
       // g.affiche();
        g2.ajouterForme(g);
        g2.affiche();
        //System.out.println(g.getListForm().contains(rectangle) );
    }

    
}
