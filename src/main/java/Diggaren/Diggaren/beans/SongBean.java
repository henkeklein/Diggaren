package Diggaren.Diggaren.beans;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.google.gson.annotations.SerializedName;

public class SongBean {
	@SerializedName("title")
	private String title;

	@SerializedName("description")
	private String description;

	@SerializedName("artist")
	private String artist;

	@SerializedName("composer")
	private String composer;

	@SerializedName("conductor")
	private String conductor;

	@SerializedName("albumname")
	private String albumname;

	@SerializedName("recordlabel")
	private String recordlabel;

	@SerializedName("lyricist")
	private String lyricist;

	@SerializedName("producer")
	private String producer;

	@SerializedName("starttimeutc")
	private String starttimeutc;

	@SerializedName("stoptimeutc")
	private String stoptimeutc;

	public SongBean() {

	}

	public String getTitle() {
	
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public String getConductor() {
		return conductor;
	}

	public void setConductor(String conductor) {
		this.conductor = conductor;
	}

	public String getAlbumname() {
		return albumname;
	}

	public void setAlbumname(String albumname) {
		this.albumname = albumname;
	}

	public String getRecordlabel() {
		return recordlabel;
	}

	public void setRecordlabel(String recordlabel) {
		this.recordlabel = recordlabel;
	}

	public String getLyricist() {
		return lyricist;
	}

	public void setLyricist(String lyricist) {
		this.lyricist = lyricist;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getStarttimeutc() {
		return starttimeutc;
	}

	public void setStarttimeutc(String starttimeutc) {
		this.starttimeutc = starttimeutc;
	}

	public String getStoptimeutc() {
		return stoptimeutc;
	}

	public void setStoptimeutc(String stoptimeutc) {
		this.stoptimeutc = stoptimeutc;
	}

}
