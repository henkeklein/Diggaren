package Diggaren.Beans.Spotify;


	import com.google.gson.annotations.SerializedName;

	public class ArtistBean {
		@SerializedName("href")
		private String href;

	@SerializedName("items")
	private String items;

	@SerializedName("limit")
	private String limit;

	@SerializedName("next")
	private String next;

	@SerializedName("offset")
	private String offset;

	@SerializedName("previous")
	private String previous;

	@SerializedName("total")
	private String total;

	public ArtistBean() {

	}

		public String getHref() {
			return href;
		}



		public void setHref(String href) {
			this.href = href;
		}



		public String getItems() {
			return items;
		}



		public void setItems(String items) {
			this.items = items;
		}



		public String getLimit() {
			return limit;
		}



		public void setLimit(String limit) {
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