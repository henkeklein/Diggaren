package Diggaren.Beans.SR;
import com.google.gson.annotations.SerializedName;

/**
 * Added some features to retrieve a whole list of songs Uses the same
 * techniques as LinkBean in Beans.Spotify
 * 
 * @author danielhertzman-ericson, Hernik Klein, Dennis Kristensson
 *
 */
public class LinkSongListBean {
	
	@SerializedName("song")
	private String song;
	
	public LinkSongListBean() {}

	/**
	 * Returns the song 
	 * @return the song
	 */
	public String getSong() {
		return song;
	}

	/**
	 * Sets song to new value of song 
	 * @param song
	 */
	public void setSong(String song) {
		this.song = song;
	}

}
