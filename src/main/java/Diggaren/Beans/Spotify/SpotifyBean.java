package Diggaren.Beans.Spotify;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.annotations.SerializedName;

public class SpotifyBean {
	

	@SerializedName("artists")
	public List<ArtistBean> artists = new ArrayList<ArtistBean>();

//	public ArtistBean artists = new ArtistBean();

	
	// @SerializedName("track")
	// private TrackBean beanInfo;


		/**
		 * Being a bean, the class needs an empty, public constructor.
		 */
		public SpotifyBean() {
			
		}



	// public TrackBean getBeanInfo() {
	// return beanInfo;
	// }
	//
	//
	//
	// public void setBeanInfo(TrackBean beanInfo) {
	// this.beanInfo = beanInfo;
	// }

	public List<ArtistBean> getPlaylist() {
		return artists;
		}
	}



