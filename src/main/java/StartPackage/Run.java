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
    	
    	get("/kanaler", (req, res) -> {
    		return app.getSpotifyLink(2576);
    	});
        System.out.println( "Hello World!" );
        get("/hej", (req, res) -> "Hej");
        
    }
    
    public Run (){
    	sr = new DiggarenTest();
    	spotify = new Test();
    	sr.startRadio(new ChannelBean());
    	spotify.startSpotify(sr.getSong());
    }
    
    public String getSpotifyLink(int channel){
    	SongBean song = sr.getSong();
    	SpotifyBean ssb = spotify.getSpotify(song);
		return ssb.getUrl();
    }


}
