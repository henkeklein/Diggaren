package Diggaren.Beans.SR;

import com.google.gson.annotations.SerializedName;

/**
 * Maps objects in the JSON-document
 * 
 * @author danielhertzman-ericson, Hernik Klein, Dennis Kristensson
 *
 */
public class Playlist {

	@SerializedName("song")
	private SongBean song;

	@SerializedName("nextsong")
	private SongBean nextsong;

	@SerializedName("channel")
	private ChannelBean channel;


	public Playlist() {}

	/**
	 * Returns an instance of ChannelBean
	 * @return instance of ChannelBean
	 */
	public ChannelBean getChannel() {
		return channel;
	}

	/**
	 * Sets value of channel to new value of channel
	 * @param channel
	 */
	public void setChannel(ChannelBean channel) {
		this.channel = channel;
	}

	/**
	 * Returns an instance of SongBean
	 * @return instance of SongBean
	 */
	public SongBean getSong() {
		return song;
	}

	/**
	 * Sets value of song to new value of song
	 * @param song
	 */
	public void setSong(SongBean song) {
		this.song = song;
	}

	/**
	 * Returns instance of SongBean that holds
	 * information about nextsong
	 * @return instance of SongBean that holds
	 * information about nextsong
	 */
	public SongBean getNextSong() {
		return nextsong;
	}

	/**
	 * Sets value of nextsong to new value of nextsong
	 * @param song
	 */
	public void setNextSong(SongBean song) {
		nextsong = song;
	}
}

