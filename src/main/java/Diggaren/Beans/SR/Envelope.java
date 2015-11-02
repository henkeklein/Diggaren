package Diggaren.Beans.SR;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;;

/**
 * Bean that holds information about the songs in the JSON-data from SR
 * 
 * @author danielhertzman-ericson, Hernik Klein, Dennis Kristensson
 *
 */
public class Envelope {

	private Playlist playlist;

	// this list holds the information about the songs
	@SerializedName("song")
	public ArrayList<SongListBean> list = new ArrayList<SongListBean>();

	/**
	 * Returns a list of song lists
	 * @return list of song lists
	 */
	public List<SongListBean> getList() {
		return list;
	}
	
	/**
	 * Sets list to the new list
	 * @param list
	 */
	public void setList(ArrayList<SongListBean> list) {
		this.list = list;
	}

	public Envelope() {}

	/**
	 * Returns a instance of Playlist
	 * @return instance of Playlist
	 */
	public Playlist getPlaylist() {
		return playlist;
	}

	/**
	 * Sets playlist to the new value of playlist
	 * @param playlist
	 */
	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}
}
