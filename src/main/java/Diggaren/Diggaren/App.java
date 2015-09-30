package Diggaren.Diggaren;
import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	get("/kanaler", (req, res) -> "Hej");
        System.out.println( "Hello World!" );
        
        
        get("/hej", (req, res) -> "Hej");
    }
}
