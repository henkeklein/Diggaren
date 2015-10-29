package Diggaren.Beans.Spotify;
import com.google.gson.annotations.SerializedName;
/**
 * Class that holds all the information from Spotify.
 * @author Henrik Klein
 *
 */
public class SpotifyBean {
	/**
	 * Mapping against tracks in Spotify.
	 */
	@SerializedName("tracks")
	public ArtistBean track = new ArtistBean();
	
	/**
	 * Empty constructor.
	 */
	public SpotifyBean() {
			
	}
	/**
	 * 
	 * @return a list of tracks.
	 */
	public ArtistBean getPlaylist() {
		return track;
	}




	}



