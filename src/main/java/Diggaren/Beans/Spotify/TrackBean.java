package Diggaren.Beans.Spotify;

import com.google.gson.annotations.SerializedName;

/**
 * Bean that maps the JSON response from Spotify API
 * @author danielhertzman-ericson
 *
 */
public class TrackBean {

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

	public TrackBean() {

	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public ArtistBean[] getItems() {
		return items;
	}

	public void setItems(ArtistBean[] items) {
		this.items = items;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getOffset() {
		return offset;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

}