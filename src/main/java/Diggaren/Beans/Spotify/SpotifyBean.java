package Diggaren.Beans.Spotify;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import Diggaren.Diggaren.beans.SongBean;

import com.google.gson.annotations.SerializedName;

public class SpotifyBean {
	

	@SerializedName("tracks")
//	public List<ArtistBean> artists = new ArrayList<ArtistBean>();
//	public Map<String, ArtistBean> artists = new TreeMap<String, ArtistBean>();
	public ArtistBean track = new ArtistBean();

	
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

	public ArtistBean getPlaylist() {
		return track;
		}



	public String getUrl() {
		return track.getUri();
	}

	}



