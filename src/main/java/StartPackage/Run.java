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
	//	app.getSpotifyLinkFirst(2576);

		String createLink = app.getSpotifyLinkFirst(2576);

		get("/song", (req, res) -> 
//			return app.getSpotifyLinkFirst(2576);
			"<!DOCTYPE html>"+
			"<html>"+

			"<head>"+
			"<title>Spotify</title>"+
//				"<meta http-equiv="+content-type+" content="+text/html+;charset=utf-8+" />"+
//				"<meta name="+generator+" content="+Geany 0.19.1+" />"+
			"</head>"+
			"<body>"+
				"<header>"+
					"<h1>"+
 app.getSpotifyLinkFirst(2576) +
					"</h1>"+
				"</header>"+
				"<section>"+
					"<heading></heading>"+
 "<a href=" + "\"" + createLink + "\"" + ">" + "uhgu" + "</a>" +

				// "<a href=" + app.getSpotifyLinkFirst(2576) + ">Link</a>" +
			                
					"</nav>"+
					"</section>	"+   	
			"<footer>"+
		
			    "</footer>"+
			"</body>"+
			"</html>"
			)
			;
    	

    
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
		return sr.getFirstSong() + spotify.getLink();

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
