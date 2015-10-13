package StartPackage;

import static spark.Spark.get;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Diggaren.Beans.SR.ChannelList;
import Diggaren.Beans.SR.Playlist;
import Diggaren.Beans.SR.SRStarter;
import Diggaren.Beans.SR.SongListBean;
import Diggaren.Beans.Spotify.SpotifyStarter;
import Diggaren.Json.JavaToJson;

/**
 * Initiates our server
 * 
 * @author danielhertzman-ericson, Henrik Klein, Dennis Kristensson
 *
 */
public class Run {

	private SRStarter sr;
	private SpotifyStarter spotify;
	private ChannelList list;
	
    public static void main( String[] args )
    {
    	Run app = new Run();
    	JavaToJson json = new JavaToJson();
    	

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
 "<a href=" + "\"" + app.getLink() + "\"" + ">" + "Spotify link" + "</a>" +

			                
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
"<a href=" + "\"" + app.getLink() + "\"" + ">" + "Spotify link" + "</a>" +

		                
				"</nav>"+
				"</section>	"+   	
		"<footer>"+
	
		    "</footer>"+
		"</body>"+
		"</html>"
		);
		
		
		get("/Knatte", (req, res) -> 
		"<!DOCTYPE html>"+
		"<html>"+

		"<head>"+
		"<title>Spotify</title>"+
		"</head>"+
		"<body>"+
			"<header>"+
				"<h1>"+
				app.getSpotifyLinkFirst(2755) +
				"</h1>"+
			"</header>"+
			"<section>"+
				"<heading></heading>"+
"<a href=" + "\"" + app.getLink() + "\"" + ">" + "Spotify link" + "</a>" +

		                
				"</nav>"+
				"</section>	"+   	
		"<footer>"+
	
		    "</footer>"+
		"</body>"+
		"</html>"
		);
		
		get("/channels", (req,res) -> {
			return app.getChannelList();			
		});

    
        get("/list", (req,res) -> {
        	return app.getList();
        });
        
        
        get("/Dingata/json", (req,res) -> {
        	res.type("text/json");
        	return json.getJson();
        });
        
    }
    
    public Run (){
    	sr = new SRStarter();
		spotify = new SpotifyStarter();
		list = new ChannelList();

    }
    
	public String getSpotifyLinkFirst(int channel) {
		sr.startRadio(channel);
		spotify.startSpotify(sr.getFirstSong());
		return sr.getFirstSong();

	}
	
	public String getLink() {
		return spotify.getLink();
	}
	
	public int getChannelList(){
		
		ArrayList<Playlist> list1 = list.getChannelList();
		int i = 0;
		
		for (Playlist pl : list1) {
			i = pl.getChannel().getId();
		}
		
		return i;
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
