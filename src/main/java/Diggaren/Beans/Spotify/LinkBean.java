package Diggaren.Beans.Spotify;
import com.google.gson.annotations.SerializedName;

/**
 * Class that gets the url from Spotify with the correct song.
 * @author Henrik Klein
 *
 */
public class LinkBean {
	/**
	 * The mapping from Spotify.
	 */
	@SerializedName("spotify")
	private String url;
	/**
	 * 
	 * @return the url from Spotify.
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * Sets the url to new url.
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
