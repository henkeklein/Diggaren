package Diggaren.Json;

import Diggaren.Beans.SR.SRStarter;
import Diggaren.Beans.Spotify.SpotifyStarter;

public class CreateJson {
	
	private String description;
	private String url;

	public void setValues(int channel) {
		System.out.println(channel);
		SpotifyStarter spotify = new SpotifyStarter();
		SRStarter sr = new SRStarter();
		sr.startRadio(channel);
		spotify.startSpotify(sr.getFirstSong());

		
		description = sr.getFirstSong();
		url = spotify.getLink();
	}
	

	public String getDescribtion() {
		return description;
	}

	public void setDescribtion(String describtion) {
		this.description = describtion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
