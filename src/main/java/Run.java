import static spark.Spark.get;
import static spark.Spark.port;
import java.util.ArrayList;
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


    	/**
    	 * Return the channel Stars' data as JSON
    	 */
		get("/star", (req, res) -> {
			res.header("Access-Control-Allow-Origin", "*");
        	res.type("text/json");
        	return json.getJson(1607);	
		});
		
		/**
		 * Return the channel Knattes' data as JSON
		 */
		get("/knatte", (req, res) -> {
			res.header("Access-Control-Allow-Origin", "*");
        	res.type("text/json");
        	return json.getJson(2755);	
			
		});
		
		/**
		 * Returns the channels in SR
		 */
		get("/channels", (req,res) -> {
			return app.getChannelList();			
		});

    
		/**
		 * Returns the playlist from a day
		 */
        get("/list", (req,res) -> {
        	return app.getList();
        });
        
        /**
         * Return the channel dingatas' data as JSON
         */
        get("/dingata", (req,res) -> {
        	res.header("Access-Control-Allow-Origin", "*");
        	res.type("text/json");
        	return json.getJson(2576);
        });
        
    }

	/**
	 * Creats a port. If no port i available, 4567 is being returned 
	 * @return the port 
	 */
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
    
    /**
     * Return the information about the current song from a
     * specific channel
     * @param channel
     * @return the data as a string
     */
	public String getSpotifyLinkFirst(int channel) {
		sr.startRadio(channel);
		spotify.startSpotify(sr.getFirstSong());
		return sr.getFirstSong();

	}
	
	/**
	 * Return the Spotify URL
	 * @return
	 */
	public String getLink() {
		return spotify.getLink();
	}
	
	/**
	 * Return a specific channels' ID
	 * @return the ID
	 */
	public int getChannelList(){
		
		ArrayList<Playlist> list1 = list.getChannelList();
		int i = 0;
		
		for (Playlist pl : list1) {
			i = pl.getChannel().getId();
		}
		
		return i;
	}
	
	/**
	 * Return a whole list as a String.
	 * Hav'nt specified a day yet, since this was just
	 * for test purposes.
	 * @return a whole playlist as a full String, with every songs URL
	 */
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
