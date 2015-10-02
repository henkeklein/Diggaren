package Diggaren.Beans.Spotify;

import com.google.gson.annotations.SerializedName;

public class ArtistBean {

	@SerializedName("href")
	private String href;

	@SerializedName("items")
	private ArtistBean[] items;

	@SerializedName("limit")
	private int limit;

	@SerializedName("next")
	private String next;

	@SerializedName("offset")
	private int offset;

	@SerializedName("previous")
	private String previous;

	@SerializedName("total")
	private int total;

	public ArtistBean() {

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



	public int getOffset() {
			return offset;
		}



	public void setOffset(int offset) {
			this.offset = offset;
		}



		public String getPrevious() {
			return previous;
		}



		public void setPrevious(String previous) {
			this.previous = previous;
		}



	public int getTotal() {
			return total;
		}



	public void setTotal(int total) {
			this.total = total;
		}

	}