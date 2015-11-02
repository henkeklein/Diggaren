package Diggaren.Json;

import Diggaren.Beans.SR.SRStarter;
import Diggaren.Beans.Spotify.SpotifyStarter;

/**
 * Sets the values from the results from the both API.
 * 
 * @author danielhertzman-ericson, Hernik Klein, Dennis Kristensson
 *
 */
public class CreateJson {
	
	//defines the full description of song
	private String description;
	//defines the songs url
	private String url;

	/**
	 * Sets the values of description and url.
	 * In order to do that, we need to define a 
	 * specific radio channel.
	 * @param channel
	 */
	public void setValues(int channel) {
		System.out.println(channel);
		SpotifyStarter spotify = new SpotifyStarter();
		SRStarter sr = new SRStarter();
		sr.startRadio(channel);
		spotify.startSpotify(sr.getFirstSong());

		
		description = sr.getFirstSong();
		url = spotify.getLink();
	}
	

	/**
	 * Returns value of description
	 * @return value of description
	 */
	public String getDescribtion() {
		return description;
	}

	/**
	 * Sets the value of description to new value
	 * @param describtion
	 */
	public void setDescribtion(String describtion) {
		this.description = describtion;
	}

	/**
	 * Return the URL
	 * @return the URL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Set the value of URL 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
