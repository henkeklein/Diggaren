package Diggaren.Diggaren;
import static spark.Spark.get;

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
		System.out.println("Hello World1!");
    }
}
