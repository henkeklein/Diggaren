package Diggaren.Beans.Spotify;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

/**
 * Bean that holds information about an artist from spotify.
 * @author danielhertzman-ericson
 *
 */
public class ArtistBean {
	
	/**
	 * All the mapping from Spotifys API
	 */
	@SerializedName("href")
	private String href;
	
	@SerializedName ("items")
	public ArrayList<ItemBean> items = new ArrayList<ItemBean>();
	
	@SerializedName("total")
	private String total;
	
	@SerializedName("uri")
	private String uri;

	/**
	 * Empty constructor
	 */
	public ArtistBean() {
		
	}
	/**
	 * 
	 * @return list of items.
	 */
	public List<ItemBean> getItems() {
		return items;
	}
	/**
	 * 
	 * @return A href from Spotify
	 */
	public String getHref() {
		return href;
	}
	/**
	 * Sets the href to href.
	 * @param href
	 */
	public void setHref(String href) {
		this.href = href;
	}
	/**
	 * Sets the uri to uri.
	 * @param uri
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}
	/**
	 * 
	 * @return the uro from Spotify.
	 */
	public String getUri() {
		return uri;
	}
	/**
	 * 
	 * @return the number of results from Spotify.
	 */
	public String getTotal() {
		return total;
	}
	/**
	 * Sets total to total.
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}

}