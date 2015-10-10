package StartPackage;

import static spark.Spark.get;

import Diggaren.Beans.Spotify.Test;
import Diggaren.Diggaren.DiggarenTest;

public class Run {

	private DiggarenTest sr;
	private Test spotify;

    public static void main( String[] args )
    {
    	Run app = new Run();
		app.getSpotifyLinkFirst(2576);

		get("/song", (req, res) -> {
			return app.getSpotifyLinkFirst(2576);
    	});
        System.out.println( "Hello World!" );
        get("/hej", (req, res) -> "Hej");


    }
    
    public Run (){
    	sr = new DiggarenTest();
		spotify = new Test();



    }
    
	public String getSpotifyLinkFirst(int channel) {
		sr.startRadio(channel);
		spotify.startSpotify(sr.getFirstSong());
		return sr.getFirstSong() + spotify.getLink();

	}


}
