package koddas.web.spark;

import static spark.Spark.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A very simple web service.
 * 
 * @author Johan Holmberg
 */
public class WebService {

	/**
	 * Implicitly sets up a web server and publishes a set of endpoints that
	 * can be accessed through HTTP.
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		setPort(8080);
		
		// A very simple Hello World end point
		get("/hello", (req, res) -> "Hello, World!");
		
		// A demonstration of how to use code within an endpoint
		get("/time", (req, res) -> {
			DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
			Date dateobj = new Date();
			
			return df.format(dateobj);
		});
		
		// A demonstration of how to do a POST endpoint
		post("/send", (req, res) -> {
			return "You sent me\n" + req.body() + "\nfrom " + req.ip() + "\n\n Thank you!";
		});
	}

}
