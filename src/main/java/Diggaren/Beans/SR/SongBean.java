package Diggaren.Beans.SR;

import com.google.gson.annotations.SerializedName;

/**
 * Bean that holds information about a specific song
 * @author danielhertzman-ericson
 *
 */
public class SongBean {
	
	
	@SerializedName("title")
	public String title;

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
	
	@SerializedName("name")
	private String name;
	

	public SongBean() {}

	/**
	 * Returns title of song
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets title of song
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns full describtion of song
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets value of describtion
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns name of artist
	 * @return name of artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * Sets value of artist
	 * @param artist
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * Returns name of composer
	 * @return name of composer
	 */
	public String getComposer() {
		return composer;
	}

	/**
	 * Sets value of composer
	 * @param composer
	 */
	public void setComposer(String composer) {
		this.composer = composer;
	}

	/**
	 * Returns value of conductor
	 * @return value of conductor
	 */
	public String getConductor() {
		return conductor;
	}

	/**
	 * Sets value of conductor
	 * @param conductor
	 */
	public void setConductor(String conductor) {
		this.conductor = conductor;
	}
	
	/**
	 * Returns name of album
	 * @return name of album
	 */
	public String getAlbumname() {
		return albumname;
	}

	/**
	 * Sets value of album
	 * @param albumname
	 */
	public void setAlbumname(String albumname) {
		this.albumname = albumname;
	}

	/**
	 * Return name of label
	 * @return name of label
	 */
	public String getRecordlabel() {
		return recordlabel;
	}

	/**
	 * Sets value of record label
	 * @param recordlabel
	 */
	public void setRecordlabel(String recordlabel) {
		this.recordlabel = recordlabel;
	}

	/**
	 * Return name of lyricist
	 * @return name of lyricist
	 */
	public String getLyricist() {
		return lyricist;
	}

	/**
	 * Sets value of lyricist
	 * @param lyricist
	 */
	public void setLyricist(String lyricist) {
		this.lyricist = lyricist;
	}

	/**
	 * Return name of producer
	 * @return name of producer
	 */
	public String getProducer() {
		return producer;
	}

	/**
	 * Sets name of producer
	 * @param producer
	 */
	public void setProducer(String producer) {
		this.producer = producer;
	}

	/**
	 * Return the start time of the song
	 * @return the start time of the song
	 */
	public String getStarttimeutc() {
		return starttimeutc;
	}

	/**
	 * Sets the value of start time
	 * @param starttimeutc
	 */
	public void setStarttimeutc(String starttimeutc) {
		this.starttimeutc = starttimeutc;
	}

	/**
	 * Return the stop time of the song
	 * @return the stop time of song
	 */
	public String getStoptimeutc() {
		return stoptimeutc;
	}

	/**
	 * Sets the value of stop time
	 * @param stoptimeutc
	 */
	public void setStoptimeutc(String stoptimeutc) {
		this.stoptimeutc = stoptimeutc;
	}
}
