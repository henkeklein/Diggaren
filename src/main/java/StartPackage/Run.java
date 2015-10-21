package StartPackage;

import static spark.Spark.get;
import static spark.Spark.port;

import java.util.ArrayList;

import javax.swing.JOptionPane;

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
	
	public static void main(String[] args) {
		port(getHerokuAssignedPort());
    	Run app = new Run();
    	JavaToJson json = new JavaToJson();
    	JOptionPane.showMessageDialog(null, "Server started");
    	
		get("/hello", (req, res) -> "Hello World");

		get("/star", (req, res) -> {
			res.header("Access-Control-Allow-Origin", "*");
        	res.type("text/json");
        	return json.getJson(1607);	
		});
		
		
		get("/knatte", (req, res) -> {
			res.header("Access-Control-Allow-Origin", "*");
        	res.type("text/json");
        	return json.getJson(2755);	
			
		});
		
		get("/channels", (req,res) -> {
			return app.getChannelList();			
		});

    
        get("/list", (req,res) -> {
        	return app.getList();
        });
        
        
        get("/dingata", (req,res) -> {
        	res.header("Access-Control-Allow-Origin", "*");
        	res.type("text/json");
        	return json.getJson(2576);
        });
        
    }

	static int getHerokuAssignedPort() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		if (processBuilder.environment().get("PORT") != null) {
			return Integer.parseInt(processBuilder.environment().get("PORT"));
		}
		return 4567; // return default port if heroku-port isn't set (i.e. on
						// localhost)
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
			s += "<p>" + nbr + ": " + bean.getDescription() + " - URL: " + "<a href="+"\""+link+"\"" + ">"+link+"</a>" + "</p>";
		}
		
		return s;
	
	}

}
