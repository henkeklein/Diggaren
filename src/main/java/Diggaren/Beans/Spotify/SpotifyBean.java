package Diggaren.Beans.Spotify;

import com.google.gson.annotations.SerializedName;

public class SpotifyBean {
	

	@SerializedName("tracks")
	public ArtistBean track = new ArtistBean();



		public SpotifyBean() {
			
		}


	public ArtistBean getPlaylist() {
		return track;
		}




	}



