package Diggaren.Beans.SR;
import com.google.gson.annotations.SerializedName;

/**
 * Mapping objects in song. Look at the following JSON response to get a head of
 * what I'm mapping. This one was for experimental purpose, to be used to get
 * full list of a song from a specific day
 * 
 * http://api.sr.se/api/v2/playlists/getplaylistbyprogramid?id=2576&
 * startdatetime=2015-10-09&format=json
 * 
 * @author danielhertzman-ericson, Hernik Klein, Dennis Kristensson
 *
 */
public class SongListBean {
	
	@SerializedName("title") 
	private String title;
	
	@SerializedName("description")
	private String describtion;
	
	@SerializedName("artist")
	private String artist;
	
	
	public SongListBean() {}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return describtion;
	}

	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	
}
