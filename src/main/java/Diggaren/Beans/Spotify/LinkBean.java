package Diggaren.Beans.Spotify;
import com.google.gson.annotations.SerializedName;

public class LinkBean {
	
	@SerializedName("spotify")
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
