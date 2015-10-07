package StartPackage;

import static spark.Spark.get;
import Diggaren.Beans.Spotify.SpotifyBean;
import Diggaren.Beans.Spotify.Test;
import Diggaren.Diggaren.App;
import Diggaren.Diggaren.DiggarenTest;
import Diggaren.Diggaren.SR;
import Diggaren.Diggaren.Spotify;
import Diggaren.Diggaren.beans.SongBean;

public class Run {

	private DiggarenTest sr;
	private Test spotify;
    public static void main( String[] args )
    {
    	Run app = new Run();
    	
    	get("/kanaler", (req, res) -> "Hej");
        System.out.println( "Hello World!" );
        get("/hej", (req, res) -> "Hej");
        
        
    }
    
    public Run (){
    	sr = new DiggarenTest();
    	spotify = new Test();
    	
    }
    
    public String getSpotifyLink(int channel){
    	SongBean song = sr.getSong();
    	SpotifyBean ssb = spotify(song);
    	
		return ssb.getUrl();
    	
    }
}
