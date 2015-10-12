package StartPackage;

import static spark.Spark.get;

import java.util.ArrayList;

import Diggaren.Beans.SR.SRStarter;
import Diggaren.Beans.SR.SongListBean;
import Diggaren.Beans.Spotify.SpotifyStarter;

/**
 * Initiates our server
 * 
 * @author danielhertzman-ericson, Henrik Klein, Dennis Kristensson
 *
 */
public class Run {

	private SRStarter sr;
	private SpotifyStarter spotify;
	
    public static void main( String[] args )
    {
    	Run app = new Run();

		String createLinkDingata = app.getSpotifyLinkFirst(2576);
		String createLink163 = app.getSpotifyLinkFirst(1607);

		get("/Dingata", (req, res) -> 
			"<!DOCTYPE html>"+
			"<html>"+

			"<head>"+
			"<title>Spotify</title>"+
			"</head>"+
			"<body>"+
				"<header>"+
					"<h1>"+
					app.getSpotifyLinkFirst(2576) +
					"</h1>"+
				"</header>"+
				"<section>"+
					"<heading></heading>"+
 "<a href=" + "\"" + app.getLink() + "\"" + ">" + createLinkDingata + "</a>" +

			                
					"</nav>"+
					"</section>	"+   	
			"<footer>"+
		
			    "</footer>"+
			"</body>"+
			"</html>"
			);
    	
		get("/Star", (req, res) -> 
		"<!DOCTYPE html>"+
		"<html>"+

		"<head>"+
		"<title>Spotify</title>"+
		"</head>"+
		"<body>"+
			"<header>"+
				"<h1>"+
				app.getSpotifyLinkFirst(1607) +
				"</h1>"+
			"</header>"+
			"<section>"+
				"<heading></heading>"+
"<a href=" + "\"" + app.getLink() + "\"" + ">" + createLink163 + "</a>" +

		                
				"</nav>"+
				"</section>	"+   	
		"<footer>"+
	
		    "</footer>"+
		"</body>"+
		"</html>"
		);

    
        get("/list", (req,res) -> {
        	return app.getList();
        });
        

    }
    
    public Run (){
    	sr = new SRStarter();
		spotify = new SpotifyStarter();

    }
    
	public String getSpotifyLinkFirst(int channel) {
		sr.startRadio(channel);
		spotify.startSpotify(sr.getFirstSong());
		return sr.getFirstSong();

	}
	
	public String getLink() {
		return spotify.getLink();
	}
	
	public String getList() {
		
		ArrayList<SongListBean> list = sr.createAndGetList();
		String s = "";
		int nbr = 0;
		
		/*
		 * Here is were the magic happens :)
		 */
		for (SongListBean bean : list) {
			spotify.startSpotify(bean.getTitle());
			String link = spotify.getLink();
			nbr++;
			s += "<p>" + nbr + ": " + bean.getDescribtion() + " - URL: " + "<a href="+"\""+link+"\"" + ">"+link+"</a>" + "</p>";
		}
		
		return s;
	
	}

}
