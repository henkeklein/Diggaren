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

		get("/song", (req, res) -> {
			return app.getSpotifyLinkFirst(2576);
    	});
        System.out.println( "Hello World!" );
        get("/hej", (req, res) -> "Hej");
        
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
		
		/*
		 * Here is were the magic happens :)
		 */
		for (int i = 0; i < list.size(); i++) {
			SongListBean bean = list.get(i);
			spotify.startSpotify(list.get(i).getTitle());
			String link = spotify.getLink();
			int nbr = i+1;
			s += "<p>" + nbr + ": " + bean.getDescribtion() + " - URL: " + "<a href="+"\""+link+"\"" + ">"+link+"</a>" + "</p>";
		}
		
		return s;
	
	}

}
