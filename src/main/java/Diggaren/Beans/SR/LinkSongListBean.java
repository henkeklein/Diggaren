package Diggaren.Beans.SR;
import com.google.gson.annotations.SerializedName;

/**
 * Added some features to retrieve a whole list of songs
 * Uses the same techniques as LinkBean in Beans.Spotify
 * @author danielhertzman-ericson
 *
 */
public class LinkSongListBean {
	
	@SerializedName("song")
	private String song;
	
	public LinkSongListBean() {}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

}
