package Diggaren.Beans.Spotify;
import com.google.gson.annotations.SerializedName;

/**
 * Class that maps "external_urls" from the JSON response
 * @author danielhertzman-ericson
 *
 */
public class ItemBean {
	/**
	 * Mapping from Spotify.
	 */
	@SerializedName("external_urls")
	private LinkBean link;
	/**
	 * 
	 * @return the external_urls link.
	 */
	public LinkBean getLink() {
		return link;
	}
	/**
	 * Sets the link to link.
	 * @param link
	 */
	public void setLink(LinkBean link) {
		this.link = link;
	}

}