package Diggaren.Beans.Spotify;

import java.util.Map;
import java.util.TreeMap;

import com.google.gson.annotations.SerializedName;

public class SpotifyBean {
	

		@SerializedName("playlist")
	public Map<String, ArtistBean> playlist = new TreeMap<String, ArtistBean>();



		@SerializedName("channel")
		private TrackBean beanInfo;


		/**
		 * Being a bean, the class needs an empty, public constructor.
		 */
		public SpotifyBean() {
			
		}



		public TrackBean getBeanInfo() {
			return beanInfo;
		}



		public void setBeanInfo(TrackBean beanInfo) {
			this.beanInfo = beanInfo;
		}

	public Map<String, ArtistBean> getPlaylist() {
			return playlist;
		}
	}



