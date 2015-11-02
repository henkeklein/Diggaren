package Diggaren.Beans.Spotify;

import com.google.gson.annotations.SerializedName;

/**
 * Class that maps the JSON response from Spotify API
 * 
 * @author danielhertzman-ericson, Hernik Klein, Dennis Kristensson
 *
 */
public class TrackBean {
	/**
	 * All the mapping against the Spotify API to get a track. 
	 */

	@SerializedName("href")
	private String href;

	@SerializedName("items")
	private ArtistBean[] items;

	@SerializedName("limit")
	private int limit;

	@SerializedName("next")
	private String next;

	@SerializedName("offset")
	private String offset;

	@SerializedName("previous")
	private String previous;

	@SerializedName("total")
	private String total;

	/**
	 * Empty constructor.
	 */
	public TrackBean() {

	}
	/**
	 * 
	 * @return a href to a track.
	 */
	public String getHref() {
		return href;
	}
	/**
	 * Sets the href to new href.
	 * @param href
	 */
	public void setHref(String href) {
		this.href = href;
	}
	/**
	 * return a list of items.
	 * @return
	 */
	public ArtistBean[] getItems() {
		return items;
	}
	/**
	 * Sets a new list of items to items.
	 * @param items
	 */
	public void setItems(ArtistBean[] items) {
		this.items = items;
	}
	/**
	 * 
	 * @return returns a limit of search resluts from Spotify.
	 */
	public int getLimit() {
		return limit;
	}
	/**
	 * Sets limit to new limit.
	 * @param limit
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}
	/**
	 * 
	 * @return next song in the track list.
	 */
	public String getNext() {
		return next;
	}
	/**
	 * Sets next to new next.
	 * @param next
	 */
	public void setNext(String next) {
		this.next = next;
	}
	/**
	 * 
	 * @return 
	 */
	public String getOffset() {
		return offset;
	}
	/**
	 * Sets the offset to new offset.
	 * @param offset
	 */
	public void setOffset(String offset) {
		this.offset = offset;
	}
	/**
	 * 
	 * @return previous song.
	 */
	public String getPrevious() {
		return previous;
	}
	/**
	 * Sets previous song to new previous.
	 * @param previous
	 */
	public void setPrevious(String previous) {
		this.previous = previous;
	}
	/**
	 * 
	 * @return all the result that can be found in Spotify.
	 */
	public String getTotal() {
		return total;
	}
	/**
	 * Sets total to new total.
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}

}