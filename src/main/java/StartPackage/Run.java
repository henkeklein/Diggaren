package StartPackage;

import static spark.Spark.get;

import java.util.ArrayList;

import Diggaren.Beans.SR.SongListBean;
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
        
        get("/list", (req,res) -> {
        	return app.getList();
        });
        

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
	
	public String getList() {
		
		ArrayList<SongListBean> list = sr.createAndGetList();
		String s = "";
		
		for (int i = 0; i < list.size(); i++) {
			spotify.startSpotify(list.get(i).getTitle());
			String link = spotify.getLink();
			s += "<p>" + i + ": " + list.get(i).getTitle() + " - URL: " + "<a href="+"\""+link+"\"" + ">"+link+"</a>" + "</p>";
		}
		
		return s;
		
		
		
	}


}
