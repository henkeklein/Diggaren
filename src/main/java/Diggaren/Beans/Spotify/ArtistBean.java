package Diggaren.Beans.Spotify;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author danielhertzman-ericson
 *
 */
public class ArtistBean {

	@SerializedName("href")
	private String href;
	@SerializedName ("items")
	public ArrayList<ItemBean> items = new ArrayList<ItemBean>();

//
//	@SerializedName("limit")
//	private String limit;
//
//	@SerializedName("next")
//	private String next;
//
//	@SerializedName("offset")
//	private String offset;
//
//	@SerializedName("previous")
//	private String previous;

	public List<ItemBean> getItems() {
		return items;
	}


	@SerializedName("total")
	private String total;
	
	@SerializedName("uri")
	private String uri;

	public ArtistBean() {

	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
	
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	public String getUri() {
		System.out.println(uri + "Hej");
		return uri;
	}


	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

}