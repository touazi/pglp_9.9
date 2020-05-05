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
        Triangle c = new Triangle( "lylia",new Coordonnee(1,1), new Coordonnee(0,0), new Coordonnee(0,2) );
        c.affiche();
        c.move("lylia",3,0);
        c.affiche();
        
     
      /*      String s = "c1 = Cercle((0, 0), 50)";
            String x=   "move(c1, (10, 20))";
            s = s.substring(0, s.length() - 1);
            System.out.println(s);
            
           for (int i = 0 ; i < s.length() ;i++)
        	   
                System.out.println(s.charAt(i));
    */
    }

    
}
