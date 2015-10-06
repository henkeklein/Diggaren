package Diggaren.Beans.Spotify;

import java.util.Map;
import java.util.TreeMap;

import com.google.gson.annotations.SerializedName;

public class SpotifyBean {

	@SerializedName("artists")
	// public Map<String, ArtistBean> artists = new TreeMap<String,
	// ArtistBean>();

	public ArtistBean artists = new ArtistBean();

	// @SerializedName("track")
	// private TrackBean beanInfo;

	/**
	 * Being a bean, the class needs an empty, public constructor.
	 */
	public SpotifyBean() {}

	// public TrackBean getBeanInfo() {
	// return beanInfo;
	// }
	//
	//
	//
	// public void setBeanInfo(TrackBean beanInfo) {
	// this.beanInfo = beanInfo;
	// }

	public ArtistBean getPlaylist() {
		return artists;
	}
}
