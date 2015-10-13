package Diggaren.Json;

import java.util.ArrayList;

import Diggaren.Beans.SR.SRStarter;
import Diggaren.Beans.SR.SongListBean;
import Diggaren.Beans.Spotify.SpotifyStarter;

public class CreateJson {
	
	private String describtion;
	private String url;

	public void setValues() {
		SpotifyStarter spotify = new SpotifyStarter();
		SRStarter sr = new SRStarter();
		sr.startRadio(2576);
		spotify.startSpotify(sr.getFirstSong());

		
		describtion = sr.getFirstSong();
		url = spotify.getLink();
	}
	

	

	public String getDescribtion() {
		return describtion;
	}

	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
