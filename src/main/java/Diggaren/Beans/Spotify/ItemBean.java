package Diggaren.Beans.Spotify;
import com.google.gson.annotations.SerializedName;

public class ItemBean {
	@SerializedName("external_urls")
	private LinkBean link;

	public LinkBean getLink() {
		return link;
	}

	public void setLink(LinkBean link) {
		this.link = link;
	}

}
