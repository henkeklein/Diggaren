package Diggaren.Beans.SR;

import com.google.gson.annotations.SerializedName;

public class Playlist {

	@SerializedName("song")
	private SongBean song;

	@SerializedName("nextsong")
	private SongBean nextsong;

	@SerializedName("channel")
	private ChannelBean channel;


	public Playlist() {
		
	}

	public ChannelBean getChannel() {
		return channel;
	}

	public void setChannel(ChannelBean channel) {
		this.channel = channel;
	}

	public SongBean getSong() {
		return song;
	}

	public void setSong(SongBean song) {
		this.song = song;
	}

	public SongBean getNextSong() {
		return nextsong;
	}

	public void setNextSong(SongBean song) {
		nextsong = song;
	}
	}

