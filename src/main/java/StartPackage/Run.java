package StartPackage;

import static spark.Spark.get;
import Diggaren.Beans.Spotify.SpotifyBean;
import Diggaren.Beans.Spotify.Test;
import Diggaren.Diggaren.DiggarenTest;
import Diggaren.Diggaren.beans.ChannelBean;
import Diggaren.Diggaren.beans.SongBean;

public class Run {

	private DiggarenTest sr;
	private Test spotify;

    public static void main( String[] args )
    {
    	Run app = new Run();
    	app.getSpotifyLink(2576);
    	get("/kanaler", (req, res) -> {
    		return app.getSpotifyLink(2576);
    	});
        System.out.println( "Hello World!" );
        get("/hej", (req, res) -> "Hej");
        
    }
    
    public Run (){
    	sr = new DiggarenTest();
    	spotify = new Test();
    	
    	sr.startRadio(2576);
    	spotify.startSpotify(sr.getTitle());

    }
    
    public String getSpotifyLink(int channel){
    	SpotifyBean ssb = spotify.getSpotify();
		return ssb.getUrl();
    }


}
